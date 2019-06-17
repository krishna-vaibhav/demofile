package com.yash.ppmtoolweb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class AddProjectController
 */
@WebServlet("/AddProjectController")
public class AddProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddProjectController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProjectService projectService = new ProjectServiceImpl();

		Project project = new Project();
		project.setProject_name(request.getParameter("project_name"));
		project.setProject_identifier(request.getParameter("project_identifier"));
		project.setDescription(request.getParameter("description"));
		project.setStart_date(DBUtil.stringToDate(request.getParameter("start_date")));
		project.setEnd_date(DBUtil.stringToDate(request.getParameter("end_date")));
		
		try {
			projectService.createProject(project);
			
		} catch (ProjectException e) {
			log.info(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

}
