
$(document).ready(function () {
    /* Este id Selector es para mostrar el modal para crear un nuevo registro*/
    $("#id-btn-crear-usuario").click(function () {
        $("#id-modal-usuario").modal();
    });

    /* Esta clase Selector es para mostrar el modal para actualizar un registro*/
    $('.class-actualizar-usuario').click(function () {
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');

        $columns.addClass('row-highlight');
        var values = [8];

        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        $('#idUsuario').val(values[0]);
        $('#idNombre').val(values[3]);
        $('#idApellido').val(values[4]);
        $('#idNombreUsuario').val(values[3]);
        $('#idContraseña').val(values[4]);
         $('#idTipo').val(values[4]);
        $("#id-modal-usuario").modal();
    });
});



