<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Alta de Empresa</title>
<asset:stylesheet src="application.css"/>
</head>
<body>
<div class="container">
	<section id="content">
		<g:form controller="company" action="createCompany">
			<h1>Alta de Empresa</h1>
			<div>
				<input type="text" placeholder="Nombre de la Empresa" required="" id="nombre" name="nombre"/>
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" name="password" />
			</div>

			<div>
				<input type="submit" value="Crear Empresa" />
			</div>
		</g:form><!-- form -->



<g:hasErrors bean="${company}">
  <ul>
   <g:eachError var="err" bean="${company}">
       <li><g:message error="Ya existe una empresa con ese nombre" /></li>
   </g:eachError>
  </ul>
</g:hasErrors>
		


	</section><!-- content -->
</div><!-- container -->
</body>
</html>