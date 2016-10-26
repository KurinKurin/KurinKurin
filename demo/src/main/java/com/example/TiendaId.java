/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author USUARIO
 */
@Embeddable
public class TiendaId implements java.io.Serializable {
    
    private int id;

    public TiendaId() {
    }

    public TiendaId(int id) {
       this.id = id;

    }
    
    @Column(name = "id")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    } 
    
}
