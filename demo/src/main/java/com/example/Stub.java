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
   
}
