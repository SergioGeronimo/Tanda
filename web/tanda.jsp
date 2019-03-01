<%-- 
    Document   : tandas
    Created on : 24/02/2019, 10:19:16 PM
    Author     : Uriel
--%>
<%@page import="java.util.Vector"%>
<%@page import="com.tanda.DB.Tanda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   Vector<Tanda> allTandas = (Vector<Tanda>)request.getAttribute("AllTandas");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tandas</title>
    </head>
    <body>
        <h1>Estas son las tandas actuales con sus respectivos usuarios</h1>
        <% for (int i = 0; i < allTandas.size(); i++){ %>
        
        <h2><%= allTandas.elementAt(i).getMonto()%></h2>
        
        <% } %>
          <form method="get" action="create_tanda.jsp">
           <input type="submit" value="Crear Tanda" />
           <form method="get" action="edit_tandas.jsp">
           <input type="submit" value="Editar Tanda" />
           <form method="get" action="delete_tandas.jsp">
           <input type="submit" value="Eliminar Tanda" />


    </body>
</html>
