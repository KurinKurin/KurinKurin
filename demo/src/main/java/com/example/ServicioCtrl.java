/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static com.example.Controller.getSessionFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristo López
 */
@RestController
@RequestMapping("/servicios")
public class ServicioCtrl {
    
    
   @RequestMapping(value="/{nombreTienda}", method = RequestMethod.GET)
    public Set<Servicio> getServicios(@PathVariable("nombreTienda") String nombre) {
        System.out.println("Traer los servicios --------------------------------------------------------------------------------");
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        List tiend = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Servicio> servicios = new HashSet<Servicio>();
        for(Tienda t: todas){
                if(t.getNombre().equals(nombre)){
                    servicios = t.getServicios();
                }
        }
        return servicios;     
    }
    
    @RequestMapping(value="/{nombreTienda}/servicio",method = RequestMethod.POST)
    public void setServicio(@RequestBody Servicio serv, @PathVariable("nombreTienda") String nombreTienda){
        System.out.println("Entro en setSetvicio----------------------------------------");
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        List tiend = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Servicio> servicios = new HashSet<Servicio>();
        for(Tienda t: todas){
                if(t.getNombre().equals(nombreTienda)){
                    servicios = t.getServicios();
                    servicios.add(serv);
                    t.setServicios(servicios);
                }
        }
//        s.save(t);
//        tx.commit();    
//        s.close();
//        sf.close();
    }
}
