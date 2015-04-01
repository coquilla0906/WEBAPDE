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
import model.Picture;

/**
 *
 * @author User
 */
public class PictureDAO implements IDBCUD{
    
    public void add(Object object) {
        
        Connection connection = DBConnection.getConnection();
        Picture picture = (Picture) object;
        try {

            String query = "INSERT INTO picture VALUES(?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, picture.getPicID());
            preparedStatement.setInt(2, picture.getUserID());
            preparedStatement.setString(3, picture.getSRC());
            preparedStatement.setString(4, picture.getCaption());
            

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
        Picture picture = (Picture)object;
        try {
            String query = "UPDATE picture SET picID = ?, userID = ?, src = ?, caption = ? WHERE picID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, picture.getPicID());
            preparedStatement.setInt(2, picture.getUserID());
            preparedStatement.setString(3, picture.getSRC());
            preparedStatement.setString(4, picture.getCaption());
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
        Picture picture = (Picture)object;
        try {
            String query = "DELETE FROM picture WHERE picID = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, picture.getPicID());
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
        ArrayList<Picture> pictures = new ArrayList<Picture>();
        try {
            String query = "SELECT * FROM picture";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Picture picture = new Picture(resultSet.getInt("picID"), resultSet.getInt("userID"), resultSet.getString("src"), resultSet.getString("caption"));
                pictures.add(picture);
                
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

        return pictures.iterator();
    }

    @Override
    public Object get(String key) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM picture WHERE picID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Picture picture = new Picture(resultSet.getInt("picID"), resultSet.getInt("userID"), resultSet.getString("src"), resultSet.getString("caption"));
                
                
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return picture;
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
        ArrayList<Picture> pictures = new ArrayList<Picture>();
        try {
            String query = "SELECT * FROM picture WHERE picID LIKE ? " + "ORDER BY 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchStr + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Picture picture = new Picture(resultSet.getInt("picID"), resultSet.getInt("userID"), resultSet.getString("src"), resultSet.getString("caption"));
                pictures.add(picture);
                
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
        return pictures.iterator();
    }
    
    public int getPicID() {
        Connection connection = DBConnection.getConnection();
        int picid = 0;
        try {
            String query = "SELECT MAX(picID) FROM picture";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                picid = resultSet.getInt("MAX(picID)");
                
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
        return picid;
        
    }
    
}
