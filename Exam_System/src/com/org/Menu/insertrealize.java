package com.org.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertrealize implements ALLinterface{
	insertrealize(){}
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
	public int Insert(String a,String PRO_DETAIL,String c,String PRO_KEYW,String z,
			String f,String CHA_TITLE,String CHA_MPOINT,String CHA_TYPE,String ANS_NO,String ANS_DETAIL){
	       Connection conn = getConn();
		   int i = 0;
		    
		    PreparedStatement pstmt=null;
		    try {
		    	String sql = "insert into problem values(?,?,?,?,?,?,?,?,?,0)";
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setString(1, a);
		        pstmt.setString(2,PRO_DETAIL );
		        pstmt.setString(3, c);
		        pstmt.setString(4,PRO_KEYW );
		        pstmt.setString(5, z);
		        pstmt.setString(6, f);
		        pstmt.setString(7,CHA_TITLE );
		        pstmt.setString(8,CHA_MPOINT );
		        pstmt.setString(9,CHA_TYPE );
		       // pstmt.setString(10,lssb );
		        System.out.println("fhznb");
		        i=pstmt.executeUpdate();
		        pstmt.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    if(i==0)
		    {
		    	return i;
		    }
		    try {
		    	String sql = "insert into answer values(?,?,?)";
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setString(1, c);
		        pstmt.setString(2,ANS_DETAIL );
		        pstmt.setString(3, a);		     
		        System.out.println("fhzwow");
		        i=pstmt.executeUpdate();
		        pstmt.close();
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
	public int delete(String no) {
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
	@Override
	public void searchdelete(String no) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getnumbypro_state() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	

}
