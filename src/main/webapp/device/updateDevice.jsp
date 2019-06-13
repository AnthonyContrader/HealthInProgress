<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<html>

<head>

<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"

	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">




<%

	DeviceDTO updateDevice = (DeviceDTO) request.getAttribute("deviceUpdate");

%>

</head>



<body>

	<div class="center">



		<div class="pre_contenitore">



			<p>Device Update</p>



		</div>

		<br>

		<br>

		<form method="POST" action="DeviceServlet?richiesta=update">


			<input type="hidden" name="iduser" value="<%=updateDevice.getIddevice()%>" />

			<br>

			<br>
					

			

			nome: <input type="text" size="40" maxlength="40" name="nome" value="<%=updateDevice.getNome()%>" />

			<br>

			<br>

			
			<input type="submit" value="Update">

			<br>

			<br>

			<a href="/JspApp/DeviceServlet?richiesta=DeviceManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>



		</form>



	</div>

</body>

</html>