<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="fInsert"  method="post">
	编号：	<input type="text" name="PRO_NO" /><br/>
	<br />
	题目：	<input type="text" name="PRO_DETAIL" /><br/>
	<br />
	习题答案编号：	<input type="text" name="PRO_ANSNO" /><br/>
	<br />
	关键字：	<input type="text" name="PRO_KEYW" /><br/>
	<br />
	难度系数：	<input type="text" name="PRO_DIF" /><br/>
	<br />
	所属章节编号：	<input type="text" name="CHA_NO" /><br/>
	<br />
	所属章节标题：	<input type="text" name="CHA_TITLE" /><br/>
	<br />
	所属章节要点：	<input type="text" name="CHA_MPOINT" /><br/>
	<br />
	习题类型：	<input type="text" name="pro_type" /><br/>
	<br />
	习题标注：       <input type="text" name="pro_state" /><br/>
	<br/>
	<input type="submit" value="确定" >
</form>
</body>
</html>