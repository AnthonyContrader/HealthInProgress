<html>

<head>

<title>Login</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

 <style>


body{
background-image:url('https://i.ytimg.com/vi/1TCC-DjkKOQ/maxresdefault.jpg')
</style>
</head>

<body>


<div class="contenitore">

		<form action="LoginServlet" method="post">

	
<div class="container h-80">
<div class="row align-items-center h-100">
    <div class="col-3 mx-auto">
        <div class="text-center">
            <img id="profile-img" class="rounded-circle profile-img-card" src="http://vignette3.wikia.nocookie.net/littlemix/images/3/30/Mixers-salute-logo.png/revision/latest?cb=20131222041511" />
            <p id="profile-name" class="profile-name-card"></p>
            <form  class="form-signin">

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