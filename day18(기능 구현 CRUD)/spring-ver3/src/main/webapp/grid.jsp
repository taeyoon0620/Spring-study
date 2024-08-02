<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<c:url var="resPath" value="/resources/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grid</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
.col {
	background-color: #eee;
	border: 2px solid #fff;
}
</style>
</head>

<body>
	<!-- 컬럼 12개 -->
	<div class="container text-center">
		<div class="row">
			<div class="col">1</div>
			<div class="col">2</div>
			<div class="col">3</div>
			<div class="col">4</div>
			<div class="col">5</div>
			<div class="col">6</div>
			<div class="col">7</div>
			<div class="col">8</div>
			<div class="col">9</div>
			<div class="col">10</div>
			<div class="col">11</div>
			<div class="col">12</div>
		</div>
	</div>

	<!-- 컬럼3개 -->
	<div class="container text-center">
		<div class="row">
			<div class="col">1</div>
			<div class="col">2</div>
			<div class="col">3</div>
		</div>
	</div>

	<!-- 컬럼3개(2개지정) -->
	<div class="container text-center">
		<div class="row">
			<div class="col">1</div>
			<div class="col col-2">2</div>
			<div class="col">3</div>
		</div>
	</div>


	<!-- 기본 -->
	<div class="container text-center">
		<div class="row">
			<div class="col">1</div>
			<div class="col col-md">2</div>
			<div class="col">3</div>
		</div>
	</div>

	<!-- 기본 -->
	<div class="container text-center">
		<div class="row">
			<div class="col">1</div>
			<div class="col col-md-auto">AUTO</div>
			<div class="col">3</div>
		</div>
	</div>

	<!-- AUTO - 자동(공간 균등배분 ) -->

	<!-- 기본 -->
	<div class="container text-center">
		<div class="row">
			<div class="col">1</div>
			<div class="col col-md-auto">GOOD! GOOD! GOOD!</div>
			<div class="col">3</div>
		</div>
	</div>

</body>
</html>