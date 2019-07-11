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
	 * Exam("1","��һ�β���","1998-01-01","blank","1","20","100",sList); ExamDaoMpl
	 * mpl = new ExamDaoMpl(); mpl.insertExam(s1);
	 */

	// Dao��ɾ����¼
	// ExamDaoMpl mpl = new ExamDaoMpl();
	// mpl.deleteExam("1");

	// Dao���ѯ��¼
	/*
	 * Exam s1; ExamDaoMpl mpl = new ExamDaoMpl(); s1=mpl.getExamByNo("1");
	 * if(s1==null) System.out.println("�����ڸü�¼"); else
	 * System.out.println(s1.toString());
	 */

	// Dao���޸ļ�¼
	/*
	 * Exam s1=new Exam("1","�ڶ��β���","1998-01-01","judge","1","20","100");
	 * ExamDaoMpl mpl = new ExamDaoMpl(); mpl.updateExam(s1);
	 */
	// }
	public boolean createExam(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Connection conn= ExamUtils.getConnection();
		PreparedStatement stmt = null;

		try {
			String sql = null;
			sql = "select * from problem where cha_no= ? and cha_mpoint= ? and ? and pro_type= ? order by rand() limit ?";
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
					"yyyy��MM��dd��-HHʱmm��ss��");
			String tst_time = time.format(nowDate);
			System.out.println(tst_time);

			if (tst_dif.contains("-")) {
				String[] difList = tst_dif.split("-");
				String maxn = Integer.parseInt(difList[0]) > Integer
						.parseInt(difList[1]) ? difList[0] : difList[1];
				String minn = Integer.parseInt(difList[0]) < Integer
						.parseInt(difList[1]) ? difList[0] : difList[1];
				System.out.println("max=" + maxn + " min=" + minn);
				sql = "select * from problem where cha_no= ? and cha_mpoint= ? and pro_dif between ? and ? and pro_type= ? order by rand() limit ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(3, minn);
				stmt.setString(4, maxn);
				stmt.setString(5, tst_type);
				stmt.setInt(6, Integer.parseInt(tst_num));
			} else {
				sql = "select * from problem where cha_no= ? and cha_mpoint= ? and pro_dif ? and pro_type= ? order by rand() limit ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(3, tst_dif);
				stmt.setString(4, tst_type);
				stmt.setInt(5, Integer.parseInt(tst_num));
			}

			stmt.setString(1, cha_no);
			stmt.setString(2, cha_mpoint);

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
				System.out.println("������������Ŀ�������㣡");
				return false;
			} else {
				ExamDaoMpl mpl = new ExamDaoMpl();
				mpl.insertExam(e);
				return true;
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return false;
	}
}
