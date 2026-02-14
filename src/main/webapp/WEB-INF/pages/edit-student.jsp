<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

<!-- Bootstrap -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg mx-auto" style="max-width:500px;">

        <div class="card-header bg-warning text-dark text-center">
            <h4 class="mb-0">Edit Student</h4>
        </div>

        <div class="card-body">

            <form action="${pageContext.request.contextPath}/update" method="post">

                <!-- ID (readonly) -->
                <div class="mb-3">
                    <label class="form-label">Student ID</label>
                    <input type="text"
                           name="id"
                           value="${student.id}"
                           class="form-control"
                           readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text"
                           name="name"
                           value="${student.name}"
                           class="form-control"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email"
                           name="email"
                           value="${student.email}"
                           class="form-control"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Course</label>
                    <input type="text"
                           name="course"
                           value="${student.course}"
                           class="form-control"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Fees</label>
                    <input type="number"
                           name="fees"
                           value="${student.fees}"
                           class="form-control"
                           required>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="stud_list" class="btn btn-secondary">Back</a>
                    <button type="submit" class="btn btn-warning">Update Student</button>
                </div>

            </form>

        </div>

    </div>

</div>

</body>
</html>