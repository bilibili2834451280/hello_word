package com.org.Exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamServce {
	// public void test(){
	/*
	 * String[] sList=new String[200]; sList[0]="1"; sList[1]="2"; sList[2]="3";
	 * sList[3]="4"; Exam s1=new
	 * Exam("1","第一次测验","1998-01-01","blank","1","20","100",sList); ExamDaoMpl
	 * mpl = new ExamDaoMpl(); mpl.insertExam(s1);
	 */

	// Dao层删除记录
	// ExamDaoMpl mpl = new ExamDaoMpl();
	// mpl.deleteExam("1");

	// Dao层查询记录
	/*
	 * Exam s1; ExamDaoMpl mpl = new ExamDaoMpl(); s1=mpl.getExamByNo("1");
	 * if(s1==null) System.out.println("不存在该记录"); else
	 * System.out.println(s1.toString());
	 */

	// Dao层修改记录
	/*
	 * Exam s1=new Exam("1","第二次测验","1998-01-01","judge","1","20","100");
	 * ExamDaoMpl mpl = new ExamDaoMpl(); mpl.updateExam(s1);
	 */
	// }
	public void createExam(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String DB_URL = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		String USER = "root";
		String PASS = "123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		PreparedStatement stmt = null;

		try {
			String sql = null;
			sql = "select * from problem where cha_no= ? and cha_mpoint= ? and pro_dif= ? and pro_type= ? order by rand() limit ?";
			stmt = conn.prepareStatement(sql);

			String tst_no = request.getParameter("tst_no");
			String tst_name = request.getParameter("tst_name");
			String cha_no = request.getParameter("cha_no");
			String cha_mpoint = request.getParameter("cha_mpoint");
			String tst_type = request.getParameter("tst_type");
			String tst_dif = request.getParameter("tst_dif");
			String tst_num = request.getParameter("tst_num");
			String tst_score = request.getParameter("tst_score");
			Date nowDate = new Date(System.currentTimeMillis());
			SimpleDateFormat time = new SimpleDateFormat(
					"yyyy年MM月dd日-HH时mm分ss秒");
			String tst_time = time.format(nowDate);
			System.out.println(tst_time);

			stmt.setString(1, cha_no);
			stmt.setString(2, cha_mpoint);
			stmt.setString(3, tst_dif);
			stmt.setString(4, tst_type);
			stmt.setInt(5, Integer.parseInt(tst_num));

			ResultSet rs = stmt.executeQuery();

			Exam e = new Exam(tst_no, tst_name, tst_time, tst_type, tst_dif,
					tst_num, tst_score);
			System.out.println(e.toString());
			String[] sList = new String[200];
			int num = 0;

			while (rs.next()) {
				sList[num++] = rs.getString("pro_no");
			}
			e.setTst_detail(sList);

			if (num != Integer.parseInt(tst_num)) {
				System.out.println("符合条件的题目数量不足！");
			} else {
				ExamDaoMpl mpl = new ExamDaoMpl();
				mpl.insertExam(e);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
}
