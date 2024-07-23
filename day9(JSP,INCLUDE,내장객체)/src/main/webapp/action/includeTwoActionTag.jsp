<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	String siteName = request.getParameter("siteName"); 
 	String siteInfo = request.getParameter("siteInfo");
 	String etc = request.getParameter("etc");
 %>
	<hr>
	<div class ="tag">
		<h1>includeTwoActionTag.jsp</h1>
		<div>siteName : <%= siteName %> </div>
		<div>siteInfo : <%= siteInfo %> </div>
		<div>etc : <%= etc %> </div>
		<div>request : <%= request %></div>
		<div>request : <%= request.getContextPath() %></div> <!-- CONTEXT=p240723  -->
		
	</div>
