package com.yash.ppmtoolweb.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolcore.mapper.ProjectMapper;
import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.domain.Project;
import com.yash.ppmtoolweb.util.DBUtil;

public class ProjectDAOImpl extends DBUtil implements ProjectDAO{
	
	ProjectMapper projectMapper;
	
	public ProjectDAOImpl() {
		projectMapper = new ProjectMapper();
	}

	@Override
	public void save(Project project) {
		
		String sql = "insert into projects(project_name,"
				+ "project_identifier,"
				+ "description,"
				+ "start_date,"
				+ "end_date,"
				+ "created_At,"
				+ "updated_At) "
				+ "values(?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			
			pstmt.setString(1, project.getProject_name());
			pstmt.setString(2, project.getProject_identifier().toUpperCase());
			pstmt.setString(3, project.getDescription());
			pstmt.setTimestamp(4, toConvertDate(project.getStart_date()));
			pstmt.setTimestamp(5, toConvertDate(project.getEnd_date()));
			pstmt.setTimestamp(6, toConvertDate(project.getCreated_At()));
			pstmt.setTimestamp(7, toConvertDate(project.getUpdated_At()));
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Project project) {
		
		String sql = "update projects set project_name=?, "
				+ "description=?,"
				+ "start_date=?,"
				+ "end_date=?,"
				+ "updated_At=? "
				+ "where id=?";
		
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			pstmt.setString(1, project.getProject_name());
			pstmt.setString(2, project.getDescription());
			pstmt.setTimestamp(3, toConvertDate(project.getStart_date()));
			pstmt.setTimestamp(4, toConvertDate(project.getEnd_date()));
			pstmt.setTimestamp(5, toConvertDate(project.getUpdated_At()));
			pstmt.setLong(6, project.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Long id) {
		
		String sql ="DELETE FROM projects " + 
				    " WHERE id = ?";
		
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Project find(Long id) {
		Project project = null;
		String sql = "select project_name,"
				+ " project_identifier, "
				+ "description, "
				+ "start_date, "
				+ "end_date, "
				+ "created_At, "
				+ "updated_At "
				+ "from projects "
				+ "where id = ?";
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();	
			projectMapper.mapProject(project,rs);
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return project;
	}

	@Override
	public List<Project> findAll() {
		
		String sql = "select * from projects ";
			
		
		List<Project> list = new ArrayList<>();
		
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			
			ResultSet rs = pstmt.executeQuery();
			list=projectMapper.mapProjects(list, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Project find(String project_identifier) {
		String sql = "select * from projects where project_identifier='"+project_identifier+"'";
		PreparedStatement pstmt = prepareStatement(sql);
		Project project = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			
			project = projectMapper.mapProject(project, rs);
			
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return project;
	}

}
