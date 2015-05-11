<head>
<asset:javascript src="application.js"/>
</head>

<body>

<label>Busca Empleados por el Nombre a traves de un servicio REST</label>
<br>
	
	<input type="text" id="nombre" name="nombre" value=""/> 
	<input type="button" name="Submit" value="Buscar" onclick="enviar();"/>


<div id ="contenedor">
</div>
<br>
</br>
</br>
</br>
</br>
<label>Formulario de alta por REST</label>
	<br>
	<br>
	<g:form>
		<label>Datos del empleado</label>
		<br>
		<br>
		<label>Nombre:</label>
		<g:field type="text" name="name"/>
		<br>
		<label>Apellido:</label>
		<g:field type="text" name="lastname"/>
		<br>
		<label>Fecha de nacimiento</label>
		<g:datePicker precision="day" name="birthday"/>
		<br>
		<br>
		<g:field type="submit" name="confirmar" value="Guardar" onclick="guardar();"/>
	</g:form>
</body>


<script>

(function() {
  alert('hola')
});


function enviar(){
	console.log("enviar");
	var nombre = $("#nombre").val();

	console.log("nombre", nombre);

	var request = $.ajax({
  		url: "${createLink(controller: "empleados", action: "search")}",
		data: { name: nombre }
	});
 
	request.done(function( data ) {
		console.log("done", data);
		var str

			$("#contenedor").empty();
			data.forEach(function(item) {
				str = item.name + " " + item.lastName + " " + "<br>";
				$("#contenedor").append(str);
			})
	});
 
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});
}
</script>
</html>
