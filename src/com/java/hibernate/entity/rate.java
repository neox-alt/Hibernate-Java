/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author laava
 */
@Entity
@Table(name = "Rate")
public class rate implements Serializable {
    
    
    private int rateId;
    private int rating;
    private String review;
    
    private user rUser;
    private movie rMovie;

    public rate() {
    }

    public rate(int rating, String review) {
        
        this.rating = rating;
        this.review = review;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    public user getrUser() {
        return rUser;
    }

    public void setrUser(user rUser) {
        this.rUser = rUser;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST})
    public movie getrMovie() {
        return rMovie;
    }

    public void setrMovie(movie rMovie) {
        this.rMovie = rMovie;
    }
    
    
    
    
}
