/*
 * Autor: Hiralda Castro Cisneros
 * E-mail: hiraldac.cisneros@gmail.com
 * Fecha Creación: 03/05/2019
 * Fecha Modificación: 03/05/2019
 * Descripción: scritp para manipular el modulo de
 *              Practica.
 */

$(document).ready(function () {
    $( "#link-practica" ).css( "color", "#9A3633");
    $( "#link-practica" ).css( "font-size", "16px");
    /*Modifica los mensajes de error en el input*/
    var intputElements = document.getElementsByTagName("INPUT");
    for (var i = 0; i < intputElements.length; i++) {
        intputElements[i].oninvalid = function (e) {
            e.target.setCustomValidity("");
            if (!e.target.validity.valid) {
                if (e.target.validity.valueMissing)
                    e.target.setCustomValidity("El campo esta vacio");
                else {
                    e.target.setCustomValidity("El valor es incorrecto");
                }
            }
        };
    }
    /* Este id Selector es para mostrar el modal para crear un nueva practica*/
    $("#id-btn-crear-practica").click(function () {

        /*Modifica la parte del código para crear una practica*/
        $('#grupoCodigoPractica').show();
        $('#crearPractica').val('1');

        /*Limpia el formulario*/
        $('#codigoPractica').val('');
        $('#nombrePractica').val('');
        $('#idSemestrePractica').val('');
        $("#id-modal-practica").modal();
    });

    
    /* Esta clase Selector es para mostrar el modal para actualizar una practica*/
    $('.class-actualizar-practica').click(function () {

        /*Modifica la parte del código para actualizar una practica*/
        $('#crearPractica').val('');
        $('#grupoCodigoPractica').hide();

        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');

        $columns.addClass('row-highlight');
        var values = [4];

        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#codigoPractica').val(values[0]);
        $('#nombrePractica').val(values[1]);
        $('#idSemestrePractica').val(values[2]);
        
        var carrera=values[3].trim();
        //buscamos el nombre de carrera para mostrarlo en el modal
       switch(carrera){
           //Se utilizó el codigo '\u00ED' que representa 'í' en el estándar unicode
            case "Enfermer\u00EDa" :
                $("#idCarreraPractica option[value='13']").removeAttr("selected");
                $("#idCarreraPractica option[value='14']").removeAttr("selected");
               $("#idCarreraPractica option[value='03']").attr("selected", true);
                break;
            case "Odontolog\u00EDa":
                $("#idCarreraPractica option[value='03']").removeAttr("selected");
                $("#idCarreraPractica option[value='14']").removeAttr("selected");
                $("#idCarreraPractica option[value='13']").attr("selected", true);
                break;
            case "Medicina":
                $("#idCarreraPractica option[value='03']").removeAttr("selected");
                $("#idCarreraPractica option[value='13']").removeAttr("selected");
                $("#idCarreraPractica option[value='14']").attr("selected", true);
                break;
        } 

        $("#id-modal-practica").modal();
    });
    
});
