/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

import Tienda.controlador.Controlador;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author nanom
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Pedido> pedidos_cliente;
    private ArrayList<Empleado> empleado_en_tienda;
    private boolean supervisado;
    private ConexionDB conexion;


    public boolean isSupervisado() {
        return supervisado;
    }

    public void setSupervisado(boolean supervisado) {
        this.supervisado = supervisado;
    }

    // Constructor por parametros
    public Cliente(String dni, String nombre, String direccion, String telefono) {
        pedidos_cliente = new ArrayList<>();
        this.setDni(dni);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        empleado_en_tienda = new ArrayList<>();
        setSupervisado(false);
        
        conexion = new ConexionDB();
    }

    // Constructor en blanco
    public Cliente(){

        pedidos_cliente = new ArrayList<>();

        this.setDni("");
        this.setNombre("");
        this.setDireccion("");
        this.setTelefono("");
        empleado_en_tienda = new ArrayList<>();
        setSupervisado(false);
        
        conexion = new ConexionDB();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos_cliente.add(pedido);
    }
    
    public void borrarPedido(Pedido pedido) {
        pedidos_cliente.remove(pedido);
    }
    
    /*public Pedido getPedidos(int pos) {
        Pedido p = pedidos_cliente(pos);
        return pedidos_cliente(pos);
    }*/

    public ArrayList<Empleado> getEmpleadoTienda() {
        return empleado_en_tienda;
    }

    public void setEmpleadoTienda(Empleado empleado){
        this.empleado_en_tienda.add(empleado);
        setSupervisado(true);
    }
    
    public void borrarEmpleadoTienda(Empleado e){
        empleado_en_tienda.remove(e);
        setSupervisado(false);
    }
    
    public void addPedidoCliente(Pedido p){
        if(p != null)
            pedidos_cliente.add(p);
    }
    
    public void borrarPedidoCliente(Pedido p){
        pedidos_cliente.remove(p);
    }
    
    public ArrayList<Pedido> listaPedidosCliente(){
        return pedidos_cliente;
    }
    
    
    public ArrayList<Cliente> obtenerClientesBD() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT * FROM Clientes");

            //Ejecuto la consulta
            ResultSet resultados = statement.executeQuery();

            //Introduzco los datos de la bd y voy creando los clientes
            while (resultados.next()) {
                String dni = resultados.getString("dni");
                String nombre = resultados.getString("nombre_cliente");
                String direccion = resultados.getString("direccion");
                String telefono = resultados.getString("telefono");

                Cliente cliente = new Cliente(dni, nombre, direccion, telefono);
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }

        return clientes;
    }
    
    public void introducirDatosDeClientesEnBD(Cliente c){
        
        System.out.println("Entro en introducir los datos de cliente");
        
        String sentenciaSql = "INSERT INTO Clientes (dni, nombre_cliente, direccion, telefono) VALUES (?, ?, ?, ?)";
        
        PreparedStatement sentencia = null;
        
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, c.getDni());
            sentencia.setString(2, c.getNombre());
            sentencia.setString(3, c.getDireccion());
            sentencia.setString(4, c.getTelefono());
            sentencia.executeUpdate();
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia != null){
                try{
                    sentencia.close();
                    conexion.cerrarConexion();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }

    } 
    
    public void borrarDatosClienteEnBD(Cliente c){
        String sentenciaSql = "DELETE FROM Clientes WHERE dni = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, c.getDni());
            sentencia.executeUpdate();
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                    conexion.cerrarConexion();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void modificarDatosClienteEnBD(Cliente c, Cliente antiguo_c){
        String sentenciaSql = "UPDATE Clientes SET dni = ?, nombre_cliente = ?, direccion = ?, telefono = ? "
                + "WHERE dni = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, c.getDni());
            sentencia.setString(2, c.getNombre());
            sentencia.setString(3, c.getDireccion());
            sentencia.setString(4, c.getTelefono());
            sentencia.setString(5, antiguo_c.getDni());
            sentencia.executeUpdate();
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                    conexion.cerrarConexion();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
}

