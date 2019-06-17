package com.yash.ppmtoolcore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yash.ppmtoolweb.domain.Project;



public class ProjectMapper {

	public Project mapProject(Project project, ResultSet rs) throws SQLException {
	
		  
			if(rs.next())
			{
		    project = new Project();
		    project.setId(rs.getLong("id"));
			project.setProject_name(rs.getString("project_name"));
			project.setProject_identifier(rs.getString("project_identifier"));
			project.setDescription(rs.getString("description"));
			project.setStart_date(rs.getTimestamp("start_date"));
			project.setEnd_date(rs.getTimestamp("end_date"));
			project.setCreated_At(rs.getTimestamp("created_At"));
			project.setUpdated_At(rs.getTimestamp("updated_At"));
			
			}
		
              return project;
	}

	public List<Project> mapProjects(List<Project> list, ResultSet rs) throws SQLException {
				while (rs.next()) {
					
					Project project = new Project();
			project.setId(rs.getLong("id"));
			project.setProject_name(rs.getString("project_name"));
			project.setProject_identifier(rs.getString("project_identifier"));
			project.setDescription(rs.getString("description"));
			project.setStart_date(rs.getTimestamp("start_date"));
			project.setEnd_date(rs.getTimestamp("end_date"));
			project.setCreated_At(rs.getTimestamp("created_At"));
			project.setUpdated_At(rs.getTimestamp("updated_At"));
			list.add(project);
		}
		return list;
	}
	
}
