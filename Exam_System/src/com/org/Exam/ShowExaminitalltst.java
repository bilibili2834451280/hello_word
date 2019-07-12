package com.org.Exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowExaminit
 */
@WebServlet("/ShowExaminitalltst")
public class ShowExaminitalltst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowExaminitalltst() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// StudentDao impl=new StudentDaoimpl();

		ExamDaoMpl impl = new ExamDaoMpl();
		List<String> tst_name_no = new ArrayList<String>();
		tst_name_no = impl.getExamname_tst_no();
		response.setContentType("text/html;charset=utf-8");
		String ans = new String();

		
		for (int i = 0; i < tst_name_no.size(); i+=2) {
			ans += "<dd><a href='javascript:refresh1(" + tst_name_no.get(i+1) + ");'>" + tst_name_no.get(i) + "</a></dd>";
		}
		
		if(ans.length()<=0) {
			for (int i = 0; i < 3; i++)
				ans += "<dd><a href='javascript:refresh1(" + i + ");'>testtest</a></dd>";
		}

		response.getWriter().write(ans);

//		out.print(tst_name_no);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
