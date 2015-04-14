<%-- 
    Document   : signIn
    Created on : Mar 21, 2015, 9:26:39 PM
    Author     : Alds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <!-- Title + imports -->
        <jsp:include page="common/head.jsp">
            <jsp:param name="title" value="CHOWTIME! Login"/>
        </jsp:include>

    </head>

    <body style="background-image:url('images/signIn.jpg')">
        
        <!-- Header navbar + modals -->
        <jsp:include page="common/header.jsp">
            <jsp:param name="master" value="signIn.jsp"/>
        </jsp:include>
        
        <!-- Body -->
        <div class="container">
            <div id="frontAndCenter" align="center">
                <h1>Back on CHOWTIME?</h1>
                
                <form name="youform" role="form" 
                      action="loginServlet" method="post">
                    
                    <!-- Username -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <input type="text" class="form-control" name="username"
                               placeholder="Enter your username">
                    </div>
                    
                    <!-- Password -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <input type="password" class="form-control" 
                               name="password" placeholder="What's the password?">
                    </div>
                    
                    <!-- Confirmation -->
                    <div class="input-group col-lg-4 input-group-lg">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="rememberMe"> 
                                "REMEMBER ME when You enter Your Kingdom."
                            </label>
                        </div>
                        <input class="btn btn-success" 
                                type="submit" value="LOG ME IN!">
                    </div>
                    
                </form>
                    
            </div>
        </div>
        
    </body>

</html>