package com.yash.ppmtoolweb.test;

import java.util.Date;


import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;
import com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl;

public class ProjectServiceCreateProjectTest {

	public static void main(String[] args) {
		ProjectService projectService = new ProjectServiceImpl();

		Project project = new Project();

		project.setProject_name("test4");
		project.setProject_identifier("te02");
		project.setDescription("test4 description");
		project.setStart_date(new Date());
		project.setEnd_date(new Date());
		project.setCreated_At(new Date());
		project.setUpdated_At(new Date());

		try {
			projectService.createProject(project);
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}

	}

}
