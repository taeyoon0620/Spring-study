<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[문제 2]</title>
<style>
    table {
        width: 50%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid black;
        padding: 3px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <h1> 배열의 값을 테이블의 데이터로 표현</h1>
    <%! String[] language = {"Java", "JSP", "C", "C++"}; %>
    
    <table>
        <thead>
            <tr>
                <th> 번호 </th>
                <th> 배열의 값 </th>
            </tr>
        </thead>
        <tbody>
            <% for (int i = 0; i < language.length; i++) { %>
                <tr>
                    <td><%= (i + 1) %></td>
                    <td><%= language[i] %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
