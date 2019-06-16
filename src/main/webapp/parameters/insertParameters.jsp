<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>aggiunto nuovo parametro</title>

 <script>
            
            function calc()
            {
            	var n1 =document.getElementById('n1').value;
                var n2 = parseFloat(document.getElementById('n2').value);
                var n3 = parseFloat(document.getElementById('n3').value);
                var n4 = parseFloat(document.getElementById('n4').value);
                
                if(n1 === 'Maschio')
                {
                    document.getElementById('result').value =(66.5+(13.8*n3)+(5*n2)-(6.5*n4));
                }
                
                if(n1 === 'Femina')
                {
                    document.getElementById('result').value = (655.1+(9.6*n3)+(1.9*n2)-(4.7*n4));
                }
 
      
            }
            
        </script>
        
        
</head>
<body>
	<div class="pre_contenitore">

		<p>aggiunto nuovo parametro</p>

	</div>

	<br>
	<br>
	<form method="POST" action="/JspApp/ParametersServlet?richiesta=insert">
		<br>
	    <br>
	    Sesso:
	    <select  id="n1" name ="sesso">
            <option value="Maschio">Maschio</option>
            <option value="Femina">Femina</option>
        </select>
		<br>
		<br>
		Altezza: <input type="text" size="40" maxlength="40" name="altezza" id ="n2" class="rightAligned"/>
		<br>
		<br>
		Peso: <input type="text" size="40" maxlength="40" name="peso" id ="n3" class="rightAligned"/>
		<br>
		<br>
		Eta: <input type="text" size="40" maxlength="40" name="eta"  id ="n4"class="rightAligned"/>
		<br>
		<br>
		Polso: <input type="text" size="40" maxlength="40" name="polso" id ="n5"class="rightAligned" />
		<br>
		<br>
		FreqResp: <input type="text" size="40" maxlength="40" name="freqResp" id ="n6"class="rightAligned"/>
		<br>
		<br>
		TempCorp: <input type="text" size="40" maxlength="40" name="tempCorp" id="n7"class="rightAligned"/>
		<br>
		<br>	
		<input type="SUBMIT" value="ADD">
	
	</form>
	
	<br>
		<button onclick="calc();">calc kcal</button>
        <input type="text" id="result"/>
   	    <br>

	
</body>
</html>