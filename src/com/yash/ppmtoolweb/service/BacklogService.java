package com.yash.ppmtoolweb.service;

import com.yash.ppmtoolweb.domain.Backlog;
import com.yash.ppmtoolweb.domain.Project;

public interface BacklogService {

	
	void createBacklog(Project project);
	
	Backlog findBacklog(String project_identifier);
	
}
