<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 6/11/24
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit User</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>

<body>
<header>
    <!-- place navbar here -->
</header>
<main>
    <div class="container mt-4">
        <div class="card">
            <c:if test="${message != null}">
                <c:choose>
                    <c:when test="${message[1] == 1}">
                        <div class="alert alert-success">
                                ${message[0]}
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-danger">
                                ${message[0]}
                        </div>
                    </c:otherwise>
                </c:choose>

            </c:if>
            <div class="header">
                <h2 class="text-center">Thêm người dùng</h2>
            </div>
            <div class="card-body">
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/edit">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" name="name" placeholder id="name"
                               aria-describedby="helpId" placeholder="" value="${user.name}" />
                    </div>
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" name="username" id="username"
                               aria-describedby="helpId" placeholder="" value="${user.username}"/>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password"
                               aria-describedby="helpId" placeholder="" value="${user.password}"/>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" name="email" id="email" aria-describedby="helpId"
                               placeholder="" value="${user.email}"/>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" class="form-control" name="address" id="address"
                               aria-describedby="helpId" placeholder="" value="${user.address}"/>
                    </div>
                    <input type="text" name="id" hidden="hidden" value="${user.id}"/>
                    <input type="text" name="role" hidden="hidden" value="${user.role}"/>
                    <button type="submit" class="btn btn-primary">
                        Edit
                    </button>
                </form>

            </div>
        </div>
    </div>
    </div>
    </div>
</main>
<footer>
    <!-- place footer here -->
</footer>
<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>
