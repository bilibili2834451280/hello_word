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
	//更改密码
	public void uppassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String shengfen=request.getParameter("yesorno");//获取身份
		String  no=request.getParameter("userno");//获取账号
		String oldpwd=request.getParameter("oldpassword");//获取旧密码
		String newpwd=request.getParameter("newpassword");//获取新密码
		//System.out.println(shengfen+no+oldpwd+newpwd);
		Way w=new Solution();
		if(shengfen.equals("student"))//学生
		{
			//System.out.println("ok");
			boolean updatetipe=w.updatestupwd(no, oldpwd, newpwd);//判断旧密码是否正确
			if(updatetipe)
			{
				w.updatestuwork(no,newpwd);//更改密码
				response.sendRedirect("showofupdatesuccess.html");//跳转更改成功界面
				//request.getRequestDispatcher("showofupdatesuccess.html").forward(request, response);
			}
			else
			{
				
				response.sendRedirect("showofupdatefalse.html");//跳转信息错误界面
				//request.getRequestDispatcher("showofupdatefalse.html").forward(request, response);
			}
		}
		if(shengfen.equals("teacher"))//老师
		{
			boolean updatetipe=w.updateteapwd(no, oldpwd, newpwd);//判断旧密码是否正确
			if(updatetipe)
			{
				w.updateteawork(no, newpwd);
				response.sendRedirect("showofupdatesuccess.html");//跳转更改成功界面
				//request.getRequestDispatcher("showofupdatesuccess.html").forward(request, response);
			}
			else
			{
				response.sendRedirect("showofupdatefalse.html");//跳转信息错误界面
				//request.getRequestDispatcher("showofupdatefalse.html").forward(request, response);
			}
		}
	}

}
