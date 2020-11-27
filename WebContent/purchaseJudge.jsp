<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% try{if(session.getAttribute("actor").equals("member")){ %>
<input id="judge" type="hidden" value="member">
<%}%>
<%}catch(NullPointerException e) {%><input id="judge" type="hidden" value="No">BBB<%} %>

</body>
</html>