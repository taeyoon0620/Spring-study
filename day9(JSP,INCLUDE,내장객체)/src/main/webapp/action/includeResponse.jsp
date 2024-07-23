<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includeResponse.jsp</title>

<style type="text/css">
	.bg2 {background-color: #ff0;}
</style>

</head>
<body class="bg2">
	<h1>includeResponse.jsp 페이지입니다</h1>
	<div>
		<% String user_name = request.getParameter("user_name"); %>
		<h2>includeResponse.jsp 페이지 상단입니다.</h2>
		
		<div> <%= user_name %> 님, 반갑습니다. </div>
		
		<!-- include 지시자 -->
		<%-- <%@ include file="includeSub.jsp" %> --%>
		
		<%-- 액션태그 : include --%>
		<jsp:include page="includeSub.jsp" />

		<h2>includeResponse.jsp 페이지 하단입니다.</h2>
	</div>
</body>
</html>