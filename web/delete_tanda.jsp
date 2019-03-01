<%-- 
    Document   : delete_tanda
    Created on : 25/02/2019, 11:20:05 AM
    Author     : Uriel
--%>
<%@page import="com.tanda.DB.Tanda"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tanda.DB.Pago"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   Vector<Tanda> allTandas = (Vector<Tanda>)request.getAttribute("AllTandas");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminando tandas</title>
    </head>
    <body>
        <h1>DELETE TANDAS</h1>
        
        <h2>Desea borrar alguna tanda?></h2>
        <% for (int i = 0; i < allTandas.size(); i++){ %>
        <select name="" size="">
            <option> <%= allTandas.elementAt(i).getMonto()%></option<
        </select>
        <% } %>
        <input type="submit" name="boton1" value="Eliminar tanda">
        
    </body>
</html>
