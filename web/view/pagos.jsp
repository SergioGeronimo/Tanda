<%-- 
    Document   : pagos
    Created on : 6/03/2019, 09:27:12 PM
    Author     : Sergio Gerónimo
--%>

<%@page import="com.tanda.DB.Pago"%>
<%@page import="com.tanda.DB.Persona"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tanda.DB.Tanda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
   
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
        <title>TandApp - view payments</title>
    </head>
    <body>
        <form id="form" method="POST" action="/TandApp/remove/tanda">
            <% if((allPagos != null) && (tanda != null)) { %>
            <div>
                
                <span>Tanda ID: </span>
                <input type="text" name="ID_TANDA" id="ID_TANDA" value="<%= tanda.getIdTanda() %>" readonly><br>
                
                <span>Amount: </span>
                <input type="text" name="MONTO" name="MONTO" value="<%= tanda.getMonto() %>" readonly><br>
                
                <span>Rounds: </span>
                <input type="text" id="ROUNDS" value="<%= allPagos.size() %>" readonly><br>
                
                <span>Payment per person: </span>
                <input  type="text" id="PAYMENTS" value="<%= allPagos.isEmpty() ? 0 : tanda.getMonto()/allPagos.size() %>" readonly><br>
                
                <button onclick="this.form.submit()"><i id="submit" class="material-icons">delete</i></button>
                
            </div>

            <div>

                    <% if(allPagos.isEmpty()){ %>
                <h3>No payments founds</h3>


                    <% }else{ %>

                <table>
                    <tr>
                        <th>
                            <i class="material-icons"> event </i>
                        </th>
                        <th>
                            Curp
                        </th>
                        <th id="NOMBRE">
                            <i class="material-icons"> perm_identity </i>
                        </th>
                        <th id="DIRECCION">
                            <i class="material-icons"> place </i>
                        </th>
                        <th id="TELEFONO">
                            <i class="material-icons"> contact_phone </i>
                        </th>
                        <th id="PAGADO">
                            Paid
                        </th>
                        <th id="ACEPTADO">
                            Acepted
                        </th>
                    </tr>

                        <% for(int i = 0; i < allPagos.size(); i++) {%>
                    <tr>
                        <td>
                            <input type="date" id="<%= "FECHA" + i %>" name="<%= "FECHA" + i %>"
                                   value="<%=allPagos.elementAt(i).getFecha().toString()%>" readonly> 
                        </td>
                        <td>
                            <input type="text" id="<%= "ID_PERSONA" + i%>" name="<%= "ID_PERSONA" + i %>"
                                   value="<%=allDeudores.elementAt(i).getCurp()%>" readonly>
                        </td>
                        <td id="<%= "NOMBRE" + i %>">
                            <input type="text" 
                                   value="<%= allDeudores.elementAt(i).getNombre() + " " + allDeudores.elementAt(i).getApellido() %>" readonly>
                        </td>
                        <td id="<%= "DIRECCION" + i %>">
                            <input type="text" 
                                   value="<%= allDeudores.elementAt(i).getDireccion() %>" readonly>
                        </td>
                        <td id="<%= "TELEFONO" + i %>">
                            <input type="text" 
                                   value="<%= allDeudores.elementAt(i).getTelefono() %>" readonly>
                        </td>
                        <td id="<%= "PAGADO" + i %>">
                            <i class="material-icons">
                                <%= allPagos.elementAt(i).isPagado()? "check_circle" : "cancel"  %>
                            </i>
                        </td>
                        <td id="<%= "ACEPTADO" + i %>">
                            <i class="material-icons">
                                <%= allPagos.elementAt(i).isAceptado()? "check_circle" : "cancel"  %>
                            </i>
                        </td>
                    </tr>
                        <% } %>

                </table>

                    <% } %>
                    
                    
            </div>
                <% } %>
        </form>
        
        <button onclick="toTandas()"><i class="material-icons">arrow_back</i></button>
        <button onclick="toIndex()"><i class="material-icons">home</i></button>
        <button id="editButton" onclick="enableEditTanda()"><i class="material-icons">edit</i></button>
                    
    </body>
</html>
