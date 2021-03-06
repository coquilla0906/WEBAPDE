<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <!-- Title + imports -->
        <jsp:include page="common/head.jsp">
            <jsp:param name="title" value="CHOWTIME! Maps"/>
        </jsp:include>
        
        <!-- Cookies -->
        <%
            String username = "", email = "", memberSince = "";
            Cookie[] monster = request.getCookies();
            if (monster != null)
                for (Cookie clicker: monster)
                    if (clicker.getName().equals("loginCookie")){
                        String shit[] = clicker.getValue().split("~");
                        for (int i=0; i<shit.length; i++){
                            if (i==0) username = shit[i];
                            else if (i==1) email = shit[i];
                            else if (i==3) memberSince = shit[i];
                        }
                    }
        %>
        
    </head>
    <body style="background-image:url('images/userPage.jpg')">
        
        <!-- Header navbar + modals -->
        <jsp:include page="common/header.jsp">
            <jsp:param name="master" value="maps.jsp"/>
        </jsp:include>
        
        <!-- If no user is signed in -->
        <% if (username.isEmpty()){ %>
        
        <div class="container">
            <div class="row">
            
                <!-- Content -->
                <div class="container">
                    <div class="panel panel-default post">
                        <div class="panel-body">
                            
                            <!-- Content header: Name of place and address -->
                            <div class="page-header">
                                <h2>
                                    De La Salle University-Manila
                                    <small>
                                        2401 Taft Avenue, Malate, Manila
                                    </small>
                                </h2>
                            </div>
                            
                            <!-- The map -->
                            <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script><div style="overflow:hidden;height:480px;width:100%;"><div id="gmap_canvas" style="height:480px;width:100%;"></div><style>#gmap_canvas img{max-width:none!important;background:none!important}</style><a class="google-map-code" href="http://premium-wordpress-themes.org" id="get-map-data">wordpress with woocommerce</a></div><script type="text/javascript"> function init_map(){var myOptions = {zoom:17,center:new google.maps.LatLng(14.5661786,120.99339080000004),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(14.5661786, 120.99339080000004)});infowindow = new google.maps.InfoWindow({content:"<b>De La Salle University-Manila</b><br/>2401 Taft Avenue, Malate<br/> Manila" });google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});}google.maps.event.addDomListener(window, 'load', init_map);</script>
                            
                            <!-- Footer: buttons for interaction -->
                            <div class="page-footer" align="right">
                                <br/>
                                <a class="navbar-button btn-warning btn"
                                   href="index.html">
                                    WRONG LOCATION
                                </a>&nbsp;
                                <button class="navbar-button btn-danger btn">
                                    FIND ANOTHER
                                </button>&nbsp;
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
 
        <!-- else, if a user is logged in... -->
        <% } else { %>
        
        <div class="container">
            <div class="row">
            
                <!-- Sidebar -->
                <div class="col-lg-3">
                    <div class="list-group">
                        <a class="list-group-item">
                            <img class="featureImg" src="images/aldsTM.jpg"
                                width="100%">
                            <h4 class="list-group-item-heading">
                                <%=username%>
                            </h4>
                            <p class="list-group-item-info">
                                <span class="glyphicon glyphicon-home">
                                </span>
                                Member since <%=memberSince%>
                            </p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">
                                Kentucky Fried Chicken
                            </h4>
                            <p class="list-group-item-text">
                                <i>Laa shay'a waqi'un moutlaq bale kouloun 
                                moumkine.</i> These are the words spoken by our
                                ancestors that lay at the heart of our Creed.
                            </p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">
                                Sun Valley, Antipolo City
                            </h4>
                            <p class="list-group-item-text">
                                Where other men blindly follow the truth,
                                remember, nothing is true.
                            </p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">
                                Windmills and Rainforest
                            </h4>
                            <p class="list-group-item-text">
                                Where other men are limited, by morality or
                                fear, remember, everything is permitted.
                            </p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">
                                Jollibee
                            </h4>
                            <p class="list-group-item-text">
                                We work in the dark, to serve the light.
                                We are Assassins.
                            </p>
                        </a>
                    </div>
                </div>
                
                <!-- Content -->
                <div class="col-lg-9">
                    <div class="panel panel-default post">
                        <div class="panel-body">
                            
                            <!-- Content header: Name of place and address -->
                            <div class="page-header">
                                <h2>
                                    De La Salle University-Manila
                                    <small>
                                        2401 Taft Avenue, Malate, Manila
                                    </small>
                                </h2>
                            </div>
                            
                            <!-- The map -->
                            <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script><div style="overflow:hidden;height:480px;width:100%;"><div id="gmap_canvas" style="height:480px;width:100%;"></div><style>#gmap_canvas img{max-width:none!important;background:none!important}</style><a class="google-map-code" href="http://premium-wordpress-themes.org" id="get-map-data">wordpress with woocommerce</a></div><script type="text/javascript"> function init_map(){var myOptions = {zoom:17,center:new google.maps.LatLng(14.5661786,120.99339080000004),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(14.5661786, 120.99339080000004)});infowindow = new google.maps.InfoWindow({content:"<b>De La Salle University-Manila</b><br/>2401 Taft Avenue, Malate<br/> Manila" });google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});}google.maps.event.addDomListener(window, 'load', init_map);</script>
                            
                            <!-- Footer: buttons for interaction -->
                            <div class="page-footer" align="right">
                                <br/>
                                <button class="navbar-button btn-success btn">
                                    ADD TO FAVORITES
                                </button>
                                <a class="navbar-button btn-warning btn"
                                   href="index.html">
                                    WRONG LOCATION
                                </a>&nbsp;
                                <button class="navbar-button btn-danger btn">
                                    FIND ANOTHER
                                </button>&nbsp;
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
        <% } %>

    </body>
</html>
