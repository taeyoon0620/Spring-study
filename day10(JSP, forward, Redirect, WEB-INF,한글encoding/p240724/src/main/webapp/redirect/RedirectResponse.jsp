<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RedirectResponse.jsp</title>
</head>
<body>
	<h1>RedirectResponse.jsp</h1>
	<% System.out.println("** Redirect 메서드 실행 전 **"); %>
	<%
	String userName = request.getParameter("userName");
	if(userName.isEmpty()) {
		response.sendRedirect("RedirectNoname.jsp");
		//response.sendRedirect("/WEB-INF/view/user_info.jsp");
	}
	
	// 요청에대한 응답을 다시 받아야하기때문에 RESPONSE를 사용한다 REQUEST대신
	%>
	
	<div> <%= userName %> 님, 환영합니다.</div>
	
	
	<% System.out.println("** Redirect 메서드 실행 후 **"); %>
	
</body>
</html>