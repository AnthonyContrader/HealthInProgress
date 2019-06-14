<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>

<html>

<head>

<title>Gestione Sport</title>

	<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"

	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

<style>

/*contenitore in cima dove c'è scritto "Login"*/

.pre_contenitore {

	width: 320px;

	margin: auto;

	height: 50px;

	border: 1px solid black;

	border-radius: 40px 40px 40px 40px;

	background-color: rgba(0, 0, 0, 0.9);

	box-shadow: 20px 30px 20px #000000;

	padding: 20px;

}



.pre_contenitore p {

	color: white;

	text-align: center;

	font-size: 1.9em;

	font-family: arial;

	line-height: 2px;

}

</style>

</head>

<%

	List<SportDTO> allSport = (List<SportDTO>) request.getAttribute("allSport");

%>



<body>



	<div>



		<p>Sport Management</p>



	</div>

	<br>







	<br />



	<table>

		<tr>

			<th>ID</th>

			<th>Nome</th>

			<th>Tipo</th>

			<th>Durata</th>

			<th>Update</th>

			<th>Delete</th>

		</tr>

		<%

			for (SportDTO sport : allSport) {

		%>

		<tr>

			<td><%=sport.getIdsport() %></td>

			<td><%=sport.getNome()%></td>

			<td><%=sport.getTipo()%></td>

			<td><%=sport.getDurata()%></td>

			<td><a href="SportServlet?richiesta=updateRedirect&id=<%=sport.getIdsport() %>">Update</a></td>

			<td><a href="SportServlet?richiesta=delete&id=<%=sport.getIdsport() %>" >Delete</a></td>

		</tr>

		<%

			}

		%>

	</table>

	

	<br>

	<a href="/JspApp/SportServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Sport</i></a>

	<br>	

	<a href="SportServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>





</body>

</html>