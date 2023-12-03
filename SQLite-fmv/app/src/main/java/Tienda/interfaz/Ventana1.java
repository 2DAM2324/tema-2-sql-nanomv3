/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import Tienda.modelo.Cliente;
import Tienda.modelo.Empleado;
import Tienda.modelo.Pedido;
import Tienda.modelo.Producto;
import Tienda.modelo.Proveedor;
import Tienda.controlador.Controlador;
import Tienda.modelo.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JTable;

/**
 *
 * @author Patricia Burgos
 */
public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    public Ventana1() throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException {
        initComponents();
        conexion = new ConexionDB();
        mostrarDatosCliente(controlador.listaClientes());
        mostrarDatosPedido(controlador.listaPedidos());
        mostrarDatosProducto(controlador.listaProductos());
        mostrarDatosProveedor(controlador.listaProveedores());
        mostrarDatosEmpleado(controlador.listaEmpleados());
    }
    
    
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField_num_habitantes1 = new javax.swing.JTextField();
        jButton_borrar_persona1 = new javax.swing.JButton();
        jButton_modificar_persona1 = new javax.swing.JButton();
        jButton_aniadir_persona1 = new javax.swing.JButton();
        jButton_borrar_persona2 = new javax.swing.JButton();
        jButton_modificar_persona2 = new javax.swing.JButton();
        jButton_aniadir_persona2 = new javax.swing.JButton();
        jButton_aniadir_persona3 = new javax.swing.JButton();
        jButton_borrar_persona3 = new javax.swing.JButton();
        jButton_modificar_persona3 = new javax.swing.JButton();
        jButton_aniadir_persona4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        introducir_telf_cliente2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        paginas = new javax.swing.JTabbedPane();
        panel_cliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_datos_cliente = new javax.swing.JTable();
        button_add_cliente = new javax.swing.JButton();
        button_mod_cliente = new javax.swing.JButton();
        button_del_cliente = new javax.swing.JButton();
        dni_label_cliente = new javax.swing.JLabel();
        nombre_label_cliente = new javax.swing.JLabel();
        direccion_label_cliente = new javax.swing.JLabel();
        introducir_dni_cliente = new javax.swing.JTextField();
        introducir_nombre_cliente = new javax.swing.JTextField();
        introducir_direccion_cliente = new javax.swing.JTextField();
        introducir_telf_cliente = new javax.swing.JTextField();
        telf_label_cliente = new javax.swing.JLabel();
        label_relacion_pedido = new javax.swing.JLabel();
        relacion_introducir_pedido_cliente = new javax.swing.JTextField();
        relacion_pedido_cliente_add_button = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        relacion_tabla_datos_pedido_cliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        relacion_introducir_empleado_cliente = new javax.swing.JTextField();
        relacion_empleado_cliente_add_button = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        relaicon_tabla_datos_empleado_cliente = new javax.swing.JTable();
        relacion_pedido_cliente_del_button = new javax.swing.JButton();
        relacion_empleado_cliente_del_button = new javax.swing.JButton();
        panel_pedido = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_datos_pedido = new javax.swing.JTable();
        fecha_label_pedido = new javax.swing.JLabel();
        estado_label_pedido = new javax.swing.JLabel();
        introducir_fecha_pedido = new javax.swing.JTextField();
        introducir_estado_pedido = new javax.swing.JTextField();
        button_add_pedido = new javax.swing.JButton();
        button_mod_pedido = new javax.swing.JButton();
        button_del_pedido = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        relacion_tabla_datos_producto_pedido = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        relacion_introducir_cliente_pedido = new javax.swing.JTextField();
        relacion_cliente_pedido_add_button = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        relaicon_tabla_datos_cliente_pedido = new javax.swing.JTable();
        relacion_producto_pedido_del_button = new javax.swing.JButton();
        relacion_cliente_pedido_del_button = new javax.swing.JButton();
        label_relacion_pedido1 = new javax.swing.JLabel();
        relacion_introducir_producto_pedido = new javax.swing.JTextField();
        relacion_producto_pedido_add_button = new javax.swing.JButton();
        panel_producto = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_datos_producto = new javax.swing.JTable();
        nombre_label_producto = new javax.swing.JLabel();
        precio_label_producto = new javax.swing.JLabel();
        introducir_precio_producto = new javax.swing.JTextField();
        introducir_nombre_producto = new javax.swing.JTextField();
        button_del_producto = new javax.swing.JButton();
        button_mod_producto = new javax.swing.JButton();
        button_add_producto = new javax.swing.JButton();
        stock_label_producto = new javax.swing.JLabel();
        introducir_stock_producto = new javax.swing.JTextField();
        relacion_introducir_pedido_producto = new javax.swing.JTextField();
        relacion_pedido_producto_del_button = new javax.swing.JButton();
        relacion_pedido_producto_add_button = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        relacion_tabla_datos_pedido_producto = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        label_relacion_pedido2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        relacion_introducir_proveedor_producto = new javax.swing.JTextField();
        relacion_proveedor_producto_add_button = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        relaicon_tabla_datos_proveedor_producto = new javax.swing.JTable();
        relacion_proveedor_producto_del_button = new javax.swing.JButton();
        panel_proveedor = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_datos_proveedor = new javax.swing.JTable();
        nom_empresa_label_proveedor = new javax.swing.JLabel();
        precio_label_proveedor = new javax.swing.JLabel();
        introducir_stock_proveedor = new javax.swing.JTextField();
        introducir_nom_empresa_proveedor = new javax.swing.JTextField();
        button_del_proveedor = new javax.swing.JButton();
        button_mod_proveedor = new javax.swing.JButton();
        button_add_proveedor = new javax.swing.JButton();
        stock_label_proveedor = new javax.swing.JLabel();
        introducir_precio_proveedor = new javax.swing.JTextField();
        relacion_introducir_producto_proveedor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        relacion_producto_proveedor_add_button = new javax.swing.JButton();
        relacion_producto_proveedor_del_button = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        relacion_tabla_datos_producto_proveedor = new javax.swing.JTable();
        label_relacion_pedido3 = new javax.swing.JLabel();
        panel_empleado = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_datos_empleado = new javax.swing.JTable();
        button_del_empleado = new javax.swing.JButton();
        button_mod_empleado = new javax.swing.JButton();
        button_add_empleado = new javax.swing.JButton();
        introducir_nombre_empleado = new javax.swing.JTextField();
        introducir_cargo_empleado = new javax.swing.JTextField();
        nombre_label_empleado = new javax.swing.JLabel();
        cargo_label_empleado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        relacion_introducir_cliente_empleado = new javax.swing.JTextField();
        relacion_cliente_empleado_add_button = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        relaicon_tabla_datos_cliente_empleado = new javax.swing.JTable();
        relacion_cliente_empleado_del_button = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jButton_borrar_persona1.setText("Borrar");
        jButton_borrar_persona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_persona1ActionPerformed(evt);
            }
        });

        jButton_modificar_persona1.setText("Modificar");
        jButton_modificar_persona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_persona1ActionPerformed(evt);
            }
        });

        jButton_aniadir_persona1.setText("AÒadir");
        jButton_aniadir_persona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_persona1ActionPerformed(evt);
            }
        });

        jButton_borrar_persona2.setText("Borrar");
        jButton_borrar_persona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_persona2ActionPerformed(evt);
            }
        });

        jButton_modificar_persona2.setText("Modificar");
        jButton_modificar_persona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_persona2ActionPerformed(evt);
            }
        });

        jButton_aniadir_persona2.setText("AÒadir");
        jButton_aniadir_persona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_persona2ActionPerformed(evt);
            }
        });

        jButton_aniadir_persona3.setText("AÒadir");
        jButton_aniadir_persona3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_persona3ActionPerformed(evt);
            }
        });

        jButton_borrar_persona3.setText("Borrar");
        jButton_borrar_persona3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_persona3ActionPerformed(evt);
            }
        });

        jButton_modificar_persona3.setText("Modificar");
        jButton_modificar_persona3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_persona3ActionPerformed(evt);
            }
        });

        jButton_aniadir_persona4.setText("AÒadir");
        jButton_aniadir_persona4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_persona4ActionPerformed(evt);
            }
        });

        jLabel4.setText("AÒadir pedido (ID):  ");

        jButton2.setText("AÒadir");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabla_datos_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "DirecciÛn", "TelÈfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_datos_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datos_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_datos_cliente);
        if (tabla_datos_cliente.getColumnModel().getColumnCount() > 0) {
            tabla_datos_cliente.getColumnModel().getColumn(0).setResizable(false);
            tabla_datos_cliente.getColumnModel().getColumn(1).setResizable(false);
            tabla_datos_cliente.getColumnModel().getColumn(2).setResizable(false);
            tabla_datos_cliente.getColumnModel().getColumn(3).setResizable(false);
        }

        button_add_cliente.setText("AÒadir");
        button_add_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_clienteActionPerformed(evt);
            }
        });

        button_mod_cliente.setText("Modificar");
        button_mod_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mod_clienteActionPerformed(evt);
            }
        });

        button_del_cliente.setText("Borrar");
        button_del_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_del_clienteActionPerformed(evt);
            }
        });

        dni_label_cliente.setText("DNI:");

        nombre_label_cliente.setText("Nombre:");

        direccion_label_cliente.setText("DirecciÛn:");

        introducir_dni_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introducir_dni_clienteActionPerformed(evt);
            }
        });

        telf_label_cliente.setText("TelÈfono:");

        label_relacion_pedido.setText("AÒadir pedido (ID):  ");

        relacion_introducir_pedido_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_introducir_pedido_clienteActionPerformed(evt);
            }
        });

        relacion_pedido_cliente_add_button.setText("AÒadir");
        relacion_pedido_cliente_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_pedido_cliente_add_buttonActionPerformed(evt);
            }
        });

        relacion_tabla_datos_pedido_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relacion_tabla_datos_pedido_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relacion_tabla_datos_pedido_clienteMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(relacion_tabla_datos_pedido_cliente);
        if (relacion_tabla_datos_pedido_cliente.getColumnModel().getColumnCount() > 0) {
            relacion_tabla_datos_pedido_cliente.getColumnModel().getColumn(0).setResizable(false);
            relacion_tabla_datos_pedido_cliente.getColumnModel().getColumn(1).setResizable(false);
            relacion_tabla_datos_pedido_cliente.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Pedidos cliente");

        jLabel3.setText("Empleado que supervisa el cliente");

        jLabel5.setText("AÒadir empleado (ID):");

        relacion_empleado_cliente_add_button.setText("AÒadir");
        relacion_empleado_cliente_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_empleado_cliente_add_buttonActionPerformed(evt);
            }
        });

        relaicon_tabla_datos_empleado_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relaicon_tabla_datos_empleado_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relaicon_tabla_datos_empleado_clienteMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(relaicon_tabla_datos_empleado_cliente);
        if (relaicon_tabla_datos_empleado_cliente.getColumnModel().getColumnCount() > 0) {
            relaicon_tabla_datos_empleado_cliente.getColumnModel().getColumn(0).setResizable(false);
            relaicon_tabla_datos_empleado_cliente.getColumnModel().getColumn(1).setResizable(false);
            relaicon_tabla_datos_empleado_cliente.getColumnModel().getColumn(2).setResizable(false);
        }

        relacion_pedido_cliente_del_button.setText("Borrar");
        relacion_pedido_cliente_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_pedido_cliente_del_buttonActionPerformed(evt);
            }
        });

        relacion_empleado_cliente_del_button.setText("Borrar");
        relacion_empleado_cliente_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_empleado_cliente_del_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_clienteLayout = new javax.swing.GroupLayout(panel_cliente);
        panel_cliente.setLayout(panel_clienteLayout);
        panel_clienteLayout.setHorizontalGroup(
            panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_clienteLayout.createSequentialGroup()
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_mod_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_add_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_del_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_clienteLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(236, 236, 236)
                                    .addComponent(relacion_empleado_cliente_del_button, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_clienteLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(relacion_introducir_empleado_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(relacion_empleado_cliente_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_clienteLayout.createSequentialGroup()
                                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_clienteLayout.createSequentialGroup()
                                                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dni_label_cliente)
                                                    .addComponent(nombre_label_cliente)
                                                    .addComponent(direccion_label_cliente)
                                                    .addComponent(telf_label_cliente)
                                                    .addComponent(label_relacion_pedido))
                                                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(panel_clienteLayout.createSequentialGroup()
                                                        .addGap(24, 24, 24)
                                                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(introducir_dni_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                                            .addComponent(introducir_nombre_cliente)
                                                            .addComponent(introducir_direccion_cliente)
                                                            .addComponent(introducir_telf_cliente)))
                                                    .addGroup(panel_clienteLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(relacion_introducir_pedido_cliente)))
                                                .addGap(38, 38, 38))
                                            .addGroup(panel_clienteLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(334, 334, 334)))
                                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(relacion_pedido_cliente_del_button, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                            .addComponent(relacion_pedido_cliente_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel_clienteLayout.setVerticalGroup(
            panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_clienteLayout.createSequentialGroup()
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button_add_cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_mod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_del_cliente))
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dni_label_cliente)
                    .addComponent(introducir_dni_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label_cliente)
                    .addComponent(introducir_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion_label_cliente)
                    .addComponent(introducir_direccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telf_label_cliente)
                    .addComponent(introducir_telf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_clienteLayout.createSequentialGroup()
                                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_relacion_pedido)
                                    .addComponent(relacion_introducir_pedido_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2))
                            .addGroup(panel_clienteLayout.createSequentialGroup()
                                .addComponent(relacion_pedido_cliente_add_button)
                                .addGap(12, 12, 12)
                                .addComponent(relacion_pedido_cliente_del_button)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(relacion_introducir_empleado_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relacion_empleado_cliente_add_button))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(relacion_empleado_cliente_del_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        paginas.addTab("Cliente", panel_cliente);

        tabla_datos_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_datos_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datos_pedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_datos_pedido);
        if (tabla_datos_pedido.getColumnModel().getColumnCount() > 0) {
            tabla_datos_pedido.getColumnModel().getColumn(0).setResizable(false);
            tabla_datos_pedido.getColumnModel().getColumn(1).setResizable(false);
            tabla_datos_pedido.getColumnModel().getColumn(2).setResizable(false);
        }

        fecha_label_pedido.setText("Fecha (DD/MM/AAAA):");

        estado_label_pedido.setText("Estado (Entregado / En proceso):");

        button_add_pedido.setText("AÒadir");
        button_add_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_pedidoActionPerformed(evt);
            }
        });

        button_mod_pedido.setText("Modificar");
        button_mod_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mod_pedidoActionPerformed(evt);
            }
        });

        button_del_pedido.setText("Borrar");
        button_del_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_del_pedidoActionPerformed(evt);
            }
        });

        relacion_tabla_datos_producto_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relacion_tabla_datos_producto_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relacion_tabla_datos_producto_pedidoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(relacion_tabla_datos_producto_pedido);
        if (relacion_tabla_datos_producto_pedido.getColumnModel().getColumnCount() > 0) {
            relacion_tabla_datos_producto_pedido.getColumnModel().getColumn(0).setResizable(false);
            relacion_tabla_datos_producto_pedido.getColumnModel().getColumn(1).setResizable(false);
            relacion_tabla_datos_producto_pedido.getColumnModel().getColumn(2).setResizable(false);
            relacion_tabla_datos_producto_pedido.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setText("Productos pedido");

        jLabel7.setText("Cliente del pedido");

        jLabel8.setText("AÒadir cliente (DNI):");

        relacion_cliente_pedido_add_button.setText("AÒadir");
        relacion_cliente_pedido_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_cliente_pedido_add_buttonActionPerformed(evt);
            }
        });

        relaicon_tabla_datos_cliente_pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "DirecciÛn", "TelÈfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relaicon_tabla_datos_cliente_pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relaicon_tabla_datos_cliente_pedidoMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(relaicon_tabla_datos_cliente_pedido);
        if (relaicon_tabla_datos_cliente_pedido.getColumnModel().getColumnCount() > 0) {
            relaicon_tabla_datos_cliente_pedido.getColumnModel().getColumn(0).setResizable(false);
            relaicon_tabla_datos_cliente_pedido.getColumnModel().getColumn(1).setResizable(false);
            relaicon_tabla_datos_cliente_pedido.getColumnModel().getColumn(2).setResizable(false);
            relaicon_tabla_datos_cliente_pedido.getColumnModel().getColumn(3).setResizable(false);
        }

        relacion_producto_pedido_del_button.setText("Borrar");
        relacion_producto_pedido_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_producto_pedido_del_buttonActionPerformed(evt);
            }
        });

        relacion_cliente_pedido_del_button.setText("Borrar");
        relacion_cliente_pedido_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_cliente_pedido_del_buttonActionPerformed(evt);
            }
        });

        label_relacion_pedido1.setText("AÒadir producto (ID):  ");

        relacion_producto_pedido_add_button.setText("AÒadir");
        relacion_producto_pedido_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_producto_pedido_add_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_pedidoLayout = new javax.swing.GroupLayout(panel_pedido);
        panel_pedido.setLayout(panel_pedidoLayout);
        panel_pedidoLayout.setHorizontalGroup(
            panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pedidoLayout.createSequentialGroup()
                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_mod_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_add_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_del_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_pedidoLayout.createSequentialGroup()
                                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(236, 236, 236))
                                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(relacion_introducir_cliente_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relacion_cliente_pedido_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(relacion_cliente_pedido_del_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_pedidoLayout.createSequentialGroup()
                                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(334, 334, 334))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pedidoLayout.createSequentialGroup()
                                        .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel_pedidoLayout.createSequentialGroup()
                                                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(fecha_label_pedido)
                                                    .addComponent(estado_label_pedido))
                                                .addGap(24, 24, 24)
                                                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(introducir_fecha_pedido)
                                                    .addComponent(introducir_estado_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(panel_pedidoLayout.createSequentialGroup()
                                                .addComponent(label_relacion_pedido1)
                                                .addGap(18, 18, 18)
                                                .addComponent(relacion_introducir_producto_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(38, 38, 38)))
                                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relacion_producto_pedido_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(relacion_producto_pedido_del_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_pedidoLayout.setVerticalGroup(
            panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pedidoLayout.createSequentialGroup()
                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button_add_pedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_mod_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_del_pedido))
                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_label_pedido)
                    .addComponent(introducir_fecha_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estado_label_pedido)
                    .addComponent(introducir_estado_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_pedidoLayout.createSequentialGroup()
                        .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_relacion_pedido1)
                            .addComponent(relacion_introducir_producto_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relacion_producto_pedido_add_button))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6))
                    .addComponent(relacion_producto_pedido_del_button))
                .addGap(18, 18, 18)
                .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pedidoLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(panel_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(relacion_introducir_cliente_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relacion_cliente_pedido_add_button))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(relacion_cliente_pedido_del_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        paginas.addTab("Pedido", panel_pedido);

        tabla_datos_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_datos_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datos_productoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_datos_producto);
        if (tabla_datos_producto.getColumnModel().getColumnCount() > 0) {
            tabla_datos_producto.getColumnModel().getColumn(0).setResizable(false);
            tabla_datos_producto.getColumnModel().getColumn(1).setResizable(false);
            tabla_datos_producto.getColumnModel().getColumn(2).setResizable(false);
            tabla_datos_producto.getColumnModel().getColumn(3).setResizable(false);
        }

        nombre_label_producto.setText("Nombre:");

        precio_label_producto.setText("Precio:");

        button_del_producto.setText("Borrar");
        button_del_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_del_productoActionPerformed(evt);
            }
        });

        button_mod_producto.setText("Modificar");
        button_mod_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mod_productoActionPerformed(evt);
            }
        });

        button_add_producto.setText("AÒadir");
        button_add_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_productoActionPerformed(evt);
            }
        });

        stock_label_producto.setText("Sotck (SI/NO):");

        relacion_pedido_producto_del_button.setText("Borrar");
        relacion_pedido_producto_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_pedido_producto_del_buttonActionPerformed(evt);
            }
        });

        relacion_pedido_producto_add_button.setText("AÒadir");
        relacion_pedido_producto_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_pedido_producto_add_buttonActionPerformed(evt);
            }
        });

        relacion_tabla_datos_pedido_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relacion_tabla_datos_pedido_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relacion_tabla_datos_pedido_productoMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(relacion_tabla_datos_pedido_producto);
        if (relacion_tabla_datos_pedido_producto.getColumnModel().getColumnCount() > 0) {
            relacion_tabla_datos_pedido_producto.getColumnModel().getColumn(0).setResizable(false);
            relacion_tabla_datos_pedido_producto.getColumnModel().getColumn(1).setResizable(false);
            relacion_tabla_datos_pedido_producto.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel9.setText("Pedidos producto");

        label_relacion_pedido2.setText("AÒadir pedido (ID):  ");

        jLabel10.setText("Proveedor del producto");

        jLabel11.setText("AÒadir proveedor (ID):");

        relacion_proveedor_producto_add_button.setText("AÒadir");
        relacion_proveedor_producto_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_proveedor_producto_add_buttonActionPerformed(evt);
            }
        });

        relaicon_tabla_datos_proveedor_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Empresa", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relaicon_tabla_datos_proveedor_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relaicon_tabla_datos_proveedor_productoMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(relaicon_tabla_datos_proveedor_producto);
        if (relaicon_tabla_datos_proveedor_producto.getColumnModel().getColumnCount() > 0) {
            relaicon_tabla_datos_proveedor_producto.getColumnModel().getColumn(0).setResizable(false);
            relaicon_tabla_datos_proveedor_producto.getColumnModel().getColumn(1).setResizable(false);
            relaicon_tabla_datos_proveedor_producto.getColumnModel().getColumn(2).setResizable(false);
            relaicon_tabla_datos_proveedor_producto.getColumnModel().getColumn(3).setResizable(false);
        }

        relacion_proveedor_producto_del_button.setText("Borrar");
        relacion_proveedor_producto_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_proveedor_producto_del_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_productoLayout = new javax.swing.GroupLayout(panel_producto);
        panel_producto.setLayout(panel_productoLayout);
        panel_productoLayout.setHorizontalGroup(
            panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_productoLayout.createSequentialGroup()
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_productoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_mod_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_add_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_del_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_productoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_productoLayout.createSequentialGroup()
                                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_productoLayout.createSequentialGroup()
                                        .addComponent(label_relacion_pedido2)
                                        .addGap(18, 18, 18)
                                        .addComponent(relacion_introducir_pedido_producto)
                                        .addGap(38, 38, 38))
                                    .addGroup(panel_productoLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(334, 334, 334)))
                                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(relacion_pedido_producto_del_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(relacion_pedido_producto_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel_productoLayout.createSequentialGroup()
                                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_productoLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(236, 236, 236))
                                    .addGroup(panel_productoLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(relacion_introducir_proveedor_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relacion_proveedor_producto_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(relacion_proveedor_producto_del_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panel_productoLayout.createSequentialGroup()
                                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel_productoLayout.createSequentialGroup()
                                        .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombre_label_producto)
                                            .addComponent(precio_label_producto)
                                            .addComponent(stock_label_producto))
                                        .addGap(34, 34, 34)
                                        .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(introducir_nombre_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                            .addComponent(introducir_precio_producto)
                                            .addComponent(introducir_stock_producto))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        panel_productoLayout.setVerticalGroup(
            panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_productoLayout.createSequentialGroup()
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_productoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button_add_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_mod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_del_producto))
                    .addGroup(panel_productoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label_producto)
                    .addComponent(introducir_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio_label_producto)
                    .addComponent(introducir_precio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_label_producto)
                    .addComponent(introducir_stock_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_productoLayout.createSequentialGroup()
                        .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_relacion_pedido2)
                            .addComponent(relacion_introducir_pedido_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9))
                    .addGroup(panel_productoLayout.createSequentialGroup()
                        .addComponent(relacion_pedido_producto_add_button)
                        .addGap(12, 12, 12)
                        .addComponent(relacion_pedido_producto_del_button)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_productoLayout.createSequentialGroup()
                        .addGroup(panel_productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(relacion_introducir_proveedor_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relacion_proveedor_producto_add_button))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(relacion_proveedor_producto_del_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        paginas.addTab("Producto", panel_producto);

        tabla_datos_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre empresa", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_datos_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datos_proveedorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabla_datos_proveedor);
        if (tabla_datos_proveedor.getColumnModel().getColumnCount() > 0) {
            tabla_datos_proveedor.getColumnModel().getColumn(0).setResizable(false);
            tabla_datos_proveedor.getColumnModel().getColumn(1).setResizable(false);
            tabla_datos_proveedor.getColumnModel().getColumn(2).setResizable(false);
            tabla_datos_proveedor.getColumnModel().getColumn(3).setResizable(false);
        }

        nom_empresa_label_proveedor.setText("Nombre empresa:");

        precio_label_proveedor.setText("Precio:");

        button_del_proveedor.setText("Borrar");
        button_del_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_del_proveedorActionPerformed(evt);
            }
        });

        button_mod_proveedor.setText("Modificar");
        button_mod_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mod_proveedorActionPerformed(evt);
            }
        });

        button_add_proveedor.setText("AÒadir");
        button_add_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_proveedorActionPerformed(evt);
            }
        });

        stock_label_proveedor.setText("Stock (SI/NO):");

        jLabel12.setText("Productos pedido");

        relacion_producto_proveedor_add_button.setText("AÒadir");
        relacion_producto_proveedor_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_producto_proveedor_add_buttonActionPerformed(evt);
            }
        });

        relacion_producto_proveedor_del_button.setText("Borrar");
        relacion_producto_proveedor_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_producto_proveedor_del_buttonActionPerformed(evt);
            }
        });

        relacion_tabla_datos_producto_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relacion_tabla_datos_producto_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relacion_tabla_datos_producto_proveedorMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(relacion_tabla_datos_producto_proveedor);
        if (relacion_tabla_datos_producto_proveedor.getColumnModel().getColumnCount() > 0) {
            relacion_tabla_datos_producto_proveedor.getColumnModel().getColumn(0).setResizable(false);
            relacion_tabla_datos_producto_proveedor.getColumnModel().getColumn(1).setResizable(false);
            relacion_tabla_datos_producto_proveedor.getColumnModel().getColumn(2).setResizable(false);
            relacion_tabla_datos_producto_proveedor.getColumnModel().getColumn(3).setResizable(false);
        }

        label_relacion_pedido3.setText("AÒadir producto (ID):  ");

        javax.swing.GroupLayout panel_proveedorLayout = new javax.swing.GroupLayout(panel_proveedor);
        panel_proveedor.setLayout(panel_proveedorLayout);
        panel_proveedorLayout.setHorizontalGroup(
            panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_proveedorLayout.createSequentialGroup()
                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_proveedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_mod_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_add_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_del_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_proveedorLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_proveedorLayout.createSequentialGroup()
                                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_proveedorLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(334, 334, 334))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_proveedorLayout.createSequentialGroup()
                                        .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel_proveedorLayout.createSequentialGroup()
                                                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(nom_empresa_label_proveedor)
                                                    .addComponent(precio_label_proveedor)
                                                    .addComponent(stock_label_proveedor))
                                                .addGap(24, 24, 24)
                                                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(introducir_nom_empresa_proveedor)
                                                    .addComponent(introducir_stock_proveedor)
                                                    .addComponent(introducir_precio_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(panel_proveedorLayout.createSequentialGroup()
                                                .addComponent(label_relacion_pedido3)
                                                .addGap(18, 18, 18)
                                                .addComponent(relacion_introducir_producto_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(38, 38, 38)))
                                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relacion_producto_proveedor_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(relacion_producto_proveedor_del_button, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel_proveedorLayout.setVerticalGroup(
            panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_proveedorLayout.createSequentialGroup()
                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_proveedorLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button_add_proveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_mod_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_del_proveedor))
                    .addGroup(panel_proveedorLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_empresa_label_proveedor)
                    .addComponent(introducir_nom_empresa_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio_label_proveedor)
                    .addComponent(introducir_precio_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_label_proveedor)
                    .addComponent(introducir_stock_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171)
                .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_proveedorLayout.createSequentialGroup()
                        .addGroup(panel_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_relacion_pedido3)
                            .addComponent(relacion_introducir_producto_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relacion_producto_proveedor_add_button))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12))
                    .addComponent(relacion_producto_proveedor_del_button))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        paginas.addTab("Proveedor", panel_proveedor);

        tabla_datos_empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_datos_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_datos_empleadoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabla_datos_empleado);
        if (tabla_datos_empleado.getColumnModel().getColumnCount() > 0) {
            tabla_datos_empleado.getColumnModel().getColumn(0).setResizable(false);
            tabla_datos_empleado.getColumnModel().getColumn(1).setResizable(false);
            tabla_datos_empleado.getColumnModel().getColumn(2).setResizable(false);
        }

        button_del_empleado.setText("Borrar");
        button_del_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_del_empleadoActionPerformed(evt);
            }
        });

        button_mod_empleado.setText("Modificar");
        button_mod_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mod_empleadoActionPerformed(evt);
            }
        });

        button_add_empleado.setText("AÒadir");
        button_add_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_empleadoActionPerformed(evt);
            }
        });

        introducir_nombre_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introducir_nombre_empleadoActionPerformed(evt);
            }
        });

        introducir_cargo_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introducir_cargo_empleadoActionPerformed(evt);
            }
        });

        nombre_label_empleado.setText("Nombre:");

        cargo_label_empleado.setText("Cargo (Empleado / Encargado):");

        jLabel13.setText("Cliente del pedido");

        jLabel14.setText("AÒadir cliente (DNI):");

        relacion_cliente_empleado_add_button.setText("AÒadir");
        relacion_cliente_empleado_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_cliente_empleado_add_buttonActionPerformed(evt);
            }
        });

        relaicon_tabla_datos_cliente_empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "DirecciÛn", "TelÈfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relaicon_tabla_datos_cliente_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relaicon_tabla_datos_cliente_empleadoMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(relaicon_tabla_datos_cliente_empleado);
        if (relaicon_tabla_datos_cliente_empleado.getColumnModel().getColumnCount() > 0) {
            relaicon_tabla_datos_cliente_empleado.getColumnModel().getColumn(0).setResizable(false);
            relaicon_tabla_datos_cliente_empleado.getColumnModel().getColumn(1).setResizable(false);
            relaicon_tabla_datos_cliente_empleado.getColumnModel().getColumn(2).setResizable(false);
            relaicon_tabla_datos_cliente_empleado.getColumnModel().getColumn(3).setResizable(false);
        }

        relacion_cliente_empleado_del_button.setText("Borrar");
        relacion_cliente_empleado_del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacion_cliente_empleado_del_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_empleadoLayout = new javax.swing.GroupLayout(panel_empleado);
        panel_empleado.setLayout(panel_empleadoLayout);
        panel_empleadoLayout.setHorizontalGroup(
            panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_empleadoLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_add_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_mod_empleado)
                    .addComponent(button_del_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(panel_empleadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_empleadoLayout.createSequentialGroup()
                        .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_empleadoLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(236, 236, 236))
                            .addGroup(panel_empleadoLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(relacion_introducir_cliente_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(relacion_cliente_empleado_add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(relacion_cliente_empleado_del_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_empleadoLayout.createSequentialGroup()
                        .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_empleadoLayout.createSequentialGroup()
                                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre_label_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cargo_label_empleado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(introducir_nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(introducir_cargo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_empleadoLayout.setVerticalGroup(
            panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_empleadoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_empleadoLayout.createSequentialGroup()
                        .addComponent(button_add_empleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_mod_empleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_del_empleado)))
                .addGap(32, 32, 32)
                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label_empleado)
                    .addComponent(introducir_nombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargo_label_empleado)
                    .addComponent(introducir_cargo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(212, 212, 212)
                .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_empleadoLayout.createSequentialGroup()
                        .addGroup(panel_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(relacion_introducir_cliente_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relacion_cliente_empleado_add_button))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addComponent(relacion_cliente_empleado_del_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        paginas.addTab("Empleado", panel_empleado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paginas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paginas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        paginas.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_borrar_persona1ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_modificar_persona1ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_aniadir_persona1ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_borrar_persona2ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_modificar_persona2ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_aniadir_persona2ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_aniadir_persona3ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_borrar_persona3ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_modificar_persona3ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void jButton_aniadir_persona4ActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void introducir_dni_clienteActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_save_clienteActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_cancel_clienteActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void tabla_datos_pedidoMouseClicked(java.awt.event.MouseEvent evt){
        System.out.println("mouseCLick");
        DefaultTableModel model = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_seleccionada = tabla_datos_pedido.getSelectedRow();
        if(fila_seleccionada >= 0){
            Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());
            ArrayList<Cliente> cliente = pedidoSeleccionado.getCliente();
            ArrayList<Producto> productos = pedidoSeleccionado.listaProductosPedido();
            
            mostrarRelacionProductoPedido(productos);
            mostrarRelacionClientePedido(cliente);
        }
        System.out.println("Salgo del mouseclick");
    }

    private void introducir_id_pedidoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_save_pedidoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_cancel_pedidoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void tabla_datos_proveedorMouseClicked(java.awt.event.MouseEvent evt){
        System.out.println("mouseCLick");
        DefaultTableModel model = (DefaultTableModel) tabla_datos_proveedor.getModel();
        int fila_seleccionada = tabla_datos_proveedor.getSelectedRow();
        if(fila_seleccionada >= 0){
            Integer idProveedorSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Proveedor proveedorSeleccionado = controlador.getProveedorPorId(idProveedorSeleccionado.toString());
            ArrayList<Producto> productos = proveedorSeleccionado.getProductos_proveedor();
            
            mostrarRelacionProductoProveedor(productos);
        }
        System.out.println("Salgo del mouseclick");
    }

    private void introducir_id_proveedorActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_save_proveedorActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_cancel_proveedorActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_del_proveedorActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_proveedor.getModel();
        int fila_seleccionada = tabla_datos_proveedor.getSelectedRow();
        System.out.println("Entro en boton borrar");

        if (fila_seleccionada >= 0) {
            System.out.println("entro en el if");
            // ObtÔøΩn el cliente seleccionado
            Integer idProveedorSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Proveedor proveedorSeleccionado = controlador.getProveedorPorId(idProveedorSeleccionado.toString());
            System.out.println("guardo el cliente selecionao");

            // Borra el cliente seleccionado del modelo de tabla
            model.removeRow(fila_seleccionada);

            // Luego, puedes realizar otras acciones como eliminar el cliente de tu controlador o sistema de almacenamiento (si es necesario).
            controlador.borrarProveedor(proveedorSeleccionado);
            // TODO: Leer los clientes del XML
        } else {
            // Muestra un mensaje de error si no se seleccionÔøΩ ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un proveedor para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button_mod_proveedorActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_proveedor.getModel();
        int fila_seleccionada = tabla_datos_proveedor.getSelectedRow();
        System.out.println("fila:" + fila_seleccionada);
        try{
            String stock = introducir_stock_proveedor.getText().toUpperCase();
            boolean hay_stock = false;
            if (fila_seleccionada >= 0) {
                if(introducir_nom_empresa_proveedor.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò— ]+")){
                    if(introducir_precio_proveedor.getText().matches("^[0-9]+(\\.[0-9]+)?$")){
                        if (stock.equals("SI") || stock.equals("NO")) {

                            System.out.println("Entro en if");
                            Integer idProveedorSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                            System.out.println("id: "+ idProveedorSeleccionado);
                            Proveedor proveedorSeleccionado = controlador.getProveedorPorId(idProveedorSeleccionado.toString());

                            if(stock.equals("SI")){
                                hay_stock = true;
                            }
                            else if(stock.equals("NO")){
                                hay_stock = false;
                            }

                            double precio = Double.parseDouble(introducir_precio_proveedor.getText());

                            Proveedor p = new Proveedor(introducir_nom_empresa_proveedor.getText(), precio, hay_stock);

                            controlador.modificarProveedor(proveedorSeleccionado, p);
                            ArrayList<Proveedor> proveedores = controlador.listaProveedores();

                            mostrarDatosProveedor(proveedores);
                        }else{
                            JOptionPane.showMessageDialog(this, "Las introducciones v·lidas en Stock son: SI/NO.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca un n˙mero v·lido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Escriba un nombre v·lido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un proveedor para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println(aioobe);
        }
    }

    private void button_add_proveedorActionPerformed(java.awt.event.ActionEvent evt){
        if (!introducir_nom_empresa_proveedor.getText().isEmpty() && 
        !introducir_precio_proveedor.getText().isEmpty() && 
        !introducir_stock_proveedor.getText().isEmpty()) {
            if(introducir_nom_empresa_proveedor.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò— ]+")){
                String stock = introducir_stock_proveedor.getText().toUpperCase();
                boolean hay_stock = false;

                if(introducir_precio_proveedor.getText().matches("^[0-9]+(\\.[0-9]+)?$")){
                    if (stock.equals("SI") || stock.equals("NO")) {

                        if(stock.equals("SI")){
                            hay_stock = true;
                        }
                        else if(stock.equals("NO")){
                            hay_stock = false;
                        }

                        double precio = Double.parseDouble(introducir_precio_proveedor.getText());

                        Proveedor p = new Proveedor(introducir_nom_empresa_proveedor.getText(), precio, hay_stock);

                        if (controlador.comprobarId(p)) {
                            controlador.agregarProveedor(p);
                        } else {
                            JOptionPane.showMessageDialog(this, "No pueden coincidir las IDs.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        ArrayList<Proveedor> proveedores = controlador.listaProveedores();
                        mostrarDatosProveedor(proveedores);
                        //TODO: Leer los clientes del XML
                    } else {
                        JOptionPane.showMessageDialog(this, "Las introducciones v·lidas en Stock son: SI/NO.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "El precio debe ser un n˙mero v·lido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Escriba un nombre v·lido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tabla_datos_empleadoMouseClicked(java.awt.event.MouseEvent evt){
        System.out.println("mouseCLick");
        DefaultTableModel model = (DefaultTableModel) tabla_datos_empleado.getModel();
        int fila_seleccionada = tabla_datos_empleado.getSelectedRow();
        if(fila_seleccionada >= 0){
            Integer idEmpleadoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Empleado empleadoSeleccionado = controlador.getEmpleadoPorId(idEmpleadoSeleccionado.toString());
            ArrayList<Cliente> cliente = empleadoSeleccionado.listaClientesTienda();
            
            mostrarRelacionClienteEmpleado(cliente);
        }
        System.out.println("Salgo del mouseclick");
    }

    private void button_del_empleadoActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_empleado.getModel();
        int fila_seleccionada = tabla_datos_empleado.getSelectedRow();
        System.out.println("Entro en boton borrar");

        if (fila_seleccionada >= 0) {
            System.out.println("entro en el if");
            // ObtÔøΩn el cliente seleccionado
            Integer idEmpleadoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Empleado empleadoSeleccionado = controlador.getEmpleadoPorId(idEmpleadoSeleccionado.toString());
            System.out.println("guardo el cliente selecionao");

            // Borra el cliente seleccionado del modelo de tabla
            model.removeRow(fila_seleccionada);

            // Luego, puedes realizar otras acciones como eliminar el cliente de tu controlador o sistema de almacenamiento (si es necesario).
            controlador.borrarEmpleado(empleadoSeleccionado);
            // TODO: Leer los clientes del XML
        } else {
            // Muestra un mensaje de error si no se seleccionÔøΩ ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un empleado para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button_mod_empleadoActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_empleado.getModel();
        int fila_seleccionada = tabla_datos_empleado.getSelectedRow();
        System.out.println("fila:" + fila_seleccionada);
        try{
            
            if (fila_seleccionada >= 0) {
                if(introducir_nombre_empleado.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—]+")){
                    String cargoLowerCase = introducir_cargo_empleado.getText().toLowerCase();
                    if(cargoLowerCase.equals("empleado") || cargoLowerCase.equals("encargado")){ 
                        System.out.println("Entro en if");
                        Integer idEmpleadoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                        System.out.println("id: "+ idEmpleadoSeleccionado);
                        Empleado empleadoSeleccionado = controlador.getEmpleadoPorId(idEmpleadoSeleccionado.toString());
                        Empleado e = new Empleado(introducir_nombre_empleado.getText(), introducir_cargo_empleado.getText());

                        controlador.modificarEmpleado(empleadoSeleccionado, e);
                        ArrayList<Empleado> empleados = controlador.listaEmpleados();

                        mostrarDatosEmpleado(empleados);
                    }else{
                        JOptionPane.showMessageDialog(this, "El estado debe ser \"Empleado\" o \"Encargado\"", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Formato de nombre incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un empleado para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println(aioobe);
        }
    }

    private void button_add_empleadoActionPerformed(java.awt.event.ActionEvent evt){
        if (!introducir_nombre_empleado.getText().isEmpty() && 
        !introducir_cargo_empleado.getText().isEmpty()) {
            if(introducir_nombre_empleado.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—]+")){
                String cargoLowerCase = introducir_cargo_empleado.getText().toLowerCase();
                if(cargoLowerCase.equals("empleado") || cargoLowerCase.equals("encargado")){ 
                    Empleado e = new Empleado(introducir_nombre_empleado.getText(), cargoLowerCase);

                    if (controlador.comprobarId(e)) {
                        controlador.agregarEmpleado(e);
                    } else {
                        JOptionPane.showMessageDialog(this, "No pueden coincidir las DNIs.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    ArrayList<Empleado> empleados = controlador.listaEmpleados();
                    mostrarDatosEmpleado(empleados);
                }else{
                    JOptionPane.showMessageDialog(this, "El estado debe ser \"Empleado\" o \"Encargado\"", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Formato de nombre incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void introducir_dni_empleadoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void introducir_nombre_empleadoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_save_empleadoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void button_cancel_empleadoActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void introducir_cargo_empleadoActionPerformed(java.awt.event.ActionEvent evt){

    }
    
    private void button_add_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_add_productoActionPerformed
        if (!introducir_nombre_producto.getText().isEmpty() && 
        !introducir_precio_producto.getText().isEmpty() && 
        !introducir_stock_producto.getText().isEmpty()) {
            if(introducir_nombre_producto.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—]+")){
                String stock = introducir_stock_producto.getText().toUpperCase();
                boolean hay_stock = false;

                if(introducir_precio_producto.getText().matches("^[0-9]+(\\.[0-9]+)?$")){
                    if (stock.equals("SI") || stock.equals("NO")) {

                        if(stock.equals("SI")){
                            hay_stock = true;
                        }
                        else if(stock.equals("NO")){
                            hay_stock = false;
                        }

                        double precio = Double.parseDouble(introducir_precio_producto.getText());

                        Producto p = new Producto(introducir_nombre_producto.getText(), hay_stock, precio);

                        if (controlador.comprobarId(p)) {
                            controlador.agregarProducto(p);
                        } else {
                            JOptionPane.showMessageDialog(this, "No pueden coincidir las IDs.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        ArrayList<Producto> productos = controlador.listaProductos();
                        mostrarDatosProducto(productos);
                        //TODO: Leer los clientes del XML
                    } else {
                        JOptionPane.showMessageDialog(this, "Las introducciones v·lidas en Stock son: SI/NO.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "El precio debe ser un n˙mero v·lido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Introduzca un formato v·lido para el nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button_add_productoActionPerformed

    private void button_mod_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_mod_productoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_seleccionada = tabla_datos_producto.getSelectedRow();
        System.out.println("fila:" + fila_seleccionada);
        try{
            String stock = introducir_stock_producto.getText().toUpperCase();
            boolean hay_stock = false;
            if (fila_seleccionada >= 0) {
                if(introducir_precio_producto.getText().matches("^[0-9]+(\\.[0-9]+)?$")){
                    if (stock.equals("SI") || stock.equals("NO")) {

                        System.out.println("Entro en if");
                        Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                        System.out.println("id: "+ idProductoSeleccionado);
                        Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());

                        if(stock.equals("SI")){
                            hay_stock = true;
                        }
                        else if(stock.equals("NO")){
                            hay_stock = false;
                        }
                        
                        double precio = Double.parseDouble(introducir_precio_producto.getText());

                        Producto p = new Producto(introducir_nombre_producto.getText(), hay_stock, precio);

                        controlador.modificarProducto(productoSeleccionado, p);
                        ArrayList<Producto> productos = controlador.listaProductos();

                        mostrarDatosProducto(productos);
                    }else{
                        JOptionPane.showMessageDialog(this, "Las introducciones v·lidas en Stock son: SI/NO.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Por favor, introduzca un n˙mero v·lido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println(aioobe);
        }
    }//GEN-LAST:event_button_mod_productoActionPerformed

    private void button_del_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_del_productoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_seleccionada = tabla_datos_producto.getSelectedRow();
        System.out.println("Entro en boton borrar");

        if (fila_seleccionada >= 0) {
            System.out.println("entro en el if");
            // ObtÔøΩn el cliente seleccionado
            Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());
            System.out.println("guardo el cliente selecionao");

            // Borra el cliente seleccionado del modelo de tabla
            model.removeRow(fila_seleccionada);

            // Luego, puedes realizar otras acciones como eliminar el cliente de tu controlador o sistema de almacenamiento (si es necesario).
            controlador.borrarProducto(productoSeleccionado);
            // TODO: Leer los clientes del XML
        } else {
            // Muestra un mensaje de error si no se seleccionÔøΩ ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_button_del_productoActionPerformed

    private void tabla_datos_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_datos_productoMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_seleccionada = tabla_datos_producto.getSelectedRow();
        if(fila_seleccionada >= 0){
            Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());
            System.out.println("tieen provedor: " + productoSeleccionado.isTieneProveedor());
            ArrayList<Pedido> pedidos = productoSeleccionado.listaPedidosProductos();
            ArrayList<Proveedor> proveedor = productoSeleccionado.getProveedor();
            
            mostrarRelacionPedidoProducto(pedidos);
            mostrarRelacionProveedorProducto(proveedor);
        }
    }//GEN-LAST:event_tabla_datos_productoMouseClicked

    private void relacion_tabla_datos_pedido_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relacion_tabla_datos_pedido_clienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relacion_tabla_datos_pedido_clienteMouseClicked

    private void relaicon_tabla_datos_empleado_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relaicon_tabla_datos_empleado_clienteMouseClicked
        
    }//GEN-LAST:event_relaicon_tabla_datos_empleado_clienteMouseClicked

    private void relacion_tabla_datos_producto_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relacion_tabla_datos_producto_pedidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relacion_tabla_datos_producto_pedidoMouseClicked

    private void relaicon_tabla_datos_cliente_pedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relaicon_tabla_datos_cliente_pedidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relaicon_tabla_datos_cliente_pedidoMouseClicked

    private void relacion_tabla_datos_pedido_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relacion_tabla_datos_pedido_productoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relacion_tabla_datos_pedido_productoMouseClicked

    private void relaicon_tabla_datos_proveedor_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relaicon_tabla_datos_proveedor_productoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relaicon_tabla_datos_proveedor_productoMouseClicked

    private void relacion_tabla_datos_producto_proveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relacion_tabla_datos_producto_proveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relacion_tabla_datos_producto_proveedorMouseClicked

    private void relaicon_tabla_datos_cliente_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relaicon_tabla_datos_cliente_empleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relaicon_tabla_datos_cliente_empleadoMouseClicked

    private void tabla_datos_clienteMouseClicked(java.awt.event.MouseEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_seleccionada = tabla_datos_cliente.getSelectedRow();
        if(fila_seleccionada >= 0){
            String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
            Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
            ArrayList<Pedido> pedidos = clienteSeleccionado.listaPedidosCliente();
            ArrayList<Empleado> e = clienteSeleccionado.getEmpleadoTienda();
            
            mostrarRelacionPedidosCliente(pedidos);
            mostrarRelacionEmpleadoCliente(e);
        }
    }
    
    private void relacion_introducir_pedido_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_introducir_pedido_clienteActionPerformed
        
    }//GEN-LAST:event_relacion_introducir_pedido_clienteActionPerformed

    private void relacion_pedido_cliente_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_pedido_cliente_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_seleccionada = tabla_datos_cliente.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_pedido_cliente.getText().isEmpty()){
                
                String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
                Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
                Pedido p = controlador.getPedidoPorId(relacion_introducir_pedido_cliente.getText());
                System.out.println("asignado: " + p.isAsignado());
                if(!p.isAsignado()){
                    if(p.getId() != 0){
                        controlador.relacionPedidosCliente(clienteSeleccionado, p);
                        ArrayList<Pedido> pedidos = clienteSeleccionado.listaPedidosCliente();
                        mostrarRelacionPedidosCliente(pedidos);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Ese pedido ya est· asignado a un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para aÒadir pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_pedido_cliente_add_buttonActionPerformed

    private void relacion_pedido_cliente_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_pedido_cliente_del_buttonActionPerformed
        DefaultTableModel model_cliente = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_cliente = tabla_datos_cliente.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_pedido_cliente.getModel();
        int fila_seleccionada = relacion_tabla_datos_pedido_cliente.getSelectedRow();

        if (fila_seleccionada >= 0) {
            String dniCliente = (String) model_cliente.getValueAt(fila_cliente, 0);
            Cliente clienteSeleccionado = controlador.getClientePorDni(dniCliente);
            
            Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());

            model.removeRow(fila_seleccionada);

            controlador.borrarRelacionPedidoCliente(clienteSeleccionado, pedidoSeleccionado);
            ArrayList<Pedido> pedidos = clienteSeleccionado.listaPedidosCliente();
            mostrarRelacionPedidosCliente(pedidos);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_pedido_cliente_del_buttonActionPerformed

    private void relacion_empleado_cliente_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_empleado_cliente_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_seleccionada = tabla_datos_cliente.getSelectedRow();

        if (fila_seleccionada >= 0) {
            if(!relacion_introducir_empleado_cliente.getText().isEmpty()){
                
                String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
                Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
                Empleado e = controlador.getEmpleadoPorId(relacion_introducir_empleado_cliente.getText());
                System.out.println("dni empleao: " + e.getId());
                if(!clienteSeleccionado.isSupervisado()){  
                    if(e.getId() != 0){
                        controlador.relacionEmpleadoCliente(clienteSeleccionado, e);
                        ArrayList<Empleado> empleado = clienteSeleccionado.getEmpleadoTienda();
                        System.out.println("size213: " + empleado.size());
                        mostrarRelacionEmpleadoCliente(empleado);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Este cliente ya est· siendo supervisado!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para aÒadir pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_empleado_cliente_add_buttonActionPerformed

    private void relacion_empleado_cliente_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_empleado_cliente_del_buttonActionPerformed
        DefaultTableModel model_cliente = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_cliente = tabla_datos_cliente.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_empleado_cliente.getModel();
        int fila_seleccionada = relaicon_tabla_datos_empleado_cliente.getSelectedRow();

        if (fila_seleccionada >= 0) {
            String dniCliente = (String) model_cliente.getValueAt(fila_cliente, 0);
            Cliente clienteSeleccionado = controlador.getClientePorDni(dniCliente);
            if(clienteSeleccionado.isSupervisado()){
                Integer idEmpleadoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                Empleado EmpleadoSeleccionado = controlador.getEmpleadoPorId(idEmpleadoSeleccionado.toString());

                model.removeRow(fila_seleccionada);

                controlador.borrarRelacionEmpleadoCliente(clienteSeleccionado, EmpleadoSeleccionado);
            }else{
                JOptionPane.showMessageDialog(this, "Este cliente no esta siendo supervisado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_empleado_cliente_del_buttonActionPerformed

    private void relacion_cliente_pedido_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_cliente_pedido_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_seleccionada = tabla_datos_pedido.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_cliente_pedido.getText().isEmpty()){
                
                Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());
                if(!pedidoSeleccionado.isAsignado()){
                    Cliente c = controlador.getClientePorDni(relacion_introducir_cliente_pedido.getText());
                    
                    if(!c.getDni().isEmpty()){
                        controlador.relacionPedidosCliente(c, pedidoSeleccionado);
                        ArrayList<Cliente> cliente = pedidoSeleccionado.getCliente();
                        mostrarRelacionClientePedido(cliente);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Este pedido ya est· asignado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para aÒadir un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_cliente_pedido_add_buttonActionPerformed

    private void relacion_cliente_pedido_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_cliente_pedido_del_buttonActionPerformed
        DefaultTableModel model_pedido = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_pedido = tabla_datos_pedido.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_cliente_pedido.getModel();
        int fila_seleccionada = relaicon_tabla_datos_cliente_pedido.getSelectedRow();

        if (fila_seleccionada >= 0) {
            Integer idPedido = (Integer) model_pedido.getValueAt(fila_pedido, 0);
            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedido.toString());
            if(pedidoSeleccionado.isAsignado()){
                String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
                Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);

                model.removeRow(fila_seleccionada);

                controlador.borrarRelacionPedidoCliente(clienteSeleccionado, pedidoSeleccionado);
            }else{
                JOptionPane.showMessageDialog(this, "Este pedido no esta asignado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_cliente_pedido_del_buttonActionPerformed

    private void relacion_producto_pedido_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_producto_pedido_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_seleccionada = tabla_datos_pedido.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_producto_pedido.getText().isEmpty()){
                
                Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());
                Producto p = controlador.getProductoPorId(relacion_introducir_producto_pedido.getText());
                    
                    if(p.getId()!=0){
                        controlador.relacionProductoPedido(p, pedidoSeleccionado);
                        ArrayList<Producto> productos = pedidoSeleccionado.listaProductosPedido();
                        mostrarRelacionProductoPedido(productos);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para aÒadir un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_producto_pedido_add_buttonActionPerformed

    private void relacion_producto_pedido_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_producto_pedido_del_buttonActionPerformed
        DefaultTableModel model_pedido = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_pedido = tabla_datos_pedido.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_producto_pedido.getModel();
        int fila_seleccionada = relacion_tabla_datos_producto_pedido.getSelectedRow();

        if (fila_seleccionada >= 0) {
            Integer idPedido = (Integer) model_pedido.getValueAt(fila_pedido, 0);
            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedido.toString());
            
            Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());

            model.removeRow(fila_seleccionada);

            controlador.borrarRelacionProductoPedido(productoSeleccionado, pedidoSeleccionado);
            
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_producto_pedido_del_buttonActionPerformed

    private void relacion_producto_proveedor_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_producto_proveedor_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_proveedor.getModel();
        int fila_seleccionada = tabla_datos_proveedor.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_producto_proveedor.getText().isEmpty()){
                
                Integer idProveedorSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                Proveedor proveedorSeleccionado = controlador.getProveedorPorId(idProveedorSeleccionado.toString());
                Producto p = controlador.getProductoPorId(relacion_introducir_producto_proveedor.getText());
                if(!p.isTieneProveedor()){    
                    if(p.getId()!=0){
                        controlador.relacionProveedorProducto(p, proveedorSeleccionado);
                        ArrayList<Producto> productos = proveedorSeleccionado.getProductos_proveedor();
                        mostrarRelacionProductoProveedor(productos);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Este producto ya es repartido por otro proveedor!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para aÒadir un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_producto_proveedor_add_buttonActionPerformed

    private void relacion_pedido_producto_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_pedido_producto_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_seleccionada = tabla_datos_producto.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_pedido_producto.getText().isEmpty()){
                
                Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());
                Pedido p = controlador.getPedidoPorId(relacion_introducir_pedido_producto.getText());
                    
                    if(p.getId() != 0){
                        controlador.relacionProductoPedido(productoSeleccionado, p);
                        ArrayList<Pedido> pedidos = productoSeleccionado.listaPedidosProductos();
                        mostrarRelacionPedidoProducto(pedidos);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para aÒadir un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_pedido_producto_add_buttonActionPerformed

    private void relacion_pedido_producto_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_pedido_producto_del_buttonActionPerformed
        DefaultTableModel model_pedido = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_producto = tabla_datos_producto.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_pedido_producto.getModel();
        int fila_seleccionada = relacion_tabla_datos_pedido_producto.getSelectedRow();

        if (fila_seleccionada >= 0) {
            Integer idProducto = (Integer) model_pedido.getValueAt(fila_producto, 0);
            Producto productoSeleccionado = controlador.getProductoPorId(idProducto.toString());
            
            Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());

            model.removeRow(fila_seleccionada);

            controlador.borrarRelacionProductoPedido(productoSeleccionado, pedidoSeleccionado);
            
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_pedido_producto_del_buttonActionPerformed

    private void relacion_proveedor_producto_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_proveedor_producto_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_seleccionada = tabla_datos_producto.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_proveedor_producto.getText().isEmpty()){
                
                Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());
                Proveedor p = controlador.getProveedorPorId(relacion_introducir_proveedor_producto.getText());
                if(!productoSeleccionado.isTieneProveedor()){
                    if(p.getId() !=0){
                        System.out.println("size: " + productoSeleccionado.getProveedor().size());
                        controlador.relacionProveedorProducto(productoSeleccionado, p);
                        ArrayList<Proveedor> proveedor = productoSeleccionado.getProveedor();
                        System.out.println("size: " + proveedor.size());
                        mostrarRelacionProveedorProducto(proveedor);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Ya hay un proveedor que reparte este producto!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para aÒadir un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_proveedor_producto_add_buttonActionPerformed

    private void relacion_proveedor_producto_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_proveedor_producto_del_buttonActionPerformed
        DefaultTableModel model_pedido = (DefaultTableModel) tabla_datos_producto.getModel();
        int fila_producto = tabla_datos_producto.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_proveedor_producto.getModel();
        int fila_seleccionada = relaicon_tabla_datos_proveedor_producto.getSelectedRow();

        if (fila_seleccionada >= 0) {
            Integer idProducto = (Integer) model_pedido.getValueAt(fila_producto, 0);
            Producto productoSeleccionado = controlador.getProductoPorId(idProducto.toString());
            
            Integer idProveedorSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Proveedor proveedorSeleccionado = controlador.getProveedorPorId(idProveedorSeleccionado.toString());

            model.removeRow(fila_seleccionada);

            controlador.borrarRelacionProveedorProducto(productoSeleccionado, proveedorSeleccionado);
            
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_proveedor_producto_del_buttonActionPerformed

    private void relacion_producto_proveedor_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_producto_proveedor_del_buttonActionPerformed
        DefaultTableModel model_pedido = (DefaultTableModel) tabla_datos_proveedor.getModel();
        int fila_proveedor = tabla_datos_proveedor.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_producto_proveedor.getModel();
        int fila_seleccionada = relacion_tabla_datos_producto_proveedor.getSelectedRow();

        if (fila_seleccionada >= 0) {
            Integer idProveedor = (Integer) model_pedido.getValueAt(fila_proveedor, 0);
            Proveedor proveedorSeleccionado = controlador.getProveedorPorId(idProveedor.toString());
            
            Integer idProductoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Producto productoSeleccionado = controlador.getProductoPorId(idProductoSeleccionado.toString());

            model.removeRow(fila_seleccionada);

            controlador.borrarRelacionProveedorProducto(productoSeleccionado, proveedorSeleccionado);
            
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_producto_proveedor_del_buttonActionPerformed

    private void relacion_cliente_empleado_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_cliente_empleado_add_buttonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla_datos_empleado.getModel();
        int fila_seleccionada = tabla_datos_empleado.getSelectedRow();

        if (fila_seleccionada >= 0) {
        
            if(!relacion_introducir_cliente_empleado.getText().isEmpty()){
                
                String idEmpleadoSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
                Empleado empleadoSeleccionado = controlador.getEmpleadoPorId(idEmpleadoSeleccionado);
                
                Cliente c = controlador.getClientePorDni(relacion_introducir_cliente_empleado.getText());
                if(!c.isSupervisado()){    
                    if(!c.getDni().isEmpty()){
                        controlador.relacionClienteEmpleado(c, empleadoSeleccionado);
                        ArrayList<Cliente> cliente = empleadoSeleccionado.listaClientesTienda();
                        mostrarRelacionClienteEmpleado(cliente);
                    }else{
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca una ID existente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Este cliente est· siendo supervisado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para aÒadir un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_cliente_empleado_add_buttonActionPerformed

    private void relacion_cliente_empleado_del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacion_cliente_empleado_del_buttonActionPerformed
        DefaultTableModel model1 = (DefaultTableModel) tabla_datos_empleado.getModel();
        int fila_empleado = tabla_datos_empleado.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_cliente_empleado.getModel();
        int fila_seleccionada = relaicon_tabla_datos_cliente_empleado.getSelectedRow();

        if (fila_seleccionada >= 0) {
            Integer idEmpleadoSeleccionado = (Integer) model1.getValueAt(fila_empleado, 0);
                Empleado empleadoSeleccionado = controlador.getEmpleadoPorId(idEmpleadoSeleccionado.toString());
                
                String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
                Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
                if(clienteSeleccionado.isSupervisado()){

                model.removeRow(fila_seleccionada);

                controlador.borrarRelacionClienteEmpleado(clienteSeleccionado, empleadoSeleccionado);
            }else{
                JOptionPane.showMessageDialog(this, "Este cliente no esta supervisado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_relacion_cliente_empleado_del_buttonActionPerformed

    public void formWindowClosing(java.awt.event.WindowEvent evt){
        controlador.cerrarConexion();
        conexion.cerrarConexion();
    }
    
    private void button_add_clienteActionPerformed(java.awt.event.ActionEvent evt){
        if(!introducir_dni_cliente.getText().isEmpty() && !introducir_nombre_cliente.getText().isEmpty() && !introducir_direccion_cliente.getText().isEmpty() && !introducir_telf_cliente.getText().isEmpty()){  
            if(introducir_dni_cliente.getText().matches("\\d{8}[A-HJ-NP-TV-Z]")){
                if(introducir_nombre_cliente.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—]+")){
                    if(introducir_direccion_cliente.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò— ]*")){
                        if(introducir_telf_cliente.getText().matches("\\d{9}")){
                            Cliente c = new Cliente(introducir_dni_cliente.getText(), introducir_nombre_cliente.getText(), introducir_direccion_cliente.getText(), introducir_telf_cliente.getText());
                            if(controlador.comprobarDni(c)){
                                controlador.agregarCliente(c);
                            }else{
                                JOptionPane.showMessageDialog(this, "No pueden coincidir varios DNIs.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            ArrayList<Cliente> clientes = controlador.listaClientes();
                            mostrarDatosCliente(clientes);
                        }else{
                            JOptionPane.showMessageDialog(this, "Introduzca un telÈfono v·lido", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Introduzca un formato v·lido en la direcciÛn", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Introduzca un formato v·lido en el nombre", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Escriba un formato v·lido para el DNI (La letra debe estar en may˙scula)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button_mod_clienteActionPerformed(java.awt.event.ActionEvent evt) { //FIX ME
        DefaultTableModel model = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_seleccionada = tabla_datos_cliente.getSelectedRow();
        System.out.println("fila:" + fila_seleccionada);
        try{
            
            if (fila_seleccionada >= 0) {
                if(!introducir_dni_cliente.getText().isEmpty() && !introducir_nombre_cliente.getText().isEmpty() && !introducir_direccion_cliente.getText().isEmpty() && !introducir_telf_cliente.getText().isEmpty()){  
                    if(introducir_dni_cliente.getText().matches("\\d{8}[A-HJ-NP-TV-Z]")){
                        if(introducir_nombre_cliente.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—]+")){
                            if(introducir_direccion_cliente.getText().matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò— ]*")){
                                if(introducir_telf_cliente.getText().matches("\\d{9}")){
                                    System.out.println("Entro en if");
                                    String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
                                    System.out.println("cliente selec: " + dniClienteSeleccionado);
                                    if (!dniClienteSeleccionado.equals(dniClienteSeleccionado)) {
                                        if (!controlador.comprobarDni(dniClienteSeleccionado)) {
                                            Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
                                            Cliente c = new Cliente(dniClienteSeleccionado, introducir_nombre_cliente.getText(), introducir_direccion_cliente.getText(), introducir_telf_cliente.getText());

                                            controlador.modificarCliente(clienteSeleccionado, c);
                                            ArrayList<Cliente> clientes = controlador.listaClientes();
                                            mostrarDatosCliente(clientes);
                                        } else {
                                            JOptionPane.showMessageDialog(this, "El DNI ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
                                        Cliente c = new Cliente(dniClienteSeleccionado, introducir_nombre_cliente.getText(), introducir_direccion_cliente.getText(), introducir_telf_cliente.getText());

                                        controlador.modificarCliente(clienteSeleccionado, c);
                                        ArrayList<Cliente> clientes = controlador.listaClientes();
                                        mostrarDatosCliente(clientes);
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(this, "Introduzca un telÈfono v·lido", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(this, "Introduzca un formato v·lido en la direcciÛn", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, "Introduzca un formato v·lido en el nombre", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Escriba un formato v·lido para el DNI (La letra debe estar en may˙scula)", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÛn.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println(aioobe);
        }
    }


    private void button_del_clienteActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) tabla_datos_cliente.getModel();
        int fila_seleccionada = tabla_datos_cliente.getSelectedRow();
        System.out.println("Entro en boton borrar");

        if (fila_seleccionada >= 0) {
            System.out.println("entro en el if");
            // ObtÔøΩn el cliente seleccionado
            String dniClienteSeleccionado = (String) model.getValueAt(fila_seleccionada, 0);
            Cliente clienteSeleccionado = controlador.getClientePorDni(dniClienteSeleccionado);
            System.out.println("guardo el cliente selecionao");

            // Borra el cliente seleccionado del modelo de tabla
            model.removeRow(fila_seleccionada);

            // Luego, puedes realizar otras acciones como eliminar el cliente de tu controlador o sistema de almacenamiento (si es necesario).
            controlador.borrarCliente(clienteSeleccionado);
            // TODO: Leer los clientes del XML
        } else {
            // Muestra un mensaje de error si no se seleccionÔøΩ ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void mostrarDatosCliente(ArrayList<Cliente> clientes) {        
        
        DefaultTableModel model = (DefaultTableModel) tabla_datos_cliente.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Cliente cliente : clientes) {
            Object[] row = {cliente.getDni(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono()};
            model.addRow(row);
        }
    }
    
    private void button_add_pedidoActionPerformed(java.awt.event.ActionEvent evt){
        if(!introducir_fecha_pedido.getText().isEmpty() && !introducir_estado_pedido.getText().isEmpty()){  
            if(introducir_fecha_pedido.getText().matches("\\b(0?[1-9]|[12]\\d|3[01])/(0?[1-9]|1[0-2])/(\\d{4})\\b")){  
                String estadoLowerCase = introducir_estado_pedido.getText().toLowerCase();
                if(estadoLowerCase.equals("entregado") || estadoLowerCase.equals("en proceso")){    
                    Pedido p = new Pedido(introducir_fecha_pedido.getText(),estadoLowerCase);
                    if(controlador.comprobarId(p)){
                        controlador.agregarPedido(p);
                    }else{
                        JOptionPane.showMessageDialog(this, "No pueden coincidir las IDs.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    ArrayList<Pedido> pedidos = controlador.listaPedidos();
                    mostrarDatosPedido(pedidos);
                }else{
                    JOptionPane.showMessageDialog(this, "El estado debe ser \"Entregado\" o \"En proceso\"", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÔøΩn.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void button_mod_pedidoActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_seleccionada = tabla_datos_pedido.getSelectedRow();
        System.out.println("fila:" + fila_seleccionada);
        try{
            
            if (fila_seleccionada >= 0) {
                if(!introducir_fecha_pedido.getText().isEmpty() && !introducir_estado_pedido.getText().isEmpty()){  
                    if(introducir_fecha_pedido.getText().matches("\\b(0?[1-9]|[12]\\d|3[01])/(0?[1-9]|1[0-2])/(\\d{4})\\b")){  
                        String estadoLowerCase = introducir_estado_pedido.getText().toLowerCase();
                        if(estadoLowerCase.equals("entregado") || estadoLowerCase.equals("en proceso")){    
                            System.out.println("Entro en if");
                            Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
                            System.out.println("id: "+ idPedidoSeleccionado);
                            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());
                            Pedido p = new Pedido(introducir_fecha_pedido.getText(), estadoLowerCase);

                            controlador.modificarPedido(pedidoSeleccionado, p);
                            ArrayList<Pedido> pedidos = controlador.listaPedidos();

                            mostrarDatosPedido(pedidos); 
                        }else{
                            JOptionPane.showMessageDialog(this, "El estado debe ser \"Entregado\" o \"En proceso\"", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Por favor, complete la informaciÔøΩn.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println(aioobe);
        }
    }
    
    private void button_del_pedidoActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_pedido.getModel();
        int fila_seleccionada = tabla_datos_pedido.getSelectedRow();
        System.out.println("Entro en boton borrar");

        if (fila_seleccionada >= 0) {
            System.out.println("entro en el if");
            // ObtÔøΩn el cliente seleccionado
            Integer idPedidoSeleccionado = (Integer) model.getValueAt(fila_seleccionada, 0);
            Pedido pedidoSeleccionado = controlador.getPedidoPorId(idPedidoSeleccionado.toString());
            System.out.println("guardo el cliente selecionao");

            // Borra el cliente seleccionado del modelo de tabla
            model.removeRow(fila_seleccionada);

            // Luego, puedes realizar otras acciones como eliminar el cliente de tu controlador o sistema de almacenamiento (si es necesario).
            controlador.borrarPedido(pedidoSeleccionado);
            // TODO: Leer los clientes del XML
        } else {
            // Muestra un mensaje de error si no se seleccionÔøΩ ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarDatosPedido(ArrayList<Pedido> pedidos){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_pedido.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Pedido p : pedidos) {
            Object[] row = {p.getId(), p.getFecha(), p.getEstado()};
            model.addRow(row);
        }
    }
    
    public void mostrarDatosProducto(ArrayList<Producto> productos){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_producto.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Producto p : productos) {
            Object[] row = {p.getId(), p.getNombre(), p.getStock(), p.getPrecio()};
            model.addRow(row);
        }
    }
    
    public void mostrarDatosProveedor(ArrayList<Proveedor> proveedores){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_proveedor.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Proveedor p : proveedores) {
            Object[] row = {p.getId(), p.getNombre(), p.getPrecio(), p.getStock()};
            model.addRow(row);
        }
    }
    
    public void mostrarDatosEmpleado(ArrayList<Empleado> empleados){
        DefaultTableModel model = (DefaultTableModel) tabla_datos_empleado.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Empleado e : empleados) {
            Object[] row = {e.getId(), e.getNombre(), e.getCargo()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionPedidosCliente(ArrayList<Pedido> pedidos){
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_pedido_cliente.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Pedido p : pedidos) {
            Object[] row = {p.getId(), p.getFecha(), p.getEstado()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionEmpleadoCliente(ArrayList<Empleado> empleados){
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_empleado_cliente.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Empleado e : empleados) {
            Object[] row = {e.getId(), e.getNombre(), e.getCargo()};
            model.addRow(row);
        }
    
    }
    
    public void mostrarRelacionClientePedido(ArrayList<Cliente> c){
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_cliente_pedido.getModel();

        System.out.println("size: " + c.size());
        
        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Cliente cliente : c) {
            Object[] row = {cliente.getDni(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionProductoPedido(ArrayList<Producto> productos){
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_producto_pedido.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Producto p : productos) {
            Object[] row = {p.getId(), p.getNombre(), p.getStock(), p.getPrecio()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionPedidoProducto(ArrayList<Pedido> pedidos){
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_pedido_producto.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Pedido p : pedidos) {
            Object[] row = {p.getId(), p.getFecha(), p.getEstado()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionProveedorProducto(ArrayList<Proveedor> proveedores){
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_proveedor_producto.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Proveedor p : proveedores) {
            Object[] row = {p.getId(), p.getNombre(), p.getPrecio(), p.getStock()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionProductoProveedor(ArrayList<Producto> productos){
        DefaultTableModel model = (DefaultTableModel) relacion_tabla_datos_producto_proveedor.getModel();

        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Producto p : productos) {
            Object[] row = {p.getId(), p.getNombre(), p.getStock(), p.getPrecio()};
            model.addRow(row);
        }
    }
    
    public void mostrarRelacionClienteEmpleado(ArrayList<Cliente> c){
        System.out.println("entro en la relacion de empleao");
        DefaultTableModel model = (DefaultTableModel) relaicon_tabla_datos_cliente_empleado.getModel();

        System.out.println("size: " + c.size());
        
        // Limpiar la tabla antes de agregar nuevos datos
        model.setRowCount(0);

        // Agregar los datos de los clientes al modelo de la tabla
        for (Cliente cliente : c) {
            Object[] row = {cliente.getDni(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono()};
            model.addRow(row);
        }
    }
    
    public void reiniciarTabla(JTable tabla){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
    }
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add_cliente;
    private javax.swing.JButton button_add_empleado;
    private javax.swing.JButton button_add_pedido;
    private javax.swing.JButton button_add_producto;
    public javax.swing.JButton button_add_proveedor;
    private javax.swing.JButton button_del_cliente;
    private javax.swing.JButton button_del_empleado;
    private javax.swing.JButton button_del_pedido;
    private javax.swing.JButton button_del_producto;
    public javax.swing.JButton button_del_proveedor;
    private javax.swing.JButton button_mod_cliente;
    private javax.swing.JButton button_mod_empleado;
    private javax.swing.JButton button_mod_pedido;
    private javax.swing.JButton button_mod_producto;
    public javax.swing.JButton button_mod_proveedor;
    private javax.swing.JLabel cargo_label_empleado;
    private javax.swing.JLabel direccion_label_cliente;
    private javax.swing.JLabel dni_label_cliente;
    private javax.swing.JLabel estado_label_pedido;
    private javax.swing.JLabel fecha_label_pedido;
    private javax.swing.JTextField introducir_cargo_empleado;
    public javax.swing.JTextField introducir_direccion_cliente;
    public javax.swing.JTextField introducir_dni_cliente;
    public javax.swing.JTextField introducir_estado_pedido;
    public javax.swing.JTextField introducir_fecha_pedido;
    private javax.swing.JTextField introducir_nom_empresa_proveedor;
    public javax.swing.JTextField introducir_nombre_cliente;
    private javax.swing.JTextField introducir_nombre_empleado;
    private javax.swing.JTextField introducir_nombre_producto;
    private javax.swing.JTextField introducir_precio_producto;
    private javax.swing.JTextField introducir_precio_proveedor;
    private javax.swing.JTextField introducir_stock_producto;
    private javax.swing.JTextField introducir_stock_proveedor;
    public javax.swing.JTextField introducir_telf_cliente;
    public javax.swing.JTextField introducir_telf_cliente2;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton_aniadir_persona1;
    public javax.swing.JButton jButton_aniadir_persona2;
    public javax.swing.JButton jButton_aniadir_persona3;
    public javax.swing.JButton jButton_aniadir_persona4;
    public javax.swing.JButton jButton_borrar_persona1;
    public javax.swing.JButton jButton_borrar_persona2;
    public javax.swing.JButton jButton_borrar_persona3;
    public javax.swing.JButton jButton_modificar_persona1;
    public javax.swing.JButton jButton_modificar_persona2;
    public javax.swing.JButton jButton_modificar_persona3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    public javax.swing.JTextField jTextField_num_habitantes1;
    private javax.swing.JLabel label_relacion_pedido;
    private javax.swing.JLabel label_relacion_pedido1;
    private javax.swing.JLabel label_relacion_pedido2;
    private javax.swing.JLabel label_relacion_pedido3;
    private javax.swing.JLabel nom_empresa_label_proveedor;
    private javax.swing.JLabel nombre_label_cliente;
    private javax.swing.JLabel nombre_label_empleado;
    private javax.swing.JLabel nombre_label_producto;
    private javax.swing.JTabbedPane paginas;
    private javax.swing.JPanel panel_cliente;
    private javax.swing.JPanel panel_empleado;
    private javax.swing.JPanel panel_pedido;
    private javax.swing.JPanel panel_producto;
    private javax.swing.JPanel panel_proveedor;
    private javax.swing.JLabel precio_label_producto;
    private javax.swing.JLabel precio_label_proveedor;
    private javax.swing.JButton relacion_cliente_empleado_add_button;
    private javax.swing.JButton relacion_cliente_empleado_del_button;
    private javax.swing.JButton relacion_cliente_pedido_add_button;
    private javax.swing.JButton relacion_cliente_pedido_del_button;
    private javax.swing.JButton relacion_empleado_cliente_add_button;
    private javax.swing.JButton relacion_empleado_cliente_del_button;
    public javax.swing.JTextField relacion_introducir_cliente_empleado;
    public javax.swing.JTextField relacion_introducir_cliente_pedido;
    public javax.swing.JTextField relacion_introducir_empleado_cliente;
    public javax.swing.JTextField relacion_introducir_pedido_cliente;
    public javax.swing.JTextField relacion_introducir_pedido_producto;
    public javax.swing.JTextField relacion_introducir_producto_pedido;
    public javax.swing.JTextField relacion_introducir_producto_proveedor;
    public javax.swing.JTextField relacion_introducir_proveedor_producto;
    private javax.swing.JButton relacion_pedido_cliente_add_button;
    private javax.swing.JButton relacion_pedido_cliente_del_button;
    private javax.swing.JButton relacion_pedido_producto_add_button;
    private javax.swing.JButton relacion_pedido_producto_del_button;
    private javax.swing.JButton relacion_producto_pedido_add_button;
    private javax.swing.JButton relacion_producto_pedido_del_button;
    private javax.swing.JButton relacion_producto_proveedor_add_button;
    private javax.swing.JButton relacion_producto_proveedor_del_button;
    private javax.swing.JButton relacion_proveedor_producto_add_button;
    private javax.swing.JButton relacion_proveedor_producto_del_button;
    private javax.swing.JTable relacion_tabla_datos_pedido_cliente;
    private javax.swing.JTable relacion_tabla_datos_pedido_producto;
    private javax.swing.JTable relacion_tabla_datos_producto_pedido;
    private javax.swing.JTable relacion_tabla_datos_producto_proveedor;
    public javax.swing.JTable relaicon_tabla_datos_cliente_empleado;
    public javax.swing.JTable relaicon_tabla_datos_cliente_pedido;
    public javax.swing.JTable relaicon_tabla_datos_empleado_cliente;
    public javax.swing.JTable relaicon_tabla_datos_proveedor_producto;
    private javax.swing.JLabel stock_label_producto;
    private javax.swing.JLabel stock_label_proveedor;
    private javax.swing.JTable tabla_datos_cliente;
    public javax.swing.JTable tabla_datos_empleado;
    private javax.swing.JTable tabla_datos_pedido;
    private javax.swing.JTable tabla_datos_producto;
    public javax.swing.JTable tabla_datos_proveedor;
    private javax.swing.JLabel telf_label_cliente;
    // End of variables declaration//GEN-END:variables
    private ConexionDB conexion;
    
    public Controlador controlador = new Controlador();
    
    /*private ArrayList<Ciudad> ciudades;
    private Ciudad ciudad_modificar;*/
    private DefaultTableModel table_model_cliente = new DefaultTableModel();
    /*private Boolean modif_ciudad;
    private int id_ciudad;
    
    private ArrayList<Biblioteca> bibliotecas;
    private Biblioteca biblioteca_modificar;*/
    private DefaultTableModel table_model_empleado = new DefaultTableModel();    
    /*private Boolean modif_biblioteca;
    private int id_biblioteca;
    
    private ArrayList<Libro> libros;
    private Libro libro_modificar;*/
    private DefaultTableModel table_model_pedido = new DefaultTableModel();    
    /*private Boolean modif_libro;
    private int id_libro;
    
    private ArrayList<Persona> personas;
    private Persona persona_modificar;*/
    private DefaultTableModel table_model_producto = new DefaultTableModel(); 
    /*private Boolean modif_persona;
    private int id_persona;*/
    
    private DefaultTableModel table_model_proveedor = new DefaultTableModel();
    public ButtonGroup group_buttons_provedor = new ButtonGroup();
}
