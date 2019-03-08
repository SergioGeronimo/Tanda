<%-- 
    Document   : signUp
    Created on : 25/02/2019, 07:37:08 PM
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
        <script src="/TandApp/jscript/buttons.js"></script>
        <title>Sign up here!</title>
    </head>
    <body>
        <h1>Hello new user!</h1>
        <form method="POST" action="signUp">
            
            <input type="text" placeholder="CURP" maxlength="18" name="CURP" required>
            <input type="text" placeholder="Your name" maxlength="255" name="NOMBRE" required>
            <input type="text" placeholder="Your last name" maxlength="255" name="APELLIDO" required>
            <input type="text" placeholder="Addres" maxlength="255" name="DIRECCION" required>
            <input type="text" placeholder="Phone number" maxlength="10" name="TELEFONO" required>
            <input type="password" placeholder="Password" minlength="4" maxlength="15" name="PASSWORD" required>
            
            Do you want to be a TandApp Administrator?
            <input  type="radio" name="ADMIN" value="true"> Yes please
            <input  type="radio" name="ADMIN" value="false"> No, thanks
            
            <input type="submit">
            
        </form>
        <a href="/TandApp/logIn.jsp">Already a user? Log in here</a>
    </body>
</html>
