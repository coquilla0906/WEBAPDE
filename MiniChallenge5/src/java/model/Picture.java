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
public class Picture {
    
    private String src;
    private String caption;
    private int picID;
    private int userID;
    
    public Picture(){
        
        setPicID(0);
        setUserID(0);
        setSRC("");
        setCaption("");
    }
    
    public Picture(int picID, int userID, String src, String caption){
        
        setPicID(picID);
        setUserID(userID);
        setSRC(src);
        setCaption(caption);
    }
    
    public void setPicID(int picID){
        this.picID = picID;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    public void setSRC(String src){
        this.src = src;
    }
    
    public void setCaption(String caption){
        this.caption = caption;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public int getPicID(){
        return picID;
    }
    
    public String getSRC(){
        return src;
    }
    
    public String getCaption(){
        return caption;
    }
   
    
}
