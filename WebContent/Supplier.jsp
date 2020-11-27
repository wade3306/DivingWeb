<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="supplier">

		<div class="container" style="padding-top: 20px;">
			<div class="row" style="margin: 0px;">
				<div class="col-1" style="height: 30px;"></div>
				<div class="col"
					style="text-align: center; padding-left: 30px; height: 30px;">
					<label>廠商名稱
						<div id="supName" style="padding-top: 20px;">${requestScope.supplierReadName}</div>
					</label>
				</div>
				<div class="col"
					style="text-align: center; padding-right: 150px; height: 30px;">
					<label>廠商編號
						<div id="supNum" style="padding-top: 20px;">${requestScope.supplierReadNum}</div>
				</div>
				</label>
			</div>
			<div class="col-1" style="height: 30px;"></div>
		</div>
		<hr>
		<div class="row" style="height: 60px;">
			<div class="col-1"></div>
			<div class="col" style="text-align: center; padding-left: 55px;">
				<label>廠商帳號
					<div id="supIds" style="padding-top: 20px;">${requestScope.supplierReadId}</div>
				</label>
			</div>
			<div class="col" style="text-align: center; padding-right: 80px;">
				<label>廠商電話
					<div id="supPhone" style="padding-top: 20px;">${requestScope.supplierReadPhone}</div>
				</label>
			</div>
			<div class="col-1"></div>
		</div>
		<hr>
		<div class="row" style="height: 50px;">
			<div class="col-1"></div>
			<div class="col" style="text-align: center; padding-left: 100px;">
				<label>廠商信箱
					<div id="supEmail" style="padding-top: 20px;">${requestScope.supplierReadMail}</div>
				</label>
			</div>
			<div class="col-2"></div>
		</div>
		<hr>
		<div style="width: 100%; text-align: center; padding-top: 10px;">
		
			<button type="button" class="btn btn-outline-primary" 
				data-toggle="modal" data-target=".bd-example-modal-lg">修改資料</button>
		</div>
	</div>
	<!-- 彈窗廠商資料更改 -->
	<div class="modal fade bd-example-modal-lg" id="msd" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle" style="border-bottom: 0px; margin-left: 40px; text-align: center;">更改資料</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inSupplierName">廠商名稱</label> <input type="text"
										class="form-control" id="supplierUpdateName" value="${requestScope.supplierReadName}">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">廠商密碼</label> <input type="password"
										class="form-control" id="supplierUpdatePassword" value="0000">
								</div>
							</div>
							<div class="form-group">
								<label for="inputAddress">電子信箱</label> <input type="email"
									class="form-control" id="supplierUpdateMail" value="${requestScope.supplierReadMail}">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputPhone">連絡電話</label> <input type="text"
										class="form-control" id="supplierUpdatePhone" value="${requestScope.supplierReadPhone}">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
							<!-- 新增id -->
						<button type="button" class="btn btn-primary" id=methodsBtnSupplierUupdate onclick="modifystoredata()">儲存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>