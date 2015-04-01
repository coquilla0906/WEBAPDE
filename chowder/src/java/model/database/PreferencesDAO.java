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
import model.Preferences;

/**
 *
 * @author User
 */
public class PreferencesDAO implements IDBCUD{

    public void add(Object object) {
        
        Connection connection = DBConnection.getConnection();
        Preferences preference = (Preferences) object;
        try {

            String query = "INSERT INTO user VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, preference.getLocationID());
            preparedStatement.setString(2, preference.getName());
            preparedStatement.setString(3, preference.getAddress());
            

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
        Preferences preference = (Preferences) object;
        try {
            String query = "UPDATE preferences SET locationID = ?, name = ?, address = ? WHERE locationID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, preference.getLocationID());
            preparedStatement.setString(2, preference.getName());
            preparedStatement.setString(3, preference.getAddress());
            preparedStatement.setString(4, origKey);
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
        Preferences preference = (Preferences) object;
        try {
            String query = "DELETE FROM preferences WHERE locationID = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, preference.getLocationID());
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
        ArrayList<Preferences> preferences = new ArrayList<Preferences>();
        try {
            String query = "SELECT * FROM preferences";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Preferences preference = new Preferences(resultSet.getInt("locationID"), resultSet.getString("name"), resultSet.getString("address"));
                String query2 = "SELECT * FROM ratings WHERE locationID=\"" + resultSet.getInt("locatinID") + "\"";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()){
                    preference.addRating(resultSet2.getInt("ratingID"), resultSet2.getString("comments"), resultSet2.getInt("rating"));
                }
                preferences.add(preference);
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

        return preferences.iterator();
    }

    @Override
    public Object get(String key) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM preferences where locationID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Preferences preference = new Preferences(resultSet.getInt("locationID"), resultSet.getString("name"), resultSet.getString("address"));
                String query2 = "SELECT * FROM ratings WHERE locationID=\"" + resultSet.getInt("locatinID") + "\"";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()){
                    preference.addRating(resultSet2.getInt("ratingID"), resultSet2.getString("comments"), resultSet2.getInt("rating"));
                }

                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return preference;
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
        ArrayList<Preferences> preferences = new ArrayList<Preferences>();
        try {
            String query = "SELECT * FROM preferences WHERE locationID LIKE ? " + "ORDER BY 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchStr + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Preferences preference = new Preferences(resultSet.getInt("locationID"), resultSet.getString("name"), resultSet.getString("address"));
                String query2 = "SELECT * FROM ratings WHERE locationID=\"" + resultSet.getInt("locatinID") + "\"";
                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while(resultSet2.next()){
                    preference.addRating(resultSet2.getInt("ratingID"), resultSet2.getString("comments"), resultSet2.getInt("rating"));
                }
                preferences.add(preference);
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
        return preferences.iterator();
    }
    
}
