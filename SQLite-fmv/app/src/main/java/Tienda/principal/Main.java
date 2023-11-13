/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.principal;

import Tienda.interfaz.Ventana1;
import Tienda.modelo.Empleado;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.nio.file.FileAlreadyExistsException;
import org.xml.sax.SAXException;

/**
 *
 * @author nanom
 */
public class Main {
    public static void main (String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException{   
        Ventana1 interfaz = new Ventana1();
        interfaz.setVisible(true);
    }
}
