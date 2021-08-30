/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.movie;
import com.java.hibernate.entity.rate;
import com.java.hibernate.entity.user;
import com.java.hibernate.utill.HibernateUtill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author laava
 */
public class rateEaoImpl implements rateEao{
    SessionFactory sessionFactory;
    
    public rateEaoImpl() {
        sessionFactory = HibernateUtill.getSessionFactory();
    }

    
    @Override
    public void createrate(rate rat , int useId,int movieId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user userObj = (user) session.get(user.class,useId );
        movie movieObj = (movie) session.get(movie.class,movieId );
        session.save(rat);
        rat.setrUser(userObj);
        rat.setrMovie(movieObj);
       
        
        session.getTransaction().commit();
        session.close();
        
        
    }
    
}
