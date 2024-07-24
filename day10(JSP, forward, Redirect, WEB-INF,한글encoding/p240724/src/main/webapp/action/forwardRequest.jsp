<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardRequest.jsp</title>
</head>
<body>
	<h1>forwardRequests.jsp</h1>
	<form action="forwardResponse.jsp">
	<div>
		<label>아이디 : </label>
		<input type= "text" name="user_id">
	</div>
	
	<div>
		<label>비밀번호 : </label>
		<input type= "password" name="user_pw">
	</div>
	<div>
		<input type="submit" value="로그인">
	</div>
	
	</form>

</body>
</html>