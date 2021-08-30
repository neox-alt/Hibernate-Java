/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.utill;


import com.java.hibernate.eao.adminEao;
import com.java.hibernate.eao.adminEaoImpl;
import com.java.hibernate.eao.genreEao;
import com.java.hibernate.eao.genreEaoImpl;
import com.java.hibernate.eao.movieEao;
import com.java.hibernate.eao.movieEaoImpl;
import com.java.hibernate.eao.rateEao;
import com.java.hibernate.eao.rateEaoImpl;
import com.java.hibernate.eao.userEao;
import com.java.hibernate.eao.userEaoImpl;
import com.java.hibernate.entity.admins;
import com.java.hibernate.entity.genre;

import com.java.hibernate.entity.movie;
import com.java.hibernate.entity.rate;
import com.java.hibernate.entity.user;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author laava
 */
public class NewClass {

    movieEao MovEao = new movieEaoImpl();
    Scanner newScanner = new Scanner(System.in);
    userEao UseEao =new userEaoImpl();
    rateEao RateEao= new rateEaoImpl();
    adminEao AdmEao = new adminEaoImpl();
    genreEao GenEao = new genreEaoImpl();

    public void firstphase() {

        System.out.println("please enter movie name:");
        String movieName = newScanner.next();
        System.out.println("Please enter your movie run time");
        String movieRunTime = newScanner.next();
        System.out.println("Please enter your movie lead actor name");
        String movieLeadActor = newScanner.next();
        System.out.println("Please enter your movie director name");
        String movieDirector = newScanner.next();
        

        movie movieOne = new movie(movieName, movieRunTime, movieLeadActor, movieDirector);
        MovEao.createmovie(movieOne);
        System.out.println("successfully added");
        System.out.println("//////////////////////////////////////////");
    }

    public void movieDetailShow() {
        System.out.println("here is the all the movies in the data base");
        MovEao.getUsersByMovieId();
        System.out.println("//////////////////////////////////////////");

    }

    public void adminviewumoviebuyer() {
        System.out.println("please add movie id to get information");
        int i3 = newScanner.nextInt();
        MovEao.getMovie(i3);
        System.out.println("//////////////////////////////////////////");
    }
    
    
    public void buyingmovie(){
        System.out.println("please enter your movie id");
        int i4 = newScanner.nextInt();
        System.out.println("please enter your user id");
        int i5 = newScanner.nextInt();
        MovEao.buyMovie(i4, i5);
        System.out.println("//////////////////////////////////////////");
        
    }
    
    
    public void usserregister(){
        System.out.println("you are registering as a user");
        System.out.println("please enter your user name");
        String userName= newScanner.next();
        System.out.println("please enter a password");
        String userPass= newScanner.next();
        user userOne = new user(userName, userPass);
        UseEao.createuser(userOne);
        System.out.println("//////////////////////////////////////////");
        
    }
    
//    public void userlogin(){
//        System.out.println("you are logging in as a user");
//        System.out.println("please enter your user name");
//        String userName1= newScanner.next();
//        System.out.println("please enter your password");
//        String userPass1= newScanner.next();
//        boolean check1 =UseEao.uvalidate(userName1, userPass1);
//    }
    
    public void addrate(){
        System.out.println("you are going to add a rating for a movie");
        System.out.println("please enter user id");
        int i7 =newScanner.nextInt();
        System.out.println("please enter movie id");
        int i5= newScanner.nextInt();
        System.out.println("please enter your review");
        String review1= newScanner.next();
        System.out.println("please enter movie rating 1- 10");
        int i6= newScanner.nextInt();
        rate newRate= new rate(i6,review1);
        RateEao.createrate(newRate,i7, i5);
        System.out.println("//////////////////////////////////////////");
    }
    
    public void addAdmin(){
        System.out.println("you are going to add a new admin");
        System.out.println("please enter admin name");
        String adminname= newScanner.next();
        System.out.println("please enter new admins password");
        String adminpass= newScanner.next();
        admins adm=new admins(adminname,adminpass);
        AdmEao.createAdmin(adm);
        System.out.println("//////////////////////////////////////////");
        
        
    }
    
    public void userByMovie(){
        System.out.println("please enter movieId you want list of users");
        int i8= newScanner.nextInt();
        UseEao.getUserByFilms(i8);
        System.out.println("//////////////////////////////////////////");
//        for(user u:userList){
//            System.out.println(u.getuId());
//        }


    }
    
    
    public void adminDeleteMovie(){
        System.out.println("please enter the movie Id you want to delete");
        int i8= newScanner.nextInt();
        AdmEao.deleteMovie(i8);
        System.out.println("//////////////////////////////////////////");
        
    }
    
    public void getMoviesByMovieName(){
        System.out.println("insert movie name");
        String moviename= newScanner.next();
        MovEao.getMovieByName(moviename);
        System.out.println("//////////////////////////////////////////");
    }
    
    public void gettingAverage(){
        System.out.println("please enter movie id to see average ratings");
        int movid= newScanner.nextInt();
        MovEao.getAverage(movid);
        System.out.println("//////////////////////////////////////////");
    }
    
    public void createGenre(){
        System.out.println("Please enter genre name you want to add");
        String genreName = newScanner.next();
        genre newGenrw= new genre(genreName);
        GenEao.creategenre(newGenrw);
        System.out.println("//////////////////////////////////////////");
        
    }
    
    public void addinggenre(){
        System.out.println("please add movie id you want to add a genre");
        int movieId = newScanner.nextInt();
        System.out.println("please add genre id");
        int genId = newScanner.nextInt();
        GenEao.addGenre(movieId, genId);
        System.out.println("//////////////////////////////////////////");
    }
    
    public void getMovieByUse(){
        System.out.println("please add user id you want to view movies");
        int movieId = newScanner.nextInt();
        MovEao.getMovieByUser(movieId);
        System.out.println("//////////////////////////////////////////");
    }
   
}
