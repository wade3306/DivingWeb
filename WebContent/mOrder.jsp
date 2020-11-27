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
<!--  -->
	<c:forEach var="orderMember" items="${orderReadByMember}">
	<div class="row">
		<div class="col-md-3" style="margin-bottom: 0px; margin-top: 10px;">
           <img src="./image/order1.jpg" class="card-img" alt="">
        </div>
        <div class="card col-md-9" style="max-width: 1200px;height: 200px;overflow-y:scroll; SCROLLBAR-FACE-COLOR: #c2d3fc; SCROLLBAR-HIGHLIGHT-COLOR: #c2d3fc; SCROLLBAR-SHADOW-COLOR: BLACK; SCROLLBAR-3DLIGHT-COLOR: #c2d3fc; SCROLLBAR-ARROW-COLOR:#000000; SCROLLBAR-TRACK-COLOR: FFFFFF; SCROLLBAR-DARKSHADOW-COLOR: EAECEC;">
        	<div class="card-body text-center " style="font-size: 18px; box-shadow: 0 0 8px 0 rgba(0,0,0,0.5); background: #4b4276;">
               <b class="card-text" style="color: white;margin-right:10px;margin-left:20px;">訂單日期：<c:out value="${orderMember.orderDate}"/></b>
               <b class="card-text" style="color: white;margin-right:10px;margin-left:20px;">總金額：<c:out value="${orderMember.orderTotalPrice}"/></b>
             </div>
             <div class="row">
             
             	<div class="card-body col-md-6 text-center" style="font-size: 18px;">
                   <b class="card-text text-center" style="color: black;">行程名稱</b><p></p>
	
					<c:forEach var="orderDetail" items="${orderMember.orderDetail}" >	                                           
                   <c:forEach var="allTour" items="${allTour}" >	
                   <p class="card-text"><c:if test="${orderDetail.tourNum==allTour.tourNum}"><c:out value="${allTour.tourName}"/></c:if></p>
                  </c:forEach>
                   </c:forEach>
                 </div>
                 
                 <div class="card-body col-md-3 text-center" style="font-size: 18px;">
                   <b class="card-text" style="color: black;">出發日期</b><p></p>
                        
                   <c:forEach var="orderDetail" items="${orderMember.orderDetail}" >
                   <p class="card-text"><c:out value="${orderDetail.orderDetailDate}"/></p>
                   </c:forEach>
                 </div>
                 
                 <div class="card-body col-md-3 text-center" style="font-size: 18px;">
                   <b class="card-text" style="color: black;">人數</b><p></p>
                        
                   <c:forEach var="orderDetail" items="${orderMember.orderDetail}" >
                   <p class="card-text"><c:out value="${orderDetail.orderDetailPeople}"/>人</p>
                   </c:forEach>
                 </div>
                 
             </div>
        </div>
	</div>
	</c:forEach>

</body>
</html>