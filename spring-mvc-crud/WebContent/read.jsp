<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Read</title>
</head>
<body>
	<p><strong>Employee List is Here | <a href="create.jsp">Click for Create</a></strong></p>
	<table border="1">
		<tr>
			<th>EmployeeId</th>
			<th>EmployeeName</th>
			<th>EmployeeDepartment</th>
			<th>EmployeeDesignation</th>
			<th>EmployeeSalary</th>
			<th>Action</th>
		</tr>
		<c:forEach var="student" items="${listStudent}">
			<tr>
				<td>${student.employeeId}</td>
				<td>${student.employeeName}</td>
				<td>${student.employeeDepartment}</td>
				<td>${student.employeeDesignation}</td>
				<td>${student.employeeSalary}</td>
				<td><a href="update/<c:out value='${student.employeeId}'/>">Update</a> | <a
					href="delete/<c:out value='${student.employeeId}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>