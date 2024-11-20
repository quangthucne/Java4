<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 14/11/24
  Time: 23:01
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
                <h2 class="text-center">Edit Address</h2>
            </div>
            <div class="card-body">
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/edit-address" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" name="customerName" id="name"
                               aria-describedby="helpId" placeholder="" value="${address.customerName}"/>
                    </div>
                    <div class="mb-3">
                        <label for="phoneNumber" class="form-label">Phone</label>
                        <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                               aria-describedby="helpId" placeholder="" value="${address.phoneNumber}"/>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" class="form-control" name="address" id="address"
                               aria-describedby="helpId" placeholder="" value="${address.address}"/>
                    </div>
                    <input type="text" hidden="hidden" name="userId" id="id" value="${address.user.id}" />
                    <input type="text" hidden="hidden" name="addressId" id="addressId" value="${address.id}" />
                    <button type="submit" class="btn btn-primary">
                        Edit
                    </button>
                    <a href="${pageContext.request.contextPath}" class="btn btn-outline-primary">Quay lại</a>
                </form>
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