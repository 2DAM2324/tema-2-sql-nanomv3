/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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

/**
 *
 * @author nanom
 */
public class Pedido {
    private int id;
    private String estado;
    private String fecha;
    private ArrayList<Producto> productos_pedido;
    private ArrayList<Cliente> cliente;
    private boolean asignado;
    private ConexionDB conexion;

    
    public ArrayList<Producto> listaProductosPedido() {
        return productos_pedido;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    // Constructor
    public Pedido() {
        setEstado("");
        setFecha(null);
        setAsignado(false);
        cliente = new ArrayList<>();
        productos_pedido = new ArrayList<>();
        
        conexion = new ConexionDB();
    }

    // Constructor por parametros
    public Pedido(String fecha, String estado) {
        setEstado(estado);
        setFecha(fecha);
        setAsignado(false);
        cliente = new ArrayList<>();
        productos_pedido = new ArrayList<>();
        
        conexion = new ConexionDB();
    }
    
    public Pedido(int id, String fecha, String estado) {
        setId(id);
        setEstado(estado);
        setFecha(fecha);
        setAsignado(false);
        cliente = new ArrayList<>();
        productos_pedido = new ArrayList<>();
        
        conexion = new ConexionDB();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /*public Producto getProductos_pedido(int pos) {
        return productos_pedido(pos);
    }*/

    // Metodo para agregar un producto al array de productos_pedido
    public void agregarProducto(Producto producto) {
        this.productos_pedido.add(producto);
    }

    // Metodo para borrar un producto del array de productos_pedido
    public void borrarProducto(Producto producto) {
        this.productos_pedido.remove(producto);
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente c) {
        cliente.add(c);
        setAsignado(true);
    }
    
    public void borrarCliente(Cliente c){
        cliente.remove(c);
        setAsignado(false);
    }
    
    
}