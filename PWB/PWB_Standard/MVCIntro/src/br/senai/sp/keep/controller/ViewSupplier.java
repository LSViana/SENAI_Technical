package br.senai.sp.keep.controller;

import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.keep.dao.TaskDAO;

@WebServlet(value = "/")
public class ViewSupplier extends HttpServlet {
	/**
	 * 
	 */
	public static final long serialVersionUID = -4267663121631112926L;
	public static final String baseViewAddress = "/WEB-INF/views/";
	public static final String standardViewExtension = ".jsp";
	public static final String apiAccessor = "api";
	public static final String projectName = "/MVCIntro/";
	// Views routes
	public static final String apiInsertTask = projectName + apiAccessor + "/tasks/insert_task";
	public static final String apiGetAllTasks = projectName + apiAccessor + "/tasks/list_tasks";
	public static final String apiDeleteTask = projectName + apiAccessor + "/tasks/delete_task";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Getting Servlet Context to be able to find View
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = null;
		// Getting URL requested by user
		String uri = req.getRequestURI().toString();
		String finalViewURI;
		//
		if (uri.equals(apiInsertTask)) {
			finalViewURI = apiInsertTask;
		}
		else if (uri.equals(apiGetAllTasks)) {
			System.out.println(TaskDAO.tasks.size());
			finalViewURI = apiGetAllTasks;
		} else {
			// Separating levels of URI
			Integer indexOfSecondSlash = uri.indexOf("/", 1);
			uri = uri.substring(indexOfSecondSlash + 1); // +1 removes the first slash and the empty value at
			String[] uriLevels = uri.split("/");
			if (uriLevels.length == 1) { // It's is the index page
				// Landing Page
				uri = "index";
			}
			if (uriLevels.length > 1 && uriLevels[0].equals(apiAccessor)) {
				finalViewURI = "/" + uri;
			} else {
				// Request Dispatcher is the object that access the Views to supply them to user
				finalViewURI = String.format("%s%s%s", baseViewAddress, uri, standardViewExtension);
			}
		}
		System.out.println(finalViewURI);
		// Supplying View from Dispatcher through a forward operation, it means to
		dispatcher = context.getRequestDispatcher(finalViewURI);
		// answer the request as it was supposed to that View file
		dispatcher.forward(req, res);
	}
}
