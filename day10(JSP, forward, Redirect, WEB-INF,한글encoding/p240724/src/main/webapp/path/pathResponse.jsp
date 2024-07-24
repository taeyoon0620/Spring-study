<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pathResponse.jsp</title>
</head>
<body>
	<h1>pathResponse.jsp</h1>
	<h1>페이지 이동했습니다.</h1>
	<div>상품은 <%= request.getParameter("itemName") %> 입니다.</div>
	
	<!-- a 태그 이용하기  -->
	
	<div>
		<a href="/p240724/path/pathRequest.jsp" target="_blank">pathRequest.jsp 페이지로 이동</a>
	</div>
	
	<div>
		<a href= "/p240724/path/detail/pathSub.jsp" target="_blank">pathSub.jsp 페이지로 이동</a>
	</div>
	
	<div>
		<a href="/p240724/redirect/RedirectRequest.jsp" target="_blank">RedirectRequest.jsp 페이지로 이동</a>
	</div>
	
	

</body>
</html>