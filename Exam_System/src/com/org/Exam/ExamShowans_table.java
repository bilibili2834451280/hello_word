package com.org.Exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class ExamShowans_table
 */
@WebServlet("/ExamShowans_table")
public class ExamShowans_table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamShowans_table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
		ExamDaoMpl impl = new ExamDaoMpl(); 
		List<Answer_table> anstable=impl.getExamanstable(request.getParameter("tst_no"));
		
		JsonArray jsonArray=new com.google.gson.Gson().toJsonTree(anstable,new TypeToken<List<Answer_table>>(){}.getType()).getAsJsonArray();
		String json="{"+"\"code\":0,\"msg\":\"\",\"count\":"+anstable.size()+",\"data\":"+jsonArray.toString()+"}";
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
