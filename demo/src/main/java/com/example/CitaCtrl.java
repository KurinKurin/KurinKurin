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

    @RequestMapping(value = "/{nombreTienda}", method = RequestMethod.GET)
    public Set<Cita> getCitasTienda(@PathVariable("nombreTienda") String nombre) {
        System.out.println("Traer las citas --------------------------------------------------------------------------------");
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        List tiend = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Cita> citas = new HashSet<Cita>();
        for (Tienda t : todas) {
            if (t.getNombre().equals(nombre)) {
                citas = t.getCitas();
            }
        }
        return citas;
    }

    @RequestMapping(value = "/{nombreTienda}/cita", method = RequestMethod.POST)
    public void setCita(@RequestBody Cita cita, @PathVariable("nombreTienda") String nombreTienda) {
        System.out.println("Entro en setCita----------------------------------------");
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        List tiend = criteria.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Cita> citas = new HashSet<Cita>();
        for (Tienda t : todas) {
            if (t.getNombre().equals(nombreTienda)) {
                citas = t.getCitas();
                citas.add(cita);
                t.setCitas(citas);
            }
        }
//        s.save(t);
//        tx.commit();    
//        s.close();
//        sf.close();
    }
}
