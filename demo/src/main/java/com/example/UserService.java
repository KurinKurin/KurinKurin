/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2095329
 */
@Service
public class UserService implements IUser{

    ArrayList<User> users = new ArrayList<User>();
    
    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void setUsers(User user) {
        users.add(user);        
    }     
}
