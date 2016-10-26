/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 2092317
 */
public interface IStub {
    public Set<Tienda> getTiendas();
    public void setTiendas(Tienda t);
    public void removeTienda(int t);
    public void setServicios(String t, Servicio s);
    public Set<Servicio> getServicios(String t);
//    public Set<Horario> getHorarioServicioTienda(String servicio, String nombreTienda);
    public Set<Servicio> getServiciosTienda(String nombreTienda);
    public void setServicioTienda(Servicio s, String nombreTienda);
}
