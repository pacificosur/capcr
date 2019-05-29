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
                $('#tipoUsuario').val('1');
                break;
            case "administrador":
                $('.radio2').prop('checked',"checked");
                $('#tipoUsuario').val('2');
                break;
            case "encargado":
                $('.radio3').prop('checked',"checked");
                $('#tipoUsuario').val('3');
                break;
            case "profesor":
                $('.radio4').prop('checked',"checked");
                $('#tipoUsuario').val('4');
                break;
            case "alumno":
                $('.radio5').prop('checked',"checked");
                $('#tipoUsuario').val('5');
                break;
        } 
        //oculta el cuadro donde almacenamos la informacion
        
        var windowHeight = $(window).height();
        var windowWidth = $(window).width();
        var boxHeight = $('.modal-dialog').height();
        var boxWidth = $('.modal-dialog').width();
$('.modal-dialog').css({'left' : ((windowWidth - boxWidth)/2), 'top' : ((windowHeight - boxHeight)/2)});
        
        $('#valores-de-usuario').hide();
        $('#id-modal-rol').modal();
    });
    
    //cambia el valor del tipo del usuario por cada de hacen click en los checkbox
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

