package com.yash.ppmtoolweb.test;

import java.util.List;

import com.yash.ppmtoolweb.domain.ProjectTask;
import com.yash.ppmtoolweb.service.ProjectTaskService;
import com.yash.ppmtoolweb.serviceimpl.ProjectTaskServiceImpl;

public class TaskFindAllTest {

	public static void main(String[] args) {
	
		ProjectTaskService projectservice= new ProjectTaskServiceImpl();
		
		List<ProjectTask> list = projectservice.listAllProjectTask("de01");
		
		for (ProjectTask project : list) {
			System.out.println(project);
		}
		

	}

}
