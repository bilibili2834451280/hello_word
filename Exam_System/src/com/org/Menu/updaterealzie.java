package com.org.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class updaterealzie implements ALLinterface{
	public void updateinfo2(real INFO)// 更新
	{
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = openandclose.getConnection();
			String s="update  answer set ans_detail=?,"//答案
					+"ans_no=?"//答案编号
					+"where pro_no=? ";
			ps = conn.prepareStatement(s);
			ps.setString(1,INFO.getans_detail());
			ps.setString(2,INFO.getpro_ansno());
			ps.setString(3, INFO.getpro_no());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			openandclose.closeStatement(ps);
			openandclose.closeConnection(conn);
		}
	}
	public void updateinfo1(real INFO)// 更新
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement ps=null;
		try {
			conn = openandclose.getConnection();
			
			String sql = "update  problem set pro_detail=?," // 题目
					+ "pro_ansno=?,"// 习题答案编号
					+ "pro_keyw=?,"// 关键字
					+ "pro_dif=?,"// 难度系数
					+ "cha_no=?,"//所属章节编号
					+ "cha_title=?,"//所属章节标题
					+ "cha_mpoint=?,"//所属章节要点
					+ "pro_type=?"//习题类型
					+ "where pro_no=? ";//查找
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, INFO.getpro_detail());
			pstmt.setString(2, INFO.getpro_ansno());
			pstmt.setString(3, INFO.getpro_keyw());
			pstmt.setString(4, INFO.getpro_dif());
			pstmt.setString(5, INFO.getcha_no());
			pstmt.setString(6,INFO.getcha_title());
			pstmt.setString(7,INFO.getcha_mpoint());
			pstmt.setString(8,INFO.getpro_type());
			pstmt.setString(9, INFO.getpro_no());
			pstmt.executeUpdate();// 插入到数据
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			openandclose.closeStatement(pstmt);
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





}

