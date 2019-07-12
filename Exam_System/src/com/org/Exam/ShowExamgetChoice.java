package com.org.Exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowExamgetChoice
 */
@WebServlet("/ShowExamgetChoice")
public class ShowExamgetChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowExamgetChoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ExamDaoMpl impl = new ExamDaoMpl();
		List<String> Choicetmp=impl.getExampro_Choice(request.getParameter("tst_no"));
		String ans=new String();
		for(int i=0;i<Choicetmp.size();i+=6) {
			ans+="<div class='layui-colla-item'>";
			ans+="<h2 class=\"layui-colla-title\">"+Choicetmp.get(i+5)+"</h2>";
			ans+="<div class=\"layui-colla-content layui-show\">";
			ans+="<blockquote class=\"layui-elem-quote\">";
			ans+=Choicetmp.get(i);
			ans+="</blockquote>";
			ans+="<div class=\"layui-form-item\">";
			ans+="<div class=\"layui-input-block\">";
			ans+="<input type='radio' name='"+Choicetmp.get(i+5)+"' value='"+Choicetmp.get(i+1)+"' title='"+Choicetmp.get(i+1)+"'checked=''>";
			ans+="<input type='radio' name='"+Choicetmp.get(i+5)+"' value='"+Choicetmp.get(i+2)+"' title='"+Choicetmp.get(i+2)+"'>";
			ans+="<input type='radio' name='"+Choicetmp.get(i+5)+"' value='"+Choicetmp.get(i+3)+"' title='"+Choicetmp.get(i+3)+"'>";
			ans+="<input type='radio' name='"+Choicetmp.get(i+5)+"' value='"+Choicetmp.get(i+4)+"' title='"+Choicetmp.get(i+4)+"'>";
		}
		response.getWriter().write(ans);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
