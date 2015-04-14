<%-- 
    Document   : suggestions
    Created on : Mar 26, 2015, 7:54:44 PM
    Author     : Alds
--%>

<%@page import="model.database.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        
        <!-- Title + imports -->
        <jsp:include page="common/head.jsp">
            <jsp:param name="title" value="CHOWTIME! Suggestions"/>
        </jsp:include>
        
        <!-- Database connection -->
        <%
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery
                ("SELECT * from suggestions");
        %>
        
    </head>
    
    <body style="background-image:url('images/suggestions.jpg')">
        
        <!-- Header navbar + modals -->
        <jsp:include page="common/header.jsp">
            <jsp:param name="master" value="suggestions.jsp"/>
        </jsp:include>
        
        <!-- List -->
        
        <div class="container">
        <% while (resultSet.next()) { %>
            <% if ((resultSet.getInt("suggestionID")-1)%3 == 0) { %>
            <div class="row">
            <% } %>
                <div class="col-md-4">
                    <div class="panel panel-default post">
                        <div class="panel-body">
                            
                            <h4> <%= resultSet.getString("username") %>
                                <small> 
                                    <%= resultSet.getString("datetime").toString() %>
                                </small>
                            </h4>
                            <blockquote><p>
                                <%= resultSet.getString("suggestion") %>
                            </p></blockquote>
                            
                        </div>
                    </div>
                </div>
            <% if ((resultSet.getInt("suggestionID")-1)%3 == 2) { %>
            </div>
            <% } %>
        
        <% } %>
        </div>
            
            <!--
            <div class="row">
                <div class="col-md-3">
                    <div class="panel panel-default post">
                        <div class="panel-body">
                    
                            <h4>r2r0 <small>March 26, 2015</small></h4>
                            <blockquote><p>
                                Implement the following: <br/>
                                1. Places <br/>
                                2. User reviews for those places <br/>
                                3. Location history <br/>
                            </p></blockquote>
                    
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default post">
                        <div class="panel-body">

                            <h4>Clarisse Poblete <small>March 25, 2015</small></h4>
                            <blockquote><p>
                                So, <i>do you think you're pretty?</i>
                            </p></blockquote>
                    
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default post">
                        <div class="panel-body">

                            <h4>smosh <small>March 23, 2015</small></h4>
                            <blockquote><p>
                                <big><b/>SHUT UP!</b></big>
                            </p></blockquote>
                            
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default post">
                        <div class="panel-body">
                            
                            <h4>IGN <small>March 21, 2015</small></h4>
                            <blockquote><p>
                                Uses Bootstrap <b>10/10</b> <br/>
                                <i>Site of the Year</i>
                            </p></blockquote>
                    
                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>
        -->
        
    </body>
    
</html>
