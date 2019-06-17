package com.yash.ppmtoolweb.service;

import java.util.List;

import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;

public interface ProjectService {
     /**
      * This will create project
      * @param project to be created
      * @throws ProjectException will be thrown if project already exists.
      */
	void createProject(Project project) throws ProjectException;
	/**
	 * This will display all existing project
	 * @return list of project
	 * @throws ProjectException will be thrown if project does not exists.
	 */
	List<Project> listProject() throws ProjectException;
	/**
	 * This will delete project on the bases of id
	 * @param id of project to be deleted
	 * @throws ProjectException will be thrown if project does not exists.
	 */
	void deleteProject(String project_identifier) throws ProjectException;
	/**
	 * This will update the existing project details.
	 * @param project to be updated
	 */
	void updateProject(Project project)throws ProjectException;
	
	
	
}
