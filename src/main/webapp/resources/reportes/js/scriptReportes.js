/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 08/05/2019
 * Fecha Modificación: 08/05/2019
 * Descripción: scritp para manipular la creacion y actualizacion del modulo de reportes.
 */

$(document).ready(function () {
    $("#link-reporte").css("color", "#9A3633");
    $("#link-reporte").css("font-size", "16px");

    $("#boton-enviar-datos").click(function () {
        if ($("#idNombrePractica").val() === '' || $("#idGrupo").val() === '' || $("#idFechaInicio").val() === '' || $("#idFechaFin").val() === '' || $("#idSemestre").val() === '')
        {
            alert("No se aceptan campos vacios");
            return false;
        }
        $.ajax({
            url: 'ReporteController',
            data: {
                'idSemestre': $('#idSemestre').val(),
                'idNombrePractica': $('#idNombrePractica').val(),
                'idGrupo': $('#idGrupo').val(),
                'idFechaInicio': $('#idFechaInicio').val(),
                'idFechaFin': $('#idFechaFin').val(),
                'accion': 'generar'
            },
            success: function (responseText) {
                $("#id-modal-reporte").modal().hide();
                location.reload();
                $('#idNombrePractica').val('');
                $('#idGrupo').val('');
            }
        });
    });

    $("#boton-cancelar").click(function () {
        location.reload();
        $('#idNombrePractica').val('');
        $('#idGrupo').val('');
    });

    /* Este id Selector es para mostrar el modal para crear un nuevo usuario*/
    $("#id-btn-crear-reporte").click(function () {
        $('#idNombrePractica').val('');
        $('#idGrupo').val('');
        $("#id-modal-reporte").modal();
    });
}
);