<%@ page import="java.util.*" %>
<%@ page import="himedia.spring.ver2.dto.Member" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[search.jsp] 검색 결과</title>
</head>
<body>
	<h1>검색 결과</h1>
	<div>
		<span>아이디 : </span>
		<span>${member.id} : </span>
	</div>
	<div>
		<span>이름 : </span>
		<span>${member.name} : </span>
	</div>
</body>
</html>