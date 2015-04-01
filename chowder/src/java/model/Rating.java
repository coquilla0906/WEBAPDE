/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Rating {
    
    private int ratingID;
    private String comments;
    private int rating;
    
    public Rating(int ratingID, String comments, int rating){
        setRatingID(ratingID);
        setComments(comments);
        setRating(rating);
    }
    
    public Rating(){
        setRatingID(0);
        setComments("");
        setRating(0);
    }
    
    public void setRatingID( int ratingID ){
        this.ratingID = ratingID;
    }
    
    public void setComments( String comments ){
        this.comments = comments;
    }
    
    public void setRating( int rating ){
        this.rating = rating;
    }
    
    public int getRatingID(){
        return ratingID;
    }
    
    public String getComments(){
        return comments;
    }
    
    public int getRating(){
        return rating;
    }
    
    
}
