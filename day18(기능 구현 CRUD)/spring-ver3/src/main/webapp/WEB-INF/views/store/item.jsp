<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<c:url var="staticUrl" value="/resources/"/>
<c:url var="context" value="/"/>

<!doctype html>
<html lang="ko" class="h-100" data-bs-theme="auto">
<head>
    <script src="${context}assets/js/color-modes.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="행복한 마켓입니다.">
    <title>행복한 마켓</title>
    <link href="${staticUrl}css/bootstrap.min.css" rel="stylesheet">
    <link href="${staticUrl}css/cover.css" rel="stylesheet">
</head>
<body>
    <!--START : HEADER-->
    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="${context}" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
                </a>
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="${context}" class="nav-link px-2 text-secondary">Home</a></li>
                    <li><a href="${context}store/items" class="nav-link px-2 text-white">상품 목록</a></li>
                    <li><a href="${context}store/items/add" class="nav-link px-2 text-white">상품 등록</a></li>
                </ul>
                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search" action="${context}store/items/search" method="get">
                    <input type="search" name="search" class="form-control form-control-dark text-bg-dark" placeholder="상품명 입력..." aria-label="Search">
                    <button type="submit" class="btn btn-warning">조회</button>
                </form>
            </div>
        </div>
    </header>

    <div class="container">
        <h2>상품 목록</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td><a href="${context}store/items/${item.id}">${item.id}</a></td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button class="btn btn-primary" onclick="location.href='${context}store/items/add'">상품 등록</button>
    </div>

    <!--START : FOOTER-->
    <footer class="py-3 text-bg-dark mt-auto">
        <ul class="nav justify-content-center pb-3 mb-3">
            <li class="nav-item"><a href="${context}" class="nav-link px-2 text-white">Home</a></li>
            <li class="nav-item"><a href="${context}store/items" class="nav-link px-2 text-white">상품 목록</a></li>
            <li class="nav-item"><a href="${context}store/items/add" class="nav-link px-2 text-white">상품 등록</a></li>
        </ul>
        <p class="text-center text-white">&copy; 2023 Company, Inc</p>
    </footer>
</body>
</html>
