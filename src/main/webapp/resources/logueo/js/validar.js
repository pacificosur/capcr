/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 07/05/2019
  Fecha Modificación: 08/05/2019
  Descripción: Creación de jsp del logueo
  Tecnologias web I
*/
function soloLetras(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";
    tecla_especial = false
    for(var i in especiales){
        if(key == especiales[i]){
            tecla_especial = true;
            break;
        }
    }
    if(letras.indexOf(tecla)==-1 && !tecla_especial){
        return false;
      }
}

window.history.go(-1);
window.history.back();