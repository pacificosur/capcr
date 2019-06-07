/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 03/05/2019
 * Fecha Modificación: 3/05/2019
 * Descripción: Script para alumno
 */

$(document).ready(function () {
    $('#miTabla').pageMe({pagerSelector: '#myPager', showPrevNext: true, hidePageNumbers: false, perPage: 5});


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




/* función para paginar los registros*/
$.fn.pageMe = function (opts) {
    var $this = this,
            defaults = {
                perPage: 7,
                showPrevNext: false,
                hidePageNumbers: false
            },
            settings = $.extend(defaults, opts);

    var listElement = $this;
    var perPage = settings.perPage;
    var children = listElement.children();
    var pager = $('.pager');

    if (typeof settings.childSelector != "undefined") {
        children = listElement.find(settings.childSelector);
    }

    if (typeof settings.pagerSelector != "undefined") {
        pager = $(settings.pagerSelector);
    }

    var numItems = children.size();
    var numPages = Math.ceil(numItems / perPage);

    pager.data("curr", 0);

    if (settings.showPrevNext) {
        $('<li><a href="#" class="prev_link"><span><i class="fa fa-arrow-left"></i></span></a></li>').appendTo(pager);
    }

    var curr = 0;
    while (numPages > curr && (settings.hidePageNumbers == false)) {
        $('<li><a href="#" class="page_link">' + (curr + 1) + '</a></li>').appendTo(pager);
        curr++;
    }

    if (settings.showPrevNext) {
        $('<li><a href="#" class="next_link"><span><i class="fa fa-arrow-right"></i></span></a></li>').appendTo(pager);
    }

    pager.find('.page_link:first').addClass('active');
    pager.find('.prev_link').hide();
    if (numPages <= 1) {
        pager.find('.next_link').hide();
    }
    pager.children().eq(1).addClass("active");

    children.hide();
    children.slice(0, perPage).show();

    pager.find('li .page_link').click(function () {
        var clickedPage = $(this).html().valueOf() - 1;
        goTo(clickedPage, perPage);
        return false;
    });
    pager.find('li .prev_link').click(function () {
        previous();
        return false;
    });
    pager.find('li .next_link').click(function () {
        next();
        return false;
    });

    function previous() {
        var goToPage = parseInt(pager.data("curr")) - 1;
        goTo(goToPage);
    }

    function next() {
        goToPage = parseInt(pager.data("curr")) + 1;
        goTo(goToPage);
    }

    function goTo(page) {
        var startAt = page * perPage,
                endOn = startAt + perPage;

        children.css('display', 'none').slice(startAt, endOn).show();

        if (page >= 1) {
            pager.find('.prev_link').show();
        } else {
            pager.find('.prev_link').hide();
        }

        if (page < (numPages - 1)) {
            pager.find('.next_link').show();
        } else {
            pager.find('.next_link').hide();
        }

        pager.data("curr", page);
        pager.children().removeClass("active");
        pager.children().eq(page + 1).addClass("active");
    }

};

