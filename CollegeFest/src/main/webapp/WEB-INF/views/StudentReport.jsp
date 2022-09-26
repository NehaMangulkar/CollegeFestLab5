<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		<h1>Participants List</h1>
		<a href="addStudent" class="btn btn-primary"> Add Student </a>
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Student ID</th>
						<th scope="col">Name</th>
						<th scope="col">Department</th>
						<th scope="col">Country</th>
						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stud" items="${student}">
						<tr>
							<td class="table-plus">${stud.id}</td>
							<td>${stud.name}</td>
							<td>${stud.department}</td>
							<td>${stud.country}</td>
							
							<td><a href="editStudent/${stud.id}" class="btn btn-warning">
									Edit </a></td>
							<td><a href="deleteStudent/${stud.id}"
								class="btn btn-danger"> Delete </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
