package com.org.Exam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExamDaoMpl {
	public Exam getExamByNo(String no1) {
		Connection conn= ExamUtils.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = null;
			sql = "select * from test where tst_no= ?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, no1);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int i=0;
				String sql2 = null;
				sql2 = "select * from testpro where tst_no= ?";
				stmt = conn.prepareStatement(sql2);
				stmt.setString(1, no1);
				ResultSet rs2 = stmt.executeQuery();
				String[] sList1=new String[200];
				while(rs2.next()){
					sList1[i++]=rs2.getString("pro_no");
				}
				
				Exam s2=new Exam(rs.getString("tst_no"),rs.getString("tst_name"),rs.getString("tst_time"),rs.getString("tst_type"),rs.getString("tst_dif"),rs.getString("tst_num"),rs.getString("tst_score"),sList1);
				ExamUtils.closeResultSet(rs);
				ExamUtils.closeResultSet(rs2);
				ExamUtils.closeStatement(stmt);
				ExamUtils.closeConnection(conn);
				return s2;
			}
			else{
				System.out.println("学号不存在");
				ExamUtils.closeResultSet(rs);
				ExamUtils.closeStatement(stmt);
				ExamUtils.closeConnection(conn);
				return null;
			}

		} catch (Exception ee) {
			ee.printStackTrace();
		} 
		return null;
	}

	public void insertExam(Exam s1) {
		Connection conn = ExamUtils.getConnection();;
		PreparedStatement stmt = null;
		try {
			String sql = null;
			sql = "INSERT INTO test(tst_no,tst_name,tst_time,tst_type,tst_dif,tst_num,tst_score) VALUES(?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, s1.getTst_no());
			stmt.setString(2, s1.getTst_name());
			stmt.setString(3, s1.getTst_time());
			stmt.setString(4, s1.getTst_type());
			stmt.setString(5, s1.getTst_dif());
			stmt.setString(6, s1.getTst_num());
			stmt.setString(7, s1.getTst_score());

			stmt.executeUpdate();
			
			String[] list=s1.getTst_detail();
			for(int i=0;i<list.length;i++){
				if(list[i]!=null){
					sql = "INSERT INTO testpro(tst_no,pro_no) VALUES(?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, s1.getTst_no());
					stmt.setString(2, list[i]);
					stmt.executeUpdate();
				}
			}
			
			ExamUtils.closeStatement(stmt);
			ExamUtils.closeConnection(conn);
		} catch (Exception ee) {
			ee.printStackTrace();
		} 
	}

	public void updateExam(Exam s1) {
		Exam sTest;
		sTest=getExamByNo(s1.getTst_no());
		if(sTest==null){
			System.out.println("更新失败，本示例不存在！");
		}
		else{
			Connection conn = ExamUtils.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = null;
				sql = "update test set tst_no=?,tst_name=?,tst_time=?,tst_type=?,tst_dif=?,tst_num=?,tst_score=?";
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, s1.getTst_no());
				stmt.setString(2, s1.getTst_name());
				stmt.setString(3, s1.getTst_time());
				stmt.setString(4, s1.getTst_type());
				stmt.setString(5, s1.getTst_dif());
				stmt.setString(6, s1.getTst_num());
				stmt.setString(7, s1.getTst_score());

				stmt.executeUpdate();
				ExamUtils.closeStatement(stmt);
				ExamUtils.closeConnection(conn);
			} catch (Exception ee) {
				ee.printStackTrace();
			} 
		}
	}

	public void deleteExam(String no1) {
		Exam sTest;
		sTest=getExamByNo(no1);
		if(sTest==null){
			System.out.println("删除失败，本示例不存在！");
		}
		else{
			Connection conn = ExamUtils.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = null;
				sql = "delete from test where tst_no=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,no1);
				stmt.executeUpdate();
				
				sql = "delete from testpro where tst_no=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,no1);
				stmt.executeUpdate();
				
				ExamUtils.closeStatement(stmt);
				ExamUtils.closeConnection(conn);
			} catch (Exception ee) {
				ee.printStackTrace();
			} 
		}
	}	
}
