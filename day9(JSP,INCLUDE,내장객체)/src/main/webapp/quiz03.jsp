<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz03</title>
</head>
<body>
	<form action="quiz03_response.jsp">
		<div>
			<label for = "user_name">이름 : </label>
			<input type="text" name="user_name" id="user_name">
		</div>
		<div>
			<div>아래에서 취미를 선택하시오.</div>
			<div>
			<input type="checkbox" name= "hobby" value="독서">독서
			<input type="checkbox" name= "hobby" value="낚시">낚시
			<input type="checkbox" name= "hobby" value="걷기">걷기
			<input type="checkbox" name= "hobby" value="사색">사색
		   </div>		
		  </div>
		  <div>
		<input type="submit" value="전송">
		</div>
	</form>
</body>
</html>