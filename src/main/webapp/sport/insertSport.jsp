<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo Sport</title>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

</head>
<body>
	<div class="pre_contenitore">

		<p>New Sport</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/SportServlet?richiesta=insert">
		<br>
	    <br>
		Nome: <input type="" size="40" maxlength="40" name="nome" />
		<br>
		<br>
		tipo: <input type="" size="40" maxlength="40" name="tipo" />
		<br>
		<br>
		Durata: <input type="" size="40" maxlength="40" name="durata" />
		<br>
		<br>
		
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/SportServlet?richiesta=SportManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>