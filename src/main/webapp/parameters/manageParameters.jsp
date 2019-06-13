<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>

<html>

<head>

<title>Gestione Parametri</title>

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

	List<ParametersDTO> allParameters = (List<ParametersDTO>) request.getAttribute("allParameters");

%>



<body>



	<div>



		<p>Parameters Management</p>



	</div>

	<br>







	<br />



	<table>

		<tr>

			<th>IdParameter</th>

			<th>Sesso</th>

			<th>Altezza</th>

			<th>Peso</th>
			
			<th>Età</th>
			
			<th>Polso</th>
			
			<th>FreqR</th>
			
			<th>TempC</th>
			

		</tr>

		<%

			for (ParametersDTO parameters : allParameters) {

		%>

		<tr>
			<td><%=parameters.getIdParameter()%></td>

			<td><%=parameters.getSesso()%></td>
			
			<td><%=parameters.getAltezza()%></td>
			
			<td><%=parameters.getPeso()%></td>
			
			<td><%=parameters.getEta()%></td>
			
			<td><%=parameters.getPolso()%></td>
			
			<td><%=parameters.getFreqResp()%></td>
			
			<td><%=parameters.getTempCorp()%></td>


			<td><a href="ParametersServlet?richiesta=updateRedirect&id=<%=parameters.getIdParameter()%>">Update</a></td>

			<td><a href="ParametersServlet?richiesta=delete&id=<%=parameters.getIdParameter()%>" >Delete</a></td>

		</tr>

		<%

			}

		%>

	</table>

	

	<br>

	<a href="/JspApp/ParametersServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Parameters</i></a>

	<br>	

	<a href="ParametersServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>





</body>

</html>