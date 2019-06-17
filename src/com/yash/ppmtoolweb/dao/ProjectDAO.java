package com.yash.ppmtoolweb.dao;

import java.util.List;

import com.yash.ppmtoolweb.domain.Project;

public interface ProjectDAO {
	/**
	 * This will save the project into projects table.
	 * 
	 * @param project
	 *            to be saved
	 * @return project is successfully saved or not
	 */
	void save(Project project);

	/**
	 * this will update project in projects table
	 * 
	 * @param project
	 *            to be updated
	 * @return project is successfully updated or not
	 */
	void update(Project project);


	/**
	 * this will delete project in projects table if found
	 * 
	 * @param id
	 *            of project to be deleted
	 * @return a project is successfully deleted or not
	 */
	void delete(Long id);

	/**
	 * this will return project if found otherwise null
	 * 
	 * @param id
	 *            of project to be find
	 * @return project
	 */
	Project find(Long id);

	/**
	 * this will return list of project
	 * 
	 * @return list of all project
	 */
	List<Project> findAll();
	/**
	 * This will return project on bases of project_identifier
	 * @param project_identifier of project to be checked
	 * @return project with project_identifier if exists
	 */
	Project find(String project_identifier);
}
