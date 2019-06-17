package com.yash.ppmtoolweb.service;

import java.util.List;

import com.yash.ppmtoolweb.domain.ProjectTask;

public interface ProjectTaskService {

	void createProjectTask(ProjectTask projectTask);
	
	List<ProjectTask> listAllProjectTask(String project_identifier);
	
	void updateProjectTask(ProjectTask projectTask);
	
}
