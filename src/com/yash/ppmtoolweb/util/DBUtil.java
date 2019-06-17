package com.yash.ppmtoolweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This will be used for database related operation, create preparedstatement, close preparedstatement, close connection
 * @author krishna.vaibhav
 *
 */
public class DBUtil {
	
	private static PreparedStatement pstmt = null;
	private static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection connect() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppmtoolwebdb", "root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

	public static PreparedStatement prepareStatement(String sql) {

		try {

			pstmt = connect().prepareStatement(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pstmt;
	}

	public static void connectionClose() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void prepareStatementClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static Timestamp toConvertDate(Date dateToConvert)
	{
		return new Timestamp(dateToConvert.getTime());
	}
	
	public static String formatDate(Date dateToConvert)
	{ 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateToConvert);
		return date;
		
	}
	
	public static Date stringToDate(String dateToConvert)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(dateToConvert);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
	}
}
