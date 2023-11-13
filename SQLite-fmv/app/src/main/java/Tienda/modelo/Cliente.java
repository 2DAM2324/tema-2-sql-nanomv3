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
    
    public void escribirXML(ArrayList<Cliente> clientes) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            Element raiz = documento.createElement("tienda");
            documento.appendChild(raiz);

            Element nodoClientes = documento.createElement("clientes");
            raiz.appendChild(nodoClientes);

            if (!clientes.isEmpty()) {
                for (Cliente cliente : clientes) {
                    Element nodoCliente = documento.createElement("cliente");
                    nodoClientes.appendChild(nodoCliente);

                    Element nodoDni = documento.createElement("dni");
                    nodoDni.appendChild(documento.createTextNode(cliente.getDni()));
                    nodoCliente.appendChild(nodoDni);

                    Element nodoNombre = documento.createElement("nombre");
                    nodoNombre.appendChild(documento.createTextNode(cliente.getNombre()));
                    nodoCliente.appendChild(nodoNombre);

                    Element nodoDireccion = documento.createElement("direccion");
                    nodoDireccion.appendChild(documento.createTextNode(cliente.getDireccion()));
                    nodoCliente.appendChild(nodoDireccion);

                    Element nodoTelefono = documento.createElement("telefono");
                    nodoTelefono.appendChild(documento.createTextNode(cliente.getNombre()));
                    nodoCliente.appendChild(nodoTelefono);

                    Element nodoPedidos = documento.createElement("pedidos");
                    nodoCliente.appendChild(nodoPedidos);
                    
                    for(Pedido p : cliente.pedidos_cliente){
                        
                        Element nodoPedido = documento.createElement("pedido");
                        nodoPedidos.appendChild(nodoPedido);

                        Element nodoIdPedido = documento.createElement("id");
                        nodoIdPedido.appendChild(documento.createTextNode(p.getId()));
                        nodoPedido.appendChild(nodoIdPedido);

                        Element nodoEstado = documento.createElement("estado");
                        nodoEstado.appendChild(documento.createTextNode(p.getEstado()));
                        nodoPedido.appendChild(nodoEstado);

                        Element nodoFecha = documento.createElement("fecha");
                        nodoFecha.appendChild(documento.createTextNode(p.getFecha()));
                        nodoPedido.appendChild(nodoFecha);
                    
                    }

                    for(Empleado e : cliente.getEmpleadoTienda()){
                    
                    Element nodoEmpleado = documento.createElement("empleado");
                    nodoCliente.appendChild(nodoEmpleado);

                    Element nodoIdEmpleado = documento.createElement("id");
                    nodoIdEmpleado.appendChild(documento.createTextNode(e.getId()));
                    nodoEmpleado.appendChild(nodoIdEmpleado);

                    Element nodoNombreEmpleado = documento.createElement("nombre");
                    nodoNombreEmpleado.appendChild(documento.createTextNode(e.getNombre()));
                    nodoEmpleado.appendChild(nodoNombreEmpleado);

                    Element nodoCargoEmpleado = documento.createElement("cargo");
                    nodoCargoEmpleado.appendChild(documento.createTextNode(e.getCargo()));
                    nodoEmpleado.appendChild(nodoCargoEmpleado);
                    
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


    
    public ArrayList<Cliente> leerXML(String file) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            Element tienda = document.getDocumentElement();

            Element clientesElement = (Element) tienda.getElementsByTagName("clientes").item(0);

            NodeList listaClientes = clientesElement.getElementsByTagName("cliente");

            for (int i = 0; i < listaClientes.getLength(); i++) {
                Element cliente = (Element) listaClientes.item(i);

                String dni = cliente.getElementsByTagName("dni").item(0).getTextContent();
                String nombre = cliente.getElementsByTagName("nombre").item(0).getTextContent();
                String direccion = cliente.getElementsByTagName("direccion").item(0).getTextContent();
                String telefono = cliente.getElementsByTagName("telefono").item(0).getTextContent();

                Cliente clienteObj = new Cliente(dni, nombre, direccion, telefono);

                NodeList listaPedidos = cliente.getElementsByTagName("pedido");

                for (int j = 0; j < listaPedidos.getLength(); j++) {
                    Element pedido = (Element) listaPedidos.item(j);

                    String id = pedido.getElementsByTagName("id").item(0).getTextContent();
                    String estado = pedido.getElementsByTagName("estado").item(0).getTextContent();
                    String fecha = pedido.getElementsByTagName("fecha").item(0).getTextContent();

                    Pedido p = new Pedido(id, fecha, estado);
                    clienteObj.addPedidoCliente(p);
                }

                NodeList listaEmpleados = cliente.getElementsByTagName("empleado");

                for (int j = 0; j < listaEmpleados.getLength(); j++) {
                    Element empleado = (Element) listaEmpleados.item(j);

                    String id = empleado.getElementsByTagName("id").item(0).getTextContent();
                    String nombreEmpleado = empleado.getElementsByTagName("nombre").item(0).getTextContent();
                    String cargo = empleado.getElementsByTagName("cargo").item(0).getTextContent();

                    Empleado e = new Empleado(id, nombreEmpleado, cargo);
                    clienteObj.setEmpleadoTienda(e);
                }

                clientes.add(clienteObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }

}