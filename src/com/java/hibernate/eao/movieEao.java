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
import java.util.List;

/**
 *
 * @author laava
 */
public interface movieEao {
    void createmovie(movie mov);
    
    movie getMovie(int mId);
    
    void buyMovie(int movieId,int userId);
    
    List<movie> getUsersByMovieId();
    
    List<movie> getMovieByName(String movieName);
    
    void getAverage (int movieId);
    
    List<movie> getMovieByUser(int uId);
    
    

  
}
