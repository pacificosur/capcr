/* 
 * Autor: Gomez sanchez jose benito 
 * e-mail: josegomz.sa17@gmail.com
 * fecha de creacion: 08/05/2019
 * descripcion: cargar el jquery
 */

$(document).ready(function () {
    
    /* Esta clase Selector es para mostrar el modal para actualizar una practica*/
    $('.class-asignar-rol').click(function () {
        
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');
        var values = [6];
        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('.idusuario').val(values[1]);
        /*busca en la tabla cual es su rol anterior*/
        switch(values[5].trim()){
            case "invitado" :
                $('.radio1').attr('checked',"checked");
                break;
            case "administrador":
                $('.radio2').attr('checked',"checked");
                break;
            case "encargado":
                $('.radio3').attr('checked',"checked");
                break;
            case "profesor":
                $('.radio4').attr('checked',"checked"); 
                break;
            case "alumno":
                $('.radio5').attr('checked',"checked");
                break;
        } 
        $('#id-modal-rol').modal();
    });
    
    $('#modificar_rol').click(function(){
        deschequear();
    });
    
    $('#cancelar').click(function(){
       deschequear(); 
    });
    $('#cerrar-model').click(function(){
       deschequear(); 
    });
    
    
});

    function deschequear(){
        
        $('.radio1').removeAttr("checked");
        $('.radio2').removeAttr("checked");
        $('.radio3').removeAttr("checked");
        $('.radio4').removeAttr("checked");
        $('.radio5').removeAttr("checked");
    }
    