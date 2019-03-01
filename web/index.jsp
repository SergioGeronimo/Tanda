<%-- 
    Document   : index
    Created on : 25/02/2019, 08:31:45 PM
    Author     : Sergio Gerónimo
--%>

<%@page import="com.tanda.DB.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%
            if(usuario == null){
        %>
        <META http-equiv="refresh" content="5;URL=logIn.jsp">
        <%
            }
        %>
        
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(usuario == null){
        %>
        No session logged<br> redirecting you to login
        <%
            }else{
        %>
        
        <h2><%= usuario.getCurp() %> </h2>
        <div>
            <form action="signOut">
                <input type="submit" value="Cerrar sesión">
            </form>
        </div>
        
        <%
            }
        %>
    </body>
</html>
