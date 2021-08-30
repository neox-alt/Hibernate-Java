/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.admins;
import com.java.hibernate.entity.movie;
import com.java.hibernate.entity.rate;
import com.java.hibernate.entity.user;
import org.hibernate.SessionFactory;
import com.java.hibernate.utill.HibernateUtill;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author laava
 */
public class movieEaoImpl implements movieEao {

    SessionFactory sessionFactory;

    public movieEaoImpl() {
        sessionFactory = HibernateUtill.getSessionFactory();
    }

    @Override
    public void createmovie(movie mov) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        user u11 = new user();
        
        session.save(mov);
       
        //session.save(mov);
        session.getTransaction().commit();
        session.close();
        // u11.getMovies().add(mov);
//        Session session1 = sessionFactory.openSession();
//         user u11 = new user();
//        //session.persist(mov);
//        u11.getMovies().add(mov);
//        //session1.getTransaction().commit();
//        session1.close();
//       
    }

    @Override
    public movie getMovie(int mId) {
        Session session = sessionFactory.openSession();

        movie moo = (movie) session.get(movie.class, mId);
        System.out.println(moo.getmName() + "  " + moo.getLeadActor());

        session.close();
        return moo;

    }
    
    @Override
    public void buyMovie(int movieId,int userId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        user userObj = (user) session.get(user.class,userId );
        movie movieObj= (movie) session.get(movie.class,movieId);
//        List<movie> movies = userObj.getMovies();
//        List<user> users = movieObj.getUsers();
        //user u11 = new user();
        
//        u11.getMovies().add(mov2);
//        mov2.getUsers().add(u11);
        userObj.getMovies().add(movieObj);
        movieObj.getUsers().add(userObj);


        session.getTransaction().commit();
        session.close();
        
        
    }
    
    @Override
    public List<movie> getUsersByMovieId(){
         String hql = "FROM movie u ";
         Session session = sessionFactory.openSession();
         Query query = session.createQuery(hql); 
         //query.setParameter("movie_id", mId); 
         List<movie> Buyers = query.list(); 
         for (movie u : Buyers){
             System.out.println(u.getmId()+"  "+u.getmName());
         }
         session.close();
         return(Buyers);
         
         
    }
    
    @Override
    public List <movie> getMovieByName(String movieName){
        
        String hql = "FROM movie WHERE mName=:movieName ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter("movieName", movieName);
        List<movie> mmovie = query.list();
        for (movie u : mmovie){
            movie movieObj= (movie) session.get(movie.class,u.getmId());
            System.out.println(movieObj.getmId()+"  "+movieObj.getmName()+"  "+movieObj.getDirector()+"  "+movieObj.getLeadActor()+"  "+movieObj.getRunTime());
         }
        return mmovie;
        
    }
    
    @Override
    public void getAverage (int movieName){
        String hqll = "SELECT avg(rating) FROM  rate WHERE RMOVIE_MID=:movieName ";
        Session session = sessionFactory.openSession();
        //movie moo = (movie) session.get(movie.class, movieName);
        Query query = session.createQuery(hqll);
        query.setParameter("movieName", movieName);
        
        List  mmovie = query.list();
        System.out.println("average rating for movie id"+movieName+ "is: "+mmovie.get(0));
        }
    
    public List<movie> getMovieByUser(int uId){
        List<movie> movieList = null;
        Session session = sessionFactory.openSession();
        user use = (user)session.get(user.class, uId);
        
        movieList = use.getMovies();
        for (movie m :movieList){
            System.out.println(m.getmId() +"  "+ m.getmName());
        }
        session.close();
        return movieList;
    }


    }



