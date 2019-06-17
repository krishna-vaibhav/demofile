package com.yash.ppmtoolweb.controller;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class UpdateTaskController
 */
@WebServlet("/UpdateTaskController")
public class UpdateTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProjectTaskService projectTaskService= null;
	
    public UpdateTaskController() {
        projectTaskService = new ProjectTaskServiceImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProjectTask projectTask=new ProjectTask();
		projectTask.setId(id);
		projectTask.setProject_identifier(request.getParameter("project_identifier"));
		projectTask.setProject_sequence(request.getParameter("project_sequence"));
		projectTask.setAcceptance_criteria(request.getParameter("acceptance_criteria"));
		projectTask.setSummary(request.getParameter("summary"));
		Date date =DBUtil.stringToDate(request.getParameter("dueDate"));
		projectTask.setDue_date(date);
		projectTask.setStatus(request.getParameter("status"));
		
		
		System.out.println("Project task Update ::"+projectTask);
		
		
			projectTaskService.updateProjectTask(projectTask);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
	}

}
