/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2092317
 */
@RestController
public class UsersController {  

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }           
}
