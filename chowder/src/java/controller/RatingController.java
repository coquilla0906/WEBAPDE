/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Iterator;
import model.Rating;
import model.database.DAO;

/**
 *
 * @author User
 */
public class RatingController {
    
    private static RatingController instance;
    private DAO dao;
    private Rating rating;
    
    public RatingController() {
        dao = DAO.getInstance();
        rating = new Rating();  
    }
    
   
    
    public static RatingController getInstance() {
        if (instance == null) {
            instance = new RatingController();
        }
        return instance;
    }
    
    public void addRating(Rating r){
        rating.setRatingID(r.getRatingID());
        rating.setComments(r.getComments());
        rating.setRating(r.getRating());
        dao.add("rating", rating);
        
    }
    
    public Object getObject(String key) {
        return dao.get("rating", key);
    }

    public Iterator getAll() {
        return dao.get("rating");
    }
    
}
