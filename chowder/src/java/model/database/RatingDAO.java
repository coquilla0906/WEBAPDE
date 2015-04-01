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
import model.Rating;

/**
 *
 * @author User
 */
public class RatingDAO implements IDBCUD{
    
    public void add(Object object) {
        
        Connection connection = DBConnection.getConnection();
        Rating rating = (Rating) object;
        try {

            String query = "INSERT INTO user VALUES(?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rating.getRatingID());
            preparedStatement.setString(2, rating.getComments());
            preparedStatement.setInt(3, rating.getRating());
            

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
        Rating rating = (Rating)object;
        try {
            String query = "UPDATE rating SET ratingID = ?, comments = ?, rating = ? WHERE ratingID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rating.getRatingID());
            preparedStatement.setString(2, rating.getComments());
            preparedStatement.setInt(3, rating.getRating());
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
        Rating rating = (Rating)object;
        try {
            String query = "DELETE FROM rating WHERE ratingID = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, rating.getRatingID());
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
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        try {
            String query = "SELECT * FROM rating";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Rating rating = new Rating(resultSet.getInt("ratingID"), resultSet.getString("comments"), resultSet.getInt("rating"));
                ratings.add(rating);
                
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

        return ratings.iterator();
    }

    @Override
    public Object get(String key) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM rating WHERE ratingID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Rating rating = new Rating(resultSet.getInt("ratingID"), resultSet.getString("comments"), resultSet.getInt("rating"));

                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return rating;
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
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        try {
            String query = "SELECT * FROM rating WHERE ratingID LIKE ? " + "ORDER BY 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchStr + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rating rating = new Rating(resultSet.getInt("ratingID"), resultSet.getString("comments"), resultSet.getInt("rating"));
                ratings.add(rating);
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
        return ratings.iterator();
    }
    
}
