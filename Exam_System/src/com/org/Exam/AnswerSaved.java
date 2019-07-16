package com.org.Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class AnswerSaved
 */
@WebServlet("/AnswerSaved.html")
public class AnswerSaved extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswerSaved() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		this.stuAnswerSave(request, response);
	}
	static int numAll=0;
	public void stuAnswerSave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
        {
            String json = request.getParameter("json1");
            String tst_no = request.getParameter("tst_no");
            System.out.println(json);
            
            JsonParser p = new JsonParser();
            JsonElement e = p.parse(json);
            int num=jsonTree(e);
            ExamDaoMpl mpl2=new ExamDaoMpl();
            HttpSession session = request.getSession();
            int score=mpl2.getScorebyno(tst_no);
            double stu_score=(score*1.0/numAll)*num;
            mpl2.ansSaved(tst_no,session.getAttribute("stuno").toString(), json,stu_score+"");
            out.println("回答正确的试题数量为"+num+"道,本次提交分数为"+stu_score+",本次答案已保存");
            //System.out.println("回答正确的试题数量为"+num+"道");
            //System.out.println("试卷编号为"+tst_no);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}
	public static int jsonTree(JsonElement e)
	{
		
        /*if (e.isJsonNull())
        {
            System.out.println(e.toString());
            return;
        }

        if (e.isJsonPrimitive())
        {
            System.out.println(e.toString());
            return;
        }

        if (e.isJsonArray())
        {
            JsonArray ja = e.getAsJsonArray();
            if (null != ja)
            {
                for (JsonElement ae : ja)
                {
                    jsonTree(ae);
                }
            }
            return;
        }*/
		int ans=0;
        if (e.isJsonObject())
        {	
            Set<Entry<String, JsonElement>> es = e.getAsJsonObject().entrySet();
            for (Entry<String, JsonElement> en : es)
            {
            	numAll++;
            	String pro_no=en.getKey();
            	String ans_detail=en.getValue().getAsString();
            	ExamDaoMpl mpl=new ExamDaoMpl();
            	String realAns=mpl.getAnsbyNo(pro_no);
            	System.out.println(ans_detail);
            	System.out.println(realAns);
            	if(ans_detail.equals(realAns)){
            		ans++;
            	}
            }
        }
        return ans;
    }
}
