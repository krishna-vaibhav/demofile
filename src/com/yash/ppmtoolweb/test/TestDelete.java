package com.yash.ppmtoolweb.test;



import org.apache.log4j.Logger;

import com.yash.ppmtoolweb.dao.ProjectDAO;
import com.yash.ppmtoolweb.daoimpl.ProjectDAOImpl;


public class TestDelete {
	public static final Logger log = Logger.getLogger(TestDelete.class);
	public static void main(String[] args) {

		ProjectDAO projectDAO = new ProjectDAOImpl();	
		projectDAO.delete(Long.parseLong("1"));
		log.info("Record Deleted");

	}

}
