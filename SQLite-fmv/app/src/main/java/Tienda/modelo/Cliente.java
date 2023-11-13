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
}