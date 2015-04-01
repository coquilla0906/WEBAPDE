/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bryan
 */
public class Suggestion {
    
    private int suggestionID;
    private String username;
    private String email;
    private String suggestions;
    
    public Suggestion(){
        setSuggestionID(0);
        setUsername("");
        setEmail("");
        setSuggestions("");
    }
    
    public Suggestion(int suggestionID, String username, String email, String suggestions){
        setSuggestionID(suggestionID);
        setUsername(username);
        setEmail(email);
        setSuggestions(suggestions);
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
    
    public void setSuggestions(String suggestions){
        this.suggestions = suggestions;
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
    
    public String getSuggestions(){
        return suggestions;
    }
    
}
