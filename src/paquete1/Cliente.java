/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import Clases.Consulta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;
import Clases.Consulta;

/**
 *
 * @author josue
 */
public class Cliente extends Consulta{

    /**
     * @param args the command line arguments
     */
    
    
    
    public Cliente(String mensaje) {
        super(mensaje);
    }

    
    public static void main(String[] args) {
        // TODO code application logic here

        //Contacto unContacto= new Contacto("Max", "Alvarez", "jpc@azc.uam.mx", "56445454");
        Socket cliente;
        ObjectOutputStream out;
        ObjectInputStream in;

        try {
            cliente = new Socket("192.168.56.1", 12345);
            out = new ObjectOutputStream(cliente.getOutputStream());

            Scanner scan = new Scanner(System.in);

            // Solicitar la consulta al usuario
            System.out.println("Por favor, ingresa tu consulta:");
            String entradaUsuario= scan.nextLine();

            // Crear objeto Cliente (que hereda consulta)
            Consulta consulta = new Consulta(entradaUsuario);
            consulta.setHora(LocalTime.now());
            System.out.println("Se creo su consulta.");

            
            
            // Enviar consulta al servidor
            out.writeObject(consulta);
            out.flush();
            System.out.println("Se envio su consulta.");
            
            
            System.out.println("Objetos serializados...");

            in = new ObjectInputStream(cliente.getInputStream());
            String respuesta = (String) in.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);

            out.close();
            in.close();
            cliente.close();

            //excepciones:
        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion: " + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex2) {
            System.out.println("Excepcion: " + ex2.getMessage());
        }
    }
    
    
    
    public void registrarConsulta(String mensaje){
        this.setMensaje(mensaje);
        this.hora = LocalTime.now();
    }
    
    

}
