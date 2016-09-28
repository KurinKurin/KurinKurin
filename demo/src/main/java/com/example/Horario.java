/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author castellanosisa
 */
public class Horario {
     
    public String fecha;
    public String disponibilidad;

    public Horario(String fecha, String disponibilidad) {
        this.fecha = fecha;
        this.disponibilidad = disponibilidad;
    }    
    
    public Horario(){
        
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
