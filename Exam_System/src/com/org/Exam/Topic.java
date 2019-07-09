package com.org.Exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Topic
 */
@WebServlet("/Topic.html")
public class Topic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			this.searchTopic(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchTopic(HttpServletRequest request,
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
			SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");
			String tst_time=time.format(nowDate);
			System.out.println(tst_time);

			stmt.setString(1, cha_no);
			stmt.setString(2, cha_mpoint);
			stmt.setString(3, tst_dif);
			stmt.setString(4, tst_type);
			stmt.setInt(5, Integer.parseInt(tst_num));

			ResultSet rs = stmt.executeQuery();
			
			Exam e=new Exam(tst_no,tst_name,tst_time,tst_type,tst_dif,tst_num,tst_score);
			String[] sList=new String[200];
			int num=0;
			
			while(rs.next()){
				sList[num++]=rs.getString("pro_no");
			}
			e.setTst_detail(sList);
			
			if(num!=Integer.parseInt(tst_num)){
				System.out.println("符合条件的题目数量不足！");
			}
			else{
				ExamDaoMpl mpl=new ExamDaoMpl();
				mpl.insertExam(e);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public void Test() {
		ExamServce es = new ExamServce();
		// es.test();
	}
}
