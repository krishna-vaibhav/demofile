package com.yash.ppmtoolweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolweb.dao.ProjectTaskDao;
import com.yash.ppmtoolweb.daoimpl.ProjectTaskDaoImpl;
import com.yash.ppmtoolweb.domain.ProjectTask;

/**
 * Servlet implementation class GetInfoOfProjectTaskController
 */
@WebServlet("/GetInfoOfProjectTaskController")
public class GetInfoOfProjectTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	ProjectTaskDao projectTaskDao = null;
	
    public GetInfoOfProjectTaskController() {
       projectTaskDao = new ProjectTaskDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String project_sequence=request.getParameter("project_sequence");
		ProjectTask projectTask= projectTaskDao.find(project_sequence.toUpperCase());
		System.out.println(projectTask.getProject_identifier());
		request.setAttribute("task", projectTask);
		request.getRequestDispatcher("taskUpdateForm.jsp").forward(request, response);
		
	}

}
