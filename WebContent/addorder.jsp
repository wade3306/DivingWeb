<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="addOrderdiv">
		<!-- 廠商新增行程 form -->
		<form class="addOrder" action="imagesUpload" method="post"
			target="nm_iframe" enctype="multipart/form-data">

			<div id="addOrder">

				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label for="validationDefault01">行程名稱</label> <input type="text"
							class="form-control " name="tourCreateName" placeholder="行程名稱"
							required>
					</div>
					<div class="col-md-4 mb-3">
						<label for="validationDefault02">潛點編號</label> <input type="text"
							class="form-control " name="tourCreateSpot" placeholder="潛點編號"
							required>
					</div>
					<div class="col-md-4 mb-3">
						<label for="addinput">上/下架</label><select name="tourCreateShow"
							class="form-control">
							<option selected>上架</option>
							<option>下架</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-2 mb-3">
						<label for="validationDefault03">金額</label> <input type="text"
							class="form-control " name="tourCreatePrice" placeholder="金額"
							required>
					</div>
					<div class="col-md-2 mb-3">
						<label for="validationDefault04">天數</label> <input type="text"
							class="form-control " name="tourCreateSize" placeholder="天數"
							required>
					</div>
					<div class="col-md-8 mb-3">
						<label for="validationDefault05">行程伙食</label> <input type="text"
							class="form-control " name="tourCreateFood" placeholder="行程伙食"
							required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label for="validationDefault06">住宿地點</label> <input type="text"
							class="form-control " name="tourCreateMotel" placeholder="住宿"
							required>
					</div>
					<div class="col-md-3 mb-3">
						<label for="validationDefault07">交通方式</label> <input type="text"
							class="form-control " name="tourCreateTraffic" placeholder="交通方式"
							required>
					</div>
					<div class="col-md-5 mb-3 ">
			<!-- <form action="upload.do" method="post" > -->
				<label for="selectImage" style="padding-bottom: 5px;">圖片上傳</label><br>
				圖片1：<input type="file" name="newImage1" id="newImage1" style="width: 250px;" /><br> 
				圖片2：<input type="file" name="newImage2" id="newImage2" style="width: 250px;" /><br>
				圖片3：<input type="file" name="newImage3" id="newImage3" style="width: 250px;" /><br> 
				圖片4：<input type="file" name="newImage4" id="newImage4" style="width: 250px;" />
					</div>
					<!-- 廠商新增行程id -->
					<div style="padding-left: 500px;">
						<input type="hidden" name="methods" value="create">
						<button class="btn btn-danger btn-sm" type="submit"
							name="methodsBtnSupplierTourCreate"
							id="methodsBtnSupplierTourCreate">新增行程</button>
					</div>
				</div>
			</div>
			</form>
		</div>
	
	<!-- 廠商新增行程 -->
	<script>
		/*$("#methodsBtnSupplierTourCreate").click(function(){
			$.post("tourServlet",{"methods":"create",
									  "supplierNum":$("#supplierCreateNum").val(),
									  "tourCreateName":$("#tourCreateName").val(),
									  "tourCreatePrice":$("#tourCreatePrice").val(),
									  "tourCreateSize":$("#tourCreateSize").val(),
									  "tourCreateFood":$("#tourCreateFood").val(),
									  "tourCreateMotel":$("#tourCreateMotel").val(),
									  "tourCreateTraffic":$("#tourCreateTraffic").val(),
									  "tourCreateShow":$("#tourShow").val(),
									  "tourCreateSpot":$("#tourCreateSpot").val(),
									  "spotCreate2":$("#spot2").val(),
									  "spotCreate3":$("#spot3").val()});
		});*/
	</script>
</body>
</html>