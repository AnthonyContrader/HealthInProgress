<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo Parametro</title>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

</head>
<body>
	<div class="pre_contenitore">

		<p>New Device</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/ParametersServlet?richiesta=insert">
		<br>
	    <br>
		Sesso: <input type="" size="40" maxlength="40" name="sesso" />
		<br>
		<br>
		Altezza: <input type="" size="40" maxlength="40" name="altezza" />
		<br>
		<br>
		Peso: <input type="" size="40" maxlength="40" name="peso" />
		<br>
		<br>
		Eta: <input type="" size="40" maxlength="40" name="eta" />
		<br>
		<br>
		Polso: <input type="" size="40" maxlength="40" name="polso" />
		<br>
		<br>
		FreqResp: <input type="" size="40" maxlength="40" name="freqResp" />
		<br>
		<br>
		TempCorp: <input type="" size="40" maxlength="40" name="tempCorp" />
		<br>
		<br>	
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/ParametersServlet?richiesta=ParametersManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>