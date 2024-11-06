<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 5/11/24
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Quản lý người dùng</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css" />

</head>

<body>
<header>
    <!-- place navbar here -->

</header>
<main>
    <div class="container-fluid bg-body-s">
        <div class="container mt-4">
            <div class="mb-3">
                <a href="${pageContext.request.contextPath}/add" class="btn btn-primary">Add User</a>
            </div>
            <div class="card">
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-borderless table-primary align-middle"
                           id="myTable">
                        <thead class="table-light">
                        <tr>
                            <th>STT</th>
                            <th>Name</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach items="${userList}" var="user" varStatus="vs">
                                <tr class="table-body-light">
                                    <td scope="row">${vs.count}</td>
                                    <td>${user.name}</td>
                                    <td>${user.username}</td>
                                    <td>${user.email}</td>
                                    <td>${user.address}</td>
                                    <td class="d-flex justify-content-center align-items-center">
                                        <div class="mb-3">
                                            <a href="${pageContext.request.contextPath}/edit?id=${user.id}" class="btn btn-warning">Edit</a>
                                        </div>
                                        <div class="ms-1 ">
                                            <form action="${pageContext.request.contextPath}/delete" method="POST">
                                                <button class="btn btn-danger">Delete</button>
                                                <input type="text" hidden="hidden" name="id" value="${user.id}" />
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                        <tfoot>
                        </tfoot>
                    </table>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#myTable').DataTable({
            paging: true,
            ordering: true,
            info: true,
            language: {
                url: "//cdn.datatables.net/plug-ins/1.13.1/i18n/vi.json"
            }
        });
    });
</script>
</body>

</html>
