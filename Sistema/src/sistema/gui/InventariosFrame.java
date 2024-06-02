package sistema.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sistema.datos.BaseDeDatos;
import sistema.pojos.Producto;

/**
 *
 * @author Lyzz
 */
public class InventariosFrame extends javax.swing.JInternalFrame {

    //DefaultTableModel modeloTabla = new DefaultTableModel();
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };
    BaseDeDatos base = new BaseDeDatos();
    Producto productoSeleccionado = null;

    /**
     * Creates new form Inventarios
     */
    public InventariosFrame() {
        initComponents();
        cargarColumnasTabla();
        cargarModeloTabla();

    }

    /**
     * Este modelo carga el modelo de la tabla de inventarios
     */
    private void cargarColumnasTabla() {
        modeloTabla.addColumn("Clave");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Unidad");
        modeloTabla.addColumn("Precio Compra");
        modeloTabla.addColumn("Precio Venta");
        modeloTabla.addColumn("Existencias");
    }

    private void cargarModeloTabla() {
        ArrayList<Producto> listaProductos = base.obtenerProductos();
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);

        for (int i = 0; i < numeroProductos; i++) {
            Producto producto = listaProductos.get(i);
            String clave = producto.getIdProducto();
            String nombre = producto.getNomProducto();
            String unidad = producto.getUnidadProducto();
            String descripcion = producto.getDescProducto();
            Double precioCompra = producto.getPrecioCompraProducto();
            Double precioVenta = producto.getPrecioVentaProducto();
            Double existencias = producto.getExistenciasProducto();

            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(descripcion, i, 2);
            modeloTabla.setValueAt(unidad, i, 3);
            modeloTabla.setValueAt(precioCompra, i, 4);
            modeloTabla.setValueAt(precioVenta, i, 5);
            modeloTabla.setValueAt(existencias, i, 6);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevoArticulo = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoClaveProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoNombreProducto = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        tablaProductos.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && tablaProductos.getSelectedRow()>=0){
                        int filaSeleccionada = tablaProductos.getSelectedRow();
                        Producto producto = (Producto) modeloTabla.getValueAt(filaSeleccionada, 1);
                        campoNombreProducto.setText(producto.getNomProducto());
                        campoNombreProducto.setEnabled(false);
                        campoClaveProducto.setText(producto.getIdProducto());
                        campoClaveProducto.setEnabled(false);
                        String existencias = String.valueOf(producto.getExistenciasProducto());
                        campoExistenciaProducto.setText(existencias);
                        campoExistenciaProducto.setEnabled(false);
                        productoSeleccionado = producto;

                        //despliegue de la foto del producto
                        desplegarFoto(producto);
                    }
                }
            }
        );
        jLabel4 = new javax.swing.JLabel();
        campoExistenciaProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoAgregarExistencia = new javax.swing.JTextField();
        btnAgregarExistencia = new javax.swing.JButton();
        btnModificarProd = new javax.swing.JButton();
        btnBorrarProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();

        setTitle("Inventarios");
        setPreferredSize(new java.awt.Dimension(1100, 650));

        btnNuevoArticulo.setToolTipText("Añadir nuevo producto");
        btnNuevoArticulo.setPreferredSize(new java.awt.Dimension(100, 100));
        ImageIcon iconBtnNuevoArticulo = new ImageIcon("images/producto.png");
        Image imgBtnNuevoArticulo = iconBtnNuevoArticulo.getImage();

        Dimension prefSizeBtnNuevoArticulo = btnNuevoArticulo.getPreferredSize();

        int anchoBtnNuevoArticulo = (int) (prefSizeBtnNuevoArticulo.getWidth()*0.7);
        int altoBtnNuevoArticulo = (int) (prefSizeBtnNuevoArticulo.getHeight()*0.7);

        Image imgRedimBtnNuevoArticulo = imgBtnNuevoArticulo.getScaledInstance(anchoBtnNuevoArticulo,altoBtnNuevoArticulo, Image.SCALE_DEFAULT);
        ImageIcon iconRedimBtnNuevoArticulo = new ImageIcon(imgRedimBtnNuevoArticulo);

        btnNuevoArticulo.setIcon(iconRedimBtnNuevoArticulo);
        btnNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArticuloActionPerformed(evt);
            }
        });

        btnCategoria.setToolTipText("Añadir nueva categoría");
        btnCategoria.setPreferredSize(new java.awt.Dimension(100, 100));
        ImageIcon iconBtnCategoria= new ImageIcon("images/categoria.png");
        Image imgBtnCategoria= iconBtnCategoria.getImage();

        Dimension prefSizeBtnCategoria= btnCategoria.getPreferredSize();

        int anchoBtnCategoria= (int) (prefSizeBtnCategoria.getWidth()*0.7);
        int altoBtnCategoria= (int) (prefSizeBtnCategoria.getHeight()*0.7);

        Image imgRedimBtnCategoria = imgBtnCategoria.getScaledInstance(anchoBtnCategoria,altoBtnCategoria, Image.SCALE_DEFAULT);
        ImageIcon iconRedimBtnCategoria= new ImageIcon(imgRedimBtnCategoria);

        btnCategoria.setIcon(iconRedimBtnCategoria);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnProveedor.setToolTipText("Añadir nuevo proveedor");
        btnProveedor.setPreferredSize(new java.awt.Dimension(100, 100));
        ImageIcon iconBtnProveedor= new ImageIcon("images/provedor.png");
        Image imgBtnProveedor= iconBtnProveedor.getImage();

        Dimension prefSizeBtnProveedor= btnProveedor.getPreferredSize();

        int anchoBtnProveedor= (int) (prefSizeBtnProveedor.getWidth()*0.7);
        int altoBtnProveedor= (int) (prefSizeBtnProveedor.getHeight()*0.7);

        Image imgRedimBtnProveedor = imgBtnProveedor.getScaledInstance(anchoBtnProveedor,altoBtnProveedor, Image.SCALE_DEFAULT);
        ImageIcon iconRedimBtnProveedor= new ImageIcon(imgRedimBtnProveedor);

        btnProveedor.setIcon(iconRedimBtnProveedor);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Inventario:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Clave:");

        campoClaveProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoClaveProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        lblImagen.setBackground(new java.awt.Color(204, 255, 204));

        tablaProductos.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaProductos);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Existencia:");

        campoExistenciaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoExistenciaProductoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ingresar al inventario:");

        campoAgregarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAgregarExistenciaActionPerformed(evt);
            }
        });

        btnAgregarExistencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarExistencia.setText("Agregar");
        btnAgregarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExistenciaActionPerformed(evt);
            }
        });

        btnModificarProd.setToolTipText("Editar producto");
        btnModificarProd.setPreferredSize(new java.awt.Dimension(70, 70));
        ImageIcon iconBtnEditar= new ImageIcon("images/editar.png");
        Image imgBtnEditar = iconBtnEditar.getImage();

        Dimension prefSizeBtnEditar= btnModificarProd.getPreferredSize();

        int anchoBtnEditar = (int) (prefSizeBtnEditar.getWidth()*0.7);
        int altoBtnEditar= (int) (prefSizeBtnEditar.getHeight()*0.7);

        Image imgRedimBtnEditar = imgBtnEditar.getScaledInstance(anchoBtnEditar,altoBtnEditar, Image.SCALE_DEFAULT);
        ImageIcon iconRedimBtnEditar= new ImageIcon(imgRedimBtnEditar);

        btnModificarProd.setIcon(iconRedimBtnEditar);
        btnModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProdActionPerformed(evt);
            }
        });

        btnBorrarProd.setToolTipText("Eliminar producto");
        btnBorrarProd.setPreferredSize(new java.awt.Dimension(70, 70));
        ImageIcon iconBtnEliminar= new ImageIcon("images/eliminar.png");
        Image imgBtnEliminar = iconBtnEliminar.getImage();

        Dimension prefSizeBtnEliminar = btnBorrarProd.getPreferredSize();

        int anchoBtnEliminar = (int) (prefSizeBtnEliminar.getWidth()*0.7);
        int altoBtnEliminar = (int) (prefSizeBtnEliminar.getHeight()*0.7);

        Image imgRedimBtnEliminar = imgBtnEliminar.getScaledInstance(anchoBtnEliminar,altoBtnEliminar, Image.SCALE_DEFAULT);
        ImageIcon iconRedimBtnEliminar = new ImageIcon(imgRedimBtnEliminar);

        btnBorrarProd.setIcon(iconRedimBtnEliminar);
        btnBorrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Buscar:");

        campoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarActionPerformed(evt);
            }
        });
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnNuevoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(campoAgregarExistencia, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoExistenciaProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoClaveProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel6)
                                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnNuevoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoClaveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoExistenciaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarExistencia))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArticuloActionPerformed
        ProductoFrame articulo = new ProductoFrame(null, true, null, null, "Nuevo producto", false);
        articulo.setVisible(true);
        articulo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        articulo.setLocation(600, 150);
        articulo.setAlwaysOnTop(true);
        cargarModeloTabla();
    }//GEN-LAST:event_btnNuevoArticuloActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        CategoriaFrame categoria = new CategoriaFrame(null, true);
        categoria.setVisible(true);
        categoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        categoria.setLocation(600, 150);
        categoria.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void campoClaveProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoClaveProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoClaveProductoActionPerformed

    private void campoExistenciaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoExistenciaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoExistenciaProductoActionPerformed

    private void campoAgregarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAgregarExistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAgregarExistenciaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        ProveedorFrame proveedor = new ProveedorFrame(null, true);
        proveedor.setVisible(true);
        proveedor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        proveedor.setLocation(600, 150);
        proveedor.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnAgregarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExistenciaActionPerformed
        if (!campoAgregarExistencia.getText().isEmpty()) {
            double existencia = Double.parseDouble(campoAgregarExistencia.getText());
            double cantidadActual = productoSeleccionado.getExistenciasProducto();
            double nuevaCantidad = cantidadActual + existencia;
            base.actualizarInventario(productoSeleccionado, nuevaCantidad);
            cargarModeloTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No ha insertado un valor");
        }
        limpiarCampos();
    }//GEN-LAST:event_btnAgregarExistenciaActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        // Limpia la tabla antes de realizar una nueva búsqueda.
        limpiarTabla();

        // Obtiene la cadena de búsqueda ingresada en el campo de búsqueda.
        String cadenaBusqueda = campoBuscar.getText();

        // Obtiene la lista de productos que coinciden con la cadena de búsqueda.
        ArrayList<Producto> listaProductos = base.obtenerProductosPorCriterio(cadenaBusqueda);

        // Actualiza el número de filas en el modelo de la tabla según la cantidad de productos encontrados.
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);

        // Itera sobre la lista de productos y actualiza cada fila de la tabla con la información del producto correspondiente.
        for (int i = 0; i < numeroProductos; i++) {
            Producto producto = listaProductos.get(i);
            String clave = producto.getIdProducto();
            String nombre = producto.getNomProducto();
            String descripcion = producto.getDescProducto();
            String unidad = producto.getUnidadProducto();
            Double precioCompra = producto.getPrecioCompraProducto();
            Double precioVenta = producto.getPrecioVentaProducto();
            Double existencias = producto.getExistenciasProducto();

            // Actualiza las celdas de la fila actual en el modelo de la tabla con la información del producto.
            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(producto, i, 1);// Aquí se asigna directamente el objeto Producto
            modeloTabla.setValueAt(descripcion, i, 2);
            modeloTabla.setValueAt(unidad, i, 3);
            modeloTabla.setValueAt(precioCompra, i, 4);
            modeloTabla.setValueAt(precioVenta, i, 5);
            modeloTabla.setValueAt(existencias, i, 6);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarActionPerformed

    private void btnBorrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProdActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el producto?");
        if (opcion == 0 && tablaProductos.getSelectedRow() >= 0) {
            if (productoSeleccionado != null) {
                if (base.tieneVentasRegistradas(productoSeleccionado)) {
                    JOptionPane.showMessageDialog(this, "No se puede eliminar el producto porque ya tiene ventas registradas.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    modeloTabla.removeRow(tablaProductos.getSelectedRow());
                    base.borrarProducto(productoSeleccionado);
                    limpiarCampos();
                    lblImagen.setIcon(null); // Esto eliminará la imagen del JLabel
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido obtener el producto seleccionado.");
            }
        } else if (opcion == 0 && tablaProductos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún elemento de la tabla.");
        }
    }//GEN-LAST:event_btnBorrarProdActionPerformed

    private void desplegarFoto(Producto prod) {
        ImageIcon imagenProducto = null;
        try {
            //obtener imagen
            InputStream is = base.buscarFoto(prod);
            BufferedImage bi = ImageIO.read(is);
            imagenProducto = new ImageIcon(bi);

            //Redimensión de imagen para ajustarla al tamaño del JLabel
            Image imgProd = imagenProducto.getImage();
            // Obtener el ancho y alto del JLabel lblImagenArticulo
            int anchoImagen = lblImagen.getWidth();
            int altoImagen = lblImagen.getHeight();

            // Se crea un nuevo un objeto Image con la imagen redimensionada
            Image imgRedimensionada = imgProd.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);

            // Se crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);

            // Se establece el ImageIcon redimensionado como icono del JLabel
            lblImagen.setIcon(iconRedimensionado);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void btnModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProdActionPerformed

        if (productoSeleccionado != null) {
            String nombreProducto = productoSeleccionado.getNomProducto();
            ImageIcon imagenProducto = null;
            ProductoFrame frameProd = null;
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está segura(o) de modificar el artículo "
                    + nombreProducto + "?");
            if (opcion == 0) {
                try {
                    //obtener imagen
                    InputStream is = base.buscarFoto(productoSeleccionado);
                    BufferedImage bi = ImageIO.read(is);
                    imagenProducto = new ImageIcon(bi);

                    //crear ventana de actualización
                    frameProd = new ProductoFrame(null, true, productoSeleccionado, imagenProducto, "Actualizar producto", true);
                    frameProd.setVisible(true);
                    if (frameProd != null) {
                        if (frameProd.getInformacion() != "") {
                            cargarModeloTabla();
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {

            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún elemento para editar");
        }

    }//GEN-LAST:event_btnModificarProdActionPerformed

    private void limpiarTabla() {
        int numFilas = modeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }

    private void limpiarCampos() {
        campoClaveProducto.setText("");
        campoBuscar.setText("");
        campoAgregarExistencia.setText("");
        campoExistenciaProducto.setText("");
        campoNombreProducto.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExistencia;
    private javax.swing.JButton btnBorrarProd;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnModificarProd;
    private javax.swing.JButton btnNuevoArticulo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JTextField campoAgregarExistencia;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoClaveProducto;
    private javax.swing.JTextField campoExistenciaProducto;
    private javax.swing.JTextField campoNombreProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
