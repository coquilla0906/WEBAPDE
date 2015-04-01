/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import model.database.OldDAO;

/**
 *
 * @author User
 */
public class OldControllerDontUse {

    private User user;
    private OldDAO dao;
    private static OldControllerDontUse instance;
    
    public OldControllerDontUse(){
       
        dao = OldDAO.getInstance();
        if(dao == null)
        {
            System.out.println("No connection");
        }
        else
        {
            System.out.println("Connected!");
        }
    }
    
    public static OldControllerDontUse getInstance() {
        if (instance == null) {
            instance = new OldControllerDontUse();
        }
        return instance;
    }
     
    public User getUser(){
        return user;
    }
    
    
    public boolean checkUser(String username, String password){
        
        User u = dao.checkUser(username, password);
        if(u == null)
            return false;
        else
            user = u;
        return true;
        
    }

    
}
