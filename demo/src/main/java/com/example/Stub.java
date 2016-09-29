/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2092317
 */
@Service
public class Stub implements IStub{
ArrayList<Tienda> listaTiendas = new ArrayList<Tienda>(); 

    public ArrayList<Tienda> getTiendas() {
         return listaTiendas;
    }

    public void setTiendas(Tienda t) {
        listaTiendas.add(t);
    }
    
    public void removeTienda(int t){
        listaTiendas.remove(t);
    }

    @Override
    public void setServicios(String t, Servicios s) {
        
        for(int c=0;c<listaTiendas.size();c++){
            if(listaTiendas.get(c).getNombre().equals(t)){
                listaTiendas.get(listaTiendas.indexOf(t)).setServicios(s);
            }
        }
    }

    @Override
    public ArrayList<Servicios> getServicios(String t) {
        ArrayList<Servicios> servicios = new ArrayList<Servicios>();
        
        for(int c=0;c<listaTiendas.size();c++){
            if(listaTiendas.get(c).getNombre().equals(t)){
               servicios = listaTiendas.get(listaTiendas.indexOf(t)).getServicios();
            }
        }
        return servicios; 
    }
   
    @Override
    public void setServicioTienda(Servicios s, String nombreTienda){
        System.out.println("Cantidad de tiendas: "+listaTiendas.size());
        for(int i=0; i<listaTiendas.size(); i++){
             System.out.println(listaTiendas.get(i).getNombre()+"<------>"+nombreTienda);
            if(listaTiendas.get(i).getNombre().equals(nombreTienda)){
               System.out.println("Entroooo++++++++++++++++++++++++");
                listaTiendas.get(i).setServicios(s);
            }
        }
        System.out.println("Entro en setServicioTienda-------------------------"+s.getNombre());
    }
    
    @Override
    public ArrayList<Servicios> getServiciosTienda(String nombreTienda){
        ArrayList<Servicios> servicios= new ArrayList<Servicios>();
        for(int i=0; i<listaTiendas.size(); i++){
            if(listaTiendas.get(i).getNombre().equals(nombreTienda)){
                servicios=listaTiendas.get(i).getServicios();
            }
        }
        return servicios;
    }
    @Override
    public ArrayList<Horario> getHorarioServicioTienda(String servicio, String nombreTienda){
        ArrayList<Horario> hor= new ArrayList<Horario>();
        for(int i=0; i<listaTiendas.size(); i++){
            if(listaTiendas.get(i).getNombre().equals(nombreTienda)){
                hor=listaTiendas.get(i).getHorarioServicio(servicio);
            }
        }
        return hor;
    }
    
}
