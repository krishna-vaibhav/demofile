package com.yash.ppmtoolweb.test;

import java.util.Date;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Project;

public class TestSave {

	public static void main(String[] args) {
		ProjectDAO projectDAO = new ProjectDAOImpl();
		
		Project project = new Project();
		
		project.setProject_name("test4");
		project.setProject_identifier("test01");
		project.setDescription("test4 description");
		project.setStart_date(new Date());
		project.setEnd_date(new Date());
		project.setCreated_At(new Date());
		project.setUpdated_At(new Date());
		
		projectDAO.save(project);

	}

}
