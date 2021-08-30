/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.eao;

import com.java.hibernate.entity.genre;

/**
 *
 * @author laava
 */
public interface genreEao {
    void creategenre(genre gen);
    void addGenre(int  movieId,int genreId);
    
}
