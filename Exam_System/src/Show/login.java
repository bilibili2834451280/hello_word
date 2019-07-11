package Show;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginning.html")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		this.Loginpass(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	//���ݲ�ͬ�����ת����ҳ��
	public void Loginpass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String  no=request.getParameter("no");//��ȡ�˺�
		String password=request.getParameter("password");//��ȡ����
		Way w=new Solution();		
		int passtipe=w.login(no, password);//�ж��˺������Ƿ���ȷ
		if(passtipe==0)//������ת���󵯴�
		{
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.sendRedirect("worthpwd.html");
			//response.sendRedirect("index.html");
		}
		if(passtipe==1)//��תѧ��ҳ��
		{
			//out.println("s");
			//System.out.println("s");
			//response.setCharacterEncoding("UTF-8");
			request.setAttribute("stuno", no);//����ѧ��ѧ��
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			//request.getRequestDispatcher("showofstudent.html").forward(request, response);
		    response.sendRedirect("showofstudent.html");
		
		}
		if(passtipe==2)//��ת��ʦҳ��
		{
			//out.println("t");
			//System.out.println("t");
			request.setAttribute("teano", no);//������ʦѧ��
			response.sendRedirect("showofteacher.html");
		}
		if(passtipe==3)//��ת����Ա����
		{
			//out.println("m");
			//System.out.println("m");
			request.setAttribute("manano", no);//�������Աѧ��
			response.sendRedirect("showofmanager.html");
		}
		//request.setAttribute("rightStu", w.getmassage(name));
		
		
	}

}
