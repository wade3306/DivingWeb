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
import model.tourModel;

@WebServlet("/addToCartServlet")
public class addToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tourController tc=new tourController();
	ArrayList<cartModel> acm=new ArrayList<cartModel>();
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public addToCartServlet() {
        super();
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		tourModel tour=tc.tourNumRead(Integer.parseInt(request.getParameter("tourNum")));
		cartModel cm=new cartModel();
		Date d=new Date();
		String date="";
		if(!(request.getParameter("tourDate").equals(""))){
			date=request.getParameter("tourDate");
		}else {
			date=sdf.format(d);
		}	
			cm=new cartModel(
					tour.getTourName(),
					tour.getTourNum(),
					request.getParameter("tourDate"),
					tour.getTourPrice(),
					Integer.parseInt(request.getParameter("people")));
		acm.add(cm);
		HttpSession session=request.getSession();
		session.setAttribute("cart", acm);
		//測試購物車
		for(cartModel x:acm) System.out.println(x.getTourNum()+","+x.getTourName()+","+x.getTourPeople()+","+x.getTourPrice());
	}

}
