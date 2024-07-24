<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RedirectTwoResponse.jsp</title>
</head>
<body>
	<h1>[가입완료]RedirectTwoResponse.jsp</h1>
	<h2>페이지 이동했습니다.</h2>

	<div>
	<%
	
	if(!request.getParameter("userId").isEmpty()) {
		response.sendRedirect("RedirectTwoRequest.jsp");
	}
	
	%>
	</div>

</body>
</html>