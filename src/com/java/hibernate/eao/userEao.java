/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.user;
import java.util.List;
//import java.util.List;

/**
 *
 * @author laava
 */
public interface userEao {
    void createuser(user uso);
    
      
    boolean uvalidate(String username, String password);
    List<user> getUserByFilms (int mId);
    
}
