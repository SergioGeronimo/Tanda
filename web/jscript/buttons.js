/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function toIndex(){
    location.href = "/TandApp/index.jsp";
}

function toNotifications(){
    location.href = "/TandApp/view/notifications";
}
function toPayements(){
    location.href = "/TandApp/view/payements";
}
function toUserInfo(){
    location.href = "/TandApp/view/user";
}

function toEditUserInfo(){
    var table = document.getElementById("tableInput");
    var row = document.createElement("tr");
    var data1 = document.createElement("td");
    data1.appendChild(document.createTextNode("Confirm your password"));
    var data2 = document.createElement("td");
    data2.id = "confirm";
    
    createConfirmPssw("confirm");
    
    row.appendChild(data1);
    row.appendChild(data2);
    table.appendChild(row);
}

function toTandas(){
    location.href = "/TandApp/view/tandas";
}

function createConfirmPssw(divName){
    var div = document.getElementById(divName);
    
    var pssw = document.createElement("input");
    pssw.type = "password";
    pssw.name = "PASSWORD";
    pssw.placeholder = "Password";
    pssw.required = true;
    div.appendChild(pssw);
}