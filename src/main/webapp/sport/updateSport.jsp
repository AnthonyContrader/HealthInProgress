<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<html>

<head>

<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"

	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">




<%

	SportDTO updateSport = (SportDTO) request.getAttribute("sportUpdate");

%>

</head>



<body>

	<div class="center">



		<div class="pre_contenitore">



			<p>Sport Update</p>



		</div>

		<br>

		<br>

		<form method="POST" action="SportServlet?richiesta=update">


			<input type="hidden" name="idsport" value="<%=updateSport.getIdsport()%>" />

			<br>

			<br>
					
            nome: <input type="text" size="40" maxlength="40" name="nome" value="<%=updateSport.getNome()%>" />

			<br>

			<br>
			tipo: <input type="text" size="40" maxlength="40" name="tipo" value="<%=updateSport.getTipo()%>" />

			<br>

			<br>
            durata: <input type="text" size="40" maxlength="40" name="durata" value="<%=updateSport.getDurata()%>" />

			<br>

			<br>
			


			<input type="submit" value="Update">

			<br>

			<br>

			<a href="/JspApp/SportServlet?richiesta=SportManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>



		</form>



	</div>

</body>

</html>