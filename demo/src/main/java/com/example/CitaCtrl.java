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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author felipetarquino
 */
@RestController
@RequestMapping("/citas")
public class CitaCtrl {

    @RequestMapping(method = RequestMethod.GET)
    public Set<Cita> getCitas() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Cita.class);
        List citas = criteria.list();
        Set<Cita> todos = new HashSet<Cita>(citas);
        return todos;

    }

    @RequestMapping(value = "/{idTienda}", method = RequestMethod.GET)
    public Set<Cita> getCitasTienda(@PathVariable("idTienda") int tienda) {
        System.out.println("Traer las citas de ----------------------------------------" + tienda);
        Set<Cita> citasTienda = new HashSet<Cita>();
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        Criteria criteriaS = s.createCriteria(Cita.class);
        List tiend = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        for (Tienda t : todas) {
            if (t.getId().getId()==tienda) {
                System.out.println(t.getId().getId());
                citasTienda = t.getCitas();
            }
        }
        System.out.println("Tamaño de citas:" + citasTienda.size());
        Set<Cita> citasDisponibles = new HashSet<Cita>();
        for (Cita sol : citasTienda) {
            if(sol.getDisponible()==1){
                citasDisponibles.add(sol);
            }
        }
        System.out.println("Tamaño de citas Tienda:" + citasDisponibles.size());
        return citasDisponibles;

    }
    
    @RequestMapping(value = "/{idTienda}/servicios", method = RequestMethod.GET)
    public Set<Integer> getCitasServicios(@PathVariable("idTienda") int tienda) {
        System.out.println("Traer las citas de ----------------------------------------" + tienda);
        Set<Cita> citasTienda = new HashSet<Cita>();
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        Criteria criteriaS = s.createCriteria(Cita.class);
        List tiend = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        for (Tienda t : todas) {
            if (t.getId().getId()==tienda) {
                System.out.println(t.getId().getId());
                citasTienda = t.getCitas();
            }
        }
        System.out.println("Tamaño de citas:" + citasTienda.size());
        Set<Cita> citasDisponibles = new HashSet<Cita>();
        for (Cita sol : citasTienda) {
            if(sol.getDisponible()==1){
                citasDisponibles.add(sol);
            }
        }
        System.out.println("Tamaño de citas Tienda:" + citasDisponibles.size());
        
        Set<Integer> servicios = new HashSet<Integer>();
        for (Cita citaD : citasDisponibles) {
            servicios.add(citaD.getIdServicio());
        }
        return servicios;

    }

    @RequestMapping(method = RequestMethod.POST)
    public void setCita(@RequestBody Cita cita) {
        System.out.println("Entro en setCita----------------------------------------");
        System.out.println("ID-------------" + cita.getId());
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Cita.class);
        List cit = criteria.list();
        Set<Cita> citas = new HashSet<Cita>(cit);
        System.out.println(citas.size() + 2);
        System.out.println("-------------" + cita.getUser() + "--------" + cita.getIdServicio());

        s.save(cita);

        tx.commit();
        s.close();
        sf.close();
    }
}
