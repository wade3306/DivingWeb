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
	<div id="gocard" class="cardgroup">

		<div class="card-deck">
			<c:forEach var="tour" items="${tourRead}">
				<div class="col-md-3" style="margin-top: 10px;">
					<div class="card">
						<img src="image/tour/${tour.tourNum}/1.jpg" class="card-img-top"
							alt="..." data-toggle="modal" data-target="#showcard${tour.tourNum}">
						<div class="card-body">
							<h5 class="card-title">${tour.tourName}</h5>
							<p class="card-text">
								<%
									try {
									if (session.getAttribute("actor").equals("member")) {
								%>
								<button type="button" class="btn btn-primary btn-sm"
									data-toggle="modal" data-target="#showcard${tour.tourNum}">加入購物車</button>
								<%
									} else if (session.getAttribute("actor").equals("supplier")) {
								%>
								<button type="button" class="btn btn-primary btn-sm"
									onclick="supplier()">加入購物車</button>
								<%
									}
								} catch (NullPointerException e) {
								%>
								<button type="button" class="btn btn-primary btn-sm"
									data-toggle="modal" data-target="#myModal">加入購物車</button>
								<%
									}
								%>
						</div>
					</div>
				</div>

				<!-- 彈窗 -->
				<div class="modal fade" id="showcard${tour.tourNum}" tabindex="-1"
					role="dialog" aria-labelledby="showcard" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="showcard">詳細行程</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form>
									<div class="form-row">
										<div style="float: right; position: absolute;">
											<div class="BOX" style="float: left;">
												<img src="image/tour/${tour.tourNum}/1.jpg"
													id="BIG${tour.tourNum}"
													style="width: 150px; height: 200px;">
												<div id="SMALL${tour.tourNum}" style="padding-top: 5px;">
													<img src="image/tour/${tour.tourNum}/1.jpg" id="1"
														style="width: 32px; height: 45px;"> <img
														src="image/tour/${tour.tourNum}/2.jpg" id="2"
														style="width: 32px; height: 45px;"> <img
														src="image/tour/${tour.tourNum}/3.jpg" id="3"
														style="width: 32px; height: 45px;"> <img
														src="image/tour/${tour.tourNum}/4.jpg" id="4"
														style="width: 32px; height: 45px;">
												</div>
											</div>
										</div>
									</div>
								</form>
								<div class=""
									style="float: left; display: inline; padding-left: 160px;">
									<h4>
										<p>詳細行程</p>
									</h4>
									<p>
										行程編號：
										<c:out value="${tour.tourNum}" />
										<br> 行程名稱：
										<c:out value="${tour.tourName}" />
										<br> 潛點編號：
										<c:forEach var="tourSpot" items="${tour.tourspot}">
											<c:out value="${tourSpot.spotNum} " />
										</c:forEach>
										<br> 金額：
										<c:out value="${tour.tourPrice}" />
										NT$<br> 天數：
										<c:out value="${tour.tourSize}" />
										<br> 食：
										<c:out value="${tour.tourFood}" />
										<br> 住：
										<c:out value="${tour.tourMotel}" />
										<br> 交通：
										<c:out value="${tour.tourTraffic}" />
										<br> 上/下架：
										<c:out value="${tour.tourShow}" />
									</p>
								</div>
							</div>
							<div class="modal-footer text-center">
							人數：<input type='number' id="people${tour.tourNum}" value='1' min="0" style="width:30%;">
							出發日期：<input type="Date" id="tourDate${tour.tourNum}" style="width:30%;">
								<button type="button" id="${tour.tourNum}"
									class="btn btn-primary" onclick="addToCart${tour.tourNum}()">加入購物車</button>
								
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">退出</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 彈窗 -->
				<script type="text/javascript">
					$(function() {
						$("#SMALL"+${tour.tourNum}+" img").click(function() {
							var N = ${tour.tourNum}+"/"+$(this).attr("id");
							$("#BIG"+${tour.tourNum}).attr("src", "image/tour/"+N+".jpg");
						});
					});
				</script>
				<script type="text/javascript">
					function addToCart${tour.tourNum}(){
						$.post("addToCartServlet",{"tourNum":${tour.tourNum},"tourDate":$("#tourDate"+${tour.tourNum}).val(),"people":$("#people"+${tour.tourNum}).val()},function(){
							
							$("#showcard${tour.tourNum}").modal("hide");
							alert("加入購物車成功");
							})
					}
				</script>
			</c:forEach>
			
		</div>

	</div>
	
	<script>
function supplier(){
	alert("Its for member");
}
</script>
</body>
</html>