<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

          <!-- 彈窗修改會員個人資料 -->
	<div class="modal fade bd-example-modal-lg" id="mmodi" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle" style="border-bottom:0px; text-align: center; margin-left:40px;">更改資料</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inSupplierName">會員姓名</label> <input type="text"
										class="form-control" id="memberUpdateName" value="${requestScope.mName}">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">會員密碼</label> <input type="text"
										class="form-control" id="memberUpdatePassword" value="${requestScope.mPassword}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputAddress">電子信箱</label> <input type="email"
									class="form-control" id="memberUpdateMail" value="${requestScope.mMail}">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputPhone">連絡電話</label> <input type="text"
										class="form-control" id="memberUpdatePhone" value="${requestScope.mPhone}">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">取消</button>
							<!-- 新增id -->
						<button type="button" class="btn btn-primary" id=methodsBtnMemberUupdate onclick="backtowin()">儲存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
				<div>
                <h5 style="width: 550px;">私人資料</h5>
              </div>

              <div class="contt">
                <h4>會員姓名：${requestScope.mName}</h4><h4 id="back">出生日期：${requestScope.mBirth}</h4>
              </div>

              <div>
                <h5 style="width: 550px;">帳號資料</h5>
              </div>

              <div class="contt">
                <h4>會員帳號：${requestScope.mId}</h4><h4 id="back">會員密碼：********</h4>
              </div>

              <div>
                <h5 style="width: 550px;">聯絡資訊</h5>
              </div>

              <div class="contt">
                <h4>連絡電話：${requestScope.mPhone}</h4><h4 id="back">電子信箱：${requestScope.mMail}</h4>
              </div>

              <div class="contt">
                <!--  <input id="btt" type="submit" value="修改個人資料">  -->
                <button type="button" class="btn btn-outline-primary" 
				data-toggle="modal" data-target="#mmodi">修改資料</button>
              </div>
              
              
    
	<!-- 修改會員資料 -->
	<script>
	
	function backtowin(){
		$('#mmodi').modal('hide');
		
		$.post("memberServlet",{"methods":"update",
			  "name":$("#memberUpdateName").val(),
			  "password":$("#memberUpdatePassword").val(),
			  "mail":$("#memberUpdateMail").val(),
			  "phone":$("#memberUpdatePhone").val()});

		location.reload();	

		
	}
	</script>
</body>
</html>