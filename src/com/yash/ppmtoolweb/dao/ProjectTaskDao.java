package com.yash.ppmtoolweb.dao;

import java.util.List;

import com.yash.ppmtoolweb.domain.ProjectTask;

public interface ProjectTaskDao {

	void save(ProjectTask projectTask);
	
	List<ProjectTask> listProjectTask(String project_identifier);
	
	void updateProjectTask(ProjectTask projectTask);
	
	ProjectTask find(String project_sequence);
}
