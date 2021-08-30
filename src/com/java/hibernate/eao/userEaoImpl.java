/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.movie;
import com.java.hibernate.entity.user;
import com.java.hibernate.utill.HibernateUtill;
import java.util.List;

//import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author laava
 */
public class userEaoImpl implements userEao{
    SessionFactory sessionFactory ; 

    public  userEaoImpl(){
        sessionFactory =HibernateUtill.getSessionFactory();
    }
    
    @Override
    public  void createuser(user uso){
        
        
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        
        movie m11 = new movie();
        //
       
        
        session1.save(uso);
        //session1.save(uso);
        
        
        session1.getTransaction().commit();
        session1.close();
        //m11.getUsers().add(uso);
//        Session session2 = sessionFactory.openSession();
//        movie m11 = new movie();
//        m11.getUsers().add(uso);
//        //session2.getTransaction().commit();
//        session2.close();
//        
    }
    

        
    @Override
    public   boolean uvalidate(String username, String password){
        
        
        // session1.beginTransaction();
        boolean check = false;
        user user1;
        Session session1 = sessionFactory.openSession();
        String hql = "FROM user where uName=:username ";
        Query query = session1.createQuery(hql);
        query.setParameter("username", username);
        user usser = (user) query.uniqueResult();
        
        user1 = (user) session1.get(user.class, usser.getuId());
        
        //System.out.println(usser.getuName());
        //System.out.println(usser.getuPass());
        if (user1 != null && user1.getuPass().equals(password)){
            check = true;
            System.out.println("here is your userId"+user1.getuId());
            System.out.println("access granted");
            return true;
        }else{
            System.out.println("access denied");
            return(false);
        }
        
    }
    
    @Override
    public List<user> getUserByFilms (int mId){
        List<user> userList = null;
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        String hql = "FROM user u JOIN u.movie WHERE u.movies = :mId";
//        Query query = session.createQuery(hql);
//        query.setParameter("mId", mId);
//        userList = query.list();
//        session.close();
//        return userList;
           
          movie moo = (movie) session.get(movie.class, mId);
          userList = moo.getUsers();
          for(user u:userList){
              System.out.println(u.getuId() +" "+ u.getuName());
          }
          session.close();
          return userList;
            
    }
        
    }
   

