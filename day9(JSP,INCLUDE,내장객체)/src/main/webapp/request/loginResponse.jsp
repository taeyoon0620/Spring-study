<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginResponse.jsp</title>
</head>
<body>

	<%
	String userId = request.getParameter("userId");
	%>
	
	<h1>로그인 성공!!</h1>
	<h2>페이지 이동 되었습니다!</h2>
	
	<div>
	입력된 아이디는 <%= userId %> 이고, 
	비밀번호 <%= request.getParameter("userPw") %> 입니다.
	</div>
	
	<div>입력된 아이디는 ${param.userId}이고, 
		 비밀번호는 ${param.userPw}입니다. </div>

</body>
</html>