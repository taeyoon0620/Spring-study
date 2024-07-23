<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz05</title>
</head>
<body>
	<form action="quiz05_response.jsp">
		<div>
			<label for="user_name">이름 : </label> <input type="text"
				name="user_name" id="user_name">
		</div>
		<div>
			<div>당신의 혈액형은?</div>
			<div>
				<input type="radio" name="bloodtype" value="A">A형 <input
					type="radio" name="bloodtype" value="B">B형 <input
					type="radio" name="bloodtype" value="AB">AB형 <input
					type="radio" name="bloodtype" value="O">O형
			</div>
		</div>
		<input type="submit" value="보내기">
	</form>

</body>
</html>