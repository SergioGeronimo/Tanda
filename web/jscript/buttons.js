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

function toNewTanda(){
    location.href = "/TandApp/new/tanda"
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

function enableEditTanda(){
    
    
    var form = document.getElementById("form");
    form.action = "/TandApp/edit/tanda";
    
    var submitButton = document.getElementById("submit");
    submitButton.innerHTML = "done";
    
    removeElement("editButton" );
    
    var index = 0;
    while(document.getElementById("FECHA" + index ) !==  null){
        
        document.getElementById("FECHA" + index ).readonly = false ;
        document.getElementById("ID_PERSONA" + index ).readonly = false ;
        
        removeElement("NOMBRE" + index);
        removeElement("DIRECCION" + index);
        removeElement("TELEFONO" + index);
        removeElement("PAGADO" + index);
        removeElement("ACEPTADO" + index);
        
        index++;
    }
    
    document.getElementById("MONTO").readonly = false ;
    
    removeElement("ROUNDS");
    removeElement("PAYMENTS");
    removeElement("NOMBRE");
    removeElement("DIRECCION" );
    removeElement("TELEFONO");
    removeElement("PAGADO");
    removeElement("ACEPTADO");
}

function removeElement(elementId) {
    var element = document.getElementById(elementId);
    element.parentNode.removeChild(element);
}