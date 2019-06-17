package com.yash.ppmtoolweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Project;

/**
 * Servlet implementation class GetInfoOfProjectController
 */
@WebServlet("/GetInfoOfProjectController")
public class GetInfoOfProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProjectDAO projectDAO=null;
    public GetInfoOfProjectController() {
        projectDAO=new ProjectDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get");
		String project_identifier=request.getParameter("project_identifier");
		Project project= projectDAO.find(project_identifier.toUpperCase());
		request.setAttribute("project", project);
		request.getRequestDispatcher("updateForm.jsp").forward(request, response);
	}

}
