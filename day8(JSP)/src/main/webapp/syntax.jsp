<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP기본 문법</title>
</head>
<body>
	<h1>JSP 기본문법</h1>
	
	<!--HTML 주석  -->
	<%-- JSP 주석 --%>
	<%--
	### [JSP] [ Java Server Page ]===========================================================================
	
	<%! %>            : 선언문  변수(멤버변수, field) 선언 , 메서드 정의
	<%  %>            : 스크립트릿(scriptlet) 지역변수 선언, java 코드
	
	<%= %>            : 표현식       결과값 출력 (메소드 호출)
	
	<%@ %>            : 지시자       페이지 속성
	
	<jsp:action> </jsp:action> :  액션 태그   
	
	
	##=========================================================================================================	
	--%>
	
	<div>변수 i 값 : <%= i %></div>
	<div>sum(2, 5) 호출 결과 : <%= sum(2, 5) %></div>
	<div>변수 age 값 :<%= age %> </div>
	
	<%!
	// [선언문] ===================================================================================================
	// 변수 선언 : 멤버 필드
	int i = 10;
	String str = "Hi~~~~~~~";
	%>
	
	<%!
	// 메서드 정의
	public int sum(int a, int b) {
		return a + b;
	}
	
	%>
	
	<%
	for(int num=0; num<10; num++)
		out.println("num >>"  + num + "<br>");
	%>
	
	<%! 
	//멤버 변수 선언
	int age = 50;
	%>
	
	<%
	// 변수 선언 
	int var = 100;
	%>
	
	<div>변수 var 값 : <%= var %></div>
	<div>변수 var 값 : <%= out.print(var); %></div>

</body>
</html>