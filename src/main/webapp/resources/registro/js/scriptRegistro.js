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
        var mat = $('.input-matricula-registro').val().trim();
        var valor;
        var numero = 0;
        var numero2 = 0;
        var idregistro;

//        $("#miTabla tr").find('td').each(function () {
//            valor = $(this).html();
//            alert(valor);
//            numero++;
//        },numero++);
        $("#miTabla").find('tr').each(function () {
            $(this).find('td:eq(1)').each(function () {
                valor = $(this).html();
                alert(valor);
            })
        });

        $("#miTabla tr").find('.btn').each(function () {
            numero2++;
            if (numero == numero2) {
                idregistro = $(this).name;
                $(this).remove();
            }
        });

        if (valor == mat) {
            alert("igual");
            $.ajax({
                url: 'RegistroController',
                data: {
                    'idRegistro': $('.input-matricula-registro').val(),
                    'accion': 'actualizar'
                },
                success: function (responseText) {

                }, error: function (responseText) {
                    alert("Ocurrio un error intente de nuevo");
                }
            });
        } else {
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
        }

    });
});

function abrirModal(e) {
    if (e.keyCode === 13) {
        $("#id-modal-registro").modal();
    }

}

