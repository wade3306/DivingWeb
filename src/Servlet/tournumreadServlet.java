package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.tourController;
import model.tourModel;

/**
 * Servlet implementation class maintourServlet
 */
@WebServlet("/tournumreadServlet")
public class tournumreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	tourController tc = new tourController();
	Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tournumreadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		switch (request.getParameter("methods")) {
		case "tournumRead":
			// �P�_�O�_��J
			// if (request.getParameter("num").equals("")) {
			// num = -1;
			// } else {
			// num = Integer.parseInt(request.getParameter("num"));
			// }
			ArrayList<tourModel> tourRead = tc.tournumRead(8);
			// String tourjson=gson.toJson(tourRead);
			// response.getWriter().append(tourjson);
			request.setAttribute("tourRead",tourRead);
			request.getRequestDispatcher("tourmainPage.jsp").forward(request, response);
			break;
		}

	}

}
