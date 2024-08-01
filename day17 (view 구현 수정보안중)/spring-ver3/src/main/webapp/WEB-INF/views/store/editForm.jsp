<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<c:url var="resPath" value="/resources/" />
<c:url var="context" value="/" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>상품 수정 폼</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <!--START : HEADER-->
  <header class="p-3 text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"> <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
            <use xlink:href="#bootstrap" />
          </svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="#" class="nav-link px-2 text-white">상품 목록</a></li>
          <li><a href="#" class="nav-link px-2 text-white">상품 등록</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
        </form>

        <div class="text-end">
          <button type="button" class="btn btn-outline-light me-2">Login</button>
          <button type="button" class="btn btn-warning">Sign-up</button>
        </div>
      </div>
    </div>
  </header>

  <!--START : CONTAINER-->
  <div class="container" style="max-width: 600px;">
    <div class="py-5 text-center">
      <h2>상품 수정 폼</h2>
    </div>



     <form action="${context}store/items/1/edit" method="post">
    <div class="row">
      <div class="col-2 fw-bolder">
        <label for="id" class="form-label">상품 ID</label>
      </div>
      <div class="col">
        <input type="text" id="id" name="id" class="form-control" value="1">
      </div>
    </div>

    <div class="row my-2">
      <div class="col-2 fw-bolder">
        <label for="name" class="form-label">상품명</label>
      </div>
      <div class="col">
        <input type="text" id="name" name="name" class="form-control" value="감자깡" >
      </div>
    </div>

    <div class="row my-2">
      <div class="col-2 fw-bolder">
        <label for="price" class="form-label">가격</label>
      </div>
      <div class="col">
        <input type="text" id="price" name="price" class="form-control" value="1000">
      </div>
    </div>

    <div class="row my-2">
      <div class="col-2 fw-bolder">
        <label for="quantity" class="form-label">수량</label>
      </div>
      <div class="col">
        <input type="text" id="quantity" name="quantity" class="form-control" value="100">
      </div>
    </div>

    <hr class="my-4">

    <div class="row">
      <div class="col">
        <button type="button" class="btn btn-outline-dark w-100 btn-lg" 
        onclick="">취소</button>
      </div>
      <div>
        <button type="submit" class="btn btn-secondary w-100 btn-lg" 
        >저장</button>
      </div>
    </div>
    </form>
  </div>

  <!-- START : FOOTER -->
  <footer class="py-3 my-4 text-bg-dark">
    <ul class="nav justify-content-center pb-3 mb-3">
      <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Home</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Features</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-white">About</a></li>
    </ul>
    <p class="text-center text-white">&copy; HIMEDIA, Inc</p>
  </footer>
</body>
</html>
