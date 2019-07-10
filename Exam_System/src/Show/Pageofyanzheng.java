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
	public void yanzhengnameandno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String shengfen=request.getParameter("yesorno");//获取身份
		String  no=request.getParameter("userno");//获取账号
		String name=request.getParameter("name");//获取姓名
		System.out.println(shengfen+no+name);
		request.setAttribute("rightno", no);
		request.setAttribute("rightshengfen", shengfen);
		Way w=new Solution();
		if(shengfen.equals("student")){w.massagestupipei(no, name);}
		if(shengfen.equals("teacher")){w.massageteapipei(no, name);}
		boolean pass=true;//调用信息匹配函数
		if(pass==true)//匹配成功
		{
			request.getRequestDispatcher("fpass.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("yanzheng.html").forward(request, response);
		}
	}

}
