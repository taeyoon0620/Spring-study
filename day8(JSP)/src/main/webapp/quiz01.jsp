<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[문제]</title>
</head>
<body>
    <h1>배열의 값을 목록으로 표현</h1>
    <%! String[] order = {"대표님 인사", "임원 소개", "연말 인사", "올해의 직원상", "마무리"}; %>
    
    <h2>행사 식순</h2>
    <ol>
        <% for (int i = 0; i < order.length; i++) { %>
            <li><%= order[i] %></li>
        <% } %>
    </ol>

</body>
</html>
