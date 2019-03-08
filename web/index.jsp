<%-- 
    Document   : index
    Created on : 25/02/2019, 08:31:45 PM
    Author     : Jahaziel A. Sanchez Moreno
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
        
        <title>TandApp - Home</title>
    </head>
    <body>
        <%
            if(user == null){
        %>
        <h2>No session logged</h2>
        <h3>redirecting you to login</h3>
        <%
            }else{
        %>
        
        
        
        <div class="title">
            <h1>Hello <%= persona.getNombre() %></h1>
            <h3>welcome to your TandApp</h3>
        </div>
            
       
        
        <div class="options">
            
            <button onclick="toNotifications()" class="void">
                <i class="material-icons  navButton">notifications</i>  
                
            </button>
            View notifications
            
            <button onclick="toPayements()" class="void">
                <i class="material-icons  navButton">payment</i>  
                
            </button>
            Manage my payments
            
            <%
                if (user.isAdmin()){
            %>
            <button onclick="toTandas()" class="void">
                <i class="material-icons  navButton">monetization_on</i> 
                
            </button>
            Manage my tandas
            <%
                }
            %>
            
            
            <button onclick="toUserInfo()" class="void">
                <i class="material-icons  navButton">account_circle</i>  
                
            </button>
            View my information
            
            <form action="/TandApp/signOut">
                <button onclick="this.form.submit()" class="void">
                    <i class="material-icons navButton">exit_to_app</i>
                    
                </button>
                Log out
            </form>
            
        </div>
        
        <%
            }
        %>
    </body>
</html>
