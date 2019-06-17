package com.yash.ppmtoolweb.test;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Project;

public class TestFind {

	public static void main(String[] args) {
		
		ProjectDAO projectDAO = new ProjectDAOImpl();
		
		Project project = projectDAO.find(10l);
		
		System.out.println(project);
		

	}

}
