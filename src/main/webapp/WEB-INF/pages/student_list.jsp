<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />

<div class="container">
	<br>
	<br>
	<h2 class="text-center text-primary">Student List</h2>

	<a href="add" class="btn btn-success mb-3">Add Student</a>

	<c:choose>

		<c:when test="${!empty studData.getContent()}">

			<table class="table table-bordered table-striped">

				<tr class="table-dark">
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Course</th>
					<th>Fees</th>
					<th>Actions</th>
				</tr>

				<c:forEach var="stud" items="${studData.getContent()}">
					<tr>
						<td>${stud.id}</td>
						<td>${stud.name}</td>
						<td>${stud.email}</td>
						<td>${stud.course}</td>
						<td>${stud.fees}</td>
						<td><a class="btn btn-warning btn-sm"
							href="edit?num=${stud.id}">Edit</a> <a
							class="btn btn-danger btn-sm" onclick="return confirm('Are you really want to Delete?')"
							href="delete?num=${stud.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</table>

			<!-- Pagination -->

			<div class="text-center">

				<c:if test="${studData.hasPrevious()}">
					<a class="btn btn-primary btn-sm"
						href="stud_list?page=${studData.getPageable().getPageNumber()-1}">Previous</a>&nbsp;&nbsp;
</c:if>

				<c:if test="${studData.isFirst()}">
					<a class="btn btn-primary btn-sm" href="stud_list?page=0">First</a>&nbsp;&nbsp;
</c:if>

				<c:forEach var="i" begin="1" end="${studData.getTotalPages()}"
					step="1">
					<a class="btn btn-primary btn-sm" href="stud_list?page=${i-1}">${i}</a>&nbsp;&nbsp;
</c:forEach>

				<c:if test="${studData.isLast()}">
					<a class="btn btn-primary btn-sm"
						href="stud_list?page=${studData.getTotalPages()-1}">Last</a>&nbsp;&nbsp;
</c:if>

				<c:if test="${studData.hasNext()}">
					<a class="btn btn-primary btn-sm"
						href="stud_list?page=${studData.getPageable().getPageNumber()+1}">Next</a>
				</c:if>
			</div>
</div>

</c:when>

<c:otherwise>
	<h3 class="text-danger text-center">No Records Found</h3>
</c:otherwise>

</c:choose>

<c:if test="${!empty resultMsg}">
	<h4 class="text-success text-center">${resultMsg}</h4>
</c:if>
<br>
<br>

</div>
