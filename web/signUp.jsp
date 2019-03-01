<%-- 
    Document   : signUp
    Created on : 25/02/2019, 07:37:08 PM
    Author     : Sergio Gerónimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New user!</h1>
        <form method="POST" action="signUp">
            
            <input type="text" placeholder="CURP" maxlength="18" name="CURP">
            <input type="text" placeholder="Name" maxlength="255" name="NOMBRE">
            <input type="text" placeholder="Addres" maxlength="255" name="DIRECCION">
            <input type="text" placeholder="Phone number" maxlength="10" name="TELEFONO">
            <input type="password" placeholder="Password" maxlength="15" name="PASSWORD">
            
            <input type="submit">
            
        </form>
        <a href="logIn.jsp">Already a user? Log in here</a>
    </body>
</html>
