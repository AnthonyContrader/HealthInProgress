<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert Parameter</title>

<meta charset="utf-8">


  <title>Insert Parameter</title>



  <!-- Bootstrap CSS -->


<body>

	  <!-- container section start -->

  <section id="container" class="">





    <header class="header dark-bg">

      <div class="toggle-nav">

        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>

      </div>



      <!--logo start-->

      <a href="/homeUser.jsp" class="logo">Healthinprogress</a>

      <!--logo end-->




                <a href="/User/logout"><i class="icon_key_alt"></i> Log Out</a>

           
          <div class="col-lg-12">

            <h3 class="page-header"><i class="fa fa-laptop"></i> Insert User</h3>

            <ol class="breadcrumb">

              <li><i class="fa fa-home"></i>Home</a></li>

              <li><i class="fa fa-laptop"></i>Insert Parameter</li>

            </ol>

          </div>

        </div>

        

        <div class="row">

        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

        		<form class="insert-form" action="/Parameter/insertParameter" method="post">

		<table>

			<tr>

				<td>Sesso</td><td><input type="text" name="sesso" placeholder="Sesso"></td>

			</tr>

			

			<tr>

				<td>Altezza</td><td><input type="text" name="altezza" placeholder="altezza"></td>

			</tr>
			
			<tr>

				<td>Eta</td><td><input type="text" name="altezza" placeholder="altezza"></td>

			</tr>
			
			<tr>

				<td>Peso</td><td><input type="text" name="altezza" placeholder="altezza"></td>

			</tr>
			
			<tr>

				<td>TotKcal</td><td><input type="text" name="altezza" placeholder="altezza"></td>

			</tr>
			

		</table>

		<br>

		<button class="btn btn-primary btn-lg btn-block" type="submit">Insert</button>

	</form>

	<br>

	<a class="btn btn-primary btn-lg btn-block" href="/Parameter/ParameterManagement">Back</a>

            </div>

        </div>



      </section>

    
</html>