/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 03/05/2019
 * Fecha Modificación: 3/05/2019
 * Descripción: Script para alumno
 */

$(document).ready(function () {
    


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


    /* Este id Alumno es para mostrar el modal para crear un nuevo alumno, además de sus caracteristicas */
    $("#id-btn-crear-alumno").click(function () {
        $("#id-modal-alumno").modal();
    });

    /* Esta clase Selector es para mostrar el modal para eliminar un registro*/
    $('.class-eliminar-alumno').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');

        $columns.addClass('row-highlight');
        var values = [8];

        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });

        $('#idMatricula-eliminar-no-mostrar').text(values[0]);
        $('#idMatricula-eliminar-mostrar').text(values[0]);
        $('#idNombre-eliminar').text(values[1]);
        $('#idGrupo-eliminar').text(values[2]);
        $('#idCodigoSemestre-eliminar').text(values[3]);
        $('#idCodigoCarrera-eliminar').text(values[4]);


        $("#id-modal-alumno-eliminar").modal();
    });

    $('.class-actualizar-alumno').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');

        $columns.addClass('row-highlight');
        var values = [5];

        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#idMatricula').val(values[0]);
        $('#idNombre').val(values[1]);
        $('#idGrupo').val(values[2]);
        $('#idCodigoSemestre').val(values[3]);
        $('#idCodigoCarrera').val(values[4]);

        $("#id-modal-alumno").modal();
    });

});
