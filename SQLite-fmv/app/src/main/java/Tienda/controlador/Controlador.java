/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.controlador;

import Tienda.interfaz.Ventana1;
import java.util.ArrayList;

import Tienda.modelo.Cliente;
import Tienda.modelo.Empleado;
import Tienda.modelo.Pedido;
import Tienda.modelo.Producto;
import Tienda.modelo.Proveedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import org.xml.sax.SAXException;

/**
 *
 * @author nanom
 */
public class Controlador {
    private Cliente cliente;
    private Pedido pedido;
    private Producto producto;
    private Proveedor proveedor;
    private Empleado empleado;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos; 
    private ArrayList<Producto> productos;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Empleado> empleados;
    
    public Controlador(){       
        cliente = new Cliente();
        
        clientes = cliente.obtenerClientesBD();
        
        pedido = new Pedido();
        
        pedidos =  pedido.obtenerPedidosBD();
        
        producto = new Producto();
        
        productos =  new ArrayList<>();
        
        proveedor = new Proveedor();
        
        proveedores =  new ArrayList<>();
        
        empleado = new Empleado();
        
        empleados =  new ArrayList<>();
    }
    
    public void agregarCliente(Cliente c){
        clientes.add(c);
        
        c.introducirDatosDeClientesEnBD(c);
        
    }

    public void modificarCliente(Cliente cliente_borrar, Cliente cliente_modificado){
        int posicionCliente = clientes.indexOf(cliente_borrar);

        if (posicionCliente >= 0) {
            clientes.set(posicionCliente, cliente_modificado);
        }
        
        cliente_modificado.modificarDatosClienteEnBD(cliente_modificado, cliente_borrar);
    }

    public void borrarCliente(Cliente c){
        
        if(clientes != null)
            clientes.remove(c);
        
        System.out.println("saize clientes: " + clientes.isEmpty());
        c.borrarDatosClienteEnBD(c);
        
    }
    public ArrayList<Cliente> listaClientes(){
        return clientes;
    }
    
