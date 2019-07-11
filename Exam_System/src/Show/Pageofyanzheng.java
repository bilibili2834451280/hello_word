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
 * Servlet implementation class Pageofyanzheng
 */
@WebServlet("/yanzheng.html")
public class Pageofyanzheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pageofyanzheng() {
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
		this.yanzhengnameandno(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	//忘记密码
	public void yanzhengnameandno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String shengfen=request.getParameter("yesorno");//获取身份
		String  no=request.getParameter("userno");//获取账号
		String name=request.getParameter("name");//获取姓名
		//System.out.println(shengfen+no+name);
		//request.setAttribute("rightno", no);
		//request.setAttribute("rightshengfen", shengfen);
		Way w=new Solution();
	
		if(shengfen.equals("student"))//学生
		{
			boolean pass=w.massagestupipei(no, name);//判断信息匹配结果
			if(pass)
			{
				String p=w.findstupassword(no);//寻址密码
				//System.out.println(p);
				request.setAttribute("rightpassword", p);//存储密码
				//response.sendRedirect("showpassword.jsp");
				request.getRequestDispatcher("showpassword.jsp").forward(request, response);//跳入显示密码界面
			}
			else
			{
				response.sendRedirect("falsefindpwd.html");//验证错误跳入错误弹窗
				//request.getRequestDispatcher("forgetpassword.html").forward(request, response);
			}
		}
		if(shengfen.equals("teacher"))//老师
		{
			boolean pass=w.massageteapipei(no, name);//判断信息匹配结果
	       if(pass)//匹配成功
		   {
	    	   String p=w.findteapassword(no);//寻找老师密码
	    	   //System.out.println(p);
				request.setAttribute("rightpassword", p);//存储密码
				//response.sendRedirect("showpassword.jsp");
				request.getRequestDispatcher("showpassword.jsp").forward(request, response);//显示密码
		   }
	       else
			{
	    	   response.sendRedirect("falsefindpwd.html");//验证错误跳入错误弹窗
	    	   //request.getRequestDispatcher("forgetpassword.html").forward(request, response);
			}
		}
	}

}
