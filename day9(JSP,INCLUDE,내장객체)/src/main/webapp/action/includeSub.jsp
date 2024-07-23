<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<hr>
	<h1>includeSub.jsp 페이지입니다.</h1>
	<% String user_name2 = request.getParameter("user_name"); %>
	<div><%= user_name2 %>님, 또 만나서 반가워요~! </div>
	<!-- 요청이 아무것도 없으면 안보이게하기  -->
	<hr>
