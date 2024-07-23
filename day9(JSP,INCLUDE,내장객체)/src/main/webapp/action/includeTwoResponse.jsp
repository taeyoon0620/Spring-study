<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includeTwoResponse.jsp</title>
<style type="text/css">
	.tag {background-color: #aaa;}
</style>
</head>
<body>
	<% String siteName = request.getParameter("siteName"); %>
	<h1>includeTwoResponse.jsp</h1>
	<div>siteName : <%= siteName %> </div>
	
	<%-- 1. 지시자 : include --%>
	<%@ include file="includeTwoDirective.jsp" %>
	
	<%-- 2. 액션태그: include --%>
	<%-- <jsp:include page="includeTwoActionTag.jsp" /> --%>
	
	<%-- 추가 정보를 includeTwoActionTag.jsp 파일에 넘기고 싶다! --%>
	<jsp:include page="includeTwoActionTag.jsp">
		<jsp:param value="HyperText Transfer Protocol" name="siteInfo"/>
		<!--이 해당이되는 parameter에 넘겨준다. includeTwoaction태그가 받아준다 . parameter를 추가해서.  -->
		<jsp:param value="etc,,," name="etc"/>
	</jsp:include>
	
	
	
</body>
</html>