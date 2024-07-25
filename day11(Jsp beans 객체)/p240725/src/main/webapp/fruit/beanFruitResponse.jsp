<%@page import="simple.Fruit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beanFruitResponse.jsp</title>
</head>
<body>
	<h1>beanFruitResponse.jsp</h1>
	<h2>페이지 이동했습니다.</h2>
	
	<!-- [생성된 bean 사용] (request에서 생성된 빈 response에서 사용) -->
	<jsp:useBean id="fruit" class="simple.Fruit" scope="page" ></jsp:useBean>
	
	<!--[값 출력] -->
	<div>과일 종류 : <jsp:getProperty property = "sort" name = "fruit" /> </div>
	
	<!-- [getter 호출] -->]
	
	 

</body>
</html>