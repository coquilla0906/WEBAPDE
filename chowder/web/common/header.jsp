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
                <a href="index.jsp" class="navbar-brand">CHOWTIME!</a>		
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

                    <!-- Suggestions -->
                    <li>
                        <a href="#suggestions" data-toggle="modal">
                            SUGGESTIONS
                        </a>
                    </li>

                    <!-- About us -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">
                            ABOUT US  <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="https://www.facebook.com/aldsTM">
                                Alds Hade
                            </a></li>
                            <li><a href="https://www.facebook.com/cokeslovesyou">
                                Phillip Bryan Coquilla
                            </a></li>
                            <li><a href="https://www.facebook.com/jrs000">
                                Jan Renee Susada
                            </a></li>
                        </ul>
                    </li>

                    <!-- Register -->
                    <li><a href="register.jsp">
                        JOIN US
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
                        <h2>Sign in to CHOWTIME!</h2>
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

    <!-- Suggestions modal -->
    <div class="modal fade" id="suggestions" role="dialog">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <form name="formhub" role="form" 
                      action="suggestionsServlet" method="post">

                    <div class="modal-header">
                        <h2>We appreciate your feedback.</h2>
                    </div>

                    <div class="modal-body">
                        <!-- Name -->
                        <div class="form-group">
                            <label for="username" class="col-lg-2">
                                Username
                            </label>
                            <div class="input-group col-lg-10">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-user">
                                    </span>
                                </span>
                                <input type="text" class="form-control" 
                                    name="username"
                                    placeholder="Who are you?">
                            </div>
                        </div>

                        <!-- E-mail -->
                        <div class="form-group">
                            <label for="email" class="col-lg-2">
                                E-mail
                            </label>
                            <div class="input-group col-lg-10">
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-envelope">
                                    </span>
                                </span>
                                <input type="email" class="form-control" 
                                    name="email"
                                    placeholder="you_study@dlsu.edi.wow">
                            </div>
                        </div>

                        <!-- Actual suggestion content -->
                        <div class="form-group">
                            <label for="suggestion" class="col-lg-2">
                                Suggestion
                            </label>
                            <div class="input-group col-lg-10">
                                <textarea class="form-control" rows="5"
                                    cols="69" style="resize:none;"
                                    name="suggestion"></textarea>
                            </div>
                        </div>

                        <!-- Where is the header embedded? -->
                        <input type="hidden" name="master" value="<%=master%>"/>

                    </div>

                    <div class="modal-footer">

                        <!-- Cancel -->
                        <a class="btn btn-danger" data-dismiss="modal">
                            <span class="glyphicon glyphicon-arrow-left"></span>
                            Cancel
                        </a>

                        <!-- Confirmation -->
                        <input class="btn btn-success" 
                            type="submit" value="Submit">

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
                <a href="index.jsp" class="navbar-brand">CHOWTIME!</a>		
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

                    <!-- Suggestions -->
                    <li>
                        <a href="#suggestions" data-toggle="modal">
                            SUGGESTIONS
                        </a>
                    </li>

                    <!-- About us -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">
                            ABOUT US  <b class="caret"></b>
                        </a>						
                        <ul class="dropdown-menu">
                            <li><a href="https://www.facebook.com/aldsTM">
                                Alds Hade
                            </a></li>
                            <li><a href="https://www.facebook.com/cokeslovesyou">
                                Phillip Bryan Coquilla
                            </a></li>
                            <li><a href="https://www.facebook.com/jrs000">
                                Jan Renee Susada
                            </a></li>
                        </ul>
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

    <!-- Suggestions modal -->
    <div class="modal fade" id="suggestions" role="dialog">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <form name="formhub" role="form" 
                      action="suggestionsServlet" method="post">

                    <div class="modal-header">
                        <h2>We appreciate your feedback, <%=username%>.</h2>
                    </div>

                    <div class="modal-body">
                        
                        <!-- Name -->
                        <input type="hidden" name="username" value="<%=username%>">

                        <!-- E-mail -->
                        <input type="hidden" name="email" value="<%=email%>">

                        <!-- Actual suggestion content -->
                        <div class="form-group">
                            <label for="suggestion" class="col-lg-2">
                                Suggestion
                            </label>
                            <div class="input-group col-lg-10">
                                <textarea class="form-control" rows="5"
                                    cols="69" style="resize:none;"
                                    name="suggestion"></textarea>
                            </div>
                        </div>

                        <!-- Where is the header embedded? -->
                        <input type="hidden" name="master" value="<%=master%>"/>

                    </div>

                    <div class="modal-footer">

                        <!-- Cancel -->
                        <a class="btn btn-danger" data-dismiss="modal">
                            <span class="glyphicon glyphicon-arrow-left"></span>
                            Cancel
                        </a>

                        <!-- Confirmation -->
                        <input class="btn btn-success" 
                            type="submit" value="Submit">

                    </div>
                </form>
            </div>
        </div>
    </div> 
                        
    <% } %>