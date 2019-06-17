package com.yash.ppmtoolweb.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;
import com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl;
import com.yash.ppmtoolweb.util.DBUtil;

/**
 * Servlet implementation class UpdateProjectController
 */
@WebServlet("/UpdateProjectController")
public class UpdateProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(UpdateProjectController.class);   
	
	private ProjectService projectService= null;
    public UpdateProjectController() {
    	 projectService=new ProjectServiceImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post");
		Project project=new Project();
		project.setProject_name(request.getParameter("project_name"));
		project.setProject_identifier(request.getParameter("project_identifier"));
		project.setDescription(request.getParameter("description"));
		Date date =DBUtil.stringToDate(request.getParameter("start_date"));
		project.setStart_date(date);
		date =DBUtil.stringToDate(request.getParameter("end_date"));
		project.setEnd_date(date);
		System.out.println(request.getParameter("project_identifier"));
		
		try {
			projectService.updateProject(project);
		} catch (ProjectException e) {
			log.info(e.getMessage());
		}
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
	}

}
