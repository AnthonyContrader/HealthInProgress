<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<html>

<head>

<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"

	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">




<%

	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");

%>

</head>



<body>

	<div class="center">



		<div class="pre_contenitore">



			<p>User Update</p>



		</div>

		<br>

		<br>

		<form method="POST" action="UserServlet?richiesta=update">


			<input type="hidden" name="iduser" value="<%=updateUser.getIduser()%>" />

			<br>

			<br>
					

			

			Username: <input type="text" size="40" maxlength="40" name="nome" value="<%=updateUser.getNome()%>" />

			<br>

			<br>

			User type: <input type="text" size="40" maxlength="40" name="tipo" value="<%=updateUser.getTipo()%>" />

			<br>

			<br>

			Password: <input type="text" size="40" maxlength="40" name="password" value="<%=updateUser.getPassword()%>" />

			<br>

			<br>


			<input type="submit" value="Update">

			<br>

			<br>

			<a href="/JspApp/UserServlet?richiesta=UserManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>



		</form>



	</div>

</body>

</html>