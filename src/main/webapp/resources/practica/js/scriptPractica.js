/*
 * Autor: Hiralda Castro Cisneros
 * E-mail: hiraldac.cisneros@gmail.com
 * Fecha Creación: 03/05/2019
 * Fecha Modificación: 03/05/2019
 * Descripción: scritp para manipular el modulo de
 *              Practica.
 */

$(document).ready(function () {
    /* Este id Selector es para mostrar el modal para crear un nueva practica*/
    $("#id-btn-crear-practica").click(function () {
        $('#codigoPractica').prop('disabled', false);
        $('#codigoPractica').val('');
        $('#nombrePractica').val('');
        $('#idSemestrePractica').val('');
        $('#idCarreraPractica').val('');
        $("#id-modal-practica").modal();
    });

    /* Esta clase Selector es para mostrar el modal para actualizar una practica*/
    $('.class-actualizar-practica').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');
        
        $('#codigoPractica').prop('disabled', true);
        
        $columns.addClass('row-highlight');
        var values = [4];

        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#codigoPractica').val(values[0]);
        $('#nombrePractica').val(values[1]);
        $('#idSemestrePractica').val(values[2]);
        $('#idCarreraPractica').val(values[3]);

        $("#id-modal-practica").modal();
    });
});
