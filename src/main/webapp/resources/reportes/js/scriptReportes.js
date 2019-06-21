/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 08/05/2019
 * Fecha Modificación: 08/05/2019
 * Descripción: scritp para manipular la creacion y actualizacion del modulo de usuario.
 */

$(document).ready(function () {
    $( "#link-usuario" ).css( "color", "#9A3633");
    $( "#link-usuario" ).css( "font-size", "16px");    

    $("#boton-enviar-datos").click(function () {
        if ($("#idNombre").val() === '' || $("#idApellidos").val() === '' || $("#idNombreUsuario").val() === '' || $("#idContrasena").val() === '' || $("#idContrasena2").val() === '')
        {
            alert("No se aceptan campos vacios");
            return false;
        }
        if ($("#idContrasena").val() === $("#idContrasena2").val()) {
            $.ajax({
                url: 'UsuarioController',
                data: {
                    'idUsuario': $('#idUsuario').val(),
                    'idNombre': $('#idNombre').val(),
                    'idApellidos': $('#idApellidos').val(),
                    'idNombreUsuario': $('#idNombreUsuario').val(),
                    'idContrasena': $('#idContrasena').val(),
                    'accion': 'crear'
                },
                success: function (responseText) {
                    $("#id-modal-usuario").modal().hide();
                    location.reload();
                    $('#idNombre').val('');
                    $('#idApellidos').val('');
                    $('#idNombreUsuario').val('');
                    $('#idContrasena').val('');
                    $('#idContrasena2').val('');
                }
            });
        } else {
            $("#id-modal-usuario-pwd-igual").modal();
        }
    });

    $("#boton-cancelar").click(function () {
        location.reload();
        $('#idNombre').val('');
        $('#idApellidos').val('');
        $('#idNombreUsuario').val('');
        $('#idContrasena').val('');
        $('#idContrasena2').val('');
    });

    /* Este id Selector es para mostrar el modal para crear un nuevo usuario*/
    $("#id-btn-crear-usuario").click(function () {
        $('#idNombre').val('');
        $('#idApellidos').val('');
        $('#idNombreUsuario').val('');
        $('#idContrasena').val('');
        $('#idContrasena2').val('');
        $("#id-modal-usuario").modal();
    });
    
    /* Esta clase Selector es para mostrar el modal para eliminar un usuario*/
    $('.class-eliminar-usuario').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');
        $columns.addClass('row-highlight');
        var values = [8];
        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#idUsuario-eliminar').val(values[0]);
        $('#idNombre-eliminar').text(values[1]);
        $('#idApellidos-eliminar').text(values[2]);
        $('#idNombreUsuario-eliminar').text(values[3]);
        $("#id-modal-usuario-eliminar").modal();
    });
    
    /* Esta clase Selector es para mostrar el modal para actualizar un usuario*/
    $('.class-actualizar-usuario').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');
        $columns.addClass('row-highlight');
        var values = [8];
        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#idUsuario').val(values[0]);
        $('#idNombre').val(values[1]);
        $('#idApellidos').val(values[2]);
        $('#idNombreUsuario').val(values[3]);
        $('#idContrasena').val();
        $('#idContrasena2').val();
        $("#id-modal-usuario").modal();
    });
}
);