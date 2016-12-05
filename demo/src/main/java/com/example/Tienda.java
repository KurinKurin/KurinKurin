/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 *
 * @author Cristo López
 */

@Entity
@Table(name="tiendas")
public class Tienda implements java.io.Serializable {
        
    private TiendaId id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String descripcion;
    private Set<Servicio> servicios = new HashSet<>();
    private Set<Cita> citas = new HashSet<>();

        
    public Tienda() {
    }

    public Tienda(TiendaId id, String nombre, String direccion, int telefono, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }
       
    public Tienda(TiendaId id, String nombre, String direccion, int telefono, String descripcion, Set<Servicio> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.servicios = servicios;
    }
    

    @OneToMany(cascade =CascadeType.ALL)
    @PrePersist 
    @PreUpdate
    @JoinColumns({@JoinColumn(name="tienda_id", nullable=true, updatable = false, insertable = false)})
    public Set<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Set<Cita> citas) {
        this.citas = citas;
    }
    
    @EmbeddedId
    public TiendaId getId() {
        return this.id;
    }
    
    public void setId(TiendaId id) {
        this.id = id;
    }

//    public Set<Horario> getHorarioServicio(String nombreServicio) {
//        Set<Horario> hor = new HashSet<Horario>();
//        for (Servicio i:servicios) {
//            if (i.getNombre() == nombreServicio) {
//                hor =i.getHorarios();
//            }
//        }
//        return hor;
//    }



//    /**
//     * @return the Servicios
//     */
// @OneToMany(cascade =CascadeType.ALL)
//    @PrePersist 
//    @PreUpdate
//    @JoinColumns({@JoinColumn(name="tiendas_id", nullable=false)})
//   public Set<Servicio> getServicios() {
//        return this.servicios;
//    }
//
//    /**
//     * @param s the Servicios to set
//     */
//    public void setServicios(Servicio s) {
//        this.servicios.add(s);
//        System.out.println("Agrego a: " + this.nombre + "->" + s.getNombre());
//    }
//
    /**
     * @return the nombre
     */
    @Column(name="nombre")
    public String getNombre() {
        return this.nombre;
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
    @Column(name="direccion")
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
    @Column(name="telefono")

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
     * @return the servicios
     */
    @OneToMany(cascade =CascadeType.ALL)
    @PrePersist 
    @PreUpdate
    @JoinColumns({@JoinColumn(name="tiendas_id", nullable=false)})
    public Set<Servicio> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }
}
