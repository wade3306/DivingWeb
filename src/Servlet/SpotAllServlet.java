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


@WebServlet("/SpotAllServlet")
public class SpotAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SpotAllServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		spotController sc = new spotController();
		ArrayList<spotModel> sm=sc.readAllSpot();
		request.setAttribute("spotAll", sm);
		request.getRequestDispatcher("ShowAllSpot.jsp").forward(request,response);
		
	}

}
