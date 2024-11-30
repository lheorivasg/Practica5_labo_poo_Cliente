/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author Alumno11
 */
public class Consulta implements Serializable{
    private static final long serialVersionUID = 1L; //Serial Version UID agregado
    
    protected LocalTime hora;
    protected String mensaje;

    public Consulta( String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Consulta{" + "hora=" + hora + ", mensaje=" + mensaje + '}';
    }
    
    
    
    
    public String Consultar(String mensaje){
        hora=LocalTime.now();
        
        return mensaje +" "+ hora;   
    }
    
}
