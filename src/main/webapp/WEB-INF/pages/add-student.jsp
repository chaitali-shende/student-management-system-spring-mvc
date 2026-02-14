<%@ page isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

<!-- Bootstrap CDN -->
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg mx-auto" style="max-width:500px;">

        <div class="card-header bg-primary text-white text-center">
            <h4 class="mb-0">Add Student</h4>
        </div>

        <div class="card-body">

            <form action="${pageContext.request.contextPath}/save" method="post">

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Course</label>
                    <input type="text" name="course" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Fees</label>
                    <input type="number" name="fees" class="form-control" required>
                </div>

                <div class="d-flex justify-content-between">

                    <a href="stud_list" class="btn btn-secondary">
                        Back
                    </a>

                    <button type="submit" class="btn btn-success">
                        Save Student
                    </button>

                </div>

            </form>

        </div>
    </div>

</div>

</body>
</html>