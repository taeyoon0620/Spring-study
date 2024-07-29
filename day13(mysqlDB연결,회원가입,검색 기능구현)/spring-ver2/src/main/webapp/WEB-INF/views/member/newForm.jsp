<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>newForm.jsp 회원가입</title>
</head>
<body>
	<%
	// context 주소 확인용
	String context = request.getContextPath();
	System.out.println("context >> " + context);
	%>
	
	<h1>회원 가입</h1>
	<!-- [방법1] 상대주소-->
	<!-- <form action="join" method="get"> -->
	
	<!-- [방법2] 절대주소  -->
	<%--<form action="<%=context%>/member/join" method="post"> --%>
	
		<label>이름 : </label>
	<form method="post"> 
		<input type="text" name="name" placeholder="이름을 입력하세요...">
		<input type="submit" value="입력 완료">
	</form>
	
	
	<!-- form에 action이없으면 현재페이지로 이동 -->
</body>
</html>