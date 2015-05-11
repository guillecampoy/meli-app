<html lang="en">

<head>
<asset:javascript src="application.js"/>
<asset:stylesheet src="application.css"/>
</head>

<body>

	<div class="container">
		<section id="content">
			<h1>Empresa: ${company.nombre}</h1>
		</section>
	</div>	



	<div class="container">
		<section id="content">
			
			<label>Nomina de empleados de la empresa:</label>

			<g:each var="empleado" in="${company.employee}">
			    <p>${empleado.name}, ${empleado.lastName}</p> 
			</g:each>

		</section>
	</div>	

	<div class="container">
		<section id="content">


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

		</section>
	</div>	

</body>


<script>


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
