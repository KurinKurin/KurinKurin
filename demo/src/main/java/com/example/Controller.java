/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static com.example.DemoApplication.getSessionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
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
    public Set<Tienda> getTiendas() {
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        List tiendas = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiendas);
        return todas;
        
        
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setTiendas(@RequestBody Tienda t) {
        stub.setTiendas(t);
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        //Tienda ti = new Tienda(new TiendaId(666),"Prueba","calle verdadera",5412347,"reloco");
//        Tienda tienda = (Tienda)s.load(Tienda.class, new TiendaId(5));
        //(Paciente paciente = (Paciente)s.load(Paciente.class, new PacienteId(54321,"cc"));        
//        System.out.println("--------------------------"+tienda.getNombre()+"---------------------------");
        s.save(t);
//                System.out.println("--------------------------SALIOOOOOOOOOOOOOOOOOO---------------------------");

        tx.commit();    
        s.close();
        sf.close();
     
    }
    

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void removeTienda(@PathVariable int t) {
//        //stub.removeTienda(t);       
//        System.out.println("Deleteeeeeeeee");
//    }
    
//    @RequestMapping(value="/{nombreTienda}/servicios", method = RequestMethod.GET)
//    public Set<Servicio> getServicios(@PathVariable("nombreTienda") String nombre){
//        System.out.println("Traer los servicios --------------------------------------------------------------------------------");
//        SessionFactory sf=getSessionFactory();
//        Session s=sf.openSession();
//        Transaction tx=s.beginTransaction();
//        Criteria criteria = s.createCriteria(Tienda.class);
//        List tiend = criteria.list();
//        Set<Tienda> todas = new HashSet<Tienda>(tiend);
//        Set<Servicio> servicios = new HashSet<Servicio>();
//        for(Tienda t: todas){
//                if(t.getNombre().equals(nombre)){
//                    servicios = t.getServicios();
//                }
//        }
//        return servicios;       
//    }

//    @RequestMapping(value="/{nombreTienda}/servicios/{servicio}/horarios", method = RequestMethod.GET)
//    public Set<Horario> getHorarios(@PathVariable("servicio") String servicio, @PathVariable("nombreTienda") String nombreTienda){
//        return stub.getHorarioServicioTienda(servicio, nombreTienda);
//    }
    
//    @RequestMapping(value="/{nombreTienda}/servicio",method = RequestMethod.POST)
//    public void setServicio(@RequestBody Servicio s, @PathVariable("nombreTienda") String nombreTienda){
//        System.out.println("Entro en setSetvicio->"+s.getNombre());
//        stub.setServicioTienda(s, nombreTienda);
//    }
    
    
     public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
       // builds a session factory from the service registry
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
