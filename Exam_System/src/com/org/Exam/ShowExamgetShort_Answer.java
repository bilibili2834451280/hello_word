package com.org.Exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowExamgetShort_Answer
 */
@WebServlet("/ShowExamgetShort_Answer")
public class ShowExamgetShort_Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowExamgetShort_Answer() {
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
		
		  ExamDaoMpl impl = new ExamDaoMpl(); List<String>
		  Short_Answertmp=impl.getExamShort_Answer(request.getParameter("tst_no"));
		  String ans = new String(); for(int i=0;i<Short_Answertmp.size();i+=2) {
		  ans+="<div class='layui-colla-item'>";
		  ans+="<h2 class='layui-colla-title'>"+Short_Answertmp.get(i)+"</h2>";
		  ans+="<div class='layui-colla-content'>";
		  ans+="<blockquote class='layui-elem-quote'>"; 
		  ans+=Short_Answertmp.get(i+1);
		  ans+="</blockquote>"; 
		  ans+="<div class='layui-form-item layui-form-text'>";
		  ans+="<label class='layui-form-label'>作答区域</label>";
		  ans+="<div class='layui-input-block'>"; 
		  ans+="<textarea placeholder='请输入内容' class='layui-textarea' lay-verify='required|content' name='"+Short_Answertmp.get(i)+"'></textarea>";
		  ans+="</div></div></div></div>"; 
		  }
		 
		
		
		/*
		 * String ans=new String(); ans+="<div class='layui-colla-item'>";
		 * ans+="<h2 class='layui-colla-title'>题目一</h2>";
		 * ans+="<div class='layui-colla-content'>";
		 * ans+="<blockquote class='layui-elem-quote'>"; ans+=
		 * "根据以下材料，选取角度，自拟题目，写一篇不少于800字的文章；除诗歌外，文体自选。</br>物各有性，水至淡，盐得味。水加水还是水，盐加盐还是盐。酸甜苦辣咸，五味调和，共存相生，百味纷呈。物如此，事犹是，人亦然。";
		 * ans+="</blockquote>"; ans+="<div class='layui-form-item layui-form-text'>";
		 * ans+="<label class='layui-form-label'>作答区域</label>";
		 * ans+="<div class='layui-input-block'>"; ans+
		 * ="<textarea placeholder='请输入内容' class='layui-textarea' lay-verify='required|content' name='题目一'></textarea>"
		 * ; ans+="</div></div></div></div>";
		 */
	
	
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
