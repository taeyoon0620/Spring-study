<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays, java.util.Date" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 지시자</title>
</head>
<body>
	<h1>페이지 지시자</h1>
	<%
	// 
	/*  */
	int[] arr = {10, 20, 30};
	out.print("배열의 값 : " + Arrays.toString(arr));
	System.out.println("콘솔에 출력됨 *권장하지않음");
	
	out.print("arr[0] >> " + arr[0]);
	
	Date date = new Date();
	out.println("현재 날짜와 시간 >> " + date.toString());
	//out.println("현재 날짜와 시간 >> " + date);
	// date에는 tostring 을 해도 안해도 똑같이나오는데 이유가뭘까?
	
	
	%>

</body>
</html>