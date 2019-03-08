<%-- 
    Document   : tandas
    Created on : 24/02/2019, 10:19:16 PM
    Author     : Jahaziel A. Sanchez Moreno
--%>
<%@page import="com.tanda.DB.Persona"%>
<%@page import="com.tanda.DB.Pago"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tanda.DB.Tanda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   Vector<Tanda> allTandas = (Vector<Tanda>)request.getAttribute("allTandas");
   Tanda tanda = (Tanda) request.getAttribute("tanda");
   Vector<Pago> allPagos =  (Vector<Pago>) request.getAttribute("allPagos");
   Vector<Persona> allDeudores = (Vector<Persona>) request.getAttribute("allDeudores");
%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/TandApp/UI/general.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="/TandApp/jscript/buttons.js"></script>
        <title>TandApp - Your tandas</title>
        
    </head>
    
    <body>
        <h1>All your Tandas</h1>
        
        
        <% if(allTandas != null) {  %>
        <form method="POST" action="/TandApp/view/pagos">
            <select name="ID_TANDA" onchange="this.form.submit()">
            <% if(allTandas.isEmpty()){ %>
                <option selected disabled>Please make a Tanda</option>
            <% }else{ %>

                <option selected disabled>Choose one Tanda</option>
                <% for (int i = 0; i < allTandas.size(); i++){ %>
                <option value="<%= allTandas.elementAt(i).getIdTanda()%>">
                    Tanda ID: <%= allTandas.elementAt(i).getIdTanda()%>, monto <%= allTandas.elementAt(i).getMonto() %>
                </option>

                <% } %>

            <% } %>
            </select>
        </form>
            
            
        <% } %>
        <div>
                <button onclick="toNewTanda()"><i class="material-icons">add_circle</i> New Tanda</button>
                <button onclick="toIndex()"><i class="material-icons">home</i></button>
        </div>
        
        
            
        
    </body>
</html>
