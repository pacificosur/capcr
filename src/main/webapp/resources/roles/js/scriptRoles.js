/* 
 * Autor: Gomez sanchez jose benito 
 * e-mail: josegomz.sa17@gmail.com
 * fecha de creacion: 08/05/2019
 * descripcion: cargar el jquery
 */

$(document).ready(function () {
    
    /**
     *  Esta clase Selector es para mostrar el modal para actualizar una practica
     */
    $('.class-asignar-rol').click(function () {
        //busca los datos delusuario en la fila seleccionada
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');
        var values = [6];
        //recoje los valores de cada fila
        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        
        //agregamos el valor del idUsuario para saber que usuario se le asigna el rol
        $('#idUsuario').val(values[0]);
        $('#tipoUsuario').val(values[5].trim());
        
        //buscamos cual era su rol anterior y se chequea el boton
        switch(values[5].trim()){
            case "invitado" :
                $('.radio1').prop('checked',"checked");
                break;
            case "administrador":
                $('.radio2').prop('checked',"checked");
                break;
            case "encargado":
                $('.radio3').prop('checked',"checked");
                break;
            case "profesor":
                $('.radio4').prop('checked',"checked"); 
                break;
            case "alumno":
                $('.radio5').prop('checked',"checked");
                break;
        } 
        //oculta el cuadro donde almacenamos la informacion
        
        //$('#valores-de-usuario').hide();
        $('#id-modal-rol').modal();
    });
    

    $('.radio1').click(function(){
        $('#tipoUsuario').val('1');
    });
    $('.radio2').click(function(){
        $('#tipoUsuario').val('2');
    });
    $('.radio3').click(function(){
        $('#tipoUsuario').val('3');
    });
    $('.radio4').click(function(){
        $('#tipoUsuario').val('4');
    });
    $('.radio5').click(function(){
        $('#tipoUsuario').val('5');
    });
    
});

