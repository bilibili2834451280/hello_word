<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<form action="fDelete.jsp"  method="post">
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
 	<iframe src="ExamInfoWrite.html" style="width:100%;height:100%"/>
 </th>
</tr>

</table>
</body>
</html>