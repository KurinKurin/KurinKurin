/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Cristo López
 */

@Entity
@Table(name="servicios")
public class Servicio implements java.io.Serializable {
    
    private int idServicios;
    private String nombre;
    private int precio;
    private String descripcion;
    private String tamano;
//    private Set<Horario> horarios;

    public Servicio() {

    }

    public Servicio(String nombre, int precio, String descripcion, String tamano) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tamano = tamano;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idservicios")   
    public Integer getIdServicios() {
        return this.idServicios;
    }
    
    public void setIdServicios(Integer idServicios) {
        this.idServicios = idServicios;
    }
    
//    @Column(name="horarios")
//    public Set<Horario> getHorarios() {
//        return horarios;
//    }

//    public void setHorarios(Set<Horario> horarios) {
//        this.horarios = horarios;
//    }

    /**
     * @return the nombre
     */
    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    @Column(name="precio")
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tamaño
     */
   @Column(name="tamano")

    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamaño to set
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

}
