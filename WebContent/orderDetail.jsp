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
	<div id="order">
		<div id="gocard" class="cardgroup">
		
			<div class="card-deck">
				
				<c:forEach var="tourSupplier" items="${tourReadBySupplier}">
				<!-- 行程 -->
				<div class="col-sm-3">
				<div class="card" style="height: 600px;">
					<img src="image/diving2.jpg" class="card-img-top" alt="..."
						data-toggle="modal" data-target="#showcard">
					<div class="card-body">
						<h6 class="card-title">
							<b><c:out value="${tourSupplier.tourName}"/></b>
						</h6>
						<p class="card-text">
							行程編號：<c:out value="${tourSupplier.tourNum}"/><br>
							行程名稱:<c:out value="${tourSupplier.tourName}"/><br>
							潛點編號：<c:forEach var="tourSpot" items="${tourSupplier.tourspot}" varStatus="status">
									<c:if test="${!status.last}"><c:out value="${tourSpot.spotNum}"/>,</c:if>
									<c:if test="${status.last}"><c:out value="${tourSpot.spotNum}"/></c:if>
									</c:forEach><br>
							金額：<c:out value="${tourSupplier.tourPrice}"/> NT$<br>
							天數：<c:out value="${tourSupplier.tourSize}"/><br>
							食:<c:out value="${tourSupplier.tourFood}"/><br> 
							住:<c:out value="${tourSupplier.tourMotel}"/><br> 
							交通:<c:out value="${tourSupplier.tourTraffic}"/><br>
							上/下架：<c:out value="${tourSupplier.tourShow}"/>
						</p>
						
						<div id="update/delete"
							style="padding-top: 40px;">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="modal" data-target="#update<c:out value="${tourSupplier.tourNum}"/>" id="update$(tourSupplier.tourNum)">更改</button>
							<button type="button" class="btn btn-danger btn-sm"
								data-toggle="modal" data-target="#delete<c:out value="${tourSupplier.tourNum}"/>" id="<c:out value="${tourSupplier.tourNum}"></c:out>">刪除</button>
						</div>
					</div>
				</div>
				</div>
				
	<!-- 彈窗行程資料更改 -->
	<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
		id="update<c:out value="${tourSupplier.tourNum}"/>" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle" style="border-bottom:0px; text-align: center; margin-left:40px;">更改行程資料</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-row">
								<div class="form-group col-md">
									<label for="inOrderName">行程名稱</label> <input type="text"
										class="form-control" id="supplierUpateTourName<c:out value="${tourSupplier.tourNum}"/>" style="width: 450px;"
										value="<c:out value="${tourSupplier.tourName}"/>">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md">
									<label for="inputOrderCont">潛點編號</label> <input type="text"
										class="form-control" id="supplierUpdateTourSpot<c:out value="${tourSupplier.tourNum}"/>" style="width: 450px;"
										value="<c:forEach var="tourSpot" items="${tourSupplier.tourspot}" varStatus="status"><c:if test="${!status.last}"><c:out value="${tourSpot.spotNum}"/>,</c:if><c:if test="${status.last}"><c:out value="${tourSpot.spotNum}"/></c:if></c:forEach>">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="inputMoney">金額</label> <input type="text"
										class="form-control" id="supplierUpateTourMoney<c:out value="${tourSupplier.tourNum}"/>" value="<c:out value="${tourSupplier.tourPrice}"/>">
								</div>
								<div class="form-group col-md-4">
									<label for="inputDay">天數</label> <input type="text"
										class="form-control" id="supplierUpateTourDay<c:out value="${tourSupplier.tourNum}"/>" value="<c:out value="${tourSupplier.tourSize}"/>">
								</div>
								<div class="form-group col-md-4">
									<label for="inputUp">上/下架</label> <select id="supplierUpateTourShow<c:out value="${tourSupplier.tourNum}"/>"
										class="form-control">
										<option <c:if test="${tourSupplier.tourShow=='上架'}">selected</c:if>>上架</option>
										<option <c:if test="${tourSupplier.tourShow=='下架'}">selected</c:if>>下架</option>
									</select>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col">
									<label for="inputFood">食</label> <input type="text"
										class="form-control" id="supplierUpateTourFood<c:out value="${tourSupplier.tourNum}"/>"
										value="<c:out value="${tourSupplier.tourFood}"/>">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputDay">住</label> <input type="text"
										class="form-control" id="supplierUpateTourMotel<c:out value="${tourSupplier.tourNum}"/>" value="<c:out value="${tourSupplier.tourMotel}"/>">
								</div>
								<div class="form-group col-md-6">
									<label for="inputFood">交通</label> <input type="text"
										class="form-control" id="supplierUpateTourTraffic<c:out value="${tourSupplier.tourNum}"/>" value="<c:out value="${tourSupplier.tourTraffic}"/>">
								</div>
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="<c:out value="${tourSupplier.tourNum}"/>" value="<c:out value="${tourSupplier.tourNum}"/>" onclick="update_click(this.id)">儲存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 彈窗 -->
	
	<!-- 彈窗行程刪除 -->
	<div class="modal fade" id="delete<c:out value="${tourSupplier.tourNum}"/>" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle" style="border-bottom:0px; text-align: center; margin-left:40px;">刪除提醒</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="text-align: center;">
					<span>資料刪除就無法復原</span>
					<p>刪除前請先確認行程編號</p>
				</div>
				<div class="modal-footer">
					
					<button type="button" class="btn btn-outline-secondary" data-dismiss="modal">再想想</button>
					<button type="button" class="btn btn-outline-danger" id="elete<c:out value="${tourSupplier.tourNum}"/>" value="<c:out value="${tourSupplier.tourNum}"/>" onclick="reply_click(this.id)">刪除</button>
				</div>
			</div>
		</div>
	</div>
	
				</c:forEach>


			</div>
		</div>
	</div>	

</body>
</html>