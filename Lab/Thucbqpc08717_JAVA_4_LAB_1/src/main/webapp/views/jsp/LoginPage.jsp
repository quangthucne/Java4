<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 20/11/24
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <title>Đăng nhập</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

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
    }
  </style>
</head>

<body>
<header></header>
  <main>
    <section class="bg-light">
      <div class="login-page bg-light">
        <div class="container">
          <div class="row">
            <div class="col-lg-10 offset-lg-1">
              <h1 class="mb-3 text-center text-warning">Đăng nhập</h1>
              <div class="bg-white shadow rounded">
                <div class="row">
                  <div class="col-md-7 pe-0">
                    <div class="form-left h-100 py-5 px-5">
                      <form action="${pageContext.request.contextPath}/"  method="post" class="row g-4">
                        <div class="col-12">
                          <label>Tên đăng nhập<span class="text-danger">*</span></label>
                          <div class="input-group">
                            <div class="input-group-text"><i
                                    class="bi bi-person-fill"></i>
                            </div>
                            <input type="text" class="form-control" name="username"
                                   placeholder="Enter Tên đăng nhập">
                          </div>
                        </div>

                        <div class="col-12">
                          <label>Mật khẩu<span class="text-danger">*</span></label>
                          <div class="input-group">
                            <div class="input-group-text"><i
                                    class="bi bi-lock-fill"></i>
                            </div>
                            <input type="password" class="form-control" name="password"
                                   placeholder="Nhập Mật khẩu">
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <div class="form-check">
                            <input class="form-check-input" type="checkbox"
                                   id="inlineFormCheck">
                            <label class="form-check-label"
                                   for="inlineFormCheck">Remember
                              me</label>
                          </div>
                        </div>

                        <div class="col-sm-6">
                          <a href="#" class="float-end text-warning">Forgot Mật khẩu?</a>
                        </div>

                        <div
                                class="col-12 d-flex justify-content-between align-items-center">
                          <button type="submit"
                                  class=" btn btn-warning px-4 float-end">Đăng
                            nhập</button>

                          <a href="${pageContext.request.contextPath}/register" class="btn btn-outline-warning">Đăng ký</a>

                        </div>
                      </form>
                    </div>
                  </div>
                  <div class="col-md-5 ps-0 d-none d-md-block">
                    <div class="form-right h-100 text-white text-center pt-5" id="logo">
                      <img src="${pageContext.request.contextPath}/views/img/bgdino.jpg" class="logo" alt="">
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

  <!-- Bootstrap JS -->

</body>

</html>
