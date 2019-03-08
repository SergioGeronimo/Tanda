<%-- 
    Document   : user
    Created on : 3/03/2019, 08:14:14 PM
    Author     : Jahaziel A. Sanchez Moreno
--%>

<%@page import="com.tanda.DB.Usuario"%>
<%@page import="com.tanda.DB.Persona"%>
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
        
        <%if(user == null){%>
        <META http-equiv="refresh" content="0;URL=logIn.jsp">
        
        
        <% } %>
        
        <title>Your information</title>
    </head>
    <body>
        
        <div id="nav">
        </div>
        
        <div>
            <h1>Here is your information</h1>
        </div>
        
        <div>
            <form method="POST" action="/TandApp/edit/user">
                <table id="tableInput">
                    <tr>
                        <td>User ID:</td>
                        <td><input type="text" value="<%= user.getId() %>" name="ID_USUARIO"></td>
                    </tr>
                    <tr>
                        <td>CURP:</td>
                        <td><input type="text" value="<%= persona.getCurp() %>" name="CURP"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" value="<%= persona.getNombre() %>" name="NOMBRE"></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" value="<%= persona.getApellido() %>" name="APELLIDO"></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" value="<%= persona.getDireccion() %>" name="DIRECCION"></td>
                    </tr>
                    <tr>
                        <td>Phone number:</td>
                        <td><input type="text" value="<%= persona.getTelefono() %>" name="TELEFONO"></td>
                    </tr>
                    <tr>
                        <td>Administrator:</td>
                        <td>
                        <% if (user.isAdmin()){ %>

                            <i class="material-icons">check_circle</i>

                        <% }else{  %>

                            <i class="material-icons">cancel</i>

                        <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td>Confirm password:</td>
                        <td><input type="password" name="PASSWORD"></td>
                    </tr>

                </table>
                        <input type="submit">
                        
            </form>
            
            <!--<button onclick="toEditUserInfo()">
                <i class="material-icons">edit</i>
                Edit my information
            </button>-->
            <button onclick="toIndex()"><i class="material-icons">home</i></button>
            
             
        </div>
        
    </body>
</html>
