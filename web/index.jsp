<%-- 
    Document   : index
    Created on : 25/02/2019, 08:31:45 PM
    Author     : Sergio Gerónimo
--%>

<%@page import="com.tanda.DB.Persona"%>
<%@page import="com.tanda.DB.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Usuario user = (Usuario) session.getAttribute("usuario");
    Persona persona = (Persona)session.getAttribute("persona");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/TandApp/UI/general.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="/TandApp/jscript/buttons.js"></script>
        
        <%
            if(user == null){
        %>
        <META http-equiv="refresh" content="5;URL=/TandApp/logIn.jsp">
        
        
        <%
            }
        %>
        
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(user == null){
        %>
        No session logged<br> redirecting you to login
        <%
            }else{
        %>
        
        <div id="nav">
            
        
        </div>
        
        <div>
            <h1>Hello <%= persona.getNombre() %></h1>
        </div>
        
        <div>
            
            <button onclick="toNotifications()">
                <i class="material-icons">notifications</i>  
                View notifications
            </button>
            
            <button onclick="toPayements()">
                <i class="material-icons">payment</i>  
                Manage my payments
            </button>
            
            <%
                if (user.isAdmin()){
            %>
            <button onclick="toTandas()">
                <i class="material-icons">monetization_on</i> 
                Manage my tandas
            </button>
            <%
                }
            %>
            
            
            <button onclick="toUserInfo()">
                <i class="material-icons">account_circle</i>  
                View my information
            </button>
            
            <form action="signOut">
                <input type="submit" value="Log out">
            </form>
            
        </div>
        
        <%
            }
        %>
    </body>
</html>
