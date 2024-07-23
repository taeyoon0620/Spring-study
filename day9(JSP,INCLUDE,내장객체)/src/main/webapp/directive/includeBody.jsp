<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>    
<meta charset="UTF-8">
<title>includeBody.jsp</title>
<style type="text/css">
	.content {background-color: #aaa;}]
</style>
</head>
<body>
	<h1>include 지시자</h1>
	<%@ include file="includeTop.jsp" %>
	
	<div>Body입니다!</div>
	<input type="button" value="이동1" 
		onclick= "location.href='includeSub.jsp'">
		
	<input type="button" value="이동2"
		onclick="window.open('includeSub.jsp')">
			
	<ul>
		<li onclick="location.href='includeSub.jsp'">이동</li>
	</ul>
	
	<%@ include file="includeBottom.jsp" %>
</body>
</html>