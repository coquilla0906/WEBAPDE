<%-- 
    Document   : head
    Created on : Mar 26, 2015, 6:53:36 PM
    Author     : Alds
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>

    <% String title = request.getParameter("title"); %>

    <title><%=title%></title>

    <!-- This meta tag will ensure proper zooming and mobile support -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">

    <!-- Import Bootstrap CSS and a user-defined CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">

    <!-- Import JQuery and Bootstrap JS files -->
    <script src = "js/jquery-1.11.2.min.js"></script>
    <script src = "js/bootstrap.js"></script>
    <script src = "js/javascript.js"></script>
