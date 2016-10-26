/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.*;

/**
 *
 * @author felipetarquino
 */

@Embeddable
public class CitaId implements java.io.Serializable {
    
    private int idcita;

    public CitaId() {
    }

    public CitaId(int idcita) {
       this.idcita = idcita;

    }
    
    @Column(name = "id_cita")
    public int getId() {
        return this.idcita;
    }
    
    public void setId(int id) {
        this.idcita = idcita;
    } 
    
}

    
    

