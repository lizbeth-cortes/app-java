package sistema.datos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import sistema.pojos.CategoriaProd;
import sistema.pojos.DetalleVenta;
import sistema.pojos.Producto;
import sistema.pojos.Proveedor;
import sistema.pojos.Venta;
import java.sql.Date;

/**
 *
 * @author Lyzz
 */
public class BaseDeDatos {

    //La conexión a la base de datos.
    Connection conn = null;

    //La consulta SQL preparada.
    PreparedStatement prepSt = null;

    //Los resultados de la consulta SQL.
    ResultSet rs = null;

    Statement st = null;

    /* Intenta cargar el controlador JDBC de MariaDB.
     * Si el controlador no puede ser encontrado, imprime la traza de la excepción.
     */
    public BaseDeDatos() {
        try {
            // Cargar el controlador JDBC
            Class.forName("org.postgresql.Driver");

// Establecer la conexión a la base de datos
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarProducto(Producto producto) {
        try {
            //// Establecer la conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            File fileFoto = producto.getFotoProducto();
            //// Crear un flujo de entrada para leer la foto del producto como datos binarios
            FileInputStream fis = new FileInputStream(fileFoto);
            System.out.println("Conexión establecida correctamente.");

            String sql = "INSERT INTO cat_productos (id_prod, nombre_prod,desc_prod, stock_prod, foto_prod, unidad_prod,"
                    + "precio_compra_prod, precio_venta_prod,existencias_prod, id_categoria_prod, id_proveedor)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?)";

            prepSt = conn.prepareStatement(sql);

            prepSt.setString(1, producto.getIdProducto());
            prepSt.setString(2, producto.getNomProducto());
            prepSt.setString(3, producto.getDescProducto());
            prepSt.setDouble(4, producto.getStockProducto());
            long tamanioFoto = fileFoto.length();
            prepSt.setBinaryStream(5, fis, tamanioFoto);
            prepSt.setString(6, producto.getUnidadProducto());
            prepSt.setDouble(7, producto.getPrecioCompraProducto());
            prepSt.setDouble(8, producto.getPrecioVentaProducto());
            prepSt.setDouble(9, producto.getExistenciasProducto());
            prepSt.setInt(10, producto.getIdCategoria());
            prepSt.setInt(11, producto.getIdProveedor());

            //// Ejecutar la consulta SQL de inserción
            prepSt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean tieneVentasRegistradas(Producto producto) {
        boolean tieneVentas = false;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            String sql = "SELECT COUNT(*) FROM detalle_venta WHERE id_prod=?";
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, producto.getIdProducto());
            rs = prepSt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                tieneVentas = count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prepSt != null) {
                    prepSt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return tieneVentas;
    }

    public void borrarProducto(Producto producto) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");
            String sql = "DELETE FROM cat_productos WHERE id_prod=?";
            prepSt = conn.prepareStatement(sql);
            prepSt.setString(1, producto.getIdProducto());
            prepSt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actualizarProducto(Producto producto, boolean cambiarFoto) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            if (cambiarFoto == true) {
                File fileFoto = producto.getFotoProducto();
                FileInputStream fis = new FileInputStream(fileFoto);
                String sql = "UPDATE cat_productos SET desc_prod=?, stock_prod = ?, foto_prod = ?, unidad_prod = ?,"
                        + "precio_compra_prod=?,precio_venta_prod=?,id_categoria_prod=?, id_proveedor = ?"
                        + " WHERE id_prod = ?";
                prepSt = conn.prepareStatement(sql);
                prepSt.setString(1, producto.getDescProducto());
                prepSt.setDouble(2, producto.getStockProducto());
                long tamanoFoto = fileFoto.length();
                prepSt.setBinaryStream(3, fis, tamanoFoto);
                prepSt.setString(4, producto.getUnidadProducto());
                prepSt.setDouble(5, producto.getPrecioCompraProducto());
                prepSt.setDouble(6, producto.getPrecioVentaProducto());
                prepSt.setInt(7, producto.getIdCategoria());
                prepSt.setInt(8, producto.getIdProveedor());
                prepSt.setString(9, producto.getIdProducto());
            } else {
                String sql = "UPDATE cat_productos SET desc_prod=?, stock_prod = ?, unidad_prod = ?,"
                        + "precio_compra_prod=?,precio_venta_prod=?,id_categoria_prod=?, id_proveedor = ?"
                        + " WHERE id_prod = ?";

                prepSt = conn.prepareStatement(sql);
                prepSt.setString(1, producto.getDescProducto());
                prepSt.setDouble(2, producto.getStockProducto());
                prepSt.setString(3, producto.getUnidadProducto());
                prepSt.setDouble(4, producto.getPrecioCompraProducto());
                prepSt.setDouble(5, producto.getPrecioVentaProducto());
                prepSt.setInt(6, producto.getIdCategoria());
                prepSt.setInt(7, producto.getIdProveedor());
                prepSt.setString(8, producto.getIdProducto());
            }
            prepSt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actualizarInventario(Producto producto, double cantidad) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            String sql = "UPDATE cat_productos SET existencias_prod = ? WHERE id_prod=?";

            prepSt = conn.prepareStatement(sql);

            prepSt.setDouble(1, cantidad);
            prepSt.setString(2, producto.getIdProducto());

            prepSt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void insertarCategoriaProducto(CategoriaProd categoria) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");

            System.out.println("Conexión establecida correctamente.");

            String sql = "INSERT INTO cat_categorias (nom_categoria_prod, desc_categoria_prod)"
                    + "values(?,?)";

            prepSt = conn.prepareStatement(sql);

            prepSt.setString(1, categoria.getNomCategoriaProd());
            prepSt.setString(2, categoria.getDescCategoriaProd());

            prepSt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public InputStream buscarFoto(Producto producto) {
        InputStream streamFoto = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            String sql = "SELECT foto_prod from cat_productos WHERE id_prod=?";

            prepSt = conn.prepareStatement(sql);

            prepSt.setString(1, producto.getIdProducto());

            rs = prepSt.executeQuery();

            while (rs.next()) {
                streamFoto = rs.getBinaryStream("foto_prod");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return streamFoto;
    }

    public void insertarProveedor(Proveedor prov) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            String sql = "INSERT INTO cat_proveedores (nom_proveedor, dir_proveedor, telefono_proveedor"
                    + "email_proveedor, contacto_proveedor)"
                    + "values(?,?,?,?,?,?)";

            prepSt = conn.prepareStatement(sql);

            prepSt.setString(1, prov.getNomProveedor());
            prepSt.setString(2, prov.getDir_proveedor());
            prepSt.setString(3, prov.getTelefonoProveedor());
            prepSt.setString(4, prov.getEmailProveedor());
            prepSt.setString(5, prov.getContactoProveedor());

            prepSt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public Long insertarVenta(Venta venta) {
        // Declaración de la variable para almacenar el último valor insertado
        Long lastVal = 0L;

        // SQL para insertar una nueva venta en la tabla ventas
        String sql = "INSERT INTO ventas (monto_venta, fecha_venta) VALUES (?, ?)";

        try (
                // Establecer la conexión con la base de datos
                
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456"); // Preparar la declaración SQL con opción para obtener las claves generadas
                 PreparedStatement prepSt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println("Conexión establecida correctamente.");

            // Establecer los valores para la declaración SQL preparada
            prepSt.setDouble(1, venta.getMontoFecha());
            prepSt.setDate(2, venta.getFecha());

            // Ejecutar la declaración SQL
            prepSt.executeUpdate();

            // Obtener las claves generadas (el último valor insertado)
            try (ResultSet rs = prepSt.getGeneratedKeys()) {
                if (rs.next()) {
                    lastVal = rs.getLong(1);
                }
            }

        } catch (SQLException ex) {
            // Manejo de excepciones SQL
            ex.printStackTrace();
        }

        return lastVal;
    }

    public void insertarDetalleVenta(DetalleVenta detalle) {
        try {
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");

            System.out.println("Conexión establecida correctamente.");

            String sql = "INSERT INTO detalle_venta (id_venta,id_prod, cantidad_vendida)"
                    + "values(?,?,?)";

            prepSt = conn.prepareStatement(sql);

            prepSt.setLong(1, detalle.getIdVenta());
            prepSt.setString(2, detalle.getIdProd());
            prepSt.setDouble(3, detalle.getCantidadVendida());

            prepSt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public double obtenerTotalVentas(Date fecha) {
        double totalVentas = 0.0;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");

            System.out.println("Conexión establecida correctamente.");

            // Preparar la consulta SQL
            String sql = "SELECT SUM(monto_venta) FROM ventas WHERE fecha_venta = ?";
            prepSt = conn.prepareStatement(sql);
            prepSt.setDate(1, fecha);

            // Ejecutar la consulta
            rs = prepSt.executeQuery();

            // Procesar el resultado
            if (rs.next()) {
                totalVentas = rs.getDouble(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prepSt != null) {
                    prepSt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return totalVentas;
    }

    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");

            System.out.println("Conexión establecida correctamente.");

            String sql = "SELECT * FROM cat_productos order by nombre_prod";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next()) {

                String id = rs.getString("id_prod");
                String nombre = rs.getString("nombre_prod");
                String descripcion = rs.getString("desc_prod");
                double stock = rs.getDouble("stock_prod");
                String unidad = rs.getString("unidad_prod");
                double precioCompra = rs.getDouble("precio_compra_prod");
                double precioVenta = rs.getDouble("precio_venta_prod");
                double existencias = rs.getDouble("existencias_prod");
                int idCategoria = rs.getInt("id_categoria_prod");
                int idProveedor = rs.getInt("id_proveedor");

                Producto producto = new Producto(id, nombre, descripcion, stock, null, unidad, precioCompra, precioVenta, existencias, idCategoria, idProveedor);
                listaProductos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaProductos;
    }

    /*
     * Este método obtiene los productos de la base de datos en base a un criterio
     * que se debe de cumplir en la clase del producto o en el nombre
     * del producto.
     */
    public ArrayList<Producto> obtenerProductosPorCriterio(String criterio) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            // Establece una conexión con la base de datos.
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            // Construye la consulta SQL para obtener los productos que coinciden con el criterio.
            String sql = "SELECT * FROM cat_productos "
                    + "WHERE id_prod LIKE '" + criterio + "%'"
                    + "OR nombre_prod LIKE '%" + criterio + "%'"
                    + "ORDER BY nombre_prod";

            // Crea una declaración para ejecutar la consulta.
            st = conn.createStatement();

            // Ejecuta la consulta y obtiene los resultados.
            rs = st.executeQuery(sql);

            // Itera sobre los resultados y crea objetos Producto con los datos obtenidos.
            while (rs.next()) {
                String id = rs.getString("id_prod");
                String nombre = rs.getString("nombre_prod");
                String descripcion = rs.getString("desc_prod");
                double stock = rs.getDouble("stock_prod");
                String unidad = rs.getString("unidad_prod");
                double precioCompra = rs.getDouble("precio_compra_prod");
                double precioVenta = rs.getDouble("precio_venta_prod");
                double existencias = rs.getDouble("existencias_prod");
                int idCategoria = rs.getInt("id_categoria_prod");
                int idProveedor = rs.getInt("id_proveedor");

                Producto producto = new Producto(id, nombre, descripcion, stock, null, unidad, precioCompra, precioVenta, existencias, idCategoria, idProveedor);
                listaProductos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cierra las conexiones y declaraciones para liberar recursos.
            try {
                if (prepSt != null) {
                    prepSt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        // Devuelve la lista de productos obtenida.
        return listaProductos;
    }

    public ArrayList<CategoriaProd> obtenerCategoria() {
        ArrayList<CategoriaProd> listaCategorias = new ArrayList<>();
        try {
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            String sql = "SELECT * FROM cat_categorias";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_categoria_prod");
                String nombre = rs.getString("nom_categoria_prod");
                String descripcion = rs.getString("desc_categoria_prod");

                CategoriaProd categoria = new CategoriaProd(id, nombre, descripcion);
                listaCategorias.add(categoria);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaCategorias;
    }

    public ArrayList<Proveedor> obtenerProoveedores() {
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        try {
            
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "123456");
            System.out.println("Conexión establecida correctamente.");

            String sql = "SELECT * FROM cat_proveedores";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nom_proveedor");
                String direccion = rs.getString("dir_proveedor");
                String telefono = rs.getString("telefono_proveedor");
                String email = rs.getString("email_proveedor");
                String contacto = rs.getString("contacto_proveedor");

                Proveedor proveedor = new Proveedor(id, nombre, direccion, telefono, email, contacto);
                listaProveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaProveedores;
    }

}
