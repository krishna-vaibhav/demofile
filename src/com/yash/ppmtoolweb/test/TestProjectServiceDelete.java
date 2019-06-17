package com.yash.ppmtoolweb.test;

import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.ProjectService;
import com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl;

public class TestProjectServiceDelete {

	public static void main(String[] args) {
		ProjectService projectService = new ProjectServiceImpl();
		try {
			projectService.deleteProject("TE04");
			
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
	}

}
