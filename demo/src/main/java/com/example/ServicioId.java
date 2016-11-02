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
 * @author Cristo López
 */
@Embeddable
public class ServicioId implements java.io.Serializable{
    private int id;

    public ServicioId() {
    }
    
    public ServicioId(int id) {
       this.id = id;

    }
    
    @Column(name = "idservicios")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    } 
}
