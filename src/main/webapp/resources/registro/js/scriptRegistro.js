/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 11/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: scritp para manipular la creacion y actualizacion del modulo de
 *              reservacion.
 */

$(document).ready(function () {
    $("#link-registro").css("color", "#9A3633");
    $("#link-registro").css("font-size", "16px");

    $('.btn-cancelar-registro').click(function () {
        var id = $(this).attr('name');
        $("#idRegistro").val(id);
        $('#id-modal-cancelar-registro').modal();
    });

    $('#boton-cancelar-registro').click(function () {
        if ($("#comentario").val() === '')
        {
            alert("No se aceptan campos vacios");
            return false;
        }
    });
    

    
    $('#id-btn-crear-registro').click(function () {
        $.ajax({
            url: 'RegistroController',
            data: {
                'matricula': $('.input-matricula-registro').val(),
                'accion': 'alumnopractica'
            },

            success: function (responseText) {
                var texto = responseText.split(",");

                var opcion = $("#idselect");
                opcion.empty();
                $("#idmatricula").empty();
                $("#idnombre").empty();
                $("#txtidmatricula").empty();
                $("#txtidnombre").empty();

                var matricula = texto[0].split("[");
                $("#idmatricula").val(matricula[1]);
                $("#txtidmatricula").append(matricula[1]);
                $("#txtidnombre").append(texto[1].toString().toUpperCase());
                for (var i = 2; i < texto.length; i += 2) {
                    var codigo = texto[i].split(" ");
                    opcion.append(new Option(texto[i + 1], codigo[1]));
                }

                $("#id-modal-registro").modal();
            }, error: function (responseText) {
                alert("Ocurrio un error intente de nuevo");
            }
        });
    });
});

function abrirModal(e) {
    if (e.keyCode === 13) {
        $("#id-modal-registro").modal();
    }

}

