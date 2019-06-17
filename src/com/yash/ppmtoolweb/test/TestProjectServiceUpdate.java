package com.yash.ppmtoolweb.test;

import java.util.Date;

import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;
import com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl;

public class TestProjectServiceUpdate {

	public static void main(String[] args) {
		ProjectService projectService = new ProjectServiceImpl();
		Project project = new Project();
		try {
			project.setProject_name("test");
			project.setProject_identifier("te04");
			project.setDescription("test description");
			project.setStart_date(new Date());
			project.setEnd_date(new Date());
			project.setUpdated_At(new Date());
			projectService.updateProject(project);
			
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
