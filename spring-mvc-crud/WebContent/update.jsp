<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update</title>
</head>
<body>
	<p><strong>Update Here | <a href="../read">Click for Read</a></strong></p>
<form action="../update" method="post">
<pre>
<c:forEach var="student" items="${listStudent}">
		
EmployeeId:    	<input type="text" name="dispemployeeId" value="${student.employeeId}" disabled="disabled"/>
		<input type="hidden" name="employeeId" value="${student.employeeId}"/>			
EmployeeName:  	<input type="text" name="employeeName" value="${student.employeeName}" />
		
EmployeeDepartment: 	<input type="text" name="employeeDepartment" value="${student.employeeDepartment}" />
	    
EmployeeDesignation:	<input type="text" name="employeeDesignation" value="${student.employeeDesignation}" />

EmployeeSalary:	<input type="text" name="employeeSalary" value="${student.employeeSalary}" />
		    
        <input type="submit" value="Update" />	
</c:forEach>	
</pre>
</form>
${msg}
</body>
</html>