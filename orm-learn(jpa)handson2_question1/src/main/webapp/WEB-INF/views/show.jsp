<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Page</title>
</head>
<body>
<form action="displaycountry" name="form" modelAttribute="country" method="GET">
<table>
<tr>
	<td><label for="name">Enter country</label></td>
	<td><input type="text" name="name"/></td>
</tr>
<tr>
	<td><input type="submit" name="submit" value="Check"/></td>
</tr>
</table>

</form>
${country1}


<form action="displaysearch" name="form" modelAttribute="country" method="GET">
<table>
<tr>
	<td><label>Enter letter to check country name</label></td>
	<td><input type="text" name="name"/></td>
</tr>

<tr>
	<td><input type="submit" name="submit" value="Check"/></td>
</tr>
</table>
</form>
${country2}
</body>
</html>
