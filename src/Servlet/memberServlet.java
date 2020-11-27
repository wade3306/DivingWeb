package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.memberController;
import model.memberModel;

@WebServlet("/memberServlet")
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	memberController mc = new memberController();
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	boolean msf;
	
	public memberServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		switch (request.getParameter("methods")) {
		case "create":
			System.out.println("ID: " + request.getParameter("memberId"));
			try {
				memberModel createmem = new memberModel(
						request.getParameter("memberId"),
						request.getParameter("memberPassword"),
						request.getParameter("name"),
						sdf.parse(request.getParameter("birth")),
						request.getParameter("mail"),
						request.getParameter("phone")
						);
				msf =  mc.create(createmem);
				
				session.setAttribute("registerfail", msf);
				
				if(!msf) response.getWriter().append("註冊失敗");
				else response.getWriter().append("註冊成功");
				

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "read":
			//HttpSession session = request.getSession();
			memberModel readmem = mc.read(Integer.parseInt(session.getAttribute("Num").toString()));
			
			//String memjson = gson.toJson(readmem);
			//response.getWriter().append(memjson);
			System.out.println("Birth: " + readmem.getMemberBirth());
			System.out.println("Phone: " + readmem.getMemberPhone());
			System.out.println("Mail: " + readmem.getMemberMail());
			
			request.setAttribute("mId", readmem.getMemberId());
			request.setAttribute("mPassword", readmem.getMemberPassword());
			request.setAttribute("mName", readmem.getMemberName());
			request.setAttribute("mBirth", readmem.getMemberBirth());
			request.setAttribute("mPhone", readmem.getMemberPhone());
			request.setAttribute("mMail", readmem.getMemberMail());
			request.getRequestDispatcher("mDetail.jsp").forward(request,response);
			break;
		case "update":
			
			memberModel updatemem = new memberModel(
													//Integer.parseInt(request.getParameter("num")),
													Integer.parseInt(session.getAttribute("Num").toString()),
													session.getAttribute("Id").toString(),
													request.getParameter("password"), 
													request.getParameter("name"),
													//new Date(request.getParameter("birth")), 
													mc.read(Integer.parseInt(session.getAttribute("Num").toString())).getMemberBirth(),
													request.getParameter("mail"),
													request.getParameter("phone"));
			request.setAttribute("ans", mc.update(updatemem));
			break;
		}
	}

}
