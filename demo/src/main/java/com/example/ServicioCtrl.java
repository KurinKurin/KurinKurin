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
        System.out.println("Traer los servicios de ----------------------------------------"+nombre);
        Set<Servicio> serviciosTienda = new HashSet<Servicio>();
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        Criteria criteriaS = s.createCriteria(Servicio.class);
        List tiend = criteria.list();
        List tiendS = criteriaS.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Servicio> servicios = new HashSet<Servicio>(tiendS);
        for(Tienda t: todas){
                if(t.getNombre().equals(nombre)){
                    serviciosTienda=t.getServicios();
                }
        }
        System.out.println("Tamaño de servicios:"+serviciosTienda.size());
        for(Servicio sol:serviciosTienda){
            System.out.println("***"+sol.getNombre());
        }
        return serviciosTienda;     
    }
    
       @RequestMapping(value="/id/{idTienda}", method = RequestMethod.GET)
    public Set<Servicio> getServiciosId(@PathVariable("idTienda") int id) {
        System.out.println("Traer los servicios de ----------------------------------------"+id);
        Set<Servicio> serviciosTienda = new HashSet<Servicio>();
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        Criteria criteriaS = s.createCriteria(Servicio.class);
        List tiend = criteria.list();
        List tiendS = criteriaS.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Servicio> servicios = new HashSet<Servicio>(tiendS);
        for(Tienda t: todas){
                if(t.getId().getId()==id){
                    serviciosTienda=t.getServicios();
                }
        }
        System.out.println("Tamaño de servicios:"+serviciosTienda.size());
        for(Servicio sol:serviciosTienda){
            System.out.println("***"+sol.getNombre());
        }
        return serviciosTienda;     
    }
    
    @RequestMapping(value="/{nombreTienda}/servicio",method = RequestMethod.POST)
    public void setServicio(@RequestBody Servicio serv, @PathVariable("nombreTienda") String nombreTienda){
        System.out.println("Entro en setSetvicio----------------------------------------");
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteriaT = s.createCriteria(Tienda.class);
        Criteria criteriaS = s.createCriteria(Servicio.class);
        List tiend = criteriaT.list();
        List servici = criteriaS.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Servicio> servicios = new HashSet<Servicio>(servici);
        
        for(Tienda t: todas){
                if(t.getNombre().equals(nombreTienda)){
                    Servicio ser = new Servicio(serv.getNombre(),serv.getPrecio(),serv.getDescripcion(),serv.getTamano(),t.getId().getId());
                    s.save(ser);
                    System.out.println("Entro para meter un servicio en la tienda:"+t.getNombre());
                }
        }

        tx.commit();    
        s.close();
        sf.close();
    }
}
