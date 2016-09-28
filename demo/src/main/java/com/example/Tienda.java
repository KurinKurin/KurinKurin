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
public class Tienda {

    private String nombre;
    private String direccion;
    private int telefono;
    private String descripcion;
    private ArrayList<Servicios> servicios;

    public Tienda() {
    }

    public Tienda(String nombre, String direccion, int telefono, String descripcion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public ArrayList<Horario> getHorarioServicio(String nombreServicio) {
        ArrayList<Horario> hor = new ArrayList<Horario>();
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getNombre() == nombreServicio) {
                hor = servicios.get(i).getHorarios();
            }
        }
        return hor;
    }



    /**
     * @return the Servicios
     */
    public ArrayList<Servicios> getServicios() {
        return servicios;
    }

    /**
     * @param Servicios the Servicios to set
     */
    public void setServicios(Servicios servicios) {
        this.servicios.add(servicios);
        System.out.println("Agrego a: " + this.nombre + "->" + servicios.getNombre());
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
}
