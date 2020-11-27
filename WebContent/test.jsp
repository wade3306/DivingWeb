<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${requestScope.ans==true}"><% response.getWriter().append("註冊成功"); %></c:if>
<c:if test="${requestScope.ans==false}"><% response.getWriter().append("註冊失敗"); %></c:if>
</body>
</html>