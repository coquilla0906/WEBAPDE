/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author User
 */
public class OldDAO {
    
    private DBConnection dbConnection;
    private static OldDAO instance;
    
    public OldDAO(){
        
        dbConnection = DBConnection.getInstance();
    }
    
    public Object get( String key ){
        
        User user = null;
        String username = key;
        
        try{
            String query = "SELECT * FROM user WHERE username = ?";
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
//            if(resultSet.next()) {
//	               user = new User(resultSet.getString("username"), resultSet.getString("password"));
//	            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return user;
        
    }
    
    
    public User checkUser(String username, String password) {
        
        User user = null;
        
        try{
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
//            if(resultSet.next()) {
//	               user = new User(resultSet.getString("username"), resultSet.getString("password"));
//	            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return user;
        
    }
    
    public static OldDAO getInstance() {
		if (instance == null) {
			instance = new OldDAO();
		}
		return instance;
	}
    
   
    
    
    
}
