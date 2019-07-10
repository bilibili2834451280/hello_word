<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="images/p2.png">
<form action="index.html"  method="post">
<br/><br/><br/><br/><br/><br/>
<center><font  size="7" face="方正粗黑宋简体" color=white>您的密码是</font><br/><br/><br/><br/><br/><br/>
<font  size="7" face="方正粗黑宋简体" color=white>${requestScope.rightpassword}</font><br/><br/><br/><br/><br/><br/>
<input type="submit" style="background-color:#4cc2c4; color: #fff;  width:100px; height:45px;" value="返回登陆界面">

</center>
</form>
</body>
</html>