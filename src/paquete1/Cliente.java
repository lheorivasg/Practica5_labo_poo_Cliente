/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author josue
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              
        //Contacto unContacto= new Contacto("Max", "Alvarez", "jpc@azc.uam.mx", "56445454");
        Socket cliente;
        ObjectOutputStream out;
        ObjectInputStream in;
        
        
        
        try {
            cliente= new Socket("172.16.6.115", 12345);
            out= new ObjectOutputStream(cliente.getOutputStream());
            ;
            
            System.out.println("Objetos serializados...");
            
            in=new ObjectInputStream(cliente.getInputStream());
            String respuesta= (String) in.readObject();
            System.out.println(respuesta);
            out.close();
            cliente.close();    
            
        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion: "+ex.getMessage());
        } catch (IOException ex2) {
            System.out.println("Excepcion: "+ex2.getMessage());
        } catch (ClassNotFoundException ex3) {
            System.out.println("Excepcion: "+ex3.getMessage());

        } 
  
    }
    
}
