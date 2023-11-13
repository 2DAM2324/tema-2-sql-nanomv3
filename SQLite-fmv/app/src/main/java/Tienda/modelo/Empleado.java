/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.modelo;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
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
public class Empleado {
    private String id;
    private String nombre;
    private String cargo;
    private ArrayList<Cliente> clientes_tienda;

    public ArrayList<Cliente> listaClientesTienda() {
        return clientes_tienda;
    }

    public void setClientes_tienda(Cliente c) {
        clientes_tienda.add(c);
    }
    
    public void borrarCliente_tienda(Cliente c){
        clientes_tienda.remove(c);
    }

    // Constructor por parametros
    public Empleado(String id, String nombre, String cargo) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCargo(cargo);

        clientes_tienda = new ArrayList<>();
    }

    // Constructor
    public Empleado() {
        this.setId("");
        this.setNombre("");
        this.setCargo("");
        
        clientes_tienda = new ArrayList<>();
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes_tienda.add(cliente);
    }

    public void borrarCliente(Cliente cliente) {
        this.clientes_tienda.remove(cliente);
    }

    public Cliente getCliente(int pos) {
        return this.clientes_tienda.get(pos);
    }

    public void escribirXML(ArrayList<Empleado> empleados) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();
    
            Element raiz = documento.createElement("tienda");
            documento.appendChild(raiz);

            Element nodoEmpleados = documento.createElement("empleados");
            raiz.appendChild(nodoEmpleados);
            
            for(Empleado empleado : empleados){
            
                Element nodoEmpleado = documento.createElement("empleado");
                nodoEmpleados.appendChild(nodoEmpleado);

                Element nodoId = documento.createElement("id");
                nodoId.appendChild(documento.createTextNode(empleado.getId()));
                nodoEmpleado.appendChild(nodoId);

                Element nodoNombreEmpleado = documento.createElement("nombre");
                nodoNombreEmpleado.appendChild(documento.createTextNode(empleado.getNombre()));
                nodoEmpleado.appendChild(nodoNombreEmpleado);

                Element nodoCargo = documento.createElement("cargo");
                nodoCargo.appendChild(documento.createTextNode(empleado.getCargo()));
                nodoEmpleado.appendChild(nodoCargo);

                // Add client information
                for (Cliente cliente : clientes_tienda) {
                    Element nodoCliente = documento.createElement("cliente");
                    nodoEmpleado.appendChild(nodoCliente);

                    Element nodoDni = documento.createElement("dni");
                    nodoDni.appendChild(documento.createTextNode(cliente.getDni()));
                    nodoCliente.appendChild(nodoDni);

                    Element nodoNombreCliente = documento.createElement("nombre");
                    nodoNombreCliente.appendChild(documento.createTextNode(cliente.getNombre()));
                    nodoCliente.appendChild(nodoNombreCliente);

                    Element nodoDireccion = documento.createElement("direccion");
                    nodoDireccion.appendChild(documento.createTextNode(cliente.getDireccion()));
                    nodoCliente.appendChild(nodoDireccion);

                    Element nodoTelefono = documento.createElement("telefono");
                    nodoTelefono.appendChild(documento.createTextNode(cliente.getTelefono()));
                    nodoCliente.appendChild(nodoTelefono);

                    // Add more client attributes as needed
                }
            }
            // Save the XML document to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("empleado.xml"));
    
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Empleado> leerXML(String file){
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Element tienda = document.getDocumentElement();

            Element empleadosElement = (Element) tienda.getElementsByTagName("empleados").item(0);
            System.out.println("a");
            NodeList listaEmpleados = empleadosElement.getElementsByTagName("empleado");
            System.out.println("b");
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                Element empleado = (Element) listaEmpleados.item(i);

                String id = empleado.getElementsByTagName("id").item(0).getTextContent();
                String nombre = empleado.getElementsByTagName("nombre").item(0).getTextContent();
                String cargo = empleado.getElementsByTagName("cargo").item(0).getTextContent();

                Empleado p = new Empleado(id, nombre, cargo);
                empleados.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empleados;
    }
}
