<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz04</title>
</head>
<body>
	<h1> 문자열 반복하기</h1>
	<form method="post" action="quiz04_response.jsp">
		<div>
			<label>반복하고 싶은 문구 :  </label>
			<input type="text" id="message" name="message" size="20">
		</div>
		<div>
			<label>반복하고 싶은 횟수 :  </label>
			<input TYPE="text" NAME="number">
		</div>
		<input type="submit" value="보내기">
	</form>
</body>
</html>