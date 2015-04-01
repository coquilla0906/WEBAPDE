/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Iterator;
import model.Preferences;
import model.Suggestion;
import model.database.DAO;
import model.database.SuggestionDAO;

/**
 *
 * @author User
 */
public class SuggestionController {
    
    private static SuggestionController instance;
    private DAO dao;
    private Suggestion suggestion;
    private SuggestionDAO suggestionDAO;
    
    public SuggestionController() {
        dao = DAO.getInstance();
        suggestion = new Suggestion();
        suggestionDAO = new SuggestionDAO();
        
    }
    
    public static SuggestionController getInstance() {
        if (instance == null) {
            instance = new SuggestionController();
        }
        return instance;
    }
    
    public int getMaxSuggestionID(){
        return suggestionDAO.getSuggestionID();
    }
    
    public void addSuggestion(Suggestion s){
        dao.add("suggestions", s);
    }
    
    public Object getObject(String key) {
        return dao.get("suggestions", key);
    }

    public Iterator getAll() {
        return dao.get("suggestions");
    }
    
    public Suggestion getSuggestion(){
        return suggestion;
    }
    
}
