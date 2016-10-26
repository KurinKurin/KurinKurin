/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2092317
 */
@Service
public class Stub implements IStub{
Set<Tienda> listaTiendas = new HashSet<Tienda>(); 

    public Set<Tienda> getTiendas() {
         return listaTiendas;
    }

    public void setTiendas(Tienda t) {
        listaTiendas.add(t);
    }
    
    public void removeTienda(int t){
        listaTiendas.remove(t);
    }

    @Override
    public void setServicios(String t, Servicio s) {
        Set<Servicio> servi=new HashSet<>(); 
        for(Tienda c:listaTiendas){
            if(c.getNombre().equals(t)){
                servi=c.getServicios();
                servi.add(s);
                c.setServicios(servi);
            }
        }
    }

    @Override
    public Set<Servicio> getServicios(String t) {
        Set<Servicio> servicios = new HashSet<Servicio>();
        
        for(Tienda c:listaTiendas){
            if(c.getNombre().equals(t)){
               servicios = c.getServicios();
            }
        }
        return servicios; 
    }
   
    @Override
    public void setServicioTienda(Servicio s, String nombreTienda){
        Set<Servicio> servi = new HashSet<>();
        System.out.println("Cantidad de tiendas: "+listaTiendas.size());
        for(Tienda i:listaTiendas){
             System.out.println(i.getNombre()+"<------>"+nombreTienda);
            if(i.getNombre().equals(nombreTienda)){
               System.out.println("Entroooo++++++++++++++++++++++++");
               servi=i.getServicios();
               servi.add(s);
               i.setServicios(servi);
            }
        }
        System.out.println("Entro en setServicioTienda-------------------------"+s.getNombre());
    }
    
    @Override
    public Set<Servicio> getServiciosTienda(String nombreTienda){
        Set<Servicio> servicios= new HashSet<Servicio>();
        for(Tienda i:listaTiendas){
            if(i.getNombre().equals(nombreTienda)){
                servicios=i.getServicios();
            }
        }
        return servicios;
    }
//    @Override
//    public Set<Horario> getHorarioServicioTienda(String servicio, String nombreTienda){
//        Set<Horario> hor= new HashSet<Horario>();
//        for(Tienda i:listaTiendas){
//            if(i.getNombre().equals(nombreTienda)){
//                hor=i.getHorarioServicio(servicio);
//            }
//        }
//        return hor;
//    }
    
}
