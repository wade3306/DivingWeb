<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		/*try {
			if(
				session.getAttribute("Id")!=null && session.getAttribute("name")!=null){
				session.setAttribute("Id", request.getParameter("Id"));
				session.setAttribute("name",request.getParameter("name"));
				
			}
	} catch (NullPointerException e) {
	}*/
	%>

	<%
	try{
		if (session.getAttribute("actor").equals("member")) {
	%>
	<div id='dii' class='dropdown'>
		<h5>
			<a class='nav-link dropdown-toggle' href=# id='navbarDropdown'
				role='button' data-toggle='dropdown' aria-haspopup='true'
				aria-expanded='false'>您好，<%=session.getAttribute("Id")%></a>
			<div class='dropdown-menu'>
				<a class='dropdown-item' href=./memberDetail.html>會員中心</a>
				<a class='dropdown-item' style="cursor: pointer; margin-top: 6px;" onclick="logout()">登出</a>
			</div>
	</div>
	<%
		} else if (session.getAttribute("actor").equals("supplier")) {
	%>
	<div id='dii' class='dropdown'>
		<h5>
			<a class='nav-link dropdown-toggle' href=# id='navbarDropdown'
				role='button' data-toggle='dropdown' aria-haspopup='true'
				aria-expanded='false'>您好，<%=session.getAttribute("Id")%></a>
			<div class='dropdown-menu'>
				<a class='dropdown-item' href=./storeDetail.html>廠商中心</a>
				<a class='dropdown-item' style="cursor: pointer; margin-top: 6px;" onclick="logout()">登出</a>
			</div>
	</div>
	<%
		}}catch(NullPointerException e){
	%>
	<i class="fas fa-users"></i>
	<h5>
		<a class="nav-link" href="#" data-toggle="modal"
			data-target="#myModal">會員登入 | 廠商登入</a>
	</h5>
	<%
		}
	
	%>
<script>
$('#myModal').modal('hide');
</script>
</body>
</html>