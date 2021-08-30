/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.rate;
import com.java.hibernate.entity.user;

/**
 *
 * @author laava
 */
public interface rateEao {
    void createrate(rate rat, int useId, int movieId);
    
    
    
}


