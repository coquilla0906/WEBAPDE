<%-- 
    Document   : index
    Created on : Mar 21, 2015, 9:25:39 PM
    Author     : Alds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <!-- Title + imports -->
        <jsp:include page="common/head.jsp">
            <jsp:param name="title" value="CHOWTIME!"/>
        </jsp:include>

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