package com.org.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


public class selectrealize implements ALLinterface{
	public real getinfobypro_no(String pro_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 2.连接数据库
			conn = openandclose.getConnection();
			
			// 3. 操作数据库
			String sql = "select problem.*,answer.ans_detail from answer,problem where problem.pro_no=answer.pro_no and problem.pro_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pro_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				real INFO = new real(rs.getString("pro_no"),rs.getString("pro_detail"),rs.getString("pro_ansno"),rs.getString("pro_keyw"),rs.getString("pro_dif"),rs.getString("cha_no"),rs.getString("cha_title"),rs.getString("cha_mpoint"),rs.getString("pro_type"),rs.getString("ans_detail"));
				return INFO;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 4.关闭数据库
			openandclose.closeResultSet(rs);
			openandclose.closeStatement(pstmt);
			openandclose.closeConnection(conn);
		}
		return null;
	}
	
	public boolean check(String no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 2.连接数据库
			conn = openandclose.getConnection();
			// 3. 操作数据库
			String sql = "select  *   from  problem where pro_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 4.关闭数据库
			openandclose.closeResultSet(rs);
			openandclose.closeStatement(pstmt);
			openandclose.closeConnection(conn);
		}
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
	public void searchdelete(String no) {
		// TODO Auto-generated method stub
		
	}
	
	public String[] getnumbypro_state() {
		String[] stuid=new String[1000];
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 2.连接数据库
			conn = openandclose.getConnection();
			
			// 3. 操作数据库
			String sql = "select count(*) from problem where pro_state='1'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			stuid[0]=rs.getString("count(*)");
			if (Integer.parseInt(stuid[0])!=0) {
				String sql2 = "select pro_no from problem where pro_state='1'";
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				for(int j=0;j<Integer.parseInt(stuid[0]);j++){
					rs.next();
					stuid[j+1]=rs.getString("pro_no");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 4.关闭数据库
			openandclose.closeResultSet(rs);
			openandclose.closeStatement(pstmt);
			openandclose.closeConnection(conn);
		}
		return stuid;
	}

}
