<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>	
	<h1>[request method : GET 요청]index.jsp</h1>
	<p>member 폴더 내 index.jsp 파일입니다.</p>
	<hr>
	<form action="member/join" method="get">
	<!-- <form action="/ver1/member/join" method="post"> -->
		<div>
			<label> id : </label>
			<input type="text" name="id">
		</div>
		<div>
			<label> name : </label>
			<input type="text" name="name">
		</div>
		
		<input type="submit" value="가입">
	
	</form>
	

</body>
</html>