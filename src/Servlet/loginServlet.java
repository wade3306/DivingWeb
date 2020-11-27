package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import controller.loginController;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 Gson gson=new Gson();
	public loginServlet() {
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
		
			HttpSession session = request.getSession();
			
			String actor=request.getParameter("actor");;//商家或會員登入
			String Id;
			String Password;
			Integer Num;
			
			
			
			if(actor.equals("supplier")) {
				 Id=request.getParameter("supplierId");
				 Password=request.getParameter("supplierPassword");
//				 System.out.println("ID: " + request.getParameter("supplierId"));
//				 System.out.println("Password: " + request.getParameter("supplierPassword"));
			}else if(actor.equals("member")) {
//				 System.out.println("ID: " + request.getParameter("memberId"));
//				 System.out.println("Password: " + request.getParameter("memberPassword"));
				 Id=request.getParameter("memberId");
				 Password=request.getParameter("memberPassword");
			}
			else {
				 Id="";
				 Password="";}
			
			loginController login=new loginController();
			
			//request.setAttribute("ans",login.loginActor(actor, Id, Password));
			
			//String loginjson=gson.toJson(login.loginActor(actor, Id, Password));
			//System.out.println("loginjson="+loginjson);
			try{
				session.getAttribute("registerfail"); 
				System.out.println(session.getAttribute("registerfail"));
				boolean registerfail = (boolean) session.getAttribute("registerfail");
				String loginString=login.loginActor(actor, Id, Password, registerfail);
				System.out.println("MES:" + loginString);
				
				if(loginString.equals("LoginSuccessfully")) {
					//登入成功後取得Num
//					System.out.println("Yes");
					if(actor.equals("supplier")) {
						Num=login.readSupplierNumById(Id);
					}else if(actor.equals("member")) {
						Num=login.readMemberNumById(Id);
					}
					else {
						Num=0;}
					
					session.setAttribute("actor", actor);
					session.setAttribute("Id", Id);
					session.setAttribute("Num", Num);
					request.setAttribute("message", loginString);
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					
					System.out.println("ID: "+ session.getAttribute("Id"));
				}
				else {
					request.setAttribute("message", loginString);
					
					request.getRequestDispatcher("LoginFail.jsp").forward(request, response);
				}
			}
			catch(NullPointerException e) {
				session.setAttribute("registerfail", true);
				System.out.println(session.getAttribute("registerfail"));
				boolean registerfail = (boolean) session.getAttribute("registerfail");
				String loginString=login.loginActor(actor, Id, Password, registerfail);
				System.out.println("MES:" + loginString);
				
				if(loginString.equals("LoginSuccessfully")) {
					//登入成功後取得Num
//					System.out.println("Yes");
					if(actor.equals("supplier")) {
						Num=login.readSupplierNumById(Id);
					}else if(actor.equals("member")) {
						Num=login.readMemberNumById(Id);
					}
					else {
						Num=0;}
					
					session.setAttribute("actor", actor);
					session.setAttribute("Id", Id);
					session.setAttribute("Num", Num);
					request.setAttribute("message", loginString);
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					
					System.out.println("ID: "+ session.getAttribute("Id"));
				}
				else {
					request.setAttribute("message", loginString);
					
					request.getRequestDispatcher("LoginFail.jsp").forward(request, response);
				}
			}
			
	}
}
