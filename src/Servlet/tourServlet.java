package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import controller.tourController;
import model.tourModel;
import model.tourspotModel;

/**
 * Servlet implementation class tourServlet
 */
@WebServlet("/tourServlet")
public class tourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 tourController tc=new tourController();
	 Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("spotNumReadTour").toString().equals(null))
				session.setAttribute("spotNumReadTour", "0");
		}catch(NullPointerException n){
			session.setAttribute("spotNumReadTour", "0");
		}
		switch(request.getParameter("methods")) {
			
			case "setSession":
				String s2=request.getParameter("spotNum");
				session.setAttribute("spotNumReadTour", s2);
				System.out.println("setSession"+session.getAttribute("spotNumReadTour").toString());
				break;
			case "create":
				//把tourCreateSpot的逗號分開
				String [] str=request.getParameter("tourCreateSpot").split(",");
				ArrayList<tourspotModel> a=new ArrayList<tourspotModel>();
				for(int i=0;i<str.length;i++) {
					a.add(new tourspotModel(Integer.parseInt(str[i])));
				}
				
				tourModel createtour=new tourModel(request.getParameter("tourCreateName"),
						                   		   Integer.parseInt(request.getParameter("tourCreatePrice")),
						                           Integer.parseInt(request.getParameter("tourCreateSize")),
						                           request.getParameter("tourCreateFood"),
						                           request.getParameter("tourCreateMotel"),
						                           request.getParameter("tourCreateTraffic"),
						                           request.getParameter("tourCreateShow"),
						                           Integer.parseInt(session.getAttribute("Num").toString()),
						                           a);
				request.setAttribute("ans", tc.create(createtour));
				
				//request.getRequestDispatcher("addorder.jsp").forward(request,response);
				//request.getRequestDispatcher("storeDetail.html").forward(request, response);
				System.out.println("成功");
				//這邊要改!!
				//新增成功後會指到新的storeDetail.html
//				response.sendRedirect("refreshDetail.jsp");
//				request.getRequestDispatcher("refreshDetail.jsp").forward(request, response);
				break;
				
			case "tourRead":
				System.out.println("tourRead"+session.getAttribute("spotNumReadTour").toString());
				if(!(session.getAttribute("spotNumReadTour").toString().equals("0"))) {
					ArrayList<tourModel> tourRead = tc.tourRead(Integer.parseInt(session.getAttribute("spotNumReadTour").toString()));
					request.setAttribute("tourRead", tourRead);
					session.setAttribute("spotNumReadTour", "0");
					request.getRequestDispatcher("viewTour.jsp").forward(request, response);
				}else {
				Integer tourSize=-1,tourPriceMin=-1,tourPriceMax=-1;
				String tourDate=request.getParameter("tourDate");
				if(tourDate.equals(null)) {
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					try {
							Date tourD1=df.parse(tourDate.substring(0, tourDate.indexOf("-")-1));
							Date tourD2=df.parse(tourDate.substring(tourDate.indexOf("-")+2, tourDate.length()));
							tourSize=(int)(tourD2.getTime()-tourD1.getTime())/(24*60*60*1000);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}		
				String tourPrice=request.getParameter("tourPrice");
				if(tourPrice.equals("all")) {
					tourPriceMin=-1;tourPriceMax=-1;
				}
				else if(tourPrice.equals("15000以上"))
					tourPriceMin=15000;
				else{
					tourPriceMin=Integer.parseInt(tourPrice.substring(0, tourPrice.indexOf("-")));
					tourPriceMax=Integer.parseInt(tourPrice.substring(tourPrice.indexOf("-")+1,tourPrice.length()));
				}						
				
				ArrayList<tourModel> tourRead = tc.tourRead(tourSize, tourPriceMin, tourPriceMax);
				//String tourjson=gson.toJson(tourReadRange);
				//response.getWriter().append(tourjson);
				request.setAttribute("tourRead", tourRead);
				request.getRequestDispatcher("viewTour.jsp").forward(request, response);
				}
				break;
				
			case "tourReadSpot":
				
				ArrayList<tourModel> tourReadSpot=tc.tourRead(Integer.parseInt(request.getParameter("readSpot")));
				//String tourjson2=gson.toJson(tourReadSpot);
				//response.getWriter().append(tourjson2);
				request.setAttribute("ans", tourReadSpot);
				request.getRequestDispatcher("viewTour.jsp").forward(request, response);
				break;
				
			case "tourReadSupplier":
				ArrayList<tourModel> tourSupplier=tc.supplierRead(Integer.parseInt(session.getAttribute("Num").toString()));
				
				//String tourjson3=gson.toJson(tourSupplier);
				//response.getWriter().append(tourjson3);
				
				request.setAttribute("tourReadBySupplier", tourSupplier);
				request.getRequestDispatcher("orderDetail.jsp").forward(request,response);
				break;
				
			case "update":
				//把tourSpot的,分開
				String [] strUpdateSpot=request.getParameter("supplierUpdateTourSpot").trim().split(",");
				
				//要找到原始行程潛點編號(toutSpotNum)
				
				ArrayList<Integer> tourhaveSpotNum=new ArrayList<>();
				//廠商有哪些行程
				ArrayList<tourModel> SupplierHaveTour = tc.supplierRead(Integer.parseInt(session.getAttribute("Num").toString()));//廠商編號搜尋行程
					
				
				for(tourModel x:SupplierHaveTour) {
					
					for( tourspotModel y:x.getTourspot()) {
						//行程裡的潛點編號
						if(x.getTourNum().equals(Integer.parseInt(request.getParameter("supplierUpdateTourNum")))) {
							tourhaveSpotNum.add(y.getTourspotNum());
						}
					}
				}
				//要更新行程有哪些潛點
				ArrayList<tourspotModel> aUpdateTourSpot=new ArrayList<tourspotModel>();
				
				for(int i=0;i<strUpdateSpot.length-1;i++) {
					aUpdateTourSpot.add(new tourspotModel(/*原本潛點的編號*/tourhaveSpotNum.get(i),Integer.parseInt(strUpdateSpot[i])));
				}
				
				tourModel supplierUpdateTour=new tourModel(
												   Integer.parseInt(request.getParameter("supplierUpdateTourNum")),
												   request.getParameter("supplierUpdateTourName"),
						                   		   Integer.parseInt(request.getParameter("supplierUpdateTourPrice")),
						                           Integer.parseInt(request.getParameter("supplierUpdateTourSize")),
						                           request.getParameter("supplierUpdateTourFood"),
						                           request.getParameter("supplierUpdateTourMotel"),
						                           request.getParameter("supplierUpdateTourTraffic"),
						                           request.getParameter("supplierUpdateTourShow"),
						                           Integer.parseInt(session.getAttribute("Num").toString()),
						                           aUpdateTourSpot);
				request.setAttribute("ans", tc.update(supplierUpdateTour));
				if(request.getAttribute("ans").equals(true)) response.getWriter().append("修改行程成功");
				else response.getWriter().append("修改行程失敗");
				break;
				
			case "deletetour":
//				System.out.println("deletetour");
				System.out.println("SUP: " + request.getParameter("supplierDdeleteTourNum"));
				request.setAttribute("ans", tc.deletetour(Integer.parseInt(request.getParameter("supplierDdeleteTourNum"))));
				if(request.getAttribute("ans").equals(true)) response.getWriter().append("刪除行程成功");
				else response.getWriter().append("刪除行程失敗");
				break;
				
			case "deletetourspot": 
				request.setAttribute("ans", tc.deletetourspot(Integer.parseInt(request.getParameter("deletetourspotNum"))));
				break;
		}
	}

}
