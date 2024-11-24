<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 24/11/24
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">

<head>
  <title>Đăng ký</title>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <style>
    a {
      text-decoration: none;
    }

    .login-page {
      width: 100%;
      height: 100vh;
      display: inline-block;
      display: flex;
      align-items: center;
    }

    .form-right i {
      font-size: 100px;
    }

    .logo {
      width: 100%;
    }

    #logo {
      background-color: #ffa800;
      align-items: center;
    }
  </style>
</head>

<body>
<header>
  <!-- place navbar here -->
</header>
<main>
  <section class="bg-light">
    <div class="login-page bg-light">
      <div class="container">
        <div class="row">
          <div class="col-lg-10 offset-lg-1">
            <h1 class="mb-3 text-center text-warning">Đăng ký</h1>
            <div class="bg-white shadow rounded">
              <div class="row">
                <div class="col-md-5 ps-0 d-none d-md-block">
                  <div class="form-right h-100 d-flex text-white text-center pt-5 align-items-center"
                       id="logo">
                    <img src="${pageContext.request.contextPath}/views/img/bgdino.jpg" class="logo align-middle" alt="">
                  </div>
                </div>
                <div class="col-md-7 pe-0">
                  <div class="form-left h-100 py-5 px-5">
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
                    <form action="${pageContext.request.contextPath}/register" method="post" class="row g-4">
                      <div class="col-12">
                        <label>Họ tên<span class="text-danger">*</span></label>
                        <div class="input-group">
                          <div class="input-group-text"><i class="bi bi-person-fill"></i>
                          </div>
                          <input type="text" class="form-control" name="name"
                                 placeholder="Nhập họ tên">
                        </div>
                      </div>
                      <div class="col-12">
                        <label>Email<span class="text-danger">*</span></label>
                        <div class="input-group">
                          <div class="input-group-text"><i class="bi bi-person-fill"></i>
                          </div>
                          <input type="text" class="form-control" name="email"
                                 placeholder="Nhập email">
                        </div>
                      </div>
                      <div class="col-12">
                        <label>Tên đăng nhập<span class="text-danger">*</span></label>
                        <div class="input-group">
                          <div class="input-group-text"><i class="bi bi-person-fill"></i>
                          </div>
                          <input type="text" class="form-control" name="username"
                                 placeholder="Nhập Tên đăng nhập">
                        </div>
                      </div>

                      <div class="col-12">
                        <label>Mật khẩu<span class="text-danger">*</span></label>
                        <div class="input-group">
                          <div class="input-group-text"><i class="bi bi-lock-fill"></i>
                          </div>
                          <input type="password" class="form-control" name="password"
                                 placeholder="Nhập Mật khẩu">
                        </div>
                      </div>

                      <div class="col-12">
                        <label>Xác nhận mật khẩu<span class="text-danger">*</span></label>
                        <div class="input-group">
                          <div class="input-group-text"><i class="bi bi-lock-fill"></i>
                          </div>
                          <input type="password" class="form-control" id="confirm"
                                 placeholder="Nhập lại mật khẩu">
                        </div>
                      </div>

                      <div class="col-12 d-flex justify-content-between align-items-center">
                        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-warning">Đăng nhập</a>
                        <button type="submit" class=" btn btn-warning px-4 float-end">Đăng
                          ký</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
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