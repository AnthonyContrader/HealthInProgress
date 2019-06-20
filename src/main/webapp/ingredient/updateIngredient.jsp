<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    <%@ page import="it.contrader.dto.UserDTO" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Ingredients UPDATE</title>



<%

	IngredientDTO ingredientUpdate = (IngredientDTO) request.getAttribute("ingredient");

%>

<title>Update Ingredients</title>

</head>

<body>



 <!-- container section start -->

  <section id="container" class="">

<a href="/homeAdmin.jsp" class="logo">Healthinprogress</a>

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
      <form method="POST" action="/Ingredient/updateIngredient">

			<input type="hidden" name="id" value="<%=ingredientUpdate.getIdingredient()%>" />

			<table class="table">



			<tr>

				<td><b>Username:</b></td>

				<td> <input type="text" size="40" maxlength="40" name="username" value="<%=userUpdate.getUsername()%>" /></td>

			</tr>

			<tr>

				<td><b>Password:</b></td>

				<td> <input type="text" size="40" maxlength="40" name="password" value="<%=userUpdate.getPassword()%>" /></td>

			</tr>

			<tr>

					<td><b>Usertype:</b></td>

					<td> <input type="text" size="40" maxlenght="40" name="usertype" value=<%=userUpdate.getUsertype() %>></td>

			</tr>

			

			

			
			

			

			</table>

			<br>

			<br>

			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="Update">

		



			<br>

			<br>

			<a class="btn btn-primary btn-lg btn-block" href="/User/userManagement">Back</a>



		</form>

        



      

    <!--main content end-->
