package com.yash.ppmtoolweb.serviceimpl;

import java.util.Date;
import java.util.List;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.exception.ProjectException;
import com.yash.ppmtoolweb.service.BacklogService;
import com.yash.ppmtoolweb.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	ProjectDAO projectDao = null;
	BacklogService backlogService = null;
	
	public ProjectServiceImpl() {
		projectDao = new ProjectDAOImpl();
		backlogService = new BacklogServiceImpl();
		
	}
	
	

	@Override
	public void createProject(Project project) throws ProjectException {
		
		Project projects = projectDao.find(project.getProject_identifier().toUpperCase());
		
		if(projects!=null)
		{
			throw new ProjectException("Project already exist "+project.getProject_identifier()+" project identifier");
		}
		else
		{
			project.setCreated_At(new Date());
			project.setUpdated_At(new Date());
			projectDao.save(project);
			backlogService.createBacklog(project);
			
			
		}
		

	}

	@Override
	public List<Project> listProject() throws ProjectException {
		List<Project> list =  projectDao.findAll();
		System.out.println(list);
		if(list.isEmpty())
		{
			throw new ProjectException("There is no project on your dashboard");
		}
		else
		{
			return list;
		}
	}

	@Override
	public void deleteProject(String project_identifier) throws ProjectException {
		
		Project project = projectDao.find(project_identifier.toUpperCase());
		System.out.println(project);
		if(project == null)
		{
			throw new ProjectException("There is no project with "+project_identifier+" project identifier");
			
		}
		else
		{
			projectDao.delete(project.getId());
		}

	}

	@Override
	public void updateProject(Project project) throws ProjectException {
		
		Project projects = projectDao.find(project.getProject_identifier());
		if(projects == null)
		{
			throw new ProjectException("Project cannot be updated");
		}
		else
		{
			project.setCreated_At(projects.getCreated_At());
			project.setUpdated_At(new Date());
			project.setId(projects.getId());
			
		projectDao.update(project);
		}
		
	}

	

}
