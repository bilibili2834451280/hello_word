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
 * Servlet implementation class newpwd
 */
@WebServlet("/fpass.html")
public class newpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newpwd() {
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
		this.showpassword(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void showpassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		Way w=new Solution();
		String n=(String) request.getAttribute("rightno");
		String s=(String) request.getAttribute("rightshengfen");
		System.out.println(n+s);
		String p=null;
		if(s.equals("student")){
			p=w.findstupassword(n);
			request.setAttribute("rightpassword", p);
			request.getRequestDispatcher("showpassword.jsp").forward(request, response);
			}
		if(s.equals("teacher")){
			p=w.findteapassword(n);
			request.setAttribute("rightpassword", p);
			request.getRequestDispatcher("showpassword.jsp").forward(request, response);
			}
		
		
		
	}

}
