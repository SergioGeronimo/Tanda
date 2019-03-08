<%-- 
    Document   : login
    Created on : 25/02/2019, 07:31:00 PM
    Author     : Sergio Gerónimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    session.invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/TandApp/UI/general.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="/TandApp/UI/logInLayout.css">
        <title>TandApp - Log in</title>
        
    </head>
    
    <body class="logIn">
        
        <div class="title">
            <h1>TandApp</h1>
        </div>
        
         <div class="description">
            <p>
                TandApp is a web application for tanda management<br>
                lorem ipsum
            </p>
        </div>
        
        <div class="content">
            <h3>Hello user! Log into your account</h3>
            <form method="POST" action="logIn">

                <input class="input" type="text" placeholder="User ID" name="ID_USUARIO">
                <input class="input" type="password" placeholder="Password" name="PASSWORD">
                <button class="input accent" onclick="this.form.submit()" >
                    <i class="material-icons">done</i>
                </button>
            </form> 
        </div>
        
        <div class="footer">
            <a href="/TandApp/signUp.jsp" class="suggestion">
                
                <i class="material-icons">sentiment_satisfied_alt</i>
                Not a user? Sign up here
            </a>
        </div>
        
    </body>
</html>
