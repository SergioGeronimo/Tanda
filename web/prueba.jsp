<%-- 
    Document   : prueba
    Created on : 30/01/2019, 06:37:27 PM
    Author     : Sergio M. Gerónimo González
--%>

<%@page import="com.tanda.DB.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Tanda tanda = (Tanda) request.getAttribute("tanda");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola!</h1>
        <h3><%= tanda.getIdTanda() %></h3>
        <h3><%= tanda.getCURP() %></h3>
        <h3><%= tanda.getMonto() %></h3>
    </body>
</html>
