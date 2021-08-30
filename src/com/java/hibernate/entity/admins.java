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
import javax.persistence.OneToMany;

/**
 *
 * @author laava
 */
@Entity
public class admins implements Serializable {
    private String adminId;
    private String adminPass;
    private List<movie> amovies = new ArrayList<>();

    public admins() {
    }

    public admins(String adminId, String adminPass) {
        this.adminId = adminId;
        this.adminPass = adminPass;
    }

    @Id
    
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @OneToMany(mappedBy = "admin",cascade = {CascadeType.PERSIST})
    public List<movie> getAmovies() {
        return amovies;
    }

    public void setAmovies(List<movie> amovies) {
        this.amovies = amovies;
    }
    
}
