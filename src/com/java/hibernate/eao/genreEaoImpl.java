/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.genre;
import com.java.hibernate.entity.movie;
import com.java.hibernate.entity.user;
import com.java.hibernate.utill.HibernateUtill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author laava
 */
public class genreEaoImpl implements genreEao{
    SessionFactory sessionFactory;
    
    public genreEaoImpl() {
        sessionFactory = HibernateUtill.getSessionFactory();
    }
    
    
    @Override
    public void creategenre(genre gen){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(gen);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void addGenre(int  movieId,int genreId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        genre genreObj = (genre) session.get(genre.class,genreId );
        movie movieObj= (movie) session.get(movie.class,movieId);
        
//        userObj.getMovies().add(movieObj);
//        movieObj.getUsers().add(userObj);
        genreObj.getGmovieId().add(movieObj);
        movieObj.getGeners().add(genreObj);
        
        session.getTransaction().commit();
        session.close();
        
    }
    
    
}
