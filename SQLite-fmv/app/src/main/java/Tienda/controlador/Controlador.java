/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.controlador;

import Tienda.interfaz.Ventana1;
import java.util.ArrayList;

import Tienda.modelo.Cliente;
import Tienda.modelo.ConexionDB;
import Tienda.modelo.Empleado;
import Tienda.modelo.Pedido;
import Tienda.modelo.Producto;
import Tienda.modelo.Proveedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private ConexionDB conexion;
    
    public Controlador(){
        conexion = new ConexionDB();
        
        cliente = new Cliente();
        
        clientes = obtenerClientesBD();
        
        pedido = new Pedido();
        
        pedidos =  obtenerPedidosBD();
        
        producto = new Producto();
        
        productos =  obtenerProductosBD();
        
        proveedor = new Proveedor();
        
        proveedores =  obtenerProveedorBD();
        
        empleado = new Empleado();
        
        empleados =  obtenerEmpleadosBD();
    }
    
    public void cerrarConexion(){
        conexion.cerrarConexion();
    }
    
    public void agregarCliente(Cliente c){
        clientes.add(c);
        
        introducirDatosDeClientesEnBD(c);
        
    }

    public void modificarCliente(Cliente cliente_borrar, Cliente cliente_modificado){
        int posicionCliente = clientes.indexOf(cliente_borrar);

        if (posicionCliente >= 0) {
            clientes.set(posicionCliente, cliente_modificado);
        }
        
        modificarDatosClienteEnBD(cliente_modificado, cliente_borrar);
    }

    public void borrarCliente(Cliente c){
        
        if(clientes != null)
            clientes.remove(c);
        
        System.out.println("saize clientes: " + clientes.isEmpty());
        borrarDatosClienteEnBD(c);
        
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
                
        introducirDatosDePedidosEnBD(p);        
    }
    
    public void modificarPedido(Pedido pedido_borrar, Pedido pedido_modificado){
        int posicionPedido = pedidos.indexOf(pedido_borrar);

        if (posicionPedido >= 0) {
            pedidos.set(posicionPedido, pedido_modificado);
        }
        
        modificarDatosPedidosEnBD(pedido_modificado, pedido_borrar);
    }
    
    public void borrarPedido(Pedido p){
        if(pedidos != null)
            pedidos.remove(p);
        
        borrarDatosPedidoEnBD(p);        
    }
    
    public ArrayList<Pedido> listaPedidos(){
        return pedidos;
    }
    
    public Pedido getPedidoPorId(String id){
        Pedido p = new Pedido();
        System.out.println("getPedidoPorid");
        
        int idInt = Integer.parseInt(id);
        
        for(Pedido pedido: pedidos){         
            
            if(pedido.getId() == idInt){
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
        
        introducirDatosDeProductosEnBD(p);
    }
    
    public void modificarProducto(Producto producto_borrar, Producto producto_modificado){
        int posicionProducto = productos.indexOf(producto_borrar);

        if (posicionProducto >= 0) {
            productos.set(posicionProducto, producto_modificado);
        }
        
        modificarDatosProductosEnBD(producto_modificado, producto_borrar);
    }
    
    public void borrarProducto(Producto p){
        if(productos != null)
            productos.remove(p);
        
        borrarDatosProductosEnBD(p);
    }
    
    public ArrayList<Producto> listaProductos(){
        return productos;
    }
    
    public Producto getProductoPorId(String id){
        Producto p = new Producto();
        int idInt = Integer.valueOf(id);
        for(Producto producto : productos){
            if(producto.getId() == idInt){
                p = producto;
            }
        }
        return p;
    }
    
    public boolean comprobarId(Producto p){
        
        for(Producto producto : productos){
            if(producto.getId() == p.getId()){
                return false;
            }
        }
        return true;
    }
    
    public void agregarProveedor(Proveedor p){
        proveedores.add(p);

       introducirDatosDeProveedoresEnBD(p);
    }
    
    public void modificarProveedor(Proveedor proveedor_borrar, Proveedor proveedor_modificado){
        int posicionProveedor = proveedores.indexOf(proveedor_borrar);

        if (posicionProveedor >= 0) {
            proveedores.set(posicionProveedor, proveedor_modificado);
        }
        
        modificarDatosProveedorEnBD(proveedor_modificado, proveedor_borrar);
    }
    
    public void borrarProveedor(Proveedor p){
        if(proveedores != null)
            proveedores.remove(p);
        
        borrarDatosProveedoresEnBD(p);
    }
    
    public ArrayList<Proveedor> listaProveedores(){
        return proveedores;
    }
    
    public Proveedor getProveedorPorId(String id){
        Proveedor p = new Proveedor();
        int idInt = Integer.valueOf(id);
        for(Proveedor proveedor : proveedores){
            if(proveedor.getId() == idInt){
                p = proveedor;
            }
        }
        return p;
    }
    
    public boolean comprobarId(Proveedor p){
        
        for(Proveedor proveedor : proveedores){
            if(proveedor.getId() == p.getId()){
                return false;
            }
        }
        return true;
    }
    
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
        
        introducirDatosDeEmpleadosEnBD(e);
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
        int idInt = Integer.valueOf(id);
        
        for(Empleado empleado : empleados){
            if(empleado.getId() == idInt){
                e = empleado;
            }
        }
        return e;
    }
    
    public boolean comprobarId(Empleado e){
        
        for(Empleado empleado : empleados){
            if(empleado.getId() == e.getId()){
                return false;
            }
        }
        return true;
    }
    
    
    ////////////////// BASE DE DATOS //////////////////////
    
    
    
    public ArrayList<Cliente> obtenerClientesBD() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT * FROM Clientes");

            //Ejecuto la consulta
            ResultSet resultados = statement.executeQuery();

            //Introduzco los datos de la bd y voy creando los clientes
            while (resultados.next()) {
                String dni = resultados.getString("dni");
                String nombre = resultados.getString("nombre_cliente");
                String direccion = resultados.getString("direccion");
                String telefono = resultados.getString("telefono");

                Cliente cliente = new Cliente(dni, nombre, direccion, telefono);
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
    
    public void introducirDatosDeClientesEnBD(Cliente c){
        
        System.out.println("Entro en introducir los datos de cliente");
        
        String sentenciaSql = "INSERT INTO Clientes (dni, nombre_cliente, direccion, telefono) VALUES (?, ?, ?, ?)";
        
        PreparedStatement sentencia = null;
        
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, c.getDni());
            sentencia.setString(2, c.getNombre());
            sentencia.setString(3, c.getDireccion());
            sentencia.setString(4, c.getTelefono());
            sentencia.executeUpdate();
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia != null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }

    } 
    
    public void borrarDatosClienteEnBD(Cliente c){
        String sentenciaSql = "DELETE FROM Clientes WHERE dni = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, c.getDni());
            sentencia.executeUpdate();
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void modificarDatosClienteEnBD(Cliente c, Cliente antiguo_c){
        String sentenciaSql = "UPDATE Clientes SET dni = ?, nombre_cliente = ?, direccion = ?, telefono = ? "
                + "WHERE dni = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, c.getDni());
            sentencia.setString(2, c.getNombre());
            sentencia.setString(3, c.getDireccion());
            sentencia.setString(4, c.getTelefono());
            sentencia.setString(5, antiguo_c.getDni());
            sentencia.executeUpdate();
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    
    
    
    
    public ArrayList<Pedido> obtenerPedidosBD() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT * FROM Pedidos");

            //Ejecuto la consulta
            ResultSet resultados = statement.executeQuery();

            //Introduzco los datos de la bd y voy creando los clientes
            while (resultados.next()) {
                int id = resultados.getInt("id_pedido");
                String fecha = resultados.getString("fecha");
                String estado = resultados.getString("estado");

                Pedido pedido = new Pedido(id, fecha, estado);
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
    
    public void introducirDatosDePedidosEnBD(Pedido p){
        
        System.out.println("Entro en introducir los datos de pedidos");
        
        String sentenciaSql = "INSERT INTO Pedidos (fecha, estado) VALUES (?, ?)";
        
        PreparedStatement sentencia = null;
        
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, p.getFecha());
            sentencia.setString(2, p.getEstado());
            sentencia.executeUpdate();
            
            ResultSet generatedKeys = sentencia.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                p.setId(idGenerado);
            } else {
                System.out.println("No se pudo obtener la clave generada para el pedido.");
            }
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia != null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void borrarDatosPedidoEnBD(Pedido p){
        
        System.out.println("borrar pedido BD");
        String sentenciaSql = "DELETE FROM Pedidos WHERE id_pedido = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, p.getId());
            //System.out.println(conexion.);
            sentencia.executeUpdate();
            
            System.out.println("id= " + p.getId());
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                    
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void modificarDatosPedidosEnBD(Pedido p, Pedido antiguo_p) {
        String sentenciaSql = "UPDATE Pedidos SET fecha = ?, estado = ? WHERE id_pedido = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, p.getFecha());
            sentencia.setString(2, p.getEstado());
            sentencia.setInt(3, antiguo_p.getId());
            sentencia.executeUpdate();

            p.setId(antiguo_p.getId());

            System.out.println("Pedido modificado correctamente: " + p.toString());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<Producto> obtenerProductosBD() {
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT * FROM Productos");

            //Ejecuto la consulta
            ResultSet resultados = statement.executeQuery();

            //Introduzco los datos de la bd y voy creando los clientes
            while (resultados.next()) {
                int id = resultados.getInt("id_producto");
                String nombre = resultados.getString("nombre_producto");
                boolean stock = resultados.getBoolean("stock");
                double precio = resultados.getDouble("precio");

                Producto producto = new Producto(id, nombre, stock, precio);
                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }
    
    public void introducirDatosDeProductosEnBD(Producto p){
        
        System.out.println("Entro en introducir los datos de productos");
        
        String sentenciaSql = "INSERT INTO Productos (nombre_producto, stock, precio) VALUES (?, ?, ?)";
        
        PreparedStatement sentencia = null;
        
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, p.getNombre());
            sentencia.setBoolean(2, p.getStock());
            sentencia.setDouble(3, p.getPrecio());
            sentencia.executeUpdate();
            
            ResultSet generatedKeys = sentencia.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                System.out.println("Id generada: " + idGenerado);
                p.setId(idGenerado);
            } else {
                System.out.println("No se pudo obtener la clave generada para el pedido.");
            }
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia != null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void borrarDatosProductosEnBD(Producto p){
        
        System.out.println("borrar producto BD");
        String sentenciaSql = "DELETE FROM Productos WHERE id_producto = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, p.getId());
            //System.out.println(conexion.);
            sentencia.executeUpdate();
            
            System.out.println("id= " + p.getId());
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                    
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void modificarDatosProductosEnBD(Producto p, Producto antiguo_p) {
        String sentenciaSql = "UPDATE Productos SET nombre_producto = ?, stock = ?, precio = ? WHERE id_producto = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, p.getNombre());
            sentencia.setBoolean(2, p.getStock());
            sentencia.setDouble(3, p.getPrecio());
            sentencia.setInt(4, antiguo_p.getId());
            sentencia.executeUpdate();

            p.setId(antiguo_p.getId());

            System.out.println("Producto modificado correctamente: " + p.toString());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<Proveedor> obtenerProveedorBD() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT * FROM Proveedores");

            //Ejecuto la consulta
            ResultSet resultados = statement.executeQuery();

            //Introduzco los datos de la bd y voy creando los clientes
            while (resultados.next()) {
                int id = resultados.getInt("id_proveedor");
                String nombre = resultados.getString("nombre_empresa");
                boolean stock = resultados.getBoolean("stock");
                double precio = resultados.getDouble("precio");

                Proveedor proveedor = new Proveedor(id, nombre, precio, stock);
                proveedores.add(proveedor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proveedores;
    }
    
    public void introducirDatosDeProveedoresEnBD(Proveedor p){
        
        System.out.println("Entro en introducir los datos de proveedor");
        
        String sentenciaSql = "INSERT INTO Proveedores (nombre_empresa, stock, precio) VALUES (?, ?, ?)";
        
        PreparedStatement sentencia = null;
        
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, p.getNombre());
            sentencia.setBoolean(2, p.getStock());
            sentencia.setDouble(3, p.getPrecio());
            sentencia.executeUpdate();
            
            ResultSet generatedKeys = sentencia.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                System.out.println("Id generada: " + idGenerado);
                p.setId(idGenerado);
            } else {
                System.out.println("No se pudo obtener la clave generada para el pedido.");
            }
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia != null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void borrarDatosProveedoresEnBD(Proveedor p){
        
        System.out.println("borrar proveedor BD");
        String sentenciaSql = "DELETE FROM Proveedores WHERE id_proveedor = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, p.getId());
            //System.out.println(conexion.);
            sentencia.executeUpdate();
            
            System.out.println("id= " + p.getId());
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia!= null){
                try{
                    sentencia.close();
                    
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public void modificarDatosProveedorEnBD(Proveedor p, Proveedor antiguo_p) {
        String sentenciaSql = "UPDATE Proveedores SET nombre_empresa = ?, stock = ?, precio = ? WHERE id_proveedor = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, p.getNombre());
            sentencia.setBoolean(2, p.getStock());
            sentencia.setDouble(3, p.getPrecio());
            sentencia.setInt(4, antiguo_p.getId());
            sentencia.executeUpdate();

            p.setId(antiguo_p.getId());

            System.out.println("Proveedor modificado correctamente: " + p.toString());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<Empleado> obtenerEmpleadosBD() {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT * FROM Empleados");

            //Ejecuto la consulta
            ResultSet resultados = statement.executeQuery();

            //Introduzco los datos de la bd y voy creando los clientes
            while (resultados.next()) {
                int id = resultados.getInt("id_empleado");
                String nombre = resultados.getString("nombre_empleado");
                String cargo = resultados.getString("cargo");

                Empleado empleado = new Empleado(id, nombre, cargo);
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }
    
    public void introducirDatosDeEmpleadosEnBD(Empleado e){
        
        System.out.println("Entro en introducir los datos de empleado");
        
        String sentenciaSql = "INSERT INTO Empleados (nombre_empleado, cargo) VALUES (?, ?)";
        
        PreparedStatement sentencia = null;
        
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, e.getNombre());
            sentencia.setString(2, e.getCargo());
            sentencia.executeUpdate();
            
            ResultSet generatedKeys = sentencia.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                System.out.println("Id generada: " + idGenerado);
                e.setId(idGenerado);
            } else {
                System.out.println("No se pudo obtener la clave generada para el pedido.");
            }
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            sqle.printStackTrace();
        }finally{
            if(sentencia != null){
                try{
                    sentencia.close();
                }catch(SQLException sqle){
                    //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    sqle.printStackTrace();
                }
            }
        }
    }
}