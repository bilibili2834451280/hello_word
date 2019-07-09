package com.org.Exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		this.Test();
		/*try {
			this.searchTopic(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public void searchTopic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		String DB_URL = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
		String USER = "root";
		String PASS = "123";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        Connection conn = null;
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt = null;
        
        try {
			String sql = null;
			//sql = "select * from ti where cha_no= ? and cha_mpoint=? and pro_dif=?";
			sql="select * from ti where cha_no= ? and cha_mpoint=? and pro_dif=? order by rand() limit ?";
			stmt = conn.prepareStatement(sql);
			
			int cha_no= Integer.parseInt(request.getParameter("cha_no"));
			String cha_mpoint= request.getParameter("cha_mpoint");
			int pro_dif= Integer.parseInt(request.getParameter("pro_dif"));
			int pro_num= Integer.parseInt(request.getParameter("pro_num"));
			
			stmt.setInt(1, cha_no);
			stmt.setString(2, cha_mpoint);
			stmt.setInt(3, pro_dif);
			stmt.setInt(4, pro_num);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {	
				
				System.out.println(rs.getString("pro_detail"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} 
	}
	public void Test(){
		ExamServce es=new ExamServce();
		//es.test();
	}
}
