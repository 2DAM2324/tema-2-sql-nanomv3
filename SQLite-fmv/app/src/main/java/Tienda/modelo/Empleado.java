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
}
