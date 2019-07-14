<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>试题库管理系统</title>
<style>
	.divcss6{color:white; font-size:30px;text-align:center; left: 650px; position: absolute; top: 200px;}
	.button {

            background-color:#888888;
            background-repeat:no-repeat;
            border:#585858;
            cursor:pointer;
            overflow: hidden;
        }
</style>
</head>
<body background="images/p4.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;" >
<form action="pdate2.html"  method="post">
<br/><br/>
<% 
String no1=(String)session.getAttribute("manano");  
%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font  size="6" face="方正粗黑宋简体" color=white>欢迎进入管理员试题库管理系统 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=no1%></font>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.html" margin-left:5 style="color:white; text-decoration: none;">退出登录</a>
<br/><br/>
<table align="center" width="1500" height="600" border="2" bordercolor:rgba(0,0,0,0.9)>
<tr bgcolor:rgba(0,0,0,0.9)>
 <th width="200px" height="50px"><font  size="4" face="方正粗黑宋简体" color=white>管理员功能</th>
 <th width="1000px" height="50px">&nbsp;</th>
 
</tr>
<tr bgcolor:rgba(0,0,0,0.9)>
<th width="200px" height="500px" rowspan="13" colspan="1">
 	 <a href=insert.jsp style="color:white; text-decoration: none;">新添试题</a><br/>
 <br />
 <a href=select.jsp style="color:white; text-decoration: none;">查找试题</a><br/>
 <br />
 <a href=delete.jsp style="color:white; text-decoration: none;">删除试题</a><br/>
 <br/>
  <a href="fdb.html" style="color:white; text-decoration: none;">数据库备份</a><br/>
 <br/>
  <a href="fdbd.html" style="color:white; text-decoration: none;">数据库恢复</a>
 </th>
 <th width="1000px" height="500px" rowspan="13" colspan="13">
 	
 	<div class="divcss6" >更改信息如下：</div><br />
	<div style="left: 400px; position: absolute; top: 250px; color: white;">  编号：   		</div> <input type="text" name="pro_no" value=${requestScope.info.pro_no }
		                                                                                    style="left: 540px; position: absolute; top: 250px;"/><br />
	<div style="left: 400px; position: absolute; top: 300px; color: white;"> 题目：               </div><input type="text" name="pro_detail" value=${requestScope.info.pro_detail }
		                                                                                     style="left: 540px; position: absolute; top: 300px;"/></div><br />
	<div style="left: 400px; position: absolute; top: 450px; color: white;">  关键字：</div> <input type="text" name="pro_keyw" value=${requestScope.info.pro_keyw }
		                                                                                  style="left: 540px; position: absolute; top: 450px;"/></div><br />
	<div style="left: 400px; position: absolute; top: 400px; color: white;"> 难度系数：	</div><input type="text" name="pro_dif" value=${requestScope.info.pro_dif }
		                                                                                     style="left: 540px; position: absolute; top: 400px;"/></div><br />
	<div style="left: 800px; position: absolute; top: 250px; color: white;"> 所属章节编号：</div><input type="text" name="cha_no" value=${requestScope.info.cha_no }
		                                                                                     style="left: 940px; position: absolute; top: 250px;"/></div><br />
	<div style="left: 800px; position: absolute; top: 300px; color: white;"> 所属章节标题：	</div><input type="text" name="cha_title" value=${requestScope.info.cha_title }
		                                                                                     style="left: 940px; position: absolute; top: 300px;"/></div><br />
	<div style="left: 800px; position: absolute; top: 350px; color: white;"> 所属章节要点：</div>	<input type="text" name="cha_mpoint" value=${requestScope.info.cha_mpoint }
		                                                                                     style="left: 940px; position: absolute; top: 350px;"/></div><br />
	<div style="left: 800px; position: absolute; top: 400px; color: white;"> 答案编号：	</div><input type="text" name="pro_ansno" value=${requestScope.info.pro_ansno }
		                                                                                     style="left: 940px; position: absolute; top: 400px;"/></div><br />
	<div style="left: 400px; position: absolute; top: 350px; color: white;"> 答案：	</div><input type="text" name="ans_detail" value=${requestScope.info.ans_detail }
		                                                                                     style="left: 540px; position: absolute; top: 350px;"/></div><br />		
	<input class="button" type="submit" value="更改" onclick="document.form1.Submit();"
		                          style="left: 720px; position: absolute; top: 550px;
		                          height: 30px;width: 50px;"/>	                                                                                     
		<div style="left: 800px; position: absolute; top: 450px; color: white;"> 习题类型： <select name="pro_type" style="left: 140px; position: absolute; top: 0px;width: 190px;">
	                                                                                        <option value="blank">填空</option>
                                                                                            <option value="choice">选择</option>
                                                                                            <option value="judge">判断</option>
                                                                                            <option value="short answer">简答</option>
                                                                                     </select>	  
 </th>
</tr>

</table>
</body>
</html>