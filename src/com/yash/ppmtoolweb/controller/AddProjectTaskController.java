package com.yash.ppmtoolweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolweb.domain.ProjectTask;
import com.yash.ppmtoolweb.service.ProjectTaskService;
import com.yash.ppmtoolweb.serviceimpl.ProjectTaskServiceImpl;
import com.yash.ppmtoolweb.util.DBUtil;

/**
 * Servlet implementation class AddProjectTaskController
 */
@WebServlet("/AddProjectTaskController")
public class AddProjectTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProjectTaskController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProjectTask projectTask = new ProjectTask();
		
		projectTask.setSummary(request.getParameter("summary")); 
		projectTask.setAcceptance_criteria(request.getParameter("acceptance_criteria")); 
		projectTask.setDue_date(DBUtil.stringToDate(request.getParameter("due_date"))); 
		projectTask.setPriority(request.getParameter("priority"));
		projectTask.setStatus(request.getParameter("status"));
		projectTask.setProject_identifier(request.getParameter("project_identifier").toUpperCase());
		String project_identifier = request.getParameter("project_identifier"); 
		System.out.println("Project identifier "+project_identifier);
		ProjectTaskService projectTaskService = new ProjectTaskServiceImpl();
		
		projectTaskService.createProjectTask(projectTask);
		request.getRequestDispatcher("projectBoard.jsp").forward(request, response);
		
		
	}

}
