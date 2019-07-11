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
import Shixain.Student;

/**
 * Servlet implementation class Pageofzhuce
 */
@WebServlet("/zhuceweb.html")
public class Pageofzhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pageofzhuce() {
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
		this.zhucexinxi(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//×¢²á
	public void zhucexinxi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String  no=request.getParameter("userno");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String discipline=request.getParameter("discipline");
		String grade=request.getParameter("grade");
		Student s=new Student(no,password,name,discipline,grade);
		Way w=new Solution();
		if(w.checkzhuce(no))
		{
			w.zhuceofStudent(s);//×¢²á
			response.sendRedirect("showzhuce.html");//ÌøÈëÏÔÊ¾×¢²áÒ³Ãæ
		}
		else
		{
			response.sendRedirect("showfalsezhuce.html");//ÌøÈë×¢²á´íÎóµ¯´°
		}
		

		
	}

}
