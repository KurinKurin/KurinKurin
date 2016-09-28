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
            if(listaTiendas.get(c).getNombre() == t){
                listaTiendas.get(listaTiendas.indexOf(t)).setServicios(s);
            }
        }
    }

    @Override
    public ArrayList<Servicios> getServicios(String t) {
        ArrayList<Servicios> servicios = new ArrayList<Servicios>();
        for(int c=0;c<listaTiendas.size();c++){
            if(listaTiendas.get(c).getNombre() == t){
               servicios = listaTiendas.get(listaTiendas.indexOf(t)).getServicios();
            }
        }
        return servicios; 
    }
   
    
}
