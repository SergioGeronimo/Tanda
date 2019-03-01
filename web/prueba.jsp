<%-- 
    Document   : prueba
    Created on : 30/01/2019, 06:37:27 PM
    Author     : Sergio M. Gerónimo González
--%>

<%@page import="java.util.Vector"%>
<%@page import="com.tanda.DB.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Vector<Pago> allPagos = (Vector<Pago>) request.getAttribute("pago");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola!</h1>
        
        <% 
            for(int i = 0; i < allPagos.size(); i++){
        %>
        
        <h3><%= allPagos.elementAt(i).getId()%></h3>
        <h3><%= allPagos.elementAt(i).getCURP() %></h3>
        <h3><%= allPagos.elementAt(i).getFecha().toString() %></h3>
        <h3><%= allPagos.elementAt(i).getIdTanda() %></h3>
        <h3><%= allPagos.elementAt(i).isPagado() %></h3>
        <hr>
        
        <%
            }
        %>
       
    </body>
</html>
