<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    <%@ page import="it.contrader.dto.UserDTO" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>PARAMETER UPDATE</title>



<%

	ParameterDTO parameterUpdate = (ParameterDTO) request.getAttribute("parameter");

%>

<title>Update Parameter</title>

</head>

<body>



 <!-- container section start -->

  <section id="container" class="">

<a href="/homeUser.jsp" class="logo">Healthinprogress</a>

      <!--logo end-->



      <div class="top-nav notification-row">

        <!-- notificatoin dropdown start-->

        <ul class="nav pull-right top-menu">

          <!-- user login dropdown start-->

          <li class="dropdown">

            <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                            <span class="username">${utenteCollegato}</span>

                            <b class="caret"></b>

                        </a>

            <ul class="dropdown-menu extended logout">

              <div class="log-arrow-up"></div>

              <li>

                <a href="/User/logout"><i class="icon_key_alt"></i> Log Out</a>

              </li>

            </ul>

          </li>

          <!-- user login dropdown end -->

        </ul>

        <!-- notificatoin dropdown end-->

      </div>
      <form method="POST" action="/Parameter/updateParameter">

			<input type="hidden" name="id" value="<%=parameterUpdate.getIdparameter()%>" />

			<table class="table">



			<tr>

				<td><b>Sesso:</b></td>

				<td> <input type="text" size="40" maxlength="40" name="sesso" value="<%=parameterUpdate.getSesso()%>" /></td>

			</tr>

			<tr>

				<td><b>Altezza:</b></td>

				<td> <input type="text" size="40" maxlength="40" name="altezza" value="<%=parameterUpdate.getAltezza()%>" /></td>

			</tr>

			<tr>

					<td><b>Eta:</b></td>

					<td> <input type="text" size="40" maxlenght="40" name="usertype" value=<%=parameterUpdate.getEta() %>></td>

			</tr>
			<tr>

					<td><b>TotKcal:</b></td>

					<td> <input type="text" size="40" maxlenght="40" name="" value=<%= %>></td>

			</tr>
			

			

			

			
			

			

			</table>

			<br>

			<br>

			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="Update">

		



			<br>

			<br>

			<a class="btn btn-primary btn-lg btn-block" href="/Parameter/parameterManagement">Back</a>



		</form>

        



      

    <!--main content end-->
