<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RedirectTwoRequest.jsp</title>
</head>
<body>
	<h1>[회원 가입]RedirectTwoRequest.jsp</h1>
	<form action="RedirectTwoResponse.jsp" method="post">
	<!--post 요청 -> url에 정보를 실지않음  post는 새로고침하면 양식제출다시 하라고하는데 get은 아니다. 마지막요청이 post이기떄문이다 그이유는-->
	<!--그래서 이걸 해결할려면 redirect를 설정해야한다. -->
		<div>
			<label>아이디 : </label>
			<input type="text" name="userId">
			<input type="submit" name="가입하기">
		</div>
	
	
	</form>

</body>
</html>