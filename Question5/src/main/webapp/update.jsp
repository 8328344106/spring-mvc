<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update</title>
</head>
<body>
<form action="Question5/update" method="post">
<pre>
<c:forEach var="student" items="${listStudent}" modelAttribute="employee"  style="border:1px; border-style:solid; border-color:black; padding: 1em; width:400px;">
		
Employee Id:    	<input type="text" name="employeeId" value="${student.employeeId}" disabled="disabled"/>
		<input type="hidden" name="employeeId" value="${student.employeeId}"/>	
				
Employee Name:  	<input type="text" name="employeeName" value="${student.employeeName}" />
		
Employee Department: 	<input type="text" name="employeeDepartment" value="${student.employeeDepartment}" />
	    
Employee Designation:	<input type="text" name="employeeDesignation" value="${student.employeeDesignation}" />

Employee Salary:	<input type="text" name="employeeSalary" value="${student.employeeSalary}" />
		    
        <input type="submit" value="Update" />	
</c:forEach>	
</pre>
</form>
${msg}
</body>
</html>