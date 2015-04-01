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
public class Preferences {
    
    private int locationID;
    private String name;
    private String address;
    private ArrayList<Rating> ratings;
    
    public Preferences(){
        setLocationID(0);
        setName("");
        setAddress("");
        ratings = new ArrayList<Rating>();
    }
    
    public Preferences( int locationID, String name, String address ){
        setLocationID(locationID);
        setName(name);
        setAddress(address);
        ratings = new ArrayList<Rating>();
    }
    
    
    public void setLocationID(int locationID){
        this.locationID = locationID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAddress(String address){
        this.address =address;
    }
    
    public int getLocationID(){
        return locationID;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public Iterator getRatings() {
        return ratings.iterator();
    }
    
    public void addRating( int ratingID, String comments, int rate ) {
        
        Rating r = new Rating(ratingID, comments, rate);
        ratings.add(r);
    }
    
    public void setPrefencesList(Iterator rate) {
        while(rate.hasNext()){
            this.ratings.add(((Rating)rate.next()));
        }
    }

}
