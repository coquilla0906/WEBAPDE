<%-- 
    Document   : index
    Created on : Mar 21, 2015, 9:25:39 PM
    Author     : Alds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <title>CHOWTIME!</title>

        <!-- This meta tag will ensure proper zooming and mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">

        <!-- Import Bootstrap CSS and a user-defined CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        
        <!-- Import JQuery and Bootstrap JS files -->
        <script src = "js/jquery-1.11.2.min.js"></script>
        <script src = "js/bootstrap.js"></script>
        <script src = "js/javascript.js"></script>

    </head>

    <body style="background-image:url('images/index.jpg')">
        
        <!-- Header navbar + modals -->
        <jsp:include page="common/header.jsp">
            <jsp:param name="master" value="index.jsp"/>
        </jsp:include>
        
        <!-- Body -->
        <div class="container">
            <div id="frontAndCenter" align="center">
                <h1>Saan niyo gusto kumain?</h1>
                
                <form name="indexForm" role="form" 
                      action="indexServlet" method="post">
                    
                    <!-- How much are you willing to spend? -->
                    <div class="input-group col-lg-5 input-group-lg">
                        <select class="form-control" name="budget">
                            <option value="" disabled selected style="display:none;">
                                How much are you willing to spend?
                            </option>
                            <option value="below100">
                                Less than a hundred pesos
                            </option>
                            <option value="100to200">Between ₱100 to ₱200</option>
                            <option value="200to500">From ₱200 to ₱500</option>
                            <option value="above500">
                                I'm rich. I don't care.
                            </option>
                        </select>
                    </div>

                    <!-- Type your location here -->                
                    <div class="input-group col-lg-5 input-group-lg">
                        <!-- <span class="input-group-addon">></span> -->
                        <input type="text" class="form-control" 
                               name="location"
                               placeholder="Type your location here">
                    </div>

                    <div class="input-group col-lg-5 input-group-lg">
                        <br/>
                        <input class="btn btn-primary btn-lg" 
                                type="submit" value="Take me somewhere nice!">
                    </div>
                    
                </form>
                
            </div>
        </div>

    </body>

</html>