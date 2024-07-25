<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beanFruitRequest.jsp</title>
</head>
<body>
	<%@ page import="simple.Fruit" %>
	<h1>beanFruitRequest.jsp</h1>
	<h2>자바 빈즈 연습</h2>
	<!--[빈 생성] -->
	<!-- 1. 빈 생성 : fruit 객체 생성 -->
	<jsp:useBean id="fruit" class="simple.Fruit" scope="request"/>
	
	<!--[값 설정] -->
	<!-- 생성된 빈 fruit에 값 설정 : 멤버변수 sort 에 값 설정 -->
	<!-- name -> bean 이름 -->
	<jsp:setProperty value="사과" property="sort" name="fruit" />
	<!-- fruit 이라는 bean에 sort field 에  setter를 실행해서 "사과" 저장 -->
	<!-- 참조변수 fruit이 만들어짐 -->
	
	<!--[값 출력] -->
	<!--생성된 빈 fruit에 설정된 값 출력 -->
	<div>과일 종류 ? <jsp:getProperty property="sort" name="fruit"/></div> 
	
	<!-- [getter 호출] -->
	<% String fruitSort = fruit.getSort(); %>
	<div>[getter 호출] 과일 종류 ? <%= fruitSort %></div>
	
	<!-- 페이지 이동 -->
	<jsp:forward page= "beanFruitResponse.fjsp" />
	
	
</body>
</html>