/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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
    
    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<User> getUsers(){
        return users.getUsers();       
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setUsers(@RequestBody User user){
        users.setUsers(user);   
    }
    
}
