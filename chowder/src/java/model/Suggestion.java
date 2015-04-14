/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Bryan
 */
public class Suggestion {
    
    private int suggestionID;
    private String username;
    private String email;
    private String suggestion;
    private Timestamp datetime;
    
    public Suggestion(){
        setSuggestionID(0);
        setUsername("");
        setEmail("");
        setSuggestion("");
        setDatetime(new Timestamp(new Date().getTime()));
    }
    
    public Suggestion(int suggestionID, String username, String email, String suggestion, Timestamp datetime){
        setSuggestionID(suggestionID);
        setUsername(username);
        setEmail(email);
        setSuggestion(suggestion);
        setDatetime(datetime);
    }
    
    public void setSuggestionID(int suggestionID){
        this.suggestionID = suggestionID;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setSuggestion(String suggestion){
        this.suggestion = suggestion;
    }
    
    private void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
    
    public int getSuggestionID(){
        return suggestionID;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getSuggestion(){
        return suggestion;
    }

    public Timestamp getDatetime() {
        return datetime;
    }
    
}
