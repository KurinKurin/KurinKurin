/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.*;

/**
 *
 * @author castellanosisa
 */
@Entity
@Table(name="horarios")
public class Horario {
     
    public int id; 
    public String fecha;
    public String disponibilidad;

    public Horario(String fecha, String disponibilidad) {
        this.id =id; 
        this.fecha = fecha;
        this.disponibilidad = disponibilidad;
    }    

    
    public Horario(){
        
    }
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Column(name="disponibilidad")
    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
