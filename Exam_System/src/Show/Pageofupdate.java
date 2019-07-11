package Show;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Solution;
import Dao.Way;

/**
 * Servlet implementation class Pageofupdate
 */
@WebServlet("/updatepassword.html")
public class Pageofupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pageofupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		this.uppassword(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	//��������
	public void uppassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String shengfen=request.getParameter("yesorno");//��ȡ���
		String  no=request.getParameter("userno");//��ȡ�˺�
		String oldpwd=request.getParameter("oldpassword");//��ȡ������
		String newpwd=request.getParameter("newpassword");//��ȡ������
		//System.out.println(shengfen+no+oldpwd+newpwd);
		Way w=new Solution();
		if(shengfen.equals("student"))//ѧ��
		{
			//System.out.println("ok");
			boolean updatetipe=w.updatestupwd(no, oldpwd, newpwd);//�жϾ������Ƿ���ȷ
			if(updatetipe)
			{
				w.updatestuwork(no,newpwd);//��������
				response.sendRedirect("showofupdatesuccess.html");//��ת���ĳɹ�����
				//request.getRequestDispatcher("showofupdatesuccess.html").forward(request, response);
			}
			else
			{
				
				response.sendRedirect("showofupdatefalse.html");//��ת��Ϣ�������
				//request.getRequestDispatcher("showofupdatefalse.html").forward(request, response);
			}
		}
		if(shengfen.equals("teacher"))//��ʦ
		{
			boolean updatetipe=w.updateteapwd(no, oldpwd, newpwd);//�жϾ������Ƿ���ȷ
			if(updatetipe)
			{
				w.updateteawork(no, newpwd);
				response.sendRedirect("showofupdatesuccess.html");//��ת���ĳɹ�����
				//request.getRequestDispatcher("showofupdatesuccess.html").forward(request, response);
			}
			else
			{
				response.sendRedirect("showofupdatefalse.html");//��ת��Ϣ�������
				//request.getRequestDispatcher("showofupdatefalse.html").forward(request, response);
			}
		}
	}

}
