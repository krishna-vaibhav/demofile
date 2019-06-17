package com.yash.ppmtoolweb.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.ppmtoolweb.dao.BacklogDao;
import com.yash.ppmtoolweb.domain.Backlog;
import com.yash.ppmtoolweb.util.DBUtil;

public class BacklogDaoImpl extends DBUtil implements BacklogDao {

	@Override
	public void save(Backlog backlog) {
		
		String sql = "insert into backlogs(tsequence,"
				+ "project_identifier"
				+ ",project_id) "
				+ "values(?,?,?) ";
		
		PreparedStatement pstmt = prepareStatement(sql);
		
		try {
			pstmt.setString(1, backlog.gettSequence());
			pstmt.setString(2, backlog.getProject_identifier());
			pstmt.setLong(3, backlog.getProject_id());
			pstmt.execute();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public Backlog find(String project_identifier) {
		String sql = "select * from backlogs where project_identifier='"+project_identifier+"'";
		PreparedStatement pstmt = prepareStatement(sql);
		Backlog backlog = new Backlog();
		try {
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				backlog.setId(rs.getInt("id"));
				backlog.setProject_id(rs.getLong("project_id"));
				backlog.setProject_identifier(rs.getString("project_identifier"));
				backlog.settSequence(rs.getString("tsequence"));
			}
			
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return backlog;
	}

	}

	
	

