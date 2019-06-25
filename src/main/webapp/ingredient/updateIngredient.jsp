<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

    <%@ page import="it.contrader.dto.IngredientDTO" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Ingredients UPDATE</title>



<%

	IngredientDTO ingredientUpdate = (IngredientDTO) request.getAttribute("ingredientUpdate");

%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<title>Update Ingredients</title>
<!-- Bootstrap CSS -->
<link href="/dash/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="/dash/css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="/dash/css/elegant-icons-style.css" rel="stylesheet" />
<link href="/dash/css/font-awesome.min.css" rel="stylesheet" />
<!-- full calendar css-->
<link
	href="/dash/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />
<link href="/dash/assets/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- easy pie chart-->
<link
	href="/dash/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="/dash/css/owl.carousel.css" type="text/css">
<link href="/dash/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
<!-- Custom styles -->
<link rel="stylesheet" href="/css/fullcalendar.css">
<link href="/dash/css/widgets.css" rel="stylesheet">
<link href="/dash/css/style.css" rel="stylesheet">
<link href="/dash/css/style-responsive.css" rel="stylesheet" />
<link href="/dash/css/xcharts.min.css" rel=" stylesheet">
<link href="/dash/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
<!-- =======================================================
    Theme Name: NiceAdmin
    Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->

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
      <form method="POST" action="/Ingredient/update">

			<input type="hidden" name="idIngredient" value="<%=ingredientUpdate.getIdIngredient()%>" />

			<table class="table">



			<tr>

				<td><b>Nome:</b></td>

				<td> <input type="text" size="40" maxlength="40" name="nome" value="<%=ingredientUpdate.getNome()%>" /></td>

			</tr>

		

			

			

			
			

			

			</table>

			<br>

			<br>

			<input class="btn btn-primary btn-lg btn-block" type="SUBMIT" value="Update">

		



			<br>

			<br>

			<a class="btn btn-primary btn-lg btn-block" href="/Ingredient/ingredientManagement">Back</a>



		</form>

        



      

    <!--main content end-->
