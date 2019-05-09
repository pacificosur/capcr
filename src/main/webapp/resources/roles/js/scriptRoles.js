/* 
 * Autor: Gomez sanchez jose benito 
 * e-mail: josegomz.sa17@gmail.com
 * fecha de creacion: 08/05/2019
 * descripcion: cargar el jquery
 */

$(document).ready(function () {
    
    /* Esta clase Selector es para mostrar el modal para actualizar una practica*/
    $('.class-asignar-rol').click(function () {
        
        var $row = jQuery(this).closest('tr');
        var $columns = $row.find('td');
        var values = [6];
        jQuery.each($columns, function (i, item) {
            values[i] = item.innerHTML;
        });
        if(values[5]==$('#radio4').val()){
            $("#radio4").attr("checked", this.checked);
        };
        
    });
    
    $('#radio1').click(function(){
       alert('hola'); 
    });
    
    

    
});

