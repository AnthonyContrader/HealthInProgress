<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<title>Gestione DEVICE</title>


 <style>


body{
background-image:url('https://static.vecteezy.com/system/resources/previews/000/138/637/original/tecnologia-background-template-vector.jpg ')
</style>
</head>

<body>



</head>

<%

	List<DeviceDTO> allDevice = (List<DeviceDTO>) request.getAttribute("allDevice");

%>



<body>


<div class="container">
  <h2>GESTIONE DEVICE</h2>
	<table class="table table-dark table-hover">
    <thead>
      <tr>
			<th>ID</th>

			<th>Nome</th>

			<th>Update</th>

			<th>Delete</th>

		</tr>
</thead>


		<%

			for (DeviceDTO device : allDevice) {

		%>
		<tbody>
		<tr>

			<td><%=device.getIddevice() %></td>

			<td><%=device.getNome()%></td>


			<td><a href="DeviceServlet?richiesta=updateRedirect&id=<%=device.getIddevice() %>">Update</a></td>

			<td><a href="DeviceServlet?richiesta=delete&id=<%=device.getIddevice() %>" >Delete</a></td>

		</tr>

		<%

			}

		%>

	</table>

	

	<br>

	<a href="/JspApp/DeviceServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Device</i></a>

	<br>	

	<a href="DeviceServlet?richiesta=home.jsp"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>





</body>

</html>