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
    
    
    
    public void escribirXML(ArrayList<Producto> productos){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();
    
            Element raiz = documento.createElement("tienda");
            documento.appendChild(raiz);
            
            Element nodoProductos = documento.createElement("productos");
            raiz.appendChild(nodoProductos);
    
            for(Producto p : productos){
                Element nodoProducto = documento.createElement("producto");
                nodoProductos.appendChild(nodoProducto);

                Element nodoIdProducto = documento.createElement("id");
                nodoIdProducto.appendChild(documento.createTextNode(p.getId()));
                nodoProducto.appendChild(nodoIdProducto);

                Element nodoNombre = documento.createElement("nombre");
                nodoNombre.appendChild(documento.createTextNode(p.getNombre()));
                nodoProducto.appendChild(nodoNombre);

                Element nodoStock = documento.createElement("stock");
                if(p.getStock()){
                    nodoStock.appendChild(documento.createTextNode("si"));
                }else{
                    nodoStock.appendChild(documento.createTextNode("no"));
                }
                nodoProducto.appendChild(nodoStock);
                
                Element nodoPrecio = documento.createElement("precio");
                nodoPrecio.appendChild(documento.createTextNode(String.valueOf(p.getPrecio())));
                nodoProducto.appendChild(nodoPrecio);

                for (Pedido pedidos : pedidos_producto) {
                    Element nodoPedido = documento.createElement("pedido");
                    nodoProducto.appendChild(nodoPedido);

                    Element nodoId = documento.createElement("id");
                    nodoId.appendChild(documento.createTextNode(getId()));
                    nodoPedido.appendChild(nodoId);

                    Element nodoEstado = documento.createElement("estado");
                    nodoEstado.appendChild(documento.createTextNode(pedidos.getEstado()));
                    nodoPedido.appendChild(nodoEstado);

                    Element nodoFecha = documento.createElement("fecha");
                    nodoFecha.appendChild(documento.createTextNode(pedidos.getFecha()));
                    nodoPedido.appendChild(nodoFecha);
                }

                /*Element nodoProveedor = documento.createElement("proveedor");
                nodoProveedor.appendChild(documento.createTextNode(getProveedor()));
                nodoProducto.appendChild(nodoProveedor);*/
            }
            // Save the XML document to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("producto.xml"));
    
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }    
    
    public ArrayList<Producto> leerXML(String file) {
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(file));

            Element tienda = document.getDocumentElement();
            NodeList listaProductos = tienda.getElementsByTagName("producto");

            for (int i = 0; i < listaProductos.getLength(); i++) {
                Element producto = (Element) listaProductos.item(i);

                String id = producto.getElementsByTagName("id").item(0).getTextContent();
                String nombre = producto.getElementsByTagName("nombre").item(0).getTextContent();
                String stock = producto.getElementsByTagName("stock").item(0).getTextContent();
                System.out.println("stock: " + stock);

                Node precioNode = producto.getElementsByTagName("precio").item(0);
                String precio = (precioNode != null) ? precioNode.getTextContent() : "0";
                System.out.println("precio: " + precio);

                boolean stock_bool = false;

                if (stock.equalsIgnoreCase("si")) {
                    stock_bool = true;
                } else if (stock.equalsIgnoreCase("no")) {
                    stock_bool = false;
                }

                double precio_double = Double.parseDouble(precio);

                Producto p = new Producto(id, nombre, stock_bool, precio_double);
                productos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }

}
