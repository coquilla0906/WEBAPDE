/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Iterator;
import model.Preferences;
import model.User;
import model.database.DAO;
import model.database.UserDAO;

/**
 *
 * @author User
 */
public class UserController {
    
    private static UserController instance;
    private DAO dao;
    private User user;
    private UserDAO userDAO;
    
    public UserController() {
        dao = DAO.getInstance();
        user = new User();
        userDAO = new UserDAO();
        
    }
    
    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }
    
    public int getMaxUserID(){
        return userDAO.getUserID();
    }
    
    public void addUser(User u){
//        user.setUserID(u.getUserID());
//        user.setUsername(u.getUsername());
//        user.setPassword(u.getPassword());
//        
        //dao.add("user", user);
        dao.add("user", u);
//        Iterator i = u.getPreferences();
//        while(i.hasNext()) {
//            dao.add("preferences", (Preferences)i.next());
//        }
    }
    
    public Object getObject(String key) {
        return dao.get("user", key);
    }

    public Iterator getAll() {
        return dao.get("user");
    }
    
    public boolean checkUser(String username, String password){
        
        User u = userDAO.checkUser(username, password);
        if(u == null)
            return false;
        else
            user = u;
        return true;
        
    }
    
    public User getUser(){
        return user;
    }
    
}
