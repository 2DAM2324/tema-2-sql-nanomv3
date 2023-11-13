/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

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
import org.w3c.dom.Node;

/**
 *
 * @author nanom
 */
public class Producto {
    private String id;
    private String nombre;
    private boolean stock;
    private double precio;
    private ArrayList<Pedido> pedidos_producto;
    private ArrayList<Proveedor> proveedor_producto;
    private boolean tieneProveedor;

    public boolean isTieneProveedor() {
        return tieneProveedor;
    }

    public void setTieneProveedor(boolean tieneProveedor) {
        this.tieneProveedor = tieneProveedor;
    }

    public ArrayList<Pedido> listaPedidosProductos() {
        return pedidos_producto;
    }

    public void setPedidos_producto(Pedido pedidos) {
        pedidos_producto.add(pedidos);
    }
    
    public void borrarPedidoProducto(Pedido p){
        pedidos_producto.remove(p);
    }

    // Constructor por parametros
    public Producto(String id, String nombre, boolean stock, double precio) {

        pedidos_producto = new ArrayList<>();
        proveedor_producto = new ArrayList<>();
        this.setId(id);
        this.setNombre(nombre);
        this.setStock(stock);
        this.setPrecio(precio);
        setTieneProveedor(false);
    }

    // Constructor
    public Producto() {

        pedidos_producto = new ArrayList<>();
        proveedor_producto = new ArrayList<>();
        this.setId("");
        this.setNombre("");
        this.setStock(false);
        this.setPrecio(0.0);
        setTieneProveedor(false);
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*public Pedido getPedido(int pos){
        return pedidos_producto(pos);
    }*/

    public void agregarPedido(Pedido pedido){
        this.pedidos_producto.add(pedido);
    }

    public void borrarPedido(Pedido pedido){
        this.pedidos_producto.remove(pedido);
    }

    public void setProveedor(Proveedor p){
        this.proveedor_producto.add(p);
        setTieneProveedor(true);
    }

    public ArrayList<Proveedor> getProveedor(){
        return proveedor_producto;
    }
    
    public void borrarProveedor(Proveedor p){
        proveedor_producto.remove(p);
        setTieneProveedor(false);
    }
}
