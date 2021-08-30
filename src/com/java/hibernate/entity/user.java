/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author laava
 */
@Entity
@Table(name = "USERS")
public class user implements Serializable {

    private int uId;
    private String uName;
    private String uPass;
    private List<movie> movies = new ArrayList<>();
    private List<rate>  uRating = new ArrayList<>();

    public user() {    
    }
    
    
    

    public user(String uName, String uPass) {
        this.uName = uName;
        this.uPass = uPass;

    }

//    public user() {
//        movies = new ArrayList<>();
//        
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }
    

//    @ManyToMany
//    @JoinTable(name = "MOVIE_USER_TAB",
//            joinColumns = {@JoinColumn(name = "uId")},
//            inverseJoinColumns = {@JoinColumn(name = "mId")})
//    public List<movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(List<movie> movies) {
//        this.movies = movies;
//    }
    @ManyToMany(mappedBy = "users")//cascade = {CascadeType.ALL})
//    @JoinTable(name = "MOVIE_USER_TAB",
//               joinColumns = {@JoinColumn(name = "uId")},
//               inverseJoinColumns = {@JoinColumn(name = "mId")})
    public List<movie> getMovies() {
        return movies;
    }

    public void setMovies(List<movie> movies) {
        this.movies = movies;
    }
    @OneToMany(mappedBy = "rUser",cascade = {CascadeType.PERSIST})
    public List<rate> getuRating() {
        return uRating;
    }

    public void setuRating(List<rate> uRating) {
        this.uRating = uRating;
    }
    
    
    

}
