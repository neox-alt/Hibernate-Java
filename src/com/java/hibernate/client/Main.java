/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.hibernate.client;

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
import com.java.hibernate.entity.genre;
import com.java.hibernate.entity.movie;
import com.java.hibernate.entity.rate;
import com.java.hibernate.entity.user;
//import com.java.hibernate.utill.HibernateUtill;
import com.java.hibernate.utill.NewClass;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author laava
 */
public class Main {

    public static void main(String[] args) {
        movieEao EmpEao = new movieEaoImpl();
        userEao UseEao = new userEaoImpl();
        rateEao RateEao = new rateEaoImpl();
        adminEao AdmEao = new adminEaoImpl();
        genreEao genEao=new genreEaoImpl();
        NewClass n1= new NewClass();
        
//        user u1 = new user("Shahan", "1996");
//        movie m1 = new movie("Bahubali", "max", "SRK","Sharick");
        
//        user u2 = new user("Suraj", "45664");
//        user u3 = new user("Thilina", "4564");
//        user u4 = new user("Chamith", "564");
//        
//        movie m2 = new movie("Bahubali2", "medium", "SRK","RajaMouli");
//        movie m3 = new movie("Don", "medium", "Amir","DDD");
//        movie m4 = new movie("Don2", "medium", "Katrina","Tharindu");
//        genre g1 = new genre("Adventure");
//        genre g2 = new genre("Action");
//        genre g3 = new genre("comedy");
//        genre g4 = new genre("Korean");
//        genre g5 = new genre("American");
//        genEao.creategenre(g1);
//        genEao.creategenre(g2);
//        genEao.creategenre(g3);
//        genEao.creategenre(g4);
//        genEao.creategenre(g5);

//        UseEao.createuser(u1);
//        UseEao.createuser(u2);
//        UseEao.createuser(u3);
//        UseEao.createuser(u4);
//        EmpEao.createmovie(m1);
//        EmpEao.createmovie(m2);                
//        EmpEao.createmovie(m3);
//        EmpEao.createmovie(m4);
//        
        System.out.println("///////////////////////////////////////////");
        System.out.println("Hi... welcoe to GDMB....");
        System.out.println("///////////////////////////////////////////");
        System.out.println("please enter 1 to log in as admin");
        System.out.println("please enter 2 to register as a user");
        System.out.println("please enter 3 to log in as a user");
        System.out.println("///////////////////////////////////////////");
        Scanner newScanner = new Scanner(System.in);
                
        
        int i1 = newScanner.nextInt();
        if(i1==1){
            System.out.println("you are log in as a admin.");
            System.out.println("please enter your adminName");
            String adminName = newScanner.next();
            
            System.out.println("please enter youur admin password");
                    
            String adminPass = newScanner.next();
            boolean check1 =AdmEao.avalidate(adminName, adminPass);
            
            if (check1==true){
                System.out.println("loggin successfull...you have logged in as an admin. ");
                System.out.println("///////////////////////////////////////////");
                System.out.println("please enter 1 to add a movie");
                System.out.println("Please enter 2 to create a genre");
                 System.out.println("please enter 3 to add a genre to movie");       
                System.out.println("please enter 4 to insert movies id and view all the buyers");
                System.out.println("please enter 5 to insert user id and view all the movies");
                System.out.println("Please enter 6 to add a new admin");
                System.out.println("Please enter 7 to delete a movie");
                
                int i2 = newScanner.nextInt();
                
                if(i2==1){
                    System.out.println("you are adding a movie");
                    n1.firstphase();
                    System.out.println("please rerun the code to check other functinality");

                }if(i2==2){
                    n1.createGenre();
                    System.out.println("please rerun the code to check other functinality");
                
                }if(i2==3){   
                    
                    n1.addinggenre();
                    System.out.println("please rerun the code to check other functinality");
                }if(i2==4){
                    n1.userByMovie();
                    System.out.println("please rerun the code to check other functinality");
                }if(i2==5){
                    
                    n1.getMovieByUse();
                    System.out.println("please rerun the code to check other functinality");
                }if(i2==6){
                    
                    n1.addAdmin();
                    System.out.println("please rerun the code to check other functinality");
                }if(i2==7){
                    n1.adminDeleteMovie();
                    System.out.println("please rerun the code to check other functinality");
                }
            }else{
                System.out.println("there is problem with your admin informations.please re run the code.");
            }
                    
        }if(i1==2){
            
            
            
            n1.usserregister();
            System.out.println("you are succesfully registered as a user");
            System.out.println("please rerun the code to check other functinality");
            
        }if(i1==3){
            System.out.println("you are logging in as a user");
            System.out.println("please enter your user name");
            String userName1= newScanner.next();
            System.out.println("please enter your password");
            String userPass1= newScanner.next();
            boolean check1 =UseEao.uvalidate(userName1, userPass1);
//            boolean c=n1.userlogin();
            if (check1==true){
                System.out.println("///////////////////////////////////////////");
                System.out.println("here is the all the movies");
                System.out.println("///////////////////////////////////////////");
                n1.movieDetailShow();
                //System.out.println("please enter the movie id you want to rate");
                //n1.addrate();
                System.out.println("enter 1 to for search details from above movie");
                System.out.println("enter 2 buy a movie");
                System.out.println("enter 3 to add a rating for a movie");
                System.out.println("enter 4 to get a average rating for a movie");
                
                
                int i8 = newScanner.nextInt();
                if(i8==1){
                    System.out.println("please enter movie name you want details");
                    n1.getMoviesByMovieName();
                    
                }if(i8==2){
                    n1.buyingmovie();
                    System.out.println("please rerun the code to check other functinality");
                }if(i8==3){
                    n1.addrate();
                    System.out.println("please rerun the code to check other functinality");
                    
                }if(i8==4){
                    n1.gettingAverage();
                    System.out.println("please rerun the code to check other functinality");
                
                    
                            
                
            }else{
                //System.out.println("your access is denied.. please rerun the code");
            }
            
            
            
        }else{
              //System.out.println("your access is denied.. please rerun the code");  
            }
        }
        
       
  

    }

}
