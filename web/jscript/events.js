/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function registerSE(){
    var source = new EventSource("http://localhost:8080/TandaApp/prueba");

    source.addEventListener("server-time", function(event) {
        //console.log(event.data);
        document.getElementById("myDiv").innerHTML = event.data + ":v";
    }, false);

}
