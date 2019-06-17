package com.yash.ppmtoolweb.test;

import java.util.List;

import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;
import com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl;

public class TestProjectServiceFindAll {

	public static void main(String[] args) {
		ProjectService projectService = new ProjectServiceImpl();
		try {
			List<Project> list = projectService.listProject();
			for (Project project : list) {
				System.out.println(project);
			}
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
