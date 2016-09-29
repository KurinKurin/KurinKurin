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
    public ArrayList<Tienda> getTiendas() {
        return stub.getTiendas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setTiendas(@RequestBody Tienda t) {
        stub.setTiendas(t);
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeTienda(@PathVariable int t) {
        //stub.removeTienda(t);       
        System.out.println("Deleteeeeeeeee");
    }
    
    @RequestMapping(value="/{nombreTienda}/servicios", method = RequestMethod.GET)
    public ArrayList<Servicios> getServicios(@PathVariable("nombreTienda") String nombre){
        return stub.getServiciosTienda(nombre);       
    }

    @RequestMapping(value="/{nombreTienda}/servicios/{servicio}/horarios", method = RequestMethod.GET)
    public ArrayList<Horario> getHorarios(@PathVariable("servicio") String servicio, @PathVariable("nombreTienda") String nombreTienda){
        return stub.getHorarioServicioTienda(servicio, nombreTienda);
    }
    
    @RequestMapping(value="/{nombreTienda}/servicio",method = RequestMethod.POST)
    public void setServicio(@RequestBody Servicios s, @PathVariable("nombreTienda") String nombreTienda){
        System.out.println("Entro en setSetvicio->"+s.getNombre());
        stub.setServicioTienda(s, nombreTienda);
    }
}
