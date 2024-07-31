<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:url var="staticUrl" value="/resources" />

<!doctype html>
<html lang="ko" class="h-100" data-bs-theme="auto">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="행복한 마켓입니다.">
	<title>행복한 마켓</title>
<!-- <link href="/ver3/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/ver3/resources/css/cover.css" rel="stylesheet"> -->
 	<link href="${staticUrl}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${staticUrl}/css/cover.css" rel="stylesheet"> 
	
</head>

<body class="d-flex h-100 text-center text-bg-dark">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="mb-auto">
			<div>
				<h3 class="float-md-start mb-0">Cover</h3>
				<nav class="nav nav-masthead justify-content-center float-md-end">
					<a class="nav-link fw-bold py-1 px-0 active" aria-current="page"
						href="#">Home</a> <a class="nav-link fw-bold py-1 px-0" href="#">Features</a>
					<a class="nav-link fw-bold py-1 px-0" href="#">Contact</a>
				</nav>
			</div>
		</header>

		<main class="px-3">
			<h1>행복한 마켓</h1>
			<p class="lead">행복한 마켓 방문을 환영합니다.</p>
			<p class="lead">
				<a href="#"
					class="btn btn-lg btn-light fw-bold border-white bg-white">상품 목록 이동</a>
			</p>
		</main>

		<footer class="mt-auto text-white-50">
			<p>
				Cover template for <a href="https://getbootstrap.com/"
					class="text-white">Bootstrap</a>, by <a
					href="https://twitter.com/mdo" class="text-white">@mdo</a>.
			</p>
		</footer>
	</div>
</body>
</html>
