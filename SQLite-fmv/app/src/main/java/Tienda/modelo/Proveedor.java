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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author nanom
 */
public class Proveedor {
    private String id;
    private String nombre_empresa;
    private double precio;
    private boolean stock;
    private ArrayList<Producto> productos_proveedor;

    

    // Constructor por parametros
    public Proveedor(String id, String nombre, double precio, boolean stock) {
        setId(id);
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        
        productos_proveedor = new ArrayList<>();
    }

    // Constructor
    public Proveedor() {
        setId("");
        setNombre("");
        setPrecio(0.0);
        setStock(false);
        
        productos_proveedor = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre_empresa;
    }

    public void setNombre(String nombre) {
        this.nombre_empresa = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
    
    public ArrayList<Producto> getProductos_proveedor() {
        return productos_proveedor;
    }

    public void setProductos_proveedor(Producto productos_proveedor) {
        this.productos_proveedor.add(productos_proveedor);
    }
    
    public void borrarProductoProveedor(Producto p){
        productos_proveedor.remove(p);
    }
}
