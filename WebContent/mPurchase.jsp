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
	<div class='cart transition is-open'
		style='box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.5);'>
		<div class='table'>
			<div class='layout-inline row th'
				style='font-size: 20px; line-height: 20px;'>
				<div class='col col-pro ' style='margin: 0px;'>行程商品</div>
				<div class='col col-price align-center' style='margin: 0px;'>日期</div>
				<div class='col col-qty align-center' style='margin: 0px;'>單價</div>
				<div class='col' style='margin: 0px;'>人數</div>
				<div class='col' style='margin: 0px;'>總價</div>
				<div class='col-1' style='margin: 0px;'></div>
			</div>
			<!-- 購物車的行程 -->
			<c:forEach var="cart" items="${cart}">
				<div class='layout-inline row' style='margin: 0px;'>
					<div class='col col-pro layout-inline'
						style='padding: 0px; margin: 0px;'>
						<img src='./image/tour/${cart.tourNum}/1.jpg' alt='kitten' />
						<p class='text-left' style='margin-left: 20px; line-height: 20px;'>
							<c:out value="${cart.tourName}" />
						</p>
					</div>
					<div class='col col-price col-numeric align-center '
						style='margin-right: 5px; padding: 20px 10px 0px 0px;' >
						<p>
							<c:out value="${cart.tourDate}" />
						</p>
					</div>
					<div class='col col-price col-numeric align-center '
						style='margin-right: 20px; padding: 20px 10px 0px 0px;'>
						<p>
							$
							<c:out value="${cart.tourPrice}" />
						</p>
					</div>
					<div class='col col-qty layout-inline'
						style='padding: 15px 0px 10px 0px; margin-right: 7px;'>
						<button style="width: 30px; height: 30px; border-radius: 20px;" type='button' id="minus<c:out value="${cart.tourNum}"/>"
							value="<c:out value="${cart.tourNum}"/>"
							onclick="minusOne_click(this.value)"><h6 style="font-size: 24px;">-</h6></button>

							<h6 style="margin-bottom: 0px; font-size: 20px;"><c:out value="${cart.tourPeople}" /></h6>

						<button style="width: 30px; height: 30px; border-radius: 20px;" type='button' id="<c:out value="${cart.tourNum}"/>"
							onclick="addOne_click(this.id)"><h6 style="font-size: 24px;">+</h6></button>
					</div>
					<div class='col col-total col-numeric'
						style='margin-right: 10px; padding: 20px 10px 0px 0px;'>
						<p>
							$
							<c:out value="${cart.tourTotalPrice}" />
						</p>

					</div>

					<div style="padding-top: 6px;padding-right: 10px;">
						<button type='button' class="btn btn-outline-danger"
							id="deleteTour<c:out value="${cart.tourNum}"/>"
							value="<c:out value="${cart.tourNum}"/>"
							onclick="delete_click(this.value)">刪除</button>
					</div>
				</div>
			</c:forEach>
			<!-- 購物車的行程 -->


			<div class='tf'>
				<div class='col' style='display: flex; width: 100%;'>
					<div class='col'
						style='margin: 0px 0px 0px 600px; width: 100%; text-align: right;'>
						<p style='margin: 0px;'>訂單總金額</p>
					</div>
					<div class='col' style='margin-left: 70px; width: 100%;'>
						<p style='margin-right: 10px;' id="orderTotalPrice1" value="${sum}">${sum}</p>
						<input type="hidden" id="orderTotalPrice" value="${sum}"></input>
					</div>
				</div>
			</div>
			<div class='purchase-btn'>
				<button type='button' id="buttonCheckBuy"
					onclick="clickBuy(this.id)">確認結帳</button>
			</div>
		</div>
	</div>
</body>
</html>