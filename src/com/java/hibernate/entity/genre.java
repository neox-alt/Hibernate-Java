/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author laava
 */
@Entity
public class genre implements Serializable {
    private int genreId;
    private String genreName;
    private List<movie> gmovieId = new ArrayList<>();

    public genre() {
    }

    public genre(String genreName) {
        
        this.genreName = genreName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @ManyToMany(mappedBy = "geners")
    public List<movie> getGmovieId() {
        return gmovieId;
    }

    public void setGmovieId(List<movie> gmovieId) {
        this.gmovieId = gmovieId;
    }
    
    
    
}
