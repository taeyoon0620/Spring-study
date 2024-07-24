<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardPage.jsp</title>
</head>
<body>
	<h1>forwardPage.jsp</h1>

	<div>포워딩된 페이지입니다.</div>
	<div>아이디는 <%= request.getParameter("user_id") %> 이고, 비밀번호는 <%= request.getParameter("user_pw") %> 이다.</div>
	
</body>
</html>