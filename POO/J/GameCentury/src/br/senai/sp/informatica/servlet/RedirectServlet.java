package br.senai.sp.informatica.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String page = request.getParameter("page");
		String forwardPage = "WEB-INF/jsp/index.jsp";
		//
		switch(page.toLowerCase()) {
			case "games": forwardPage = "WEB-INF/jsp/games.jsp";
				break;
			case "about-us": forwardPage = "WEB-INF/jsp/about-us.jsp";
				break;
			case "find-us": forwardPage = "WEB-INF/jsp/find-us.jsp";
				break;
			case "login": forwardPage = "WEB-INF/jsp/login.jsp";
				break;
		}
		//
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
