<%-- 
    Document   : index
    Created on : Mar 21, 2015, 9:25:39 PM
    Author     : Alds
--%>

<%@page import="controller.UserController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <title>MiniChallenge!</title>

        <!-- This meta tag will ensure proper zooming and mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">

        <!-- Import Bootstrap CSS and a user-defined CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        
        <!-- Import JQuery and Bootstrap JS files -->
        <script src = "js/jquery-1.11.2.min.js"></script>
        <script src = "js/bootstrap.js"></script>
        <script src = "js/javascript.js"></script>
        
        <!-- Cookies and controllers -->
        <%
            UserController userController = UserController.getInstance();
            String username = "", src[];
            
            Cookie[] monster = request.getCookies();
            if (monster != null)
                for (Cookie clicker: monster){
                    
                    if (clicker.getName().equals("loginCookie")){
                        String shit[] = clicker.getValue().split("~");
                        for (int i=0; i<shit.length; i++)
                            if (i==0) username = shit[i];
                    }
                    
                    if (clicker.getName().equals("imgCookie")){
                        
                    }
            
                }
            
        %>

    </head>

    <body style="background-image:url('images/index.jpg')">
        
        <!-- Header navbar + modals -->
        <jsp:include page="common/header.jsp">
            <jsp:param name="master" value="index.jsp"/>
        </jsp:include>
        
        <!-- Body -->
        <%  
            if (username.isEmpty())
                response.sendRedirect("register.jsp");
            else {
        %>
        
        <div class="container">
            
            
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
            
            
        <% } %>
            
            

    </body>

</html>