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
import javax.swing.JOptionPane;
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
        
        obtenerClientePedidoBD(pedidos);
        obtenerPedidoClienteBD(clientes);
        obtenerEmpleadoClienteBD(clientes);
        obtenerClientesEmpleadoBD(empleados);
        obtenerProveedorProductosBD(productos);
        obtenerProductosProveedorBD(proveedores);
        obtenerPedidoProductosBD(productos);
        obtenerProductosPedidoBD(pedidos);
    }
    
    /**
    * @brief Cierra la conexión a la base de datos.
    */
    public void cerrarConexion(){
       conexion.cerrarConexion();
    }

    /**
    * @brief Agrega un nuevo cliente a la lista e inserta datos en la base de datos.
    * @param c El cliente que se va a agregar.
    */
    public void agregarCliente(Cliente c){
       clientes.add(c);
       introducirDatosDeClientesEnBD(c);
    }

    /**
     * @brief Modifica un cliente existente en la lista y actualiza la base de datos.
     * @param cliente_borrar El cliente que se va a reemplazar.
     * @param cliente_modificado El cliente modificado.
     */
    public void modificarCliente(Cliente cliente_borrar, Cliente cliente_modificado){
        int posicionCliente = clientes.indexOf(cliente_borrar);
        if (posicionCliente >= 0) {
            clientes.set(posicionCliente, cliente_modificado);
        }
        modificarDatosClienteEnBD(cliente_modificado, cliente_borrar);
    }

    /**
     * @brief Elimina un cliente de la lista y borra datos asociados de la base de datos.
     * @param c El cliente que se va a eliminar.
     */
    public void borrarCliente(Cliente c){
        if(clientes != null)
            clientes.remove(c);
        borrarDatosClienteEnBD(c);
    }

    /**
     * @brief Obtiene la lista de clientes.
     * @return ArrayList de clientes.
     */
    public ArrayList<Cliente> listaClientes(){
        return clientes;
    }

    /**
     * @brief Busca un cliente por su dni.
     * @param dni
     * @return Cliente con el dni insertado.
     */
    public Cliente getClientePorDni(String dni){
        Cliente c = new Cliente();
        
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                c = cliente;
            }
        }
        return c;
    }
    
    /**
     * @brief Comprueba que un dni existe.
     * @param c
     * @return si el dni existe o no.
     */
    public boolean comprobarDni(Cliente c){
        
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(c.getDni())){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @brief Comprueba que un dni existe.
     * @param dni
     * @return si el dni existe o no.
     */
    public boolean comprobarDni(String dni){
        
        for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @brief Añade un pedido al atributo pedido del cliente y el cliente al atributo cliente del pedido.
     * @param c
     * @param p
     */
    public void relacionPedidosCliente(Cliente c, Pedido p){
        System.out.println("Relacion pedio cliente");
        
        c.addPedidoCliente(p);
        
        for(Pedido pedido : c.listaPedidosCliente()){
            pedido.setCliente(c);
        }
        
        introducirPedidoDeClienteEnBD(p);
    }
    
    /**
     * @brief Borra la relacion del pedido con el cliente.
     * @param c
     * @param p
     */
    public void borrarRelacionPedidoCliente(Cliente c, Pedido p){
        System.out.println("borrar relacion");
        
        for(Pedido pedido : c.listaPedidosCliente()){
            pedido.borrarCliente(c);
        }
        c.borrarPedido(p);
        
        borrarClientePedidoEnBD(p);
    }
    
    /**
     * @brief Crea la relacion del empleado con el cliente.
     * @param c
     * @param e
     */
    public void relacionEmpleadoCliente(Cliente c, Empleado e){
        c.setEmpleadoTienda(e);
        e.setClientes_tienda(c);
        
        introducirEmpleadoClienteEnBD(c);
    }
    
    /**
     * @brief Borra la relacion del empleado con el cliente.
     * @param c
     * @param e
     */
    public void borrarRelacionEmpleadoCliente(Cliente c, Empleado e){
        c.borrarEmpleadoTienda(e);
        e.borrarCliente(c);
        
        borrarEmpleadoClienteEnBD(c);
    }
    
    /**
     * @brief Crea la relacion del producto con el pedido.
     * @param prod
     * @param ped
     */
    public void relacionProductoPedido(Producto prod, Pedido ped){
        prod.setPedidos_producto(ped);
        ped.agregarProducto(prod);
        
        introducirPedidoProductosEnBD(ped, prod);
    }
    
    /**
     * @brief Borra la relacion del producto con el pedido.
     * @param c
     * @param e
     */
    public void borrarRelacionProductoPedido(Producto prod, Pedido ped){
        prod.borrarPedido(ped);
        ped.borrarProducto(prod);
        borrarProductosPedidoEnBD(prod, ped);
    }
    
    /**
     * @brief Crea la relacion del producto con el proveedor.
     * @param prod
     * @param prov
     */
    public void relacionProveedorProducto(Producto prod, Proveedor prov){
        prod.setProveedor(prov);
        prov.setProductos_proveedor(prod);
        
        introducirProveedorProductosEnBD(prod);
    }
    
    /**
     * @brief Borra la relacion del producto con el proveedor.
     * @param prod
     * @param prov
     */
    public void borrarRelacionProveedorProducto(Producto prod, Proveedor prov){
        prod.borrarProveedor(prov);
        prov.borrarProductoProveedor(prod);
        
        borrarProveedorProductoEnBD(prod);
    }
    
    /**
     * @brief Crea la relacion del cliente con el empleado.
     * @param c
     * @param e
     */
    public void relacionClienteEmpleado(Cliente c, Empleado e){
        c.setEmpleadoTienda(e);
        e.setClientes_tienda(c);
        System.out.println("relacion");
        introducirEmpleadoClienteEnBD(c);
    }
    
    /**
     * @brief Borra la relacion del cliente con el empleado.
     * @param c
     * @param e
     */
    public void borrarRelacionClienteEmpleado(Cliente c, Empleado e){
        c.borrarEmpleadoTienda(e);
        e.borrarCliente(c);
        borrarEmpleadoClienteEnBD(c);
    }
    
    /**
     * @brief Agrega un pedido al arraylist de pedidos.
     * @param p
     */
    public void agregarPedido(Pedido p){
        pedidos.add(p);
                
        introducirDatosDePedidosEnBD(p);        
    }
    
    /**
     * @brief Modifica los atributos de un pedido.
     * @param pedido_borrar
     * @param pedido_modificado
     */
    public void modificarPedido(Pedido pedido_borrar, Pedido pedido_modificado){
        int posicionPedido = pedidos.indexOf(pedido_borrar);

        if (posicionPedido >= 0) {
            pedidos.set(posicionPedido, pedido_modificado);
        }
        
        modificarDatosPedidosEnBD(pedido_modificado, pedido_borrar);
    }
    
    /**
     * @brief Borra un pedido.
     * @param p
     */
    public void borrarPedido(Pedido p){
        if(pedidos != null)
            pedidos.remove(p);
        
        borrarDatosPedidoEnBD(p);        
    }
    
    /**
    * @brief Obtiene la lista de pedidos.
    * @return ArrayList de pedidos.
    */
    public ArrayList<Pedido> listaPedidos(){
        return pedidos;
    }
    
    /**
     * @brief Obtiene un pedido por su identificador.
     * @param id El identificador del pedido a buscar.
     * @return El pedido correspondiente al identificador proporcionado.
     */
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
    
    /**
     * @brief Verifica si un identificador de pedido es único en la lista de
     * pedidos.
     * @param p El pedido cuyo identificador se va a verificar.
     * @return True si el identificador es único, False si ya existe en la
     * lista.
     */
    public boolean comprobarId(Pedido p){
        
        for(Pedido pedido : pedidos){
            if(pedido.getId() == p.getId()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @brief Agrega un nuevo producto a la lista e inserta datos en la base de
     * datos.
     * @param p El producto que se va a agregar.
     */
    public void agregarProducto(Producto p){
        productos.add(p);
        
        introducirDatosDeProductosEnBD(p);
    }
    
    /**
     * @brief Modifica un producto existente en la lista y actualiza la base de
     * datos.
     * @param producto_borrar El producto que se va a reemplazar.
     * @param producto_modificado El producto modificado.
     */
    public void modificarProducto(Producto producto_borrar, Producto producto_modificado){
        int posicionProducto = productos.indexOf(producto_borrar);

        if (posicionProducto >= 0) {
            productos.set(posicionProducto, producto_modificado);
        }
        
        modificarDatosProductosEnBD(producto_modificado, producto_borrar);
    }
    
    /**
     * @brief Elimina un producto de la lista y borra datos asociados de la base
     * de datos.
     * @param p El producto que se va a eliminar.
     */
    public void borrarProducto(Producto p){
        if(productos != null)
            productos.remove(p);
        
        borrarDatosProductosEnBD(p);
    }
    
    /**
     * @brief Obtiene la lista de productos.
     * @return ArrayList de productos.
     */
    public ArrayList<Producto> listaProductos(){
        return productos;
    }
    
    /**
     * @brief Obtiene un producto por su identificador.
     * @param id El identificador del producto a buscar.
     * @return El producto correspondiente al identificador proporcionado.
     */
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
    
    /**
     * @brief Verifica si un identificador de producto es único en la lista de
     * productos.
     * @param p El producto cuyo identificador se va a verificar.
     * @return True si el identificador es único, False si ya existe en la
     * lista.
     */
    public boolean comprobarId(Producto p){
        
        for(Producto producto : productos){
            if(producto.getId() == p.getId()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @brief Agrega un nuevo proveedor a la lista e inserta datos en la base de
     * datos.
     * @param p El proveedor que se va a agregar.
     */
    public void agregarProveedor(Proveedor p){
        proveedores.add(p);

       introducirDatosDeProveedoresEnBD(p);
    }
    
    /**
     * @brief Modifica un proveedor existente en la lista y actualiza la base de
     * datos.
     * @param proveedor_borrar El proveedor que se va a reemplazar.
     * @param proveedor_modificado El proveedor modificado.
     */
    public void modificarProveedor(Proveedor proveedor_borrar, Proveedor proveedor_modificado){
        int posicionProveedor = proveedores.indexOf(proveedor_borrar);

        if (posicionProveedor >= 0) {
            proveedores.set(posicionProveedor, proveedor_modificado);
        }
        
        modificarDatosProveedorEnBD(proveedor_modificado, proveedor_borrar);
    }
    
    /**
     * @brief Elimina un proveedor de la lista y borra datos asociados de la
     * base de datos.
     * @param p El proveedor que se va a eliminar.
     */
    public void borrarProveedor(Proveedor p){
        if(proveedores != null)
            proveedores.remove(p);
        
        borrarDatosProveedoresEnBD(p);
    }
    
    /**
     * @brief Obtiene la lista de proveedores.
     * @return ArrayList de proveedores.
     */
    public ArrayList<Proveedor> listaProveedores(){
        return proveedores;
    }
    
    /**
     * @brief Obtiene un proveedor según su ID.
     * @param id El ID del proveedor a buscar.
     * @return Proveedor encontrado o un nuevo Proveedor si no se encuentra.
     */
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
    /**
     * @brief Verifica si un proveedor ya existe en la lista.
     * @param p El proveedor a comprobar.
     * @return True si el proveedor no existe en la lista, False si ya existe.
     */
    public boolean comprobarId(Proveedor p){
        
        for(Proveedor proveedor : proveedores){
            if(proveedor.getId() == p.getId()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * @brief Agrega un nuevo empleado a la lista e inserta datos en la base de
     * datos.
     * @param e El empleado que se va a agregar.
     */
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
        
        introducirDatosDeEmpleadosEnBD(e);
    }
    
    /**
     * @brief Modifica un empleado existente en la lista y actualiza la base de
     * datos.
     * @param empleado_borrar El empleado que se va a reemplazar.
     * @param empleado_modificado El empleado modificado.
     */
    public void modificarEmpleado(Empleado empleado_borrar, Empleado empleado_modificado){
        int posicionEmpleado = empleados.indexOf(empleado_borrar);

        if (posicionEmpleado >= 0) {
            empleados.set(posicionEmpleado, empleado_modificado);
        }
        
        modificarDatosEmpleadosEnBD(empleado_modificado, empleado_borrar);
    }
    
    /**
     * @brief Elimina un empleado de la lista y borra datos asociados de la base
     * de datos.
     * @param e El empleado que se va a eliminar.
     */
    public void borrarEmpleado(Empleado e){
        if(empleados != null)
            empleados.remove(e);
        
        borrarDatosEmpleadosEnBD(e);
    }
    
    /**
     * @brief Obtiene la lista de empleados.
     * @return ArrayList de empleados.
     */
    public ArrayList<Empleado> listaEmpleados(){
        return empleados;
    }
    
    /**
     * @brief Obtiene un empleado según su ID.
     * @param id El ID del empleado a buscar.
     * @return Empleado encontrado o un nuevo Empleado si no se encuentra.
     */
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
    
    /**
     * @brief Verifica si un empleado ya existe en la lista.
     * @param e El empleado a comprobar.
     * @return True si el empleado no existe en la lista, False si ya existe.
     */    
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
    
    public void obtenerPedidoClienteBD(ArrayList<Cliente> clientes) {
        System.out.println("213wseq123");
        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT id_pedido FROM Pedidos WHERE dni = ?");

            for(Cliente c:clientes){
                //Ejecuto la consulta
                statement.setString(1, c.getDni());
                ResultSet resultados = statement.executeQuery();
                System.out.println("dni: "+c.getDni());

                while (resultados.next()) {
                    System.out.println("entro en el while");
                    int id_pedido = resultados.getInt("id_pedido");
                    String id_str = String.valueOf(id_pedido);
                    
                    System.out.println("id: "+id_str);

                    Pedido p = getPedidoPorId(id_str);

                    if(p.getId()!=0){
                        c.addPedidoCliente(p);
                    }else{
                        System.out.println("no hay pedio que valga");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void obtenerEmpleadoClienteBD(ArrayList<Cliente> clientes){
        System.out.println("bd empleao cliente");
        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT id_empleado FROM Clientes WHERE dni = ?");

            for(Cliente c : clientes){
                statement.setString(1, c.getDni());
                System.out.println("dni: "+c.getDni());
                ResultSet resultados = statement.executeQuery();
                
                while (resultados.next()) {
                   int id_empleado = resultados.getInt("id_empleado");
                   
                   String id_str = String.valueOf(id_empleado);
                   
                   Empleado e = getEmpleadoPorId(id_str);
                   if(e.getId()!=0){
                       
                       c.setEmpleadoTienda(e);
                   }else{
                       System.out.println("no teine");
                   }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void introducirEmpleadoClienteEnBD(Cliente c){
        System.out.println("entro en empleao cliente bd");
        String sentenciaSql = "UPDATE Clientes SET id_empleado = ? WHERE dni = ?";
        
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            if(c.getEmpleadoTienda().get(0)!=null){
                sentencia.setInt(1, c.getEmpleadoTienda().get(0).getId());
                sentencia.setString(2, c.getDni());
                sentencia.executeUpdate();
            }else{
                //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("no se ha introducido el empleao");
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
    
    public void borrarDatosClienteEnBD(Cliente c){
        String sentenciaSql = "DELETE FROM Clientes "
                + "WHERE dni = ?";
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
    
    public void borrarEmpleadoClienteEnBD(Cliente c){
        
        System.out.println("borrar empleao de cliente BD");
        String sentenciaSql = "UPDATE Clientes SET id_empleado = NULL WHERE dni = ?";
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
    
    public void obtenerProductosPedidoBD(ArrayList<Pedido> pedidos) {

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT id_producto FROM Contiene WHERE id_pedido = ?");

            for(Pedido p : pedidos){
                //Ejecuto la consulta
                statement.setInt(1, p.getId());
                ResultSet resultados = statement.executeQuery();

                //Introduzco los datos de la bd y voy creando los clientes
                while (resultados.next()) {
                    int id = resultados.getInt("id_producto");
                    
                    String id_str = String.valueOf(id);
                    
                    Producto prod = getProductoPorId(id_str);
                    
                    p.agregarProducto(prod);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void obtenerClientePedidoBD(ArrayList<Pedido> pedidos){
        System.out.println("ljfdnonfdoa");
        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT dni FROM Pedidos WHERE id_pedido = ?");

            for(Pedido p : pedidos){
                statement.setInt(1, p.getId());
                ResultSet resultados = statement.executeQuery();
                
                while (resultados.next()) {
                    String dni = resultados.getString("dni");

                    // Verificar si el dni es null
                    if (dni!=null) {
                        Cliente c = getClientePorDni(dni);
                        p.setCliente(c);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    public void introducirPedidoDeClienteEnBD(Pedido p){
                
        String sentenciaSql = "UPDATE Pedidos SET dni = ? WHERE id_pedido = ?";
        
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            if(p.getCliente().get(0)!=null){
                sentencia.setString(1, p.getCliente().get(0).getDni());
                sentencia.setInt(2, p.getId());
                sentencia.executeUpdate();
            }else{
                //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("no se ha introducido el cliente");
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
    
    public void borrarClientePedidoEnBD(Pedido p){
        
        System.out.println("borrar cliente de pedio BD");
        String sentenciaSql = "UPDATE Pedidos SET dni = NULL WHERE id_pedido = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, p.getId());
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
    
    public void obtenerPedidoProductosBD(ArrayList<Producto> productos) {

        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT id_pedido FROM Contiene WHERE id_producto = ?");

            for(Producto p : productos){
                //Ejecuto la consulta
                statement.setInt(1, p.getId());
                ResultSet resultados = statement.executeQuery();

                //Introduzco los datos de la bd y voy creando los clientes
                while (resultados.next()) {
                    int id = resultados.getInt("id_pedido");
                    
                    String id_str = String.valueOf(id);
                    
                    Pedido ped = getPedidoPorId(id_str);
                    
                    p.agregarPedido(ped);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void obtenerProveedorProductosBD(ArrayList<Producto> productos){
        System.out.println("bd prov prod");
        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT id_proveedor FROM Productos WHERE id_producto = ?");

            for(Producto p : productos){
                statement.setInt(1, p.getId());
                ResultSet resultados = statement.executeQuery();
                
                while (resultados.next()) {
                   int id_proveedor = resultados.getInt("id_proveedor");
                   
                   String id_str = String.valueOf(id_proveedor);
                   
                   Proveedor prov = getProveedorPorId(id_str);
                   if(prov.getId()!=0){
                       p.setProveedor(prov);
                   }else{
                       System.out.println("no teine");
                   }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    
    public void introducirPedidoProductosEnBD(Pedido ped, Producto prod){
                
        String sentenciaSql = "INSERT INTO Contiene (id_pedido, id_producto) VALUES (?, ?)";
        
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            
            sentencia.setInt(1, ped.getId());
            sentencia.setInt(2, prod.getId());
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
    
    public void introducirProveedorProductosEnBD(Producto p){
        System.out.println("introducirProveedorProductosEnBD");
        String sentenciaSql = "UPDATE Productos SET id_proveedor = ? WHERE id_producto = ?";
        
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            if(p.getProveedor().get(0)!=null){
                sentencia.setInt(1, p.getProveedor().get(0).getId());
                sentencia.setInt(2, p.getId());
                sentencia.executeUpdate();
            }else{
                //JOptionPane.showMessageDialog(this,"Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("no se ha introducido el proveedor");
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
    
    public void borrarProductosPedidoEnBD(Producto prod, Pedido ped){
        
        System.out.println("borrarProductosPedidoEnBD");
        String sentenciaSql = "DELETE FROM Contiene WHERE id_producto = ? AND id_pedido = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, prod.getId());
            sentencia.setInt(2, ped.getId());
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
    
    public void borrarProveedorProductoEnBD(Producto p){
        
        System.out.println("borrarProveedorProductoEnBD");
        String sentenciaSql = "UPDATE Productos SET id_proveedor = NULL WHERE id_producto = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, p.getId());
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
    
    public void obtenerProductosProveedorBD(ArrayList<Proveedor> proveedores) {
        System.out.println("obtenerProductosProveedorBD");
        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT id_producto FROM Productos WHERE id_proveedor = ?");

            for(Proveedor p:proveedores){
                //Ejecuto la consulta
                statement.setInt(1, p.getId());
                ResultSet resultados = statement.executeQuery();

                while (resultados.next()) {
                    System.out.println("entro en el while");
                    int id_productos = resultados.getInt("id_producto");
                    
                    String id_str = String.valueOf(id_productos);
                    
                    Producto prod = getProductoPorId(id_str);

                    if(prod.getId()!=0){
                        p.setProductos_proveedor(prod);
                    }else{
                        System.out.println("no hay productos que valga");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    
    public void obtenerClientesEmpleadoBD(ArrayList<Empleado> empleados) {
        System.out.println("obtenerClientesEmpleadoBD");
        try {
            //Creo una consulta
            PreparedStatement statement = conexion.obtenerConexion().prepareStatement("SELECT dni FROM Clientes WHERE id_empleado = ?");

            for(Empleado e:empleados){
                //Ejecuto la consulta
                statement.setInt(1, e.getId());
                ResultSet resultados = statement.executeQuery();

                while (resultados.next()) {
                    System.out.println("entro en el while");
                    String dni = resultados.getString("dni");
                    
                    Cliente c = getClientePorDni(dni);

                    if(!c.getDni().isEmpty()){
                        e.agregarCliente(c);
                    }else{
                        System.out.println("no hay cliente que valga");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    
    public void borrarDatosEmpleadosEnBD(Empleado e){
        
        System.out.println("borrar empleado BD");
        String sentenciaSql = "DELETE FROM Empleados WHERE id_empleado = ?";
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setInt(1, e.getId());
            sentencia.executeUpdate();
            
            System.out.println("id= " + e.getId());
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
    
    public void modificarDatosEmpleadosEnBD(Empleado e, Empleado antiguo_e) {
        String sentenciaSql = "UPDATE Empleados SET nombre_empleado = ?, cargo = ? WHERE id_empleado = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = conexion.obtenerConexion().prepareStatement(sentenciaSql);
            sentencia.setString(1, e.getNombre());
            sentencia.setString(2, e.getCargo());
            sentencia.setInt(3, antiguo_e.getId());
            sentencia.executeUpdate();

            e.setId(antiguo_e.getId());

            System.out.println("Empleado modificado correctamente: " + e.toString());
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
}