<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题库修改</title>
</head>
<body>
<form action="fupdate2.html"  method="post">
<font size="5" color=blueviolet>查询成功，如需更改，在更改框中填写信息：</font><br />
		编号：<input type="text" name="item_pro_no" value=${requestScope.info.pro_no } ></input><br />
		题目：<input type="text" value=${requestScope.info.pro_detail } name="item_pro_detail"/><br />
		习题答案编号：<input type="text" value=${requestScope.info.pro_ansno } name="item_pro_ansno"/> <br />
		关键字：<input type="text" value=${requestScope.info.pro_keyw } name="item_pro_keyw"/> <br />
		难度系数：<input type="text" value=${requestScope.info.pro_dif } name="item_pro_dif"/> <br />
		所属章节编号：<input type="text" value=${requestScope.info.cha_no } name="item_cha_no"/> <br />
		所属章节标题：<input type="text" value=${requestScope.info.cha_title } name="item_cha_title"/> <br />
		所属章节要点：<input type="text" value=${requestScope.info.cha_mpoint } name="item_cha_mpoint"/> <br />
		习题类型：<input type="text" value=${requestScope.info.pro_type } name="item_pro_type"/> <br />
		<input type="submit" value="更新" onclick="document.form1.Submit();"/>
</form>
</body>
</html>