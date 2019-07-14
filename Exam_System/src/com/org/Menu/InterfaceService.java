package com.org.Menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InterfaceService {
	public void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		selectrealize dao = new selectrealize();
		String no=request.getParameter("item_no");
		real r1 = new real();
		
		boolean judge=dao.check(no);
		if(judge)
		{
			r1 = dao.getinfobypro_no(no);
			request.setAttribute("info", r1);
			request.getRequestDispatcher("fupdate.jsp").forward(request, response);
		}
		else
		{
			out.println("<script language='javascript'>alert('查询不到该试题！')</script>");
			response.sendRedirect("showofteacher.jsp");
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ALLinterface dao2= new updaterealzie();
		String prono = request.getParameter("pro_no");
		String  detail= request.getParameter("pro_detail");
		String ansno = request.getParameter("pro_ansno");
		System.out.println("pro_ansno="+ansno);
		String  keyw= request.getParameter("pro_keyw");
		String dif = request.getParameter("pro_dif");
		String chano =request.getParameter("cha_no");
		String  title= request.getParameter("cha_title");
		String  mpoint= request.getParameter("cha_mpoint");
		String  type= request.getParameter("pro_type");
		String  ans_detail= request.getParameter("ans_detail");
		real r2=new real(prono,detail,ansno,keyw,dif,chano,title,mpoint,type,ans_detail);
		System.out.println(r2.toString());
		dao2.updateinfo1(r2);
		dao2.updateinfo2(r2);
		out.println("<script language='javascript'>alert('修改成功！')</script>");
		response.sendRedirect("showofteacher.jsp");
	}

	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String  a=request.getParameter("PRO_NO");//获取NO
		String PRO_DETAIL=request.getParameter("PRO_DETAIL");//获取输入内容
		String c=request.getParameter("PRO_ANSNO");//获取输入内容
		String PRO_KEYW=request.getParameter("PRO_KEYW");//获取输入内容
		String z=request.getParameter("PRO_DIF");//获取输入内容
		String f=request.getParameter("CHA_NO");//获取输入内容
		String CHA_TITLE=request.getParameter("CHA_TITLE");//获取输入内容
		String CHA_MPOINT=request.getParameter("CHA_MPOINT");//获取输入内容
		String CHA_TYPE=request.getParameter("CHA_TYPE");
		String ANS_NO="a";
		String ANS_DETAIL=request.getParameter("ANS_DETAIL");
		//System.out.println(CHA_NO);
		insertrealize finsert= new insertrealize();
		
		int judge=finsert.Insert(a, PRO_DETAIL, c, PRO_KEYW, z,f, CHA_TITLE, CHA_MPOINT, CHA_TYPE,ANS_NO,ANS_DETAIL);
		if(judge!=0) {
			//response.sendRedirect("Finsert.jsp");
			out.println("<script language='javascript'>alert('插入成功！')</script>");
			response.sendRedirect("showofteacher.jsp");
		}
		else {
			out.println("<script language='javascript'>alert('插入错误！')</script>");
			response.sendRedirect("showofteacher.jsp");
		}
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String  a=request.getParameter("PRO_NO");//获取NO
		deleterealize fdelete=new deleterealize();
		int judge=fdelete.delete(a);
		if(judge!=0) {
			//response.sendRedirect("Fdelete.jsp");
			out.println("<script language='javascript'>alert('删除成功！')</script>");
			response.sendRedirect("showofteacher.jsp");
		}
		else {
			out.println("<script language='javascript'>alert('查找不到要删除的试题！')</script>");
			response.sendRedirect("showofteacher.jsp");
		}
		
		
	}
}