    public Cliente getClientePorDni(String dni){
        Cliente c = new Cliente();
        
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                c = cliente;
            }
        }
        return c;
    }
    
    public boolean comprobarDni(Cliente c){
        
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(c.getDni())){
                return false;
            }
        }
        return true;
    }
    
    public boolean comprobarDni(String dni){
        
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                return false;
            }
        }
        return true;
    }
    
    public void relacionPedidosCliente(Cliente c, Pedido p){
        System.out.println("Relacion pedio cliente");
        
        c.addPedidoCliente(p);
        
        for(Pedido pedido : c.listaPedidosCliente()){
            pedido.setCliente(c);
        }
        
        //c.escribirXML(clientes);
    }
    
    public void borrarRelacionPedidoCliente(Cliente c, Pedido p){
        System.out.println("borrar relacion");
        
        for(Pedido pedido : c.listaPedidosCliente()){
            pedido.borrarCliente(c);
        }
        c.borrarPedido(p);
        
        //c.escribirXML(clientes);
    }
    
    public void relacionEmpleadoCliente(Cliente c, Empleado e){
        c.setEmpleadoTienda(e);
        e.setClientes_tienda(c);
        
        //c.escribirXML(clientes);
        
        
    }
    
    public void borrarRelacionEmpleadoCliente(Cliente c, Empleado e){
        c.borrarEmpleadoTienda(e);
        e.borrarCliente(c);
        
        //c.escribirXML(clientes);
    }
    
    public void relacionProductoPedido(Producto prod, Pedido ped){
        prod.setPedidos_producto(ped);
        ped.agregarProducto(prod);
        
        //ped.escribirXML(pedidos);
    }
    
    public void borrarRelacionProductoPedido(Producto prod, Pedido ped){
        prod.borrarPedido(ped);
        ped.borrarProducto(prod);
        
        //ped.escribirXML(pedidos);
    }
    
    public void relacionProveedorProducto(Producto prod, Proveedor prov){
        prod.setProveedor(prov);
        prov.setProductos_proveedor(prod);
    }
    
    public void borrarRelacionProveedorProducto(Producto prod, Proveedor prov){
        prod.borrarProveedor(prov);
        prov.borrarProductoProveedor(prod);
    }
    
    public void relacionClienteEmpleado(Cliente c, Empleado e){
        c.setEmpleadoTienda(e);
        e.setClientes_tienda(c);
    }
    
    public void borrarRelacionClienteEmpleado(Cliente c, Empleado e){
        c.borrarEmpleadoTienda(e);
        e.borrarCliente(c);
    }
    
    public void agregarPedido(Pedido p){
        pedidos.add(p);
                
        p.introducirDatosDePedidosEnBD(p);        
    }
    
    public void modificarPedido(Pedido pedido_borrar, Pedido pedido_modificado){
        int posicionPedido = pedidos.indexOf(pedido_borrar);

        if (posicionPedido >= 0) {
            pedidos.set(posicionPedido, pedido_modificado);
        }
        
        //pedido_modificado.escribirXML(pedidos);
    }
    
    public void borrarPedido(Pedido p){
        if(pedidos != null)
            pedidos.remove(p);
        
        //p.escribirXML(pedidos);        
    }
    
    public ArrayList<Pedido> listaPedidos(){
        return pedidos;
    }
    
    public Pedido getPedidoPorId(int id){
        Pedido p = new Pedido();
        System.out.println("getPedidoPorid");
        for(Pedido pedido: pedidos){
            if(pedido.getId() == id){
                p = pedido;
                System.out.println("han coincidio");
            }
        }
        return p;
    }
    
    public boolean comprobarId(Pedido p){
        
        for(Pedido pedido : pedidos){
            if(pedido.getId() == p.getId()){
                return false;
            }
        }
        return true;
    }
    
    public void agregarProducto(Producto p){
        productos.add(p);
        
        //p.escribirXML(productos);
    }
    
    public void modificarProducto(Producto producto_borrar, Producto producto_modificado){
        int posicionProducto = productos.indexOf(producto_borrar);

        if (posicionProducto >= 0) {
            productos.set(posicionProducto, producto_modificado);
        }
        
        //producto_modificado.escribirXML(productos);
    }
    
    public void borrarProducto(Producto p){
        if(productos != null)
            productos.remove(p);
        
        //p.escribirXML(productos);
    }
    
    public ArrayList<Producto> listaProductos(){
        return productos;
    }
    
    public Producto getProductoPorId(String id){
        Producto p = new Producto();
        for(Producto producto : productos){
            if(producto.getId().equals(id)){
                p = producto;
            }
        }
        return p;
    }
    
    public boolean comprobarId(Producto p){
        
        for(Producto producto : productos){
            if(producto.getId().equals(p.getId())){
                return false;
            }
        }
        return true;
    }
    
    public void agregarProveedor(Proveedor p){
        proveedores.add(p);

       // p.escribirXML(proveedores);
    }
    
    public void modificarProveedor(Proveedor proveedor_borrar, Proveedor proveedor_modificado){
        int posicionProveedor = proveedores.indexOf(proveedor_borrar);

        if (posicionProveedor >= 0) {
            proveedores.set(posicionProveedor, proveedor_modificado);
        }
        
       // proveedor_modificado.escribirXML(proveedores);
    }
    
    public void borrarProveedor(Proveedor p){
        if(proveedores != null)
            proveedores.remove(p);
        
        //p.escribirXML(proveedores);
    }
    
    public ArrayList<Proveedor> listaProveedores(){
        return proveedores;
    }
    
    public Proveedor getProveedorPorId(String id){
        Proveedor p = new Proveedor();
        for(Proveedor proveedor : proveedores){
            if(proveedor.getId().equals(id)){
                p = proveedor;
            }
        }
        return p;
    }
    
    public boolean comprobarId(Proveedor p){
        
        for(Proveedor proveedor : proveedores){
            if(proveedor.getId().equals(p.getId())){
                return false;
            }
        }
        return true;
    }
    
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
        
        //e.escribirXML(empleados);
    }
    
    public void modificarEmpleado(Empleado empleado_borrar, Empleado empleado_modificado){
        int posicionEmpleado = empleados.indexOf(empleado_borrar);

        if (posicionEmpleado >= 0) {
            empleados.set(posicionEmpleado, empleado_modificado);
        }
        
        //empleado_modificado.escribirXML(empleados);
    }
    
    public void borrarEmpleado(Empleado e){
        if(empleados != null)
            empleados.remove(e);
        
        //e.escribirXML(empleados);
    }
    
    public ArrayList<Empleado> listaEmpleados(){
        return empleados;
    }
    
    public Empleado getEmpleadoPorId(String id){
        Empleado e = new Empleado();
        for(Empleado empleado : empleados){
            if(empleado.getId().equalsIgnoreCase(id)){
                e = empleado;
            }
        }
        return e;
    }
    
    public boolean comprobarId(Empleado e){
        
        for(Empleado empleado : empleados){
            if(empleado.getId().equals(e.getId())){
                return false;
            }
        }
        return true;
    }
}
