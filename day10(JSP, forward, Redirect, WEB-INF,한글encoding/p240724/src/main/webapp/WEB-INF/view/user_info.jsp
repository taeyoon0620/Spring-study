<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_info.jsp</title>
</head>
<body>
	<h1>user_info.jsp</h1>
	<h2>페이지 이동되었습니다.</h2>
	<div>이름 : <%= request.getParameter("userName") %></div>
	<div>등급 : <%= request.getParameter("member") %></div>
	<div>encoding : <%= request.getCharacterEncoding() %></div>
</body>
</html>