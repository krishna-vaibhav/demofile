package com.yash.ppmtoolweb.serviceimpl;

import com.yash.ppmtoolweb.dao.BacklogDao;
import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.BacklogDaoImpl;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;
import com.yash.ppmtoolweb.domain.Backlog;
import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.service.BacklogService;

public class BacklogServiceImpl implements BacklogService {
	BacklogDao backlogDao = new BacklogDaoImpl();
	@Override
	public void createBacklog(Project project) {
		
		
		ProjectDAO projectDAO = new ProjectDAOImpl();
		Backlog backlog = new Backlog();
		
		project.setId(projectDAO.find(project.getProject_identifier()).getId());
	    backlog.setProject_id(project.getId());
	    backlog.setProject_identifier(project.getProject_identifier());
	    backlog.settSequence(project.getProject_identifier()+"b0");
	    
		
		
		backlogDao.save(backlog);

	}

	@Override
	public Backlog findBacklog(String project_identifier) {
		return backlogDao.find(project_identifier);
		
	}
	
	

}
