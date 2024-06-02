# Sistema de Inventarios y Ventas con Gestión de Productos
Es una aplicación diseñada para gestionar inventarios y ventas en un entorno empresarial. Desarrollada en Java, esta aplicación ofrece una interfaz gráfica intuitiva para la administración de productos, categorías, proveedores y transacciones de ventas.

## Modelos de Datos

Las clases que se encuentran en los paquetes `sistema.pojos` son de tipo POJO (Plain Old Java Object) y modelan entidades dentro del sistema de gestión. Cada clase representa un concepto específico dentro del dominio del sistema, como productos, categorías, proveedores y ventas. Estas entidades encapsulan datos y comportamientos relacionados con su respectivo dominio, facilitando su manipulación y gestión dentro de la aplicación:

- **Producto**: Representa un artículo disponible para la venta o gestión en el sistema, con detalles como nombre, descripción, cantidad en stock, precios, categoría y proveedor asociado.
- **CategoriaProd**: Modela las diferentes categorías de productos dentro del sistema, permitiendo organizar y gestionar los productos en grupos específicos. Contiene atributos como identificador, nombre y descripción de la categoría.
- **Proveedor**: Representa los proveedores que suministran productos al sistema, incluyendo detalles como nombre, dirección, contacto y correo electrónico.
- **Venta**: Registra cada transacción de venta en el sistema, con atributos como identificador de venta, monto total de la venta y fecha de la transacción. Es esencial para el seguimiento y gestión de las ventas realizadas.
- **DetalleVenta**: Almacena detalles específicos de cada artículo vendido, incluyendo el ID de la venta, el ID del producto y la cantidad vendida.

## Gráfica de Usuario

Las clases que se encuentran en los paquetes `sistema.gui` representan la interfaz de la aplicación. Estas clases son responsables de la interacción del usuario con el sistema, proporcionando ventanas y diálogos que permiten realizar diversas operaciones. A continuación se adjuntan una descripción de dichas clases e imágenes de su funcionamiento:

- **Principal**: Interfaz principal que permite al usuario elegir entre los módulos "Inventarios" y "Ventas". Se utiliza para mostrar los módulos seleccionados.

  ![app-principal](https://github.com/lizbeth-cortes/app-java/assets/60724433/3b64a833-1923-4710-9b6f-f22eabbfb068)

- **InventariosFrame**: Interfaz para gestionar el inventario de productos, permitiendo operaciones como agregar, modificar, eliminar, buscar y visualizar productos, así como actualizar la tabla en función de las acciones del usuario.

  ![app-inventario](https://github.com/lizbeth-cortes/app-java/assets/60724433/4f2d3bbb-27dd-424c-a598-6836471861bb)  ![app-inventario-error](https://github.com/lizbeth-cortes/app-java/assets/60724433/108734d5-6c3f-4810-bf95-be46f8e0e722)

- **ProductoFrame**: Ventana de diálogo para agregar nuevos productos o actualizar información existente. Permite ingresar detalles como clave del producto, nombre, descripción, etc.

  ![app-producto](https://github.com/lizbeth-cortes/app-java/assets/60724433/ac3610f7-74bc-4f1a-b154-96668439edcc)
  ![app-producto-error](https://github.com/lizbeth-cortes/app-java/assets/60724433/b6a33cec-dedd-4f03-9584-326215ed123a)


- **CategoriaFrame**: Diálogo de interfaz para crear nuevas categorías de productos. Permite ingresar nombre y descripción para la categoría.

  ![app-categoria](https://github.com/lizbeth-cortes/app-java/assets/60724433/a5d7b697-e439-4fb3-9175-0987b5dee03c)  ![app-categoria-error](https://github.com/lizbeth-cortes/app-java/assets/60724433/3f35ffcc-6662-4cb8-8d26-06e3f3f39506)

- **ProveedorFrame**: Ventana de diálogo para agregar nuevos proveedores al sistema. Permite ingresar detalles como nombre, dirección, teléfono, etc.

  ![app-proveedor](https://github.com/lizbeth-cortes/app-java/assets/60724433/a64005c8-a171-429c-b6d7-a240e2bf9a73)
  ![app-proveedor-error](https://github.com/lizbeth-cortes/app-java/assets/60724433/e167945c-3644-4fdf-a18e-9fc09ed1edd6)

- **VentasFrame**: Gestiona las ventas del sistema, permitiendo agregar productos a una venta, calcular el total, realizar la venta, cancelarla y obtener un corte de caja del día. También ofrece funcionalidades para eliminar productos de la venta y mostrar imágenes de productos.

  ![app-ventas](https://github.com/lizbeth-cortes/app-java/assets/60724433/be5ac880-984c-4d74-ac0f-ae6f95f322e9)
  ![app-ventas-1](https://github.com/lizbeth-cortes/app-java/assets/60724433/b5e4c4ad-ddee-4ec5-9792-7b667460a749)
  ![app-ventas-corte](https://github.com/lizbeth-cortes/app-java/assets/60724433/1b6b83e5-85e9-43fa-adec-18e133d4ed15)
  ![app-ventas-eliminar](https://github.com/lizbeth-cortes/app-java/assets/60724433/5e050ab2-c568-4901-940b-c03c74f6c828)
  ![app-ventas-cancelar](https://github.com/lizbeth-cortes/app-java/assets/60724433/d69b38ec-5c7e-46a9-adff-105e428c53ae)
  ![app-ventas-error](https://github.com/lizbeth-cortes/app-java/assets/60724433/d930f900-df60-41fe-9859-6d215147b7da)

  Para editar la cantidad de artículos en la venta sólo es necesario elegir el articulo de la tabla y presionar la tecla **f2**:
  
  ![app-ventas-modificar](https://github.com/lizbeth-cortes/app-java/assets/60724433/1d9ab7f3-bdc8-4705-ae71-6039e7ef6078)







## Base de Datos

La clase `BaseDeDatos` facilita la interacción con una base de datos PostgreSQL, ofreciendo métodos para realizar operaciones comunes:

- **Conexión a la Base de Datos**: Establece conexiones a PostgreSQL utilizando el controlador JDBC.
- **Operaciones de Inserción, Actualización y Eliminación**: Proporciona métodos para insertar, actualizar y borrar registros en las tablas de productos, proveedores y ventas.
- **Obtención de Datos**: Incluye métodos para recuperar datos, como obtener todos los productos, proveedores o categorías, así como buscar productos basados en ciertos criterios.
- **Operaciones de Gestión de Ventas**: Permite registrar ventas, insertar detalles de ventas y calcular el total de ventas en una fecha específica.

## Archivos Incluidos en el Proyecto

En este proyecto se incluye tanto el archivo de la base de datos y el código de la aplicación de Java. Si sólo se quiere ejecutar la aplicación, sólo es necesario descargar la carpeta `dist`, la cual contiene el archivo ejecutable llamado `sistema.jar`. Por supuesto, también es necesario importar la base de datos que también se incluye en dicha carpeta.

## Nota

Este proyecto fue una de las actividades realizadas en el curso de Udemy [¡Ahora con JavaFX! Aprende conceptos básicos de programación hasta el desarrollo de un sistema completo con Java](https://ibmcsr.udemy.com/certificate/UC-2d303990-3436-437f-bc47-2fc146caf255/)
