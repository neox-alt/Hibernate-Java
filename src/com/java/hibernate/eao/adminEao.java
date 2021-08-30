/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.admins;
import com.java.hibernate.entity.movie;

/**
 *
 * @author laava
 */
public interface adminEao {
    void createAdmin(admins adm);
    
    boolean avalidate(String username, String password);
    
    void deleteMovie(int mId);
    
   
    
   
    
}
