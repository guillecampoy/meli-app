$(document).ready(function(){
	$("#search-text").keydown(search);

	// Codigo para el dialogo modal

	$(function(){

		var appendthis =  ("<div class='modal-overlay js-modal-close'></div>");

		  $('button[data-modal-id]').click(function(e) {
		    e.preventDefault();
		    $("body").append(appendthis);
		    $(".modal-overlay").fadeTo(500, 0.7);
		    $(".js-modalbox").fadeIn(500);
		    var modalBox = $(this).attr('data-modal-id');
		    $('#'+modalBox).fadeIn($(this).data());

		    //change tittle
		    $("#dialog-text").text("Buscar regalo para " + this.id);
		    $()

		  });  
		  
		  
		$(".js-modal-close, .modal-overlay").click(
			function() {
				$(".modal-box, .modal-overlay").fadeOut(500, function() {
					$(".modal-overlay").remove();
				});
			}
		);
		 
		$(window).resize(function() {
		  $(".modal-box").css({
		    top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
		    left: ($(window).width() - $(".modal-box").outerWidth()) / 2
		  });
		});
		 
		$(window).resize();
		 
		});
	});

vacio = false;

current_id = "";

function search(){
	// var url_meli = "https://api.mercadolibre.com/sites/MLA/search?q=" + this.value;
	// var promise = $.get(url_meli);
	// promise.done(processResult);
	_this = this;
	setTimeout(function() {
		if (!_this.value == "" & vacio){
			vacio = !vacio;
			animateResult();
		} else{ 
				if (_this.value == "" & !vacio){
					vacio = !vacio;
					animateResult();
				}
		}

		$("#result-conteiner").empty();
		$("#result-conteiner").append("<img class='ajax-loader' src='/birthdays/assets/ajax-loader.gif'>");
		
		var url_meli = "https://api.mercadolibre.com/sites/MLA/search?q=" + _this.value;
		var promise = $.get(url_meli);
		promise.done(processResult);

		}, 0);
};

function animateResult(){
	$("#result-conteiner").animate({
			    // opacity: 0.25,
			    width: [ "toggle", "swing" ],
				height: [ "toggle", "swing" ],
				opacity: "toggle"
			  }, 500, function() {
			    // cuando termina la animacion
			  });
}

function processResult(data){
	$("#result-conteiner").empty();
	// console.log(data.results.length);

	if (!data.results.length){
		$("#result-conteiner").append("<p class='no-result'> No hay resultados </p>");
	};

	data.results.forEach(function(item, index){
		var div_item;
		if(index % 2){
			div_item = "<div class='row white-search' id='"+item.id+"'>"+"<img class='item-image' src='"+item.thumbnail+"'/>"+ "<p class='title'>"+item.title+"</p>" +"</div>"
		} else {
			div_item = "<div class='row grey-search' id='"+item.id+"'>"+"<img class='item-image' src='"+item.thumbnail+"'/>"+ "<p class='title'>"+item.title+"</p>" +"</div>"	
		}
		$("#result-conteiner").append(div_item);
	});

	$(".row").bind("click", function(){

				addGiftToEmployee(this);

				$(".modal-box, .modal-overlay").fadeOut(500, function() {
					$(".modal-overlay").remove();
				});
		});

};

function addGiftToEmployee(gift_div){

	// console.log("que esss"+gift_div);

	// var div_item = "<div class='row' id='"+item.id+"'>"+"<img class='item-image' src='"+item.thumbnail+"'/>"+ "<p class='title'>"+item.title+"</p>" +"</div>"
	$("#gift"+current_id).html($(gift_div).html());

};


function addGift(_this){
	// console.log("id button: " + $(_this).attr("id"));
	current_id = $(_this).attr("id");
	$( "#dialog" ).dialog({
      resizable: false,
      height:140,
      modal: true,
      buttons: {
        "Delete all items": function() {
          $( this ).dialog( "close" );
        },
        Cancel: function() {
          $( this ).dialog( "close" );
        }
      }
    });
};

function closePopup(){

	//cuando cierra popup

}