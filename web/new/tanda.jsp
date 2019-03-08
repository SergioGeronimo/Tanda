<%-- 
    Document   : tanda
    Created on : 6/03/2019, 12:43:18 AM
    Author     : Jahaziel A. Sanchez Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/TandApp/UI/general.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="/TandApp/jscript/buttons.js"></script>
        <title>TandApp - new tanda</title>
    </head>
    <body>
        
        <div id="nav" class="nav">
            
        </div>
        
        <form method="POST" action="/TandApp/new/tanda"
            <div class="tanda">
                <h3>Register your tanda</h3>
                <input type="number" name="MONTO" required placeholder="$----" >
                
            </div>
                <h3>Payments</h3>
                

            <div class="payments">
                <table class="payTable">
                    
                    <tr>
                        <th>
                            <i class="material-icons"> perm_identity </i>
                        </th>
                        <th>
                            <i class="material-icons"> event </i>
                        </th>
                        
                    </tr>
                    <tr>
                        <td>
                            <input type="text" placeholder="CURP" name="CURP0" required>
                            
                        </td>
                        <td>
                            <input type="date" name="DATE0" required>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Create">
            </div>
        </form>
    </body>
</html>
