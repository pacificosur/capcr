/* 
 * Autor: Gomez sanchez jose benito 
 * e-mail: josegomz.sa17@gmail.com
 * fecha de creacion: 08/05/2019
 * descripcion: cargar el jquery
 */
$(document).ready(function () {

    //paginar la segunda tabla
    $('#cargar-lista-alumno').click(function () {
        $('#cargar-lista-practica').hide('slow','swing');
        $('.cargar-alumnos').show('slow', 'swing');
    });
    $('#cargar-lista-practica').click(function () {
        $('#cargar-lista-alumno').hide('slow','swing');
        $('.cargar-practicas').show('slow', 'swing');
    });
});