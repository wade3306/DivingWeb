package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.spotController;
import model.spotModel;


@WebServlet("/spotServlet")
public class spotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public spotServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		spotController sc = new spotController();
		ArrayList<spotModel> asm=sc.readSpot(
				request.getParameter("spotCity"),
				request.getParameter("spotArea")
				);
		request.setAttribute("spot", asm);
		request.getRequestDispatcher("viewSpot.jsp").forward(request,response);
		System.out.println("有經過這");
	}

}
