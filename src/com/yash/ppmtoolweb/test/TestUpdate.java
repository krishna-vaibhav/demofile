package com.yash.ppmtoolweb.test;

import java.util.Date;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Project;

public class TestUpdate {

	public static void main(String[] args) {
		
ProjectDAO projectDAO = new ProjectDAOImpl();
		
		Project project = new Project();
		
		project.setId(1);
		project.setProject_name("test hello");
		project.setProject_identifier("te04");
		project.setDescription("test description");
		project.setStart_date(new Date());
		project.setEnd_date(new Date());
		project.setUpdated_At(new Date());
		
		projectDAO.update(project);

	}

}
