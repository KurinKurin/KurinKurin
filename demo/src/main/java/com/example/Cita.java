/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author felipetarquino
 */
@Entity
@Table(name="citas")
public class Cita implements java.io.Serializable {
   
   CitaId id;
   String user;
   String idServicio;

    public Cita() {
    }

    public Cita(String user, String idServicio) {
        this.user = user;
        this.idServicio = idServicio;
    }
    
    @EmbeddedId
    public CitaId getId() {
        return id;
    }

    public void setId(CitaId id) {
        this.id = id;
    }
    
    @Column(name="usuarios_id")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    @Column(name="servicios_id")
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

     
}
