/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class User {
    
    private String username;
    private String password;
    private String email;
    private int userID;
    
    public User(){
        setUserID(0);
        setUsername("");
        setEmail("");
        setPassword("");
    }
    
    public User(int userID, String username, String email, String password){
        setUserID(userID);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
}
