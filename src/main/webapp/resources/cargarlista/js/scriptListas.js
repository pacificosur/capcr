/* 
 * Autor: Gomez sanchez jose benito 
 * e-mail: josegomz.sa17@gmail.com
 * fecha de creacion: 08/05/2019
 * descripcion: cargar el jquery
 */
$(document).ready(function () {
    
    //paginar la segunda tabla
    $('#miTabla2').pageMe2({pagerSelector:'#myPager2',showPrevNext:true,hidePageNumbers:false,perPage:5});
    
    $('#cargar-lista-alumno').click(function(){
       $('#botones-cargar').hide('slow','swing'); 
       $('.cargar-alumnos').show('slow','swing');
    });
    $('#cargar-lista-practica').click(function(){
       $('#botones-cargar').hide('slow','swing'); 
       $('.cargar-practicas').show('slow','swing');
    });
    $("#my_file_input").click(function(){
       alert('hola mundo'); 
    });
});

/* función para paginar los registros*/
$.fn.pageMe2 = function(opts){
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
    var pager = $('.pager2');
    
    if (typeof settings.childSelector!="undefined") {
        children = listElement.find(settings.childSelector);
    }
    
    if (typeof settings.pagerSelector!="undefined") {
        pager = $(settings.pagerSelector);
    }
    
    var numItems = children.size();
    var numPages = Math.ceil(numItems/perPage);

    pager.data("curr",0);
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="prev_link"><span><i class="fa fa-arrow-left"></i></span></a></li>').appendTo(pager);
    }
    
    var curr = 0;
    while(numPages > curr && (settings.hidePageNumbers==false)){
        $('<li><a href="#" class="page_link">'+(curr+1)+'</a></li>').appendTo(pager);
        curr++;
    }
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="next_link"><span><i class="fa fa-arrow-right"></i></span></a></li>').appendTo(pager);
    }
    
    pager.find('.page_link:first').addClass('active');
    pager.find('.prev_link').css('visibility','hidden');
    
    if (numPages<=1) {
        pager.find('.next_link').css('visibility','hidden');
    }
  	pager.children().eq(1).addClass("active");
    
    children.hide();
    children.slice(0, perPage).show();
    
    pager.find('li .page_link').click(function(){
        var clickedPage = $(this).html().valueOf()-1;
        goTo(clickedPage,perPage);
        return false;
    });
    pager.find('li .prev_link').click(function(){
        previous();
        return false;
    });
    pager.find('li .next_link').click(function(){
        next();
        return false;
    });
    
    function previous(){
        var goToPage = parseInt(pager.data("curr")) - 1;
        goTo(goToPage);
    }
     
    function next(){
        goToPage = parseInt(pager.data("curr")) + 1;
        goTo(goToPage);
    }
    
    function goTo(page){
        var startAt = page * perPage,
            endOn = startAt + perPage;
        
        children.css('display','none').slice(startAt, endOn).show();
        
        if (page>=1) {
            pager.find('.prev_link').css('visibility','visible');
        }
        else {
            pager.find('.prev_link').css('visibility','hidden');
        }
        
        if (page<(numPages-1)) {
            pager.find('.next_link').css('visibility','visible');
        }
        else {
            pager.find('.next_link').css('visibility','hidden');
        }
        
        pager.data("curr",page);
      	pager.children().removeClass("active");
        pager.children().eq(page+1).addClass("active");    
    }
};
