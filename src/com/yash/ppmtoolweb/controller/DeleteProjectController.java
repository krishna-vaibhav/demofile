package com.yash.ppmtoolweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;
import com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl;

/**
 * Servlet implementation class DeleteProjectController
 */
@WebServlet("/DeleteProjectController")
public class DeleteProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DeleteProjectController.class);
    private ProjectService projectService = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProjectController() {
       projectService =new ProjectServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String project_identifier = request.getParameter("project_identifier");
		try {
			projectService.deleteProject(project_identifier);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		} catch (ProjectException e) {
			
			log.info(e.getMessage());
		}
		
		
	}

}
