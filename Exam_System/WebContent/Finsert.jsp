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
<form action="fInsert"  method="post">
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font  size="6" face="方正粗黑宋简体" color=white>欢迎进入教师试题库管理系统</font>
<br/><br/>
<table align="center" width="1500" height="600" border="2" bordercolor:rgba(0,0,0,0.9)>
<tr bgcolor:rgba(0,0,0,0.9)>
 <th width="200px" height="50px"><font  size="4" face="方正粗黑宋简体" color=white>教师功能</th>
 <th width="1000px" height="50px">&nbsp;</th>
 
</tr>
<tr bgcolor:rgba(0,0,0,0.9)>
<th width="200px" height="500px" rowspan="13" colspan="1">
 	 <a href=Finsert.jsp style="color:white; text-decoration: none;">新添试题</a><br/>
 <br />
 <a href=Fselect.html style="color:white; text-decoration: none;">查找试题</a><br/>
 <br />
 <a href=Fdelete.jsp style="color:white; text-decoration: none;">删除试题</a><br/>
 <br/>
  <a href=Fdelete.jsp style="color:white; text-decoration: none;">生成试卷</a>
 </th>
 <th width="1000px" height="500px" rowspan="13" colspan="13">
 	
 	<div class="divcss6" >新增试题信息：</div><br />
	<div style="left: 580px; position: absolute; top: 250px; color: white;">  编号：   		</div> <input type="text" name="PRO_NO"
		                                                                                    style="left: 720px; position: absolute; top: 250px;"/><br />
	<div style="left: 580px; position: absolute; top: 300px; color: white;"> 题目：               </div><input type="text" name="PRO_DETAIL"
		                                                                                     style="left: 720px; position: absolute; top: 300px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 350px; color: white;"> 习题答案编号： </div> <input type="text" name="PRO_ANSNO"
		                                                                                     style="left: 720px; position: absolute; top: 350px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 400px; color: white;"> 关键字： </div> <input type="text" name="PRO_KEYW"
		                                                                                     style="left: 720px; position: absolute; top: 400px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 450px; color: white;"> 难度系数：	</div><input type="text" name="PRO_DIF"
		                                                                                     style="left: 720px; position: absolute; top: 450px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 500px; color: white;"> 所属章节编号：</div><input type="text" name="CHA_NO"
		                                                                                     style="left: 720px; position: absolute; top: 500px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 550px; color: white;"> 所属章节标题：	</div><input type="text" name="CHA_TITLE"
		                                                                                     style="left: 720px; position: absolute; top: 550px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 600px; color: white;"> 所属章节要点：</div>	<input type="text" name="CHA_MPOINT"
		                                                                                     style="left: 720px; position: absolute; top: 600px;"/></div><br />
	<div style="left: 580px; position: absolute; top: 650px; color: white;"> 习题类型：	</div><input type="text" name="CHA_TYPE"
		                                                                                     style="left: 720px; position: absolute; top:650px;"/></div><br />
	
						
		      
		<input class="button" type="submit" value="插入" onclick="document.form1.Submit();"
		                          style="left: 720px; position: absolute; top: 690px;
		                          height: 30px;width: 50px;"/>
 </th>
</tr>

</table>
</body>
</html>