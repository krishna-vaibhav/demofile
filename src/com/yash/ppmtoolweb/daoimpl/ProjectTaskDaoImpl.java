package com.yash.ppmtoolweb.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtoolweb.dao.ProjectTaskDao;
import com.yash.ppmtoolweb.domain.ProjectTask;
import com.yash.ppmtoolweb.util.DBUtil;

public class ProjectTaskDaoImpl extends DBUtil implements ProjectTaskDao {

	@Override
	public void save(ProjectTask projectTask) {
		
	String sql = "insert into projecttasks(acceptance_criteria, "
			+ "created_at,  "
			+ "due_date,  "
			+ "priority,  "
			+ "project_identifier,  "
			+ "project_sequence,  "
			+ "status,  "
			+ "summary,  "
			+ "updated_at,  "
			+ "backlog_id  ) "
			+ "values(?,?,?,?,?,?,?,?,?,?)";	
	
	PreparedStatement pstmt = prepareStatement(sql);
	
	try {
		pstmt.setString(1, projectTask.getAcceptance_criteria());
		pstmt.setTimestamp(2, toConvertDate(projectTask.getCreated_at()));
		pstmt.setTimestamp(3, toConvertDate(projectTask.getDue_date()));
		pstmt.setString(4, projectTask.getPriority());
		pstmt.setString(5, projectTask.getProject_identifier());
		pstmt.setString(6, projectTask.getProject_sequence());
		pstmt.setString(7, projectTask.getStatus());
		pstmt.setString(8, projectTask.getSummary());
		pstmt.setTimestamp(9, toConvertDate(projectTask.getUpdated_at()));
		pstmt.setInt(10, projectTask.getBacklog_id());
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	@Override
	public List<ProjectTask> listProjectTask(String project_identifier) {
		String sql = "select * from projecttasks where project_identifier='"+project_identifier+"'";
		PreparedStatement pstmt = prepareStatement(sql);
		ProjectTask projectTask = null;
		List<ProjectTask> list = new ArrayList<ProjectTask>();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{   
				projectTask = new ProjectTask();
				projectTask.setId(rs.getInt("id"));
				projectTask.setProject_sequence(rs.getString("project_sequence"));
				projectTask.setPriority(rs.getString("priority"));
				projectTask.setSummary(rs.getString("summary"));
				projectTask.setAcceptance_criteria(rs.getString("acceptance_criteria"));
				projectTask.setDue_date(rs.getTimestamp("due_date"));
				projectTask.setStatus(rs.getString("status"));
				list.add(projectTask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateProjectTask(ProjectTask projectTask) {
		
		String sql = "update projecttasks set project_identifier=?, "
				+ "project_sequence=?,"
				+ "acceptance_criteria=?,"
				+ "summary=?,"
				+ "due_date=?, "
				+ "status=?, "
				+"id=?"
				+ "where project_sequence=?";
		
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			pstmt.setString(1, projectTask.getProject_identifier());
			pstmt.setString(2, projectTask.getProject_sequence());
			pstmt.setString(3, projectTask.getAcceptance_criteria());
			pstmt.setString(4, projectTask.getSummary());
			pstmt.setTimestamp(5, toConvertDate(projectTask.getDue_date()));
			pstmt.setString(6, projectTask.getStatus());
			pstmt.setInt(7, projectTask.getId());
			pstmt.setString(8, projectTask.getProject_sequence());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ProjectTask find(String project_sequence) {
		ProjectTask projectTask = null;
		String sql = "select * from projecttasks where project_sequence = ?";
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			pstmt.setString(1, project_sequence);
			ResultSet rs = pstmt.executeQuery();	
			if(rs.next())
			{
				projectTask = new ProjectTask();
				projectTask.setId(rs.getInt("id"));
				projectTask.setProject_identifier(rs.getString("project_identifier"));
				projectTask.setProject_sequence(rs.getString("project_sequence"));
				projectTask.setPriority(rs.getString("priority"));
				projectTask.setSummary(rs.getString("summary"));
				projectTask.setAcceptance_criteria(rs.getString("acceptance_criteria"));
				projectTask.setDue_date(rs.getTimestamp("due_date"));
				projectTask.setStatus(rs.getString("status"));
				
				System.out.println(projectTask.getProject_identifier());
				
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectTask;
	}

}
