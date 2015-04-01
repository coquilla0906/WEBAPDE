package model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Suggestion;


public class SuggestionDAO implements IDBCUD{
    
    @Override
    public void add(Object object) {
        
        Connection connection = DBConnection.getConnection();
        Suggestion suggestion = (Suggestion) object;
        try {
            
            String query = "INSERT INTO suggestions VALUES(?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, suggestion.getSuggestionID());
            preparedStatement.setString(2, suggestion.getUsername());
            preparedStatement.setString(3, suggestion.getEmail());
            preparedStatement.setString(4, suggestion.getSuggestions());

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
        Suggestion suggestion = (Suggestion) object;
        try {
            String query = "UPDATE suggestions SET suggestionID = ?, username = ?, email = ?, suggestions = ? WHERE suggestionID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, suggestion.getSuggestionID());
            preparedStatement.setString(2, suggestion.getUsername());
            preparedStatement.setString(3, suggestion.getEmail());
            preparedStatement.setString(4, suggestion.getSuggestions());
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
        Suggestion suggestion = (Suggestion) object;
        try {
            String query = "DELETE FROM suggestions WHERE suggestionID = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, suggestion.getSuggestionID());
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
        ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
        try {
            String query = "SELECT * FROM suggestions";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Suggestion suggestion = new Suggestion(resultSet.getInt("suggestionID"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("suggestions"));
                
                suggestions.add(suggestion);
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

        return suggestions.iterator();
    }

    @Override
    public Object get(String key) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM suggestions WHERE suggestionID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Suggestion suggestion = new Suggestion(resultSet.getInt("suggestionID"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("suggestions"));
                
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return suggestion;
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
        ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
        try {
            String query = "SELECT * FROM suggestions WHERE suggestionID LIKE ? " + "ORDER BY 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchStr + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Suggestion suggestion = new Suggestion(resultSet.getInt("suggestionID"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("suggestions"));
                
                suggestions.add(suggestion);
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
        return suggestions.iterator();
    }
    
    
    
    
    
    public int getSuggestionID() {
        Connection connection = DBConnection.getConnection();
        int suggestionid = 0;
        try {
            String query = "SELECT MAX(suggestionID) FROM suggestions";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                suggestionid = resultSet.getInt("MAX(suggestionID)");
                
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
        return suggestionid;
        
    }
    
}