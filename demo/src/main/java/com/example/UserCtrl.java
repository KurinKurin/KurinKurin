/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static com.example.Controller.getSessionFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2095329
 */
@RestController
@RequestMapping("/users")
public class UserCtrl {

    @Autowired
    IUser users;
/**
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> getUsers() {
        return users.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setUsers(@RequestBody User user) {
        users.setUsers(user);
    }
    **/
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<User> getUsers() {
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        Criteria criteria = s.createCriteria(User.class);
        List users = criteria.list();
        Set<User> todos = new HashSet<User>(users);
        return todos;
        
        
    }
    
     @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public User getCitasTienda(@PathVariable("user") String user) {
        System.out.println("Traer las citas de ----------------------------------------" + user);
        User userS = new User();
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        Criteria criteria = s.createCriteria(User.class);
        List usuarios = criteria.list();
        Set<User> todas = new HashSet<User>(usuarios);
        for (User t : todas) {
            if (t.getUser().equals(user)) {
                userS=t;
            }
        }
        return userS;

    }

    @RequestMapping(method = RequestMethod.POST)
    public void setUsers(@RequestBody User t) {
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
    


    public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
        // builds a session factory from the service registry
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
