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
</body>
</html>
