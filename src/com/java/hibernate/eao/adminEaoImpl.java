/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.admins;
import com.java.hibernate.entity.movie;
import com.java.hibernate.utill.HibernateUtill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author laava
 */
public class adminEaoImpl implements adminEao{
    SessionFactory sessionFactory ; 
    
    public adminEaoImpl(){
        sessionFactory =HibernateUtill.getSessionFactory();
    }
    
    /**
     *
     * @param adm
     */
   
    @Override
    public void createAdmin(admins adm){
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(adm);
        session1.getTransaction().commit();
        session1.close();
        
    }
    @Override
    public boolean avalidate(String username, String password){
        boolean check = false;
        admins admin1;
        Session session1 = sessionFactory.openSession();
        admin1 = (admins) session1.get(admins.class, username);
        
        if(admin1 != null && admin1.getAdminPass().equals(password)){
                
            return true;
        }else{
            return false;
        }
        
    }
    
    @Override
    public void deleteMovie(int mId){
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        movie m1= (movie) session1.get(movie.class, mId);
        session1.delete(m1);
        session1.getTransaction().commit();
        session1.close();
        
    }
    

    

   
    
}
