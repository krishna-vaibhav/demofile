package com.yash.ppmtoolweb.test;

import java.util.List;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Project;

public class TestFindAll {

	public static void main(String[] args) {
		
		ProjectDAO projectDAO = new ProjectDAOImpl();
		
		List<Project> list = projectDAO.findAll();
		
		for (Project project : list) {
			System.out.println(project);
		}
		

	}

}
