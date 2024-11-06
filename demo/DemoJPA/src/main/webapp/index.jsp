<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"/>
</head>
<body>
<main>
    <form action="${pageContext.request.contextPath}/form" method="post">
        <div class="container">
            <div class="m-3">
                <h3 class="text-center">Đăng kí</h3>
            </div>

            <div class="mb-3">
                <label for="" class="form-label">Username</label>
                <input type="text" class="form-control" name="username"
                       placeholder="Username"/>
            </div>


            <div class="mb-3">
                <label for="" class="form-label">Password</label>
                <input type="text" class="form-control" name="password"
                       placeholder="password"/>
            </div>

            <div class="mb-3">
                <label for="" class="form-label">Name</label>
                <input type="text" class="form-control" name="name"
                       placeholder="Fullname"/>

            </div>

            <div class="mb-3">
                <label for="" class="form-label">Email</label>
                <input type="email" class="form-control" name="email"
                       placeholder="abc@mail.com"/>
            </div>

            <div class="mb-3">
                <label for="" class="form-label">Address</label>
                <textarea class="form-control" name="address" rows="3"></textarea>
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-primary">
                    Đăng kí
                </button>
            </div>
        </div>
    </form>
</main>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>
</html>