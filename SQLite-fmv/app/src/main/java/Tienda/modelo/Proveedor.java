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
    
    public void escribirXML(ArrayList<Proveedor> proveedores){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();
    
            Element raiz = documento.createElement("tienda");
            documento.appendChild(raiz);
            
            Element nodoProveedores = documento.createElement("proveedores");
            raiz.appendChild(nodoProveedores);
            
            for(Proveedor proveedor : proveedores){
    
                Element nodoProveedor = documento.createElement("proveedor");
                nodoProveedores.appendChild(nodoProveedor);

                Element nodoId = documento.createElement("id");
                nodoId.appendChild(documento.createTextNode(proveedor.getId()));
                nodoProveedor.appendChild(nodoId);

                Element nodoNombreEmpresa = documento.createElement("nombreEmpresa");
                nodoNombreEmpresa.appendChild(documento.createTextNode(proveedor.getNombre()));
                nodoProveedor.appendChild(nodoNombreEmpresa);

                Element nodoStock = documento.createElement("stock");
                if(proveedor.getStock()){
                    nodoStock.appendChild(documento.createTextNode("si"));
                }else{
                    nodoStock.appendChild(documento.createTextNode("no"));
                }
                nodoProveedor.appendChild(nodoStock);
                
                Element nodoPrecioProveedor = documento.createElement("precio");
                nodoPrecioProveedor.appendChild(documento.createTextNode(String.valueOf(proveedor.getPrecio())));
                nodoProveedor.appendChild(nodoPrecioProveedor);

                // Add client information
                for (Producto producto : productos_proveedor) {
                    Element nodoProducto = documento.createElement("producto");
                    nodoProveedor.appendChild(nodoProducto);

                    Element nodoIdProducto = documento.createElement("id");
                    nodoIdProducto.appendChild(documento.createTextNode(getId()));
                    nodoProducto.appendChild(nodoIdProducto);

                    Element nodoNombre = documento.createElement("nombre");
                    nodoNombre.appendChild(documento.createTextNode(getNombre()));
                    nodoProducto.appendChild(nodoNombre);

                    Element nodoStockProducto = documento.createElement("stock");
                    if(getStock()){
                        nodoStockProducto.appendChild(documento.createTextNode("si"));
                    }else{
                        nodoStockProducto.appendChild(documento.createTextNode("no"));
                    }
                    nodoProducto.appendChild(nodoStockProducto);
                }
            }
            // Save the XML document to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("proveedor.xml"));
    
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Proveedor> leerXML(String file) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(file));

            Element tienda = document.getDocumentElement();
            NodeList listaProveedores = tienda.getElementsByTagName("proveedor");

            for (int i = 0; i < listaProveedores.getLength(); i++) {
                Element proveedor = (Element) listaProveedores.item(i);

                String id = proveedor.getElementsByTagName("id").item(0).getTextContent();
                String nombre = proveedor.getElementsByTagName("nombreEmpresa").item(0).getTextContent();
                String stock = proveedor.getElementsByTagName("stock").item(0).getTextContent();
                Node precioNode = proveedor.getElementsByTagName("precio").item(0);
                String precio = (precioNode != null) ? precioNode.getTextContent() : "0";

                boolean stock_bool = false;

                if (stock.equalsIgnoreCase("si")) {
                    stock_bool = true;
                } else if (stock.equalsIgnoreCase("no")) {
                    stock_bool = false;
                }

                double precio_double = Double.parseDouble(precio);

                Proveedor p = new Proveedor(id, nombre, precio_double, stock_bool);
                proveedores.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proveedores;
    }
}
