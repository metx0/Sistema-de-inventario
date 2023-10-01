package interfaz;

import cola.ColaSimple;
import cola.Nodo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import productos.Inventario;
import productos.Producto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazInventario extends javax.swing.JFrame {
    private Inventario inventario = new Inventario();
    
    // La cola se usa para insertar los elementos ordenados del inventario y así consumirlos
    private ColaSimple cola = new ColaSimple();
    
    // El formato para parsear las fechas
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    // Instancias de "DefaultTableModel" para manejar la tablas "tablaVenta" y "tablaStock"
    DefaultTableModel tblVenta = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 2; // Sólo se puede editar la columna de "Cantidad a vender"
        }
    };
    
    DefaultTableModel tblStock = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // No se puede editar nada. Modo lectura
        }
    };

    // Capturar el texto de la fecha para imprimirlo en la tabla "tablaStock"
    String fechaIngresada;

    /**
     * Creates new form InterfazInventario
     */
    public InterfazInventario() {
        initComponents();
        setTitle("Sistema de gestión de inventario");
        setLocationRelativeTo(null); // Centramos la ventana
        setResizable(false); // Establecemos que la ventana no se pueda cambiar de tamaño
        TextPrompt fondoTexto = new TextPrompt("dd-mm-yyyy", textFecha);

        // Manejando la tabla de la pestaña "Venta"
        String[] columnasVenta = new String[]{"Nombre", "Stock", "Cantidad a vender"};
        tblVenta.setColumnIdentifiers(columnasVenta);
        tablaVenta.setModel(tblVenta); // Asignando a la tabla del JFrame, el modelo actual

        // Manejando la tabla de la pestaña "Stock"
        String[] columnasStock = new String[]{"Nombre", "ID", "Stock", "Fecha caducidad"};
        tblStock.setColumnIdentifiers(columnasStock);
        tablaStock.setModel(tblStock); // Asignando a la tabla del JFrame, el modelo actual
    }

    private void agregarVenta(String nombre, String stock) {
        tblVenta.addRow(new Object[]{
            nombre, stock, "0"
        });
    }

    private void agregarStock(String nombre, String ID, String stock, String fecha) {
        tblStock.addRow(new Object[]{
            nombre, ID, stock, fecha
        });
    }

    private void vender() {
        if (tblVenta.getRowCount() != 0) {
            for (int i = 0; i < tblVenta.getRowCount(); i++) {
                try {
                    // Obtener la cantidad a vender desde la tabla (columna 3)
                    Object cantidadVenderObj = tblVenta.getValueAt(i, 2);

                    if (cantidadVenderObj != null) {
                        // Convertir la cantidad a vender a entero
                        int cantidadVender = Integer.parseInt(cantidadVenderObj.toString());

                        // Obtener el stock actual desde la tabla (columna 2)
                        Object stockObj = tblVenta.getValueAt(i, 1);

                        if (stockObj != null) {
                            int stock = Integer.parseInt(stockObj.toString());
                            if ((stock - cantidadVender) >= 0) {
                                // Restar la cantidad a vender del stock
                                int nuevoStock = stock - cantidadVender;

                                // Actualizar el stock en la tabla
                                tblVenta.setValueAt(nuevoStock, i, 1);

                                // Actualizar el stock en tu lista de inventario (si es necesario)
                                inventario.getListaProductos().get(i).setStock(nuevoStock);

                                // Actualizar la tabla "tblStock"
                                tblStock.setValueAt(((Integer.parseInt(tblStock.getValueAt(i, 2).toString())) - (Integer.parseInt(tblVenta.getValueAt(i, 2).toString()))), i, 2);
                            } else {
                                JOptionPane.showMessageDialog(null, "No puede vender más de lo que hay en el stock", "Error de validación", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Fila " + (i + 1) + ": El stock es nulo o no es un número válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila " + (i + 1) + ": Ingrese la cantidad a vender", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Fila " + (i + 1) + ": La cantidad a vender no es un número válido", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista", "Error de validación", JOptionPane.ERROR_MESSAGE);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Nuevo = new javax.swing.JPanel();
        textNombre = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        textStock = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        textFecha = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        Venta = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        Stock = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStock = new javax.swing.JTable();
        Reporte = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_nombre_archivo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 153, 204));

        Nuevo.setBackground(new java.awt.Color(104, 168, 255));

        textNombre.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N

        textID.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N

        textStock.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N

        textPrecio.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("       ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Stock inicial");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Precio unitario   $");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Fecha de caducidad");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Añadir nuevo lote");

        btnAceptar.setBackground(new java.awt.Color(51, 255, 255));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        textFecha.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N

        btnBorrar.setBackground(new java.awt.Color(51, 255, 255));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NuevoLayout = new javax.swing.GroupLayout(Nuevo);
        Nuevo.setLayout(NuevoLayout);
        NuevoLayout.setHorizontalGroup(
            NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoLayout.createSequentialGroup()
                .addGap(0, 168, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(NuevoLayout.createSequentialGroup()
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(NuevoLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoLayout.createSequentialGroup()
                                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevoLayout.createSequentialGroup()
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NuevoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(textID)
                            .addComponent(textStock)
                            .addComponent(textPrecio)
                            .addComponent(textFecha)))
                    .addGroup(NuevoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        NuevoLayout.setVerticalGroup(
            NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(NuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jLabel4.getAccessibleContext().setAccessibleName("Precio:");

        jTabbedPane1.addTab("Nuevo", Nuevo);

        Venta.setBackground(new java.awt.Color(245, 194, 109));

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Stock", "Cantidad a vender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaVenta);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ingresar la cantidad a vender en los productos deseados y pulsar \"enter\"");

        btnVender.setBackground(new java.awt.Color(253, 223, 174));
        btnVender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VentaLayout = new javax.swing.GroupLayout(Venta);
        Venta.setLayout(VentaLayout);
        VentaLayout.setHorizontalGroup(
            VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addGroup(VentaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(VentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        VentaLayout.setVerticalGroup(
            VentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentaLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venta", Venta);

        Stock.setBackground(new java.awt.Color(153, 102, 0));

        tablaStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "ID", "Stock", "Fecha caducidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaStock);

        javax.swing.GroupLayout StockLayout = new javax.swing.GroupLayout(Stock);
        Stock.setLayout(StockLayout);
        StockLayout.setHorizontalGroup(
            StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        StockLayout.setVerticalGroup(
            StockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock", Stock);

        Reporte.setBackground(new java.awt.Color(102, 153, 255));

        btnReporte.setBackground(new java.awt.Color(0, 102, 204));
        btnReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReporte.setText("Generar reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("A continuación, puede generar un reporte ordenado");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Inserta el nombre del archivo:");

        jTextField_nombre_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombre_archivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReporteLayout = new javax.swing.GroupLayout(Reporte);
        Reporte.setLayout(ReporteLayout);
        ReporteLayout.setHorizontalGroup(
            ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReporteLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReporteLayout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReporteLayout.createSequentialGroup()
                        .addGroup(ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ReporteLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_nombre_archivo))
                            .addComponent(jLabel8))
                        .addGap(89, 89, 89))))
        );
        ReporteLayout.setVerticalGroup(
            ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReporteLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nombre_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(207, 207, 207))
        );

        jTabbedPane1.addTab("Reporte", Reporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Vacía los campos de texto
    private void vaciarCampos() {
        textNombre.setText("");
        textID.setText("");
        textStock.setText("");
        textPrecio.setText("");
        textFecha.setText("");
    }

    // Método que recupera los datos para crear el objeto Producto
    // Valida que todos los datos hayan sido insertados y maneja excepciones
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Si alguno es una cadena vacía, mostramos un mensaje de error
        if (textNombre.getText().equals("") || textID.getText().equals("") || textStock.getText().equals("") || textPrecio.getText().equals("") || textFecha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos para crear el producto", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = textNombre.getText();
        int id, stock;
        double precio;

        // Puede ocurrir la excepción si un número no se puede convertir
        try {
            id = Integer.parseInt(textID.getText());
            stock = Integer.parseInt(textStock.getText());
            precio = Double.parseDouble(textPrecio.getText());
            
            if (precio <= 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor positivo para el precio", "Error de precio negativo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            fechaIngresada = textFecha.getText();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate fechaCaducidad;

        try {
            fechaCaducidad = LocalDate.parse(textFecha.getText(), formatoFecha);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "El formato para la fecha es incorrecto", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Creamos el objeto Producto
        Producto lote = new Producto(nombre, id, stock, precio, fechaCaducidad);
        // Lo añadimos al inventario
        int resultado = inventario.agregarProducto(lote);

        // Manejamos los distintos resultados posibles
        if (resultado == 1) {
            JOptionPane.showMessageDialog(null, "Ya existe un producto con ese ID", "ID ya existente", JOptionPane.ERROR_MESSAGE);
        } else if (resultado == 2) {
            JOptionPane.showMessageDialog(null, "La fecha de caducidad es inválda", "Fecha inválida", JOptionPane.ERROR_MESSAGE);
        } else if (resultado == 3) {
            JOptionPane.showMessageDialog(null, "Producto añadido exitosamente", "Producto añadido", JOptionPane.INFORMATION_MESSAGE);
            // Añadimos los datos necesarios a la tabla de la pestaña "Venta"
            agregarVenta(nombre, String.valueOf(stock));
            // Añadimos los datos necesarios a la tabla de la pestaña "Stock"
            agregarStock(nombre, String.valueOf(id), String.valueOf(stock), fechaIngresada);
            vaciarCampos();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        vaciarCampos();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        vender();
    }//GEN-LAST:event_btnVenderActionPerformed

    // Este botón manda a ordenar la lista de productos y a meterlas en una cola para consumirlas
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        String nombreArchivoCSV = jTextField_nombre_archivo.getText();

        // Verificar si el texto está vacío o contiene solo espacios en blanco
        if (nombreArchivoCSV.trim().isEmpty()) {
            nombreArchivoCSV = "Reporte";
        }
        
        if (inventario.listaProductos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Aún no hay productos añadidos", "No hay productos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        inventario.ordenarProductos();
        
        // Para cada producto de la lista
        for (Producto producto : inventario.listaProductos) {
            cola.insertar(producto); 
        }
        
        // Para consumir la cola se tiene que iterar sobre la misma, obtener al array con los datos y escribirlos
        Nodo nodoActual = cola.getFrente();
        
        try {

            int contador = 1;
            String nombreArchivoOriginal = nombreArchivoCSV;
            File archivoExistente = new File(nombreArchivoCSV + ".csv");
            while (archivoExistente.exists()) {
                // Generar un nombre de archivo único si ya existe
                nombreArchivoCSV = nombreArchivoOriginal + "_" + contador;
                archivoExistente = new File(nombreArchivoCSV + ".csv");
                contador++;
            }
            
            FileWriter creador_csv = new FileWriter(nombreArchivoCSV + ".csv"); // Crea un nuevo archivo en lugar de abrir en modo de añadir
               
            while (nodoActual != null) {
                Producto producto = nodoActual.getProducto(); // Obtener el producto del nodo

                // Acceder a los datos del producto
                String nombre = producto.getNombre();
                int id = producto.getId();
                int stock = producto.getStock();
                String fechaCaducidad = String.valueOf(producto.getFechaCaducidad());

                // Unir los datos del producto con comas
                String lineaCSV = String.join(",", nombre, String.valueOf(id), String.valueOf(stock), fechaCaducidad);

                // Escribir la línea CSV en el archivo
                creador_csv.write(lineaCSV);

                // Agregar un salto de línea después de cada línea
                creador_csv.write(System.lineSeparator());

                nodoActual = nodoActual.getSiguiente();
            }

            creador_csv.write(System.lineSeparator()); // Agregar un salto de línea después de cada bloque de datos
            
            //Borrar la cola
            while (!cola.estaVacia()) {
                cola.eliminar();
            }
            // Cerrar el objeto FileWriter después de usarlo
            creador_csv.close();

            JOptionPane.showMessageDialog(this, "El registro ha sido creado.", "Tarea completada", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(InterfazInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void jTextField_nombre_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombre_archivoActionPerformed
        
    }//GEN-LAST:event_jTextField_nombre_archivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Nuevo;
    private javax.swing.JPanel Reporte;
    private javax.swing.JPanel Stock;
    private javax.swing.JPanel Venta;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField_nombre_archivo;
    private javax.swing.JTable tablaStock;
    private javax.swing.JTable tablaVenta;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textStock;
    // End of variables declaration//GEN-END:variables
}
