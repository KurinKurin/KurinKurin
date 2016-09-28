/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2092317
 */
@RestController
@RequestMapping("/tiendas")
public class Controller {
    
   @Autowired
   IStub stub;
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Tienda> getTiendas(){
        return stub.getTiendas();       
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setTiendas(@RequestBody Tienda t){
        stub.setTiendas(t);   
    }
    
    @RequestMapping(value = "/{t}", method = RequestMethod.POST)
    public void setServicio(@PathVariable String t, @RequestBody Servicios s){
         stub.setServicios(t,s); 
    }
    
    @RequestMapping(value = "/servicios", method = RequestMethod.GET)
    public ArrayList<Servicios> getServicios(String t){
        return stub.getServicios(t);       
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeTienda(@PathVariable int t){
        //stub.removeTienda(t);       
        System.out.println("Deleteeeeeeeee");
    }
}
