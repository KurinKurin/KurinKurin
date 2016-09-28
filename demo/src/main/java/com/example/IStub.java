/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2092317
 */
public interface IStub {
    public ArrayList<Tienda> getTiendas();
    public void setTiendas(Tienda t);
    public void removeTienda(int t);
    public void setServicios(String t, Servicios s);
    public ArrayList<Servicios> getServicios(String t);
    public ArrayList<Horario> getHorarioServicioTienda(String servicio, String nombreTienda);
    public ArrayList<Servicios> getServiciosTienda(String nombreTienda);
    public void setServicioTienda(Servicios s, String nombreTienda);
}
