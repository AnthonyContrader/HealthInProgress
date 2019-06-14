<%@ page import="it.contrader.dto.*"%>

<%@ page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>

<html>

<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Home Admin</title>


 <style>


body{
background-image:url('https://i.ytimg.com/vi/1ZYbU82GVz4/maxresdefault.jpg')
</style>
</head>

<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="#">ADMIN</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  
    <ul class="navbar-nav">
      <li class="nav-item">
		<a class="nav-link"  href="UserServlet?richiesta=UserManager">User Management </a>
	 </li>
	 <li class="nav-item">
	
		<a class="nav-link" href="DeviceServlet?richiesta=DeviceManager">Device Management </a>

		</li>
		<li class="nav-item"> 
		 
		<a class="nav-link" href="IngredientServlet?richiesta=IngredientManager">Ingredient Management</a>
      </li>    
      <li class="nav-item">
		 <ul class="nav navbar-nav navbar-right">
		<a class="nav-link" href="index.jsp"> Logout </a> </a>
		 </ul>
      </li> 
    </ul>
 
  </div>  
</nav>
<br>
	</div>

</body>

</html>