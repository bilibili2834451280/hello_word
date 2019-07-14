package com.org.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class searchdeleterealize implements ALLinterface{
	public void searchdelete(String no)// ¸üÐÂ
	{
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = openandclose.getConnection();
			String s="update  problem set pro_state='1' "
					+"where pro_no=? ";
			ps = conn.prepareStatement(s);
			ps.setString(1,no);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			openandclose.closeStatement(ps);
			openandclose.closeConnection(conn);
		}
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
	public String[] getnumbypro_state() {
		// TODO Auto-generated method stub
		return null;
	}





}

