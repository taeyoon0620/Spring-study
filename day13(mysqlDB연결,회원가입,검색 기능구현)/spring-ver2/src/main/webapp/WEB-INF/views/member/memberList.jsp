<%@ page import="java.util.*" %>
<%@ page import="himedia.spring.ver2.dto.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[memberList.jsp] 회원 목록</title>
<style type="text/css">
    table {border-collapse: collapse;}
    tr, td, th {border: 2px solid #999; padding: 8px; text-align: center;}
</style>
</head>
<body>
    <h1>회원 목록</h1>
    
    <%
        List<Member> members = (List<Member>) request.getAttribute("members");
    %>
    <c:choose>
        <c:when test="${members == null || members.isEmpty()}">
            <p>회원 목록이 없습니다.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="member" items="${members}">
                        <tr>
                            <td>${member.id}</td>
                            <td>${member.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

</body>
</html>
