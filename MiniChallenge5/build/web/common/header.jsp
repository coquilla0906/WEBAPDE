<%-- 
    Document   : header
    Created on : Mar 21, 2015, 9:39:15 PM
    Author     : Alds
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    
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
   
    <!-- Header. Remember: default=silver; light=white; inverse=dark.
        This navbar occurs when there is no user signed in. -->
    <% if (username.isEmpty()){ %>

    <!-- Navbar -->
    <div class="navbar navbar-inverse navbar-static-top">
        <div class="container">

            <!-- Wrap the logo and sub btn in div called navbar-header -->
            <div class="navbar-header">		
                <!-- Logo -->
                <a href="index.jsp" class="navbar-brand">MiniChallenge!</a>		
                <!-- Substitute button for when collapse happens -->
                <button class="navbar-toggle" data-toggle="collapse" 
                        data-target=".navHeaderCollapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- What is going to be collapsed in resizing? --> 
            <div class="collapse navbar-collapse navHeaderCollapse">
                <ul class="nav navbar-nav navbar-right">

                    <!-- Register -->
                    <li><a href="register.jsp">
                        REGISTER
                    </a></li>

                    <!-- Sign in -->
                    <li><a href="#signIn" data-toggle="modal">
                        SIGN IN
                    </a></li>

                </ul>
            </div>

        </div>
    </div>

    <!-- Sign-in modal -->
    <div class="modal fade" id="signIn" role="dialog">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <form name="youform" role="form" 
                      action="loginServlet" method="post">

                    <div class="modal-header">
                        <h2>Sign in</h2>
                    </div>

                    <div class="modal-body">

                        <!-- Username -->
                        <div class="form-group">
                            <label for="username" class="col-lg-3">
                                Email/Username
                            </label>
                            <div class="input-group col-lg-9">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-user">
                                    </span>
                                </span>
                                <input type="text" class="form-control" 
                                    name="username"
                                    placeholder="Enter your username or email">
                            </div>
                        </div>

                        <!-- Password -->
                        <div class="form-group">
                            <label for="password" class="col-lg-3">
                                Password
                            </label>
                            <div class="input-group col-lg-9">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-star">
                                    </span>
                                </span>
                                <input type="password" class="form-control" 
                                    name="password" 
                                    placeholder="What's the password?">
                            </div>
                        </div>

                        <!-- Where is the header embedded? -->
                        <input type="hidden" name="master" value="<%=master%>"/>

                    </div>

                    <div class="modal-footer">
                        <!-- Confirmation -->
                        <div class="checkbox" style="display: inline;">
                            <label>
                                <input type="checkbox" name="rememberMe"> 
                                Remember me
                            </label>
                        </div>&nbsp;
                        <input class="btn btn-success" 
                            type="submit" value="LOG ME IN!">
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <!-- However, if there is somebody signed in, the header changes. -->
    <% } else { %>

    <!-- Navbar -->
    <div class="navbar navbar-inverse navbar-static-top">
        <div class="container">

            <!-- Wrap the logo and sub btn in div called navbar-header -->
            <div class="navbar-header">		
                <!-- Logo -->
                <a href="index.jsp" class="navbar-brand">MiniChallenge!</a>		
                <!-- Substitute button for when collapse happens -->
                <button class="navbar-toggle" data-toggle="collapse" 
                        data-target=".navHeaderCollapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- What is going to be collapsed in resizing? --> 
            <div class="collapse navbar-collapse navHeaderCollapse">
                <ul class="nav navbar-nav navbar-right">

                    <!-- Uploads -->
                    <li>
                        <a href="#upload" data-toggle="modal">
                            UPLOAD PIC
                        </a>
                    </li>

                    <!-- User -->
                    <li>
                        <a class="dropdown-toggle" data-toggle="dropdown">
                            <%=username%>  <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="logoutServlet">
                                LOG OUT
                            </a></li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>
    </div>

    <!-- Sign-in modal -->
    <div class="modal fade" id="upload" role="dialog">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <form name="formhub" role="form" 
                      action="uploadServlet" method="post"
                      enctype="multipart/form-data">

                    <div class="modal-header">
                        <h2>Add an image to your collection</h2>
                    </div>

                    <div class="modal-body">

                        <!-- Username -->
                        <div class="form-group">
                            <label for="username" class="col-lg-3" >
                                Select file
                            </label>
                            <div class="input-group col-lg-9">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-user">
                                    </span>
                                </span>
                                <input type="file" class="form-control" 
                                    name="file">
                            </div>
                        </div>

                        <!-- Where is the header embedded? -->
                        <input type="hidden" name="master" value="<%=master%>"/>

                    </div>

                    <div class="modal-footer">
                        <!-- Confirmation -->
                        <input class="btn btn-success" 
                            type="submit" value="Upload Image">
                    </div>
                </form>
            </div>
        </div>
    </div>
                        
    <% } %>