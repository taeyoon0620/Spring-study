<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 	<jsp:forward page= "/WEB-INF/view/user_info.jsp" /> --%>
<!-- encoding을 utf-8로 설정해주기 if 한국어로 value를 설정한다면  -->
<%-- <% request.setCharacterEncoding("UTF-8"); %> --%>
<% System.out.println("** Forward 액션태그 실행 전 **"); %>
<jsp:forward page="/WEB-INF/view/user_info.jsp">
	<jsp:param value= "일반회원" name= "member" />
</jsp:forward>
<% System.out.println("** Forward 액션태그 실행 후 **"); %>
<% // 실행후가 실행안된다 -> 그 이유는 페이지 실행되는중 forward 코드를 만나면 바로 다른 page로 넘어가기때문에(제어권 상실) %>







