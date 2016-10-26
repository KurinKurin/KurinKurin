/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.*;

/**
 *
 * @author Henry Hurtado.
 * @author Isabel Castellanos
 */

@Entity 
@Table(name="users")
public class User {
    String name;
    String lastName;
    String user;
    String password;
    String email;
    int phone;
    String address;
    
    public User(){
    
    }

    public User(String name, String lastName, String user, String password, String email, int phone, String address) {
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @Column(name="user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
