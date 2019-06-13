<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<html>

<head>

<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"

	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">




<%

	IngredientDTO updateIngredient = (IngredientDTO) request.getAttribute("ingredientUpdate");

%>

</head>



<body>

	<div class="center">



		<div class="pre_contenitore">



			<p>User Update</p>



		</div>

		<br>

		<br>

		<form method="POST" action="IngredientServlet?richiesta=update">


			<input type="hidden" name="idingredient" value="<%=updateIngredient.getIdingredient()%>" />

			<br>

			<br>
					

			

			Nome: <input type="text" size="40" maxlength="40" name="nome" value="<%=updateIngredient.getNome()%>" />

			<br>

			<br>


			<input type="submit" value="Update">

			<br>

			<br>

			<a href="/JspApp/IngredientServlet?richiesta=IngredientManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>



		</form>



	</div>

</body>

</html>