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
			out.println("<script language='javascript'>alert('��ѯ���������⣡')</script>");
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ALLinterface dao2= new updaterealzie();
		String prono = request.getParameter("item_pro_no");
		String  detail= request.getParameter("item_pro_detail");
		String ansno = request.getParameter("item_pro_ansno");
		String  keyw= request.getParameter("item_pro_keyw");
		String dif = request.getParameter("item_pro_dif");
		String chano =request.getParameter("item_cha_no");
		String  title= request.getParameter("item_cha_title");
		String  mpoint= request.getParameter("item_cha_mpoint");
		String  type= request.getParameter("item_pro_type");
		real r2=new real(prono,detail,ansno,keyw,dif,chano,title,mpoint,type);
		System.out.println(r2.toString());
		dao2.updateinfo(r2);
		out.println("<script language='javascript'>alert('�޸ĳɹ���')</script>");
	}

	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String  a=request.getParameter("PRO_NO");//��ȡNO
		String PRO_DETAIL=request.getParameter("PRO_DETAIL");//��ȡ��������
		String c=request.getParameter("PRO_ANSNO");//��ȡ��������
		String PRO_KEYW=request.getParameter("PRO_KEYW");//��ȡ��������
		String z=request.getParameter("PRO_DIF");//��ȡ��������
		String f=request.getParameter("CHA_NO");//��ȡ��������
		String CHA_TITLE=request.getParameter("CHA_TITLE");//��ȡ��������
		String CHA_MPOINT=request.getParameter("CHA_MPOINT");//��ȡ��������
		String CHA_TYPE=request.getParameter("CHA_TYPE");
		
		//System.out.println(CHA_NO);
		insertrealize finsert= new insertrealize();
		
		int judge=finsert.Insert(a, PRO_DETAIL, c, PRO_KEYW, z,f, CHA_TITLE, CHA_MPOINT, CHA_TYPE);
		if(judge!=0) {
			//response.sendRedirect("Finsert.jsp");
			out.println("<script language='javascript'>alert('����ɹ���')</script>");
		}
		else {
			out.println("<script language='javascript'>alert('�������')</script>");
		}
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String  a=request.getParameter("PRO_NO");//��ȡNO
		deleterealize fdelete=new deleterealize();
		int judge=fdelete.delete(a);
		if(judge!=0) {
			//response.sendRedirect("Fdelete.jsp");
			out.println("<script language='javascript'>alert('ɾ���ɹ���')</script>");
		}
		else {
			out.println("<script language='javascript'>alert('���Ҳ���Ҫɾ�������⣡')</script>");
		}
		
		
	}
}
