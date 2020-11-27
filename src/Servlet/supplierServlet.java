package Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import controller.supplierController;
import model.supplierModel;

/**
 * Servlet implementation class supplierServlet
 */
@WebServlet("/supplierServlet")
public class supplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	supplierController sc=new supplierController();  
	Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean msf;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		
		switch(request.getParameter("methods")) {
		case "create":

			supplierModel createsup=new supplierModel(
					request.getParameter("supplierId"),
					request.getParameter("supplierPassword"),
					request.getParameter("supplierName"),
					request.getParameter("supplierMail"),
					request.getParameter("supplierPhone"));
			
			msf =  sc.create(createsup);
			session.setAttribute("registerfail", msf);
			
			if(!msf) response.getWriter().append("註冊失敗");
			else response.getWriter().append("註冊成功");
			
			
			break;
		case "read":	
			supplierModel readsup=sc.read(Integer.parseInt(session.getAttribute("Num").toString()));
//			String supjson=gson.toJson(readsup);
//			response.getWriter().append(supjson);
//			System.out.println("supjson="+supjson);
			request.setAttribute("supplierReadId",readsup.getSupplierId());
			request.setAttribute("supplierReadPassword",readsup.getSupplierPassword());
			request.setAttribute("supplierReadName",readsup.getSupplierName());
			request.setAttribute("supplierReadMail",readsup.getSupplierMail());
			request.setAttribute("supplierReadPhone",readsup.getSupplierPhone());
			request.setAttribute("supplierReadNum",readsup.getSupplierNum());
			request.getRequestDispatcher("Supplier.jsp").forward(request, response);
			break;
		case "update":
			supplierModel updatesup=new supplierModel(
//					Integer.parseInt(request.getParameter("supplierNum")),
					Integer.parseInt(session.getAttribute("Num").toString()),
					session.getAttribute("Id").toString(),
					request.getParameter("supplierUpdatePassword"),
					request.getParameter("supplierUpdateName"),
					request.getParameter("supplierUpdateMail"),
					request.getParameter("supplierUpdatePhone"));
			request.setAttribute("ans", sc.update(updatesup));
			break;
		}
	}

}
