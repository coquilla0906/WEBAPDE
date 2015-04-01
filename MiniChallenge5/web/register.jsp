<%-- 
    Document   : register
    Created on : Mar 21, 2015, 9:26:15 PM
    Author     : Alds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <title>MiniChallenge! Register</title>

        <!-- This meta tag will ensure proper zooming and mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">

        <!-- Import Bootstrap CSS and a user-defined CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        
        <!-- Import JQuery and Bootstrap JS files -->
        <script src = "js/jquery-1.11.2.min.js"></script>
        <script src = "js/bootstrap.js"></script>
        <script src = "js/javascript.js"></script>
        
        <!-- Cookies -->
        <%
            String master = request.getParameter("master"), 
                    username = "", email = "";
            Cookie[] monster = request.getCookies();
            if (monster != null)
                for (Cookie clicker: monster)
                    if (clicker.getName().equals("loginCookie")){
                        String shit[] = clicker.getValue().split("~");
                        for (int i=0; i<shit.length; i++){
                            if (i==0) username = shit[i];
                            else if (i==1) email = shit[i];
                        }
                    }
        %>
        
    </head>

    <body style="background-image:url('images/register.jpg')">
        
        <!-- Header navbar + modals -->
        <jsp:include page="common/header.jsp">
            <jsp:param name="master" value="register.jsp"/>
        </jsp:include>
        
        <!-- Body -->
        <% if (username.isEmpty()) { %>
        
        <div class="container">
            <div id="frontAndCenter" align="center">
                <h1>Welcome!</h1>
                <p>
                    First time here? Please register for an account. <br/>
                    If not, you can sign in using the button on the top-right.
                </p>
                
                <form name="youform" role="form"
                    action="registerServlet" method="post">
                    
                    <!-- Username -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <input type="text" class="form-control" name="username"
                               placeholder="Get creative with your username"
                               required>
                    </div>
                    
                    <!-- Email -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <input type="email" class="form-control" name="email"
                               placeholder="Enter your e-mail address"
                               required>
                    </div>
                    
                    <!-- Password -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <input type="password" class="form-control" 
                               name="password" placeholder="What's the password?">
                    </div>
                    
                    <!-- Confirmation -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <br/>
                        <input class="btn btn-primary" type="submit"
                               value="REGISTER FOR CHOWTIME!">
                    </div>
                    
                </form>
                    
            </div>
        </div>
        
        <% } else {
            response.sendRedirect("index.jsp");
            }
        %>
        
    </body>

</html>