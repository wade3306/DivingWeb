package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.tourController;
import model.cartModel;
import model.orderDetailModel;
import model.orderModel;
import model.tourModel;

/**
 * Servlet implementation class alreadyBuyServlet
 */
@WebServlet("/alreadyBuyServlet")
public class alreadyBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alreadyBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//session初始化
		HttpSession session = request.getSession();
//		if(session.getAttribute("cart")==null) {
//		//測試把商品加到購物車(cart)
//			ArrayList<cartModel> acm=new ArrayList<cartModel>();
//			cartModel wantToBuyATour=new cartModel();
//		
//			
//			// 先得到購物車裡的行程編號
//				tourController tc = new tourController();
//				ArrayList<tourModel> shoppingCarHaveTour = new ArrayList<tourModel>();
//				shoppingCarHaveTour.add(tc.tourReadByTourNum(3));		
//				shoppingCarHaveTour.add(tc.tourReadByTourNum(8));
//				shoppingCarHaveTour.add(tc.tourReadByTourNum(14));
//				
//			//行程編號和行程名稱
//			//要購買的明細ArrayList<orderModel>
//				try {
//					ArrayList<orderDetailModel> shoppingCartHaveOrderDetail=new ArrayList<orderDetailModel>();
//					shoppingCartHaveOrderDetail.add(new orderDetailModel(3,sdf.parse("2020-10-10"),1));//訂購的行程編號,行程時間,人數
//					shoppingCartHaveOrderDetail.add(new orderDetailModel(8,sdf.parse("2020-11-01"),2));
//					shoppingCartHaveOrderDetail.add(new orderDetailModel(14,sdf.parse("2020-12-13"),4));
//					
//					for(int i=0;i<shoppingCarHaveTour.size();i++) {
//						for(int j=0;j<shoppingCartHaveOrderDetail.size();j++) {
//							if(shoppingCarHaveTour.get(i).getTourNum()==shoppingCartHaveOrderDetail.get(j).getTourNum()) {
//								cartModel temp=new cartModel();
//								temp.setTourNum(shoppingCarHaveTour.get(i).getTourNum());
//								temp.setTourName(shoppingCarHaveTour.get(i).getTourName());
//								temp.setTourPrice(shoppingCarHaveTour.get(i).getTourPrice());
//								temp.setTourDate(sdf.format(shoppingCartHaveOrderDetail.get(j).getOrderDetailDate()));
//								temp.setTourPeople(shoppingCartHaveOrderDetail.get(j).getOrderDetailPeople());
//								temp.setTourTotalPrice(shoppingCarHaveTour.get(i).getTourPrice()*shoppingCartHaveOrderDetail.get(j).getOrderDetailPeople());
//								acm.add(temp);
//								
//							}
//						}
//					}
//					
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				session.setAttribute("cart", acm);
//				System.out.println("Session購物車有多少行程="+acm.size());
//				for(cartModel x:acm) {
//					System.out.println("行程名稱:"+x.getTourName()+
//									 ",行程日期:"+x.getTourDate()+
//									 ",行程單價:"+x.getTourPrice()+
//									 ",行程人數:"+x.getTourPeople()+
//									 ",行程總價:"+x.getTourTotalPrice());
//				}
//		}
		

		switch(request.getParameter("methods")) {
		case "readAllTour":
			if(session.getAttribute("cart")==null) {
				response.getWriter().append("購物車");
			}
			//System.out.println("執行readAllTour");
			
			//計算總價sum
			else {
			Integer sum=0;
			ArrayList<cartModel> cm=(ArrayList<cartModel>)session.getAttribute("cart");
				for(cartModel x:cm) {
					sum=sum+x.getTourTotalPrice();
					
					//System.out.println("sum"+sum);
				}
			
			//合併成cart
				request.setAttribute("cart", session.getAttribute("cart"));
				request.setAttribute("sum", sum);
				request.getRequestDispatcher("mPurchase.jsp").forward(request,response);
			break;
			}
		case "addOne":
			//某行程編號
			if(session.getAttribute("cart")==null) {
				response.getWriter().append("目前沒");
			}
			else {
			Integer wantAddEditTourNum=Integer.parseInt(request.getParameter("editCartPeople_TourNum"));
			System.out.println("要修改數量的行程編號="+request.getParameter("editCartPeople_TourNum"));
			ArrayList<cartModel> editAddCart=(ArrayList<cartModel>)session.getAttribute("cart");	
			//增加session訂購人數的數量
				for(cartModel x:editAddCart) {
					if(x.getTourNum()==wantAddEditTourNum) {
						//要修改的行程index
						Integer index=editAddCart.indexOf(x);
						
						//該行程人數+1
						editAddCart.get(index).setTourPeople((x.getTourPeople()+1));
						editAddCart.get(index).setTourTotalPrice(editAddCart.get(index).getTourPeople()*editAddCart.get(index).getTourPrice());
					}
				}
				session.setAttribute("cart", editAddCart);
				for(cartModel x:editAddCart) {
					System.out.println("===(加1)"+"行程名稱:"+x.getTourName()+
									   ",行程日期:"+x.getTourDate()+
									   ",行程單價:"+x.getTourPrice()+
									   ",行程人數:"+x.getTourPeople()+
									   ",行程總價:"+x.getTourTotalPrice());
				}
				//計算總價sum
				Integer addOneSum=0;
				ArrayList<cartModel> addOneSumcm=(ArrayList<cartModel>)session.getAttribute("cart");
					for(cartModel x:addOneSumcm) {
						addOneSum=addOneSum+x.getTourTotalPrice();
						
						//System.out.println("sum"+sum);
					}
					////
				request.setAttribute("sum", addOneSum);
				request.getRequestDispatcher("mPurchase.jsp").forward(request,response);
			break;
			}
		case "minusOne":
			//某行程編號
			if(session.getAttribute("cart")==null) {
				response.getWriter().append("有購物內");
			}
			else {
			Integer wantMinusEditTourNumm=Integer.parseInt(request.getParameter("editCartPeople_TourNum"));
			System.out.println("要修改數量的行程編號="+request.getParameter("editCartPeople_TourNum"));
			ArrayList<cartModel> editMinusCart=(ArrayList<cartModel>)session.getAttribute("cart");	
			//減少session訂購人數的數量
				for(cartModel x:editMinusCart) {
					if(x.getTourNum()==wantMinusEditTourNumm) {
						//要修改的行程index
						Integer index=editMinusCart.indexOf(x);
						
						//該行程人數-1
						if(x.getTourPeople()<1) {
							editMinusCart.get(index).setTourPeople(0);
							editMinusCart.get(index).setTourTotalPrice(editMinusCart.get(index).getTourPeople()*editMinusCart.get(index).getTourPrice());
						}
						else {editMinusCart.get(index).setTourPeople((x.getTourPeople()-1));
						editMinusCart.get(index).setTourTotalPrice(editMinusCart.get(index).getTourPeople()*editMinusCart.get(index).getTourPrice());
						}
						}
				}
				session.setAttribute("cart", editMinusCart);
				for(cartModel x:editMinusCart) {
					System.out.println("===(減1)"+"行程名稱:"+x.getTourName()+
									   ",行程日期:"+x.getTourDate()+
									   ",行程單價:"+x.getTourPrice()+
									   ",行程人數:"+x.getTourPeople()+
									   ",行程總價:"+x.getTourTotalPrice());
				}
				//計算總價sum
				Integer minusOneSum=0;
				ArrayList<cartModel> minusOneSumcm=(ArrayList<cartModel>)session.getAttribute("cart");
					for(cartModel x:minusOneSumcm) {
						minusOneSum=minusOneSum+x.getTourTotalPrice();
						
						//System.out.println("sum"+sum);
					}
				request.setAttribute("sum", minusOneSum);
				request.getRequestDispatcher("mPurchase.jsp").forward(request,response);
			break;
			}
			
		case "delete":
			//某行程編號
			if(session.getAttribute("cart")==null) {
				response.getWriter().append("容");
			}
			else {
			Integer wantDeleteTourNumm=Integer.parseInt(request.getParameter("delete_TourNum"));
			System.out.println("要刪除的行程編號="+request.getParameter("delete_TourNum"));
			ArrayList<cartModel> deleteCart=(ArrayList<cartModel>)session.getAttribute("cart");	
			
			for(int i=0;i<deleteCart.size();i++) {
				if(deleteCart.get(i).getTourNum()==wantDeleteTourNumm) {
					//要刪除的行程index
					int deleteIndex=deleteCart.indexOf(deleteCart.get(i));
					//刪除該行程
					deleteCart.remove(deleteIndex);
				}
				
			}
				
				for(cartModel x:deleteCart) {
					System.out.println("===(已刪除的購物車)"+"行程名稱:"+x.getTourName()+
									   ",行程日期:"+x.getTourDate()+
									   ",行程單價:"+x.getTourPrice()+
									   ",行程人數:"+x.getTourPeople()+
									   ",行程總價:"+x.getTourTotalPrice());
				}
				//計算總價sum
				Integer deleteSum=0;
				ArrayList<cartModel> deleteSumcm=(ArrayList<cartModel>)session.getAttribute("cart");
					for(cartModel x:deleteSumcm) {
						deleteSum=deleteSum+x.getTourTotalPrice();
						
						//System.out.println("sum"+sum);
					}
				request.setAttribute("sum", deleteSum);
				session.setAttribute("cart", deleteCart);
				request.getRequestDispatcher("mPurchase.jsp").forward(request,response);
			break;
		}
		}
	}

}
