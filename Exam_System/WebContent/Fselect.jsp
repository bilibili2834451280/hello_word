<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题库管理系统</title>
<style>
	.divcss6{color:white; font-size:30px;text-align:center; left: 600px; position: absolute; top: 200px;}
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
<form action="fselect2.html"  method="post">
<br/><br/>
<% 
String no1=(String)session.getAttribute("teano");  
%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font  size="6" face="方正粗黑宋简体" color=white>欢迎进入教师试题库管理系统 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=no1%></font>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.html" margin-left:5 style="color:white; text-decoration: none;">退出登录</a>
<br/><br/>
<table align="center" width="1500" height="600" border="2" bordercolor:rgba(0,0,0,0.9)>
<tr bgcolor:rgba(0,0,0,0.9)>
 <th width="200px" height="50px"><font  size="4" face="方正粗黑宋简体" color=white>教师功能</th>
 <th width="1000px" height="50px">&nbsp;</th>
 
</tr>
</tr>
<tr bgcolor:rgba(0,0,0,0.9)>
<th width="200px" height="500px" rowspan="13" colspan="1">
 	 <a href=Finsert.jsp style="color:white; text-decoration: none;">新添试题</a><br/>
 <br />
 <a href=Fselect.jsp style="color:white; text-decoration: none;">查找试题</a><br/>
 <br />
 <a href=Fdelete.jsp style="color:white; text-decoration: none;">删除试题</a><br/>
 <br/>
  <a href=ExamInfoWrite.html style="color:white; text-decoration: none;">生成试卷</a>
 </th>
 <th width="1000px" height="500px" rowspan="13" colspan="13">
 	
 	<div class="divcss6" >请输入你要查询的试题编号：</div><br />
 	</div> <input type="text" name="item_no" 
	style="left: 630px; position: absolute; top: 300px;
	border:0px;
	height: 30px;width: 300px;"/><br />
	
	<input class="button" type="submit" value="查询" onclick="document.form1.Submit();"
		style="left: 750px; position: absolute; top: 370px;
		height: 30px;width: 50px;"/>
 </th>
</tr>

</table>
</body>
</html>