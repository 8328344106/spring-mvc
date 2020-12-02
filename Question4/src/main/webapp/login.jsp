<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>User Register</h2>	
<form action="login" method="post" modelAttribute="userlog">
<pre>
		
	Username: <input type="text" name="username" />
	
	Password: <input type="text" name="password" />

	<input type="submit" value="Login" />
</pre>
</form>

</body>
</html>