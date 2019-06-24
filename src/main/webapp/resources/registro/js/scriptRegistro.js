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
//    $('.boton-agregar-registro').click(function () {
//        $.ajax({
//            url: 'RegistroController',
//            data: {
//                'matriculaAlumno': $('.input-matricula-registro').val()
//            },
//            success: function (responseText) {
//                $(".tabla-data").text(responseText);
//                $(".tabla-data").text(responseText);
//                $(".tabla-data").text(responseText);
//                $(".tabla-data").text(responseText);
//                $(".tabla-data").text(responseText);
//            }
//        });
//    });


    $("#id-btn-crear-registro").click(function () {

        $.ajax({
            url: 'RegistroController',
            data: {
                'matricula': $('.input-matricula-registro').val(),
                'accion': 'alumnopractica'
            },
            success: function (responseText) {
                var texto = responseText.split(",");
                var opcion = $("#idselect");

                //limpiar valores
                opcion.empty();
                $("#idmatricula").empty();
                $("#idnombre").empty();
                $("#idmatricula").append(texto[0]);
                $("#idnombre").append(texto[1].toString().toUpperCase());

                for (var i = 2; i < texto.length; i += 2) {
                    //alert(texto[i]);
                    opcion.append(new Option(texto[i + 1], texto[i]));
                    
                }

                $("#id-modal-registro").modal();
            }, error: function (responseText) {
                alert("responseTe");
            }
        });

    });

});

function abrirModal(e) {
    if (e.keyCode === 13) {
        $("#id-modal-registro").modal();
    }

}

