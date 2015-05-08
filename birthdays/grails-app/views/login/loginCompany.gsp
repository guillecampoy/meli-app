<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Login de la Empresa</title>
<asset:stylesheet src="application.css"/>
</head>
<body onload="iniciar();">
<div class="container">
	<section id="content">
		<g:form controller="company" action="loginCompany">
			<h1>Login Empresa</h1>
			<div>
				<input type="text" placeholder="Nombre Empresa" required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" />
			</div>
			<div>
				<input type="submit" value="Ingresa" />
			<!--	<a href="#">Olvidaste tu password?</a>	-->

				<g:link controller="company" action="gotoCreateCompany">Registrarse</g:link>
			</div>
		</g:form><!-- form -->
		
	</section><!-- content -->
</div><!-- container -->
</body>

</html>

<script type="text/javascript">

var valor = false;

function iniciar() {
	if (${valor}) {
		alert("Te registraste correctamente, por favor logueate");
	}
	
}
</script>