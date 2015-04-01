/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Iterator;
import model.Preferences;
import model.Rating;
import model.database.DAO;

/**
 *
 * @author User
 */
public class PreferencesController {
    
    private static PreferencesController instance;
    private DAO dao;
    private Preferences preference;
    
    public PreferencesController() {
        dao = DAO.getInstance();
        preference = new Preferences();  
    }
    
   
    
    public static PreferencesController getInstance() {
        if (instance == null) {
            instance = new PreferencesController();
        }
        return instance;
    }
    
    public void addPreference(Preferences p){
        preference.setLocationID(p.getLocationID());
        preference.setName(p.getName());
        preference.setAddress(p.getAddress());
        
        
        dao.add("preferences", preference);
        Iterator i = p.getRatings();
        while(i.hasNext()) {
            dao.add("rating", (Rating)i.next());
        }
    }
    
    public Object getObject(String key) {
        return dao.get("preferences", key);
    }

    public Iterator getAll() {
        return dao.get("preferences");
    }
    
}
