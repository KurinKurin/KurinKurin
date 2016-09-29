/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;

/**
 *
 * @author Cristo López
 */
public class Servicios {

    private String nombre;
    private int precio;
    private String descripcion;
    private String tamano;
    private ArrayList<Horario> horarios;

    public Servicios() {

    }

    public Servicios(String nombre, int precio, String descripcion, String tamano) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tamano = tamano;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    /**
     * @return the nombre
     */
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
    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(String tamano) {
        this.tamano = tamano;
    }

}
