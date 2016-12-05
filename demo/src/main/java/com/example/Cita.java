/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author felipetarquino
 */
@Entity
@Table(name="citas")
public class Cita implements java.io.Serializable {
   
   int id;
   String user;
   int idServicio;
   int tienda_id;
   int disponible;
   String fecha;
   String hora;

    public Cita() {
    }

    public Cita(String user, int idServicio, int tienda_id, int disponible) {
        this.user = user;
        this.idServicio = idServicio;
        this.tienda_id = tienda_id;
        this.disponible = disponible;
    }  

    public Cita(String user, int idServicio, int tienda_id, int disponible, String fecha, String hora) {
        this.user = user;
        this.idServicio = idServicio;
        this.tienda_id = tienda_id;
        this.disponible = disponible;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    @Column(name="fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Column(name="hora")
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    @Column(name="disponible")
    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
   
    @Column(name="tienda_id")
    public int getTienda_id() {
        return tienda_id;
    }

    public void setTienda_id(int tienda_id) {
        this.tienda_id = tienda_id;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cita_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="usuario")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    @Column(name="servicio")
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
         
}
