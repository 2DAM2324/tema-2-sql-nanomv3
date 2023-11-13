/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

import java.io.File;
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
    private String id;
    private String estado;
    private String fecha;
    private ArrayList<Producto> productos_pedido;
    private ArrayList<Cliente> cliente;
    private boolean asignado;
    
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
        setId("");
        setEstado("");
        setFecha(null);
        setAsignado(false);
        cliente = new ArrayList<>();
        productos_pedido = new ArrayList<>();
    }

    // Constructor por parametros
    public Pedido(String id, String fecha, String estado) {
        setId(id);
        setEstado(estado);
        setFecha(fecha);
        setAsignado(false);
        cliente = new ArrayList<>();
        productos_pedido = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    
    public void escribirXML(ArrayList<Pedido> pedidos){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();
    
            Element raiz = documento.createElement("tienda");
            documento.appendChild(raiz);
    
            Element nodoPedidos = documento.createElement("pedidos");
            raiz.appendChild(nodoPedidos);
            
            for(Pedido p : pedidos){

                Element nodoPedido = documento.createElement("pedido");
                nodoPedidos.appendChild(nodoPedido);

                Element nodoId = documento.createElement("id");
                nodoId.appendChild(documento.createTextNode(p.getId()));
                nodoPedido.appendChild(nodoId);

                Element nodoEstado = documento.createElement("estado");
                nodoEstado.appendChild(documento.createTextNode(p.getEstado()));
                nodoPedido.appendChild(nodoEstado);

                Element nodoFecha = documento.createElement("fecha");
                nodoFecha.appendChild(documento.createTextNode(p.getFecha()));
                nodoPedido.appendChild(nodoFecha);

                for (Producto producto : productos_pedido) {
                    Element nodoProducto = documento.createElement("producto");
                    nodoPedido.appendChild(nodoProducto);

                    Element nodoIdProducto = documento.createElement("id");
                    nodoIdProducto.appendChild(documento.createTextNode(producto.getId()));
                    nodoProducto.appendChild(nodoId);

                    Element nodoNombre = documento.createElement("nombre");
                    nodoNombre.appendChild(documento.createTextNode(producto.getNombre()));
                    nodoProducto.appendChild(nodoNombre);

                    Element nodoStock = documento.createElement("stock");
                    if(producto.getStock()){
                        nodoStock.appendChild(documento.createTextNode("si"));
                    }else{
                        nodoStock.appendChild(documento.createTextNode("no"));
                    }
                    nodoProducto.appendChild(nodoStock);
                    
                    Element nodoPrecio = documento.createElement("precio");
                    nodoPrecio.appendChild(documento.createTextNode(String.valueOf(producto.getPrecio())));
                    nodoProducto.appendChild(nodoPrecio);
                }

                /*Element nodoCliente = documento.createElement("cliente");
                nodoCliente.appendChild(documento.createTextNode(getCliente()));
                nodoPedido.appendChild(nodoCliente);*/
            }            
            // Save the XML document to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("pedido.xml"));
    
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
         try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            Element raiz = documento.createElement("tienda");
            documento.appendChild(raiz);
    
            Element nodoPedidos = documento.createElement("pedidos");
            raiz.appendChild(nodoPedidos);

            if (!pedidos.isEmpty()) {
                for(Pedido p : pedidos){

                    Element nodoPedido = documento.createElement("pedido");
                    nodoPedidos.appendChild(nodoPedido);

                    Element nodoId = documento.createElement("id");
                    nodoId.appendChild(documento.createTextNode(p.getId()));
                    nodoPedido.appendChild(nodoId);

                    Element nodoEstado = documento.createElement("estado");
                    nodoEstado.appendChild(documento.createTextNode(p.getEstado()));
                    nodoPedido.appendChild(nodoEstado);

                    Element nodoFecha = documento.createElement("fecha");
                    nodoFecha.appendChild(documento.createTextNode(p.getFecha()));
                    nodoPedido.appendChild(nodoFecha);
                    
                    for (Producto producto : p.productos_pedido) {
                        Element nodoProducto = documento.createElement("producto");
                        nodoPedido.appendChild(nodoProducto);

                        Element nodoIdProducto = documento.createElement("id");
                        nodoIdProducto.appendChild(documento.createTextNode(producto.getId()));
                        nodoProducto.appendChild(nodoId);

                        Element nodoNombre = documento.createElement("nombre");
                        nodoNombre.appendChild(documento.createTextNode(producto.getNombre()));
                        nodoProducto.appendChild(nodoNombre);

                        Element nodoStock = documento.createElement("stock");
                        if(producto.getStock()){
                            nodoStock.appendChild(documento.createTextNode("si"));
                        }else{
                            nodoStock.appendChild(documento.createTextNode("no"));
                        }
                        nodoProducto.appendChild(nodoStock);

                        Element nodoPrecio = documento.createElement("precio");
                        nodoPrecio.appendChild(documento.createTextNode(String.valueOf(producto.getPrecio())));
                        nodoProducto.appendChild(nodoPrecio);
                    }

                    for(Cliente c : p.getCliente()){
                    
                        Element nodoCliente = documento.createElement("cliente");
                        nodoPedido.appendChild(nodoCliente);
                        
                        Element nodoDni = documento.createElement("dni");
                        nodoDni.appendChild(documento.createTextNode(c.getDni()));
                        nodoCliente.appendChild(nodoDni);

                        Element nodoNombre = documento.createElement("nombre");
                        nodoNombre.appendChild(documento.createTextNode(c.getNombre()));
                        nodoCliente.appendChild(nodoNombre);

                        Element nodoDireccion = documento.createElement("direccion");
                        nodoDireccion.appendChild(documento.createTextNode(c.getDireccion()));
                        nodoCliente.appendChild(nodoDireccion);

                        Element nodoTelefono = documento.createElement("telefono");
                        nodoTelefono.appendChild(documento.createTextNode(c.getNombre()));
                        nodoCliente.appendChild(nodoTelefono);
                    
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult("cliente.xml");

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public ArrayList<Pedido> leerXML(String file){
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Element tienda = document.getDocumentElement();

            Element pedidosElement = (Element) tienda.getElementsByTagName("pedidos").item(0);
            System.out.println("a");
            NodeList listaPedidos = pedidosElement.getElementsByTagName("pedido");
            System.out.println("b");
            for (int i = 0; i < listaPedidos.getLength(); i++) {
                Element pedido = (Element) listaPedidos.item(i);

                String id = pedido.getElementsByTagName("id").item(0).getTextContent();
                String estado = pedido.getElementsByTagName("estado").item(0).getTextContent();
                String fecha = pedido.getElementsByTagName("fecha").item(0).getTextContent();

                Pedido p = new Pedido(id, estado, fecha);
                pedidos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}
