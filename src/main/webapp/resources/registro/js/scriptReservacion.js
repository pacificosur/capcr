/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 11/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: scritp para manipular la creacion y actualizacion del modulo de
 *              reservacion.
 */

$(document).ready(function () {
    /* Este id Selector es para mostrar el modal para crear un nuevo registro*/
    $("#id-btn-crear-reservacion").click(function () {
        $("#id-modal-reservacion").modal();
    });

    /* Esta clase Selector es para mostrar el modal para actualizar un registro*/
    $('.class-actualizar-reservacion').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');

        $columns.addClass('row-highlight');
        var values = [8];

        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#idReservacion').val(values[0]);
        $('#idArea').val(values[3]);
        $('#idAreaResponsable').val(values[4]);
        $('#idPractica').val(values[3]);
        $('#idPracticaResponsable').val(values[4]);

        $("#id-modal-reservacion").modal();
    });
});
