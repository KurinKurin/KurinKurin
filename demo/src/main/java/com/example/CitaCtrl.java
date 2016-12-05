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
        System.out.println("Traer las citas de ----------------------------------------" + nombre);
        Set<Cita> citasTienda = new HashSet<Cita>();
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(Tienda.class);
        Criteria criteriaS = s.createCriteria(Cita.class);
        List tiend = criteria.list();
        List tiendC = criteriaS.list();
        Set<Tienda> todas = new HashSet<Tienda>(tiend);
        Set<Cita> citas = new HashSet<Cita>(tiendC);
        for (Tienda t : todas) {
            if (t.getNombre().equals(nombre)) {
//                citasTienda = t.getCitas();
            }
        }
        System.out.println("Tamaño de servicios:" + citasTienda.size());
        for (Cita sol : citasTienda) {
            System.out.println("***" + sol.getId());
        }
        return citasTienda;

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
        System.out.println(citas.size()+2);
        System.out.println("-------------"+cita.getUser()+"--------"+cita.getIdServicio());
        
        
        Cita ti = new Cita(new CitaId(citas.size()+2), cita.getUser(), cita.getIdServicio());

        s.save(ti);

        tx.commit();
        s.close();
        sf.close();
    }
}
