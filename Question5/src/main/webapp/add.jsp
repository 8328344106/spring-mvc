<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<div align="center">
<form action="create" method="post" modelAttribute="employee"  style="border:1px; border-style:solid; border-color:black; padding: 1em; width:400px;">
<pre>
		
	Employee Name: <input type="text" name="employeeName" />
	
	Employee Department: <input type="text" name="employeeDepartment" />
	
	Employee Designation: <input type="text" name="employeeDesignation" />

	Employee Salary: <input type="number" name="employeeSalary" />
	
	<input type="submit" value="Create" />
</pre>
</form>
</div>
</body>
</html>