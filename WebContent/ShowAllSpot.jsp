<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id=newSpot style="padding-bottom: 20px;">
		<div id="gocard" class="cardgroup">
			<div class="card-deck">
				<c:forEach var="spot" items="${spotAll}">
					<div class="col-md-3"
						style="max-width: 100%; padding-bottom: 10px;">
						<div class="card" style="height: 460px; width: 250px;">
							<img src="image/spot/${spot.spotNum}/1.jpg" class="card-img-top" alt="..."
								data-toggle="modal" data-target="#showcard">
							<div class="card-body">
								<h5 class="card-title">
									潛點編號：
									<c:out value="${spot.spotNum}" />
								</h5>
								<p class="card-text">
									潛點名稱：
									<c:out value="${spot.spotName}" />
									<br> 潛點城市：
									<c:out value="${spot.spotCity}" />
									<br> 潛點區域：
									<c:out value="${spot.spotArea}" />
									<br> 潛水型態：
									<c:out value="${spot.spotType}" />
								</p>
								<hr>
								<p class="card-text">
									<button id="${spot.spotNum}" onclick="setSession${spot.spotNum}()" 
											class="btn btn-primary btn-sm">搜尋相關行程</button>
							</div>
						</div>
					</div>
					<script type="text/javascript">
	function setSession${spot.spotNum}(){
		$.post("tourServlet",{"spotNum":${spot.spotNum},"methods":"setSession"});	
		window.location.href='choose1.html';	
		}
	</script>
				</c:forEach>
				<% session.setAttribute("spotNumReadTour", 0); %>
			</div>
		</div>
	</div>
</body>
</html>