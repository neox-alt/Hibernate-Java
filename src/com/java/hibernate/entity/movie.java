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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author laava
 */
@Entity
@Table(name = "MOVIES")

public class movie implements Serializable{
    
    private int mId;
    private String mName;
    private String runTime;
    private String leadActor;
    private String director;
    private List<genre> geners =new ArrayList<>() ;;
    
    private List<user> users =new ArrayList<>() ; 
    private List<rate>  uRating = new ArrayList<>();
    private admins admin;

    public movie() {
    }
    
    public movie(String mName, String runTime,String leadActor, String director) {
        this.mName = mName;
        this.runTime = runTime;
        this.leadActor = leadActor;
        this.director = director;
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "MOVIE_GENRE_TAB",
               joinColumns = {@JoinColumn(name="mId")},
               inverseJoinColumns = {@JoinColumn(name="genreId")})
    public List<genre> getGeners() {
        return geners;
    }

    public void setGeners(List<genre> geners) {
        this.geners = geners;
    }

   
    

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "MOVIE_USER_TAB",
               joinColumns = {@JoinColumn(name="mId")},
               inverseJoinColumns = {@JoinColumn(name="uId")})
    public List<user> getUsers() {
        return users;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }
    
    
    
    @OneToMany(mappedBy = "rMovie",cascade = {CascadeType.PERSIST})
    public List<rate> getuRating() {
        return uRating;
    }

    public void setuRating(List<rate> uRating) {
        this.uRating = uRating;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST})
    public admins getAdmin() {
        return admin;
    }

    public void setAdmin(admins admin) {
        this.admin = admin;
    }
    
    
    
    
    



    
    
       
}
