<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginRequest.jsp</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginResponse.jsp" method = "post">
		<div>
			<label>아이디 :</label>
			<input type= "text" name = "userId">
		</div>
		<div>
			<label>비밀번호 :</label>
			<input type= "password" name = "userPw">
		</div>
		<div>
			<input type = "submit" value ="전송">
		</div>
	</form>

</body>
</html>