/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import Clases.Consulta;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class Cliente extends Consulta{

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
            cliente = new Socket("192.168.8.103", 12345);
            out = new ObjectOutputStream(cliente.getOutputStream());

            Scanner scan = new Scanner(System.in);

            // Solicitar la consulta al usuario
            System.out.println("Por favor, ingresa tu consulta:");
            String entradaUsuario= scan.nextLine();

            // Crear objeto Consulta
            Consulta consulta = new Consulta();
            consulta.registrarConsulta(entradaUsuario);
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
            cliente.close();

            //excepciones:
        } catch (FileNotFoundException ex) {
            System.out.println("Excepcion: " + ex.getMessage());
        } catch (IOException ex2) {
            System.out.println("Excepcion: " + ex2.getMessage());
        } catch (ClassNotFoundException ex3) {
            System.out.println("Excepcion: " + ex3.getMessage());

        }

    }

}
