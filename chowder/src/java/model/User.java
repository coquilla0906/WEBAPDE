/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    private int isAdmin;
    private Timestamp memberSince;
    private ArrayList<Preferences> preferences;
    
    public User(){
        setUserID(0);
        setUsername("");
        setEmail("");
        setPassword("");
        setIsAdmin(0);
        setMemberSince(new Timestamp(new Date().getTime()));
        preferences = new ArrayList<Preferences>();
    }
    
    public User(int userID, String username, String email, String password, int isAdmin, Timestamp memberSince){
        setUserID(userID);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setIsAdmin(isAdmin);
        setMemberSince(memberSince);
        preferences = new ArrayList<Preferences>();
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
    
    public int getIsAdmin(){
        return isAdmin;
    }
    
    public void setIsAdmin(int isAdmin){
        this.isAdmin = isAdmin;
    }
    
    public Timestamp getMemberSince(){
        return memberSince;
    }
    
    public void setMemberSince(Timestamp memberSince) {
        this.memberSince = memberSince;
    }
    
    public Iterator getPreferences() {
        return preferences.iterator();
    }
    
    public void addPreference( int id, String name, String address ) {
        Preferences pref = new Preferences(id, name, address);
        preferences.add(pref);
    }
    
    public void setPrefencesList(Iterator prefList) {
        while(prefList.hasNext()){
            this.preferences.add(((Preferences)prefList.next()));
        }
    }

    
}
