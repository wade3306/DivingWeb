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

import com.google.gson.Gson;

import controller.orderController;
import controller.tourController;
import model.cartModel;
import model.orderDetailModel;
import model.orderModel;
import model.tourModel;

/**
 * Servlet implementation class orderServlet
 */
@WebServlet("/orderServlet")
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	orderController oc = new orderController();
	Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
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
		HttpSession session = request.getSession();
		System.out.println("會員編號="+session.getAttribute("Num").toString());
		System.out.println("request.getParameter(\"methods\")="+request.getParameter("methods"));
		switch(request.getParameter("methods")) {
			case "create":
				//取得現在的時間
				Date orderDate=new Date();
				//訂單總價
				System.out.println("request.getParameter(\"orderTotalPrice\")"+request.getParameter("orderTotalPrice"));
				Integer orderTotalPrice=Integer.parseInt(request.getParameter("orderTotalPrice"));
				
				
				//購物車的行程和明細
				ArrayList<cartModel> orderCart=(ArrayList<cartModel>)session.getAttribute("cart");
				//訂購的行程明細
				ArrayList<orderDetailModel> orderDetail=new ArrayList<orderDetailModel>();
				
				//建立訂單需要的購物車資料(行程編號,出去玩的日期,人數)
				for(cartModel x:orderCart) {
					try {
						orderDetailModel temp=new orderDetailModel(x.getTourNum(),sdf.parse(x.getTourDate()),x.getTourPeople());
						orderDetail.add(temp);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

				orderModel creatOrder=new orderModel(orderDate,//取得現在時間
													 "credit card",
													 orderTotalPrice,
													 orderDetail,
													 Integer.parseInt(session.getAttribute("Num").toString()));
				request.setAttribute("ans", oc.create(creatOrder));
				//結帳完耀清空購物車
				session.removeAttribute("cart");
				break;
				
			case "memberRead":
				//由會員編號查詢訂單
				Integer memberNum=Integer.parseInt(session.getAttribute("Num").toString());
				ArrayList<orderModel> orderReadByMember=oc.memberRead(memberNum);
				
				
				
				//行程景點查詢
				ArrayList<tourModel> allTour=new tourController().tourRead(-1, -1, -1);
				
				request.setAttribute("allTour", allTour);
				
				
				request.setAttribute("orderReadByMember", orderReadByMember);
				request.getRequestDispatcher("mOrder.jsp").forward(request,response);
				break;
			case "supplierRead":
			case "deleteOrder":
			case "deleteOrderDetail":
		}
	}

}
