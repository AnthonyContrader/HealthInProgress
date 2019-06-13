<html>

<head>

<title>Login</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">


</head>

<body>



	<div class="pre_contenitore">

		<p>Login</p>

	</div>

	<div class="contenitore">

		<form action="LoginServlet" method="post">

			<p>Enter your login details</p>

			<p>

				<br>

				<label>Username</label>

				<br>

				<input type="text" name="nome" id="nome" class="nome" placeholder="nome">

			</p>

			<p>

				<label>Password</label>

				<br>

				<input type="Password" name="password" id="password" class="password" placeholder="Password">

			</p>

			<h3><font color="red" name="error">${error}</font></h3>

			<button type="submit" value="Login" class="btn btn-warning">Sign in</button>

	  

		</form>

	</div>



</body>

</html>