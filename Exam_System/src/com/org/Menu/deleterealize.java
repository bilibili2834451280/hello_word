package com.org.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleterealize implements ALLinterface{
	deleterealize(){}
	public static Connection getConn(){
		System.out.println("yes");
		 String URL = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		 String USER = "root";
	     String PASSWORD = "123";
	     Connection conn = null;
	 	//Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
	 	//Statement stmt = conn.createStatement();
	 	//ResultSet rs =stmt.executeQuery("SELECT No,Name  FROM student");
	 	try {
	 		Class.forName("com.mysql.cj.jdbc.Driver");
	 		conn = (Connection)DriverManager.getConnection(URL,USER,PASSWORD);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	public int  delete(String no) {
      Connection conn = getConn();
      	int i= 0;
      
	    	    PreparedStatement pstmt=null;
	    	    try {
	    	    	String sql = "delete from problem where pro_no='" + no + "'";
	    	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	    	        i= pstmt.executeUpdate();
	    	        pstmt.close();
	    	     
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	    if(i==0)
	    	    {
	    	    	return i;
	    	    }
	    	    try {
	    	    	String sql = "delete from answer where pro_no='" + no + "'";
	    	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	    	        i= pstmt.executeUpdate();
	    	        pstmt.close();
	    	        conn.close();
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	    return i;
	     
	}
	@Override
	public real getinfobypro_no(String NO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean check(String no) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int Insert(String pro_no, String pro_detail, String pro_ansno,
			String pro_keyw, String pro_dif, String cha_no, String cha_title,
			String cha_mpoString, String pro_type,String ANS_NO,String ANS_DETAIL) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void dataBaseDump(String port, String username, String password,
			String databasename, String sqlname) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void backup(String root, String pwd, String dbName, String filePath) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateinfo1(real INFO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateinfo2(real INFO) {
		// TODO Auto-generated method stub
		
	}
}