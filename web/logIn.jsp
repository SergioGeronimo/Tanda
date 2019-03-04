<%-- 
    Document   : login
    Created on : 25/02/2019, 07:31:00 PM
    Author     : Sergio Gerónimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/TandApp/UI/general.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Log in please</title>
        
    </head>
    
    <body>
        
        <h1 class="title">Hello user! Log into your account</h1>
        
        <form method="POST" action="logIn">
            
            <input type="text" placeholder="User ID" name="ID_USUARIO">
            <input type="password" placeholder="Password" name="PASSWORD">
            <input type="submit">
        </form> 
        
        <a href="/signUp.jsp" class="suggestion">Not a user? Sign up here :)</a>
    </body>
</html>
