/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 11/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: scritp para manipular la creacion y actualizacion del modulo de
 *              reservacion.
 */

$(document).ready(function () {
    $('.boton-agregar-registro').click(function () {        
        $.ajax({
            url: 'RegistroController',
            data: {
                'matriculaAlumno': $('.input-matricula-registro').val()
            },
            success: function (responseText) {
                $(".tabla-data").text(responseText);
                $(".tabla-data").text(responseText);
                $(".tabla-data").text(responseText);
                $(".tabla-data").text(responseText);
                $(".tabla-data").text(responseText);
            }
        });
    });
});
