<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Alta de Usuario</title>
<asset:stylesheet src="application.css"/>
</head>
<body>
<div class="container">
	<section id="content">
		<g:form controller="usuario" action="createUsuario">
			<h1>Alta de Usuario</h1>
			<div>
				<input type="text" placeholder="Nombre del Usuario" required="" id="userName" name="userName"/>
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" name="password" />
			</div>


			<div>
			<label>Selecciona una Empresa de la lista</label>
				<g:select optionKey="id" optionValue="nombre"  noSelection="${['null':'Seleccione uno...']}"
        				  name="idCompany" from="${companies}" />
			</div>

</br>

			<div>
				<label>Selecciona un rol para el usuario</label> </br>
				<g:select optionKey="id" optionValue="tipo"  noSelection="${['null':'Seleccione uno...']}"
        				  name="rol" from="${roles}" />
			</div>



			<div>
				<input type="submit" value="Crear Usuario" />
			</div>
		</g:form><!-- form -->



<g:hasErrors bean="${usuario}">
  <ul>
   <g:eachError var="err" bean="${usuario}">
       <li><g:message error="Ya existe un usuario con ese nombre" /></li>
   </g:eachError>
  </ul>
</g:hasErrors>
		


	</section><!-- content -->
</div><!-- container -->
</body>
</html>
