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
import java.util.ArrayList;
import java.util.Iterator;
import model.User;

/**
 *
 * @author User
 */
public class UserDAO implements IDBCUD{

    @Override
    public void add(Object object) {
        
        Connection connection = DBConnection.getConnection();
        User user = (User) object;
        try {
            String query = "INSERT INTO user VALUES(?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }
    }

    @Override
    public void update(Object object, String origKey) {
        Connection connection = DBConnection.getConnection();
        User user = (User) object;
        try {
            String query = "UPDATE user SET userID = ?, username = ?, password = ?, email = ? WHERE userID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, origKey);
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Object object) {
        Connection con = DBConnection.getConnection();
        User user = (User) object;
        try {
            String query = "DELETE FROM user WHERE userID = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }
    }

    @Override
    public Iterator get() {
        Connection connection = DBConnection.getConnection();
        ArrayList<User> users = new ArrayList<User>();
        try {
            String query = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("userID"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"));
                String query2 = "SELECT * FROM preferences WHERE user=\"" + resultSet.getString("username") + "\"";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()){
                    user.addPreference(resultSet2.getInt("locationID"), resultSet2.getString("name"), resultSet2.getString("address"));
                }
                users.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }

        return users.iterator();
    }

    @Override
    public Object get(String key) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getInt("userID"), resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"));
                String query2 = "SELECT * FROM preferences WHERE user=\"" + resultSet.getString("username") + "\"";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()){
                    user.addPreference(resultSet2.getInt("locationID"), resultSet2.getString("name"), resultSet2.getString("address"));
                }
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return user;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Iterator search(String searchStr) {
        Connection connection = DBConnection.getConnection();
        ArrayList<User> users = new ArrayList<User>();
        try {
            String query = "SELECT * FROM user WHERE userID LIKE ? " + "ORDER BY 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchStr + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("userID"), resultSet.getString("username"),  resultSet.getString("email"), resultSet.getString("password"));
                String query2 = "SELECT * FROM preferences WHERE user=\"" + resultSet.getString("username") + "\"";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()){
                    user.addPreference(resultSet2.getInt("locationID"), resultSet2.getString("name"), resultSet2.getString("address"));
                }
                users.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }
        return users.iterator();
    }
    
    
    public User checkUser(String username, String password) {
        
        DBConnection db = DBConnection.getInstance();
        Connection connection = db.getConnection();
        User user = null;
        
        try{
            String query = "SELECT * FROM user WHERE (username = ? OR email = ?) AND password = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
	               user = new User(resultSet.getInt("userID"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"));
	            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return user;
        
    }
    
    
    public int getUserID() {
        Connection connection = DBConnection.getConnection();
        int userid = 0;
        try {
            String query = "SELECT MAX(userID) FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userid = resultSet.getInt("MAX(userID)");
                
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }
        return userid;
        
    }
    
}
