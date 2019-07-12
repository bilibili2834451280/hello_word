<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.org.Exam.*" import="java.util.ArrayList"
import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <script src="./jquery-3.4.1.min.js"></script>
  <script src="./layui-v2.5.4/layui/layui.js"></script>
  <link rel="stylesheet" href="./layui-v2.5.4/layui/css/layui.css"  media="all">
</head>
<body>
<div id="myDiv"><h2>使用 AJAX 修改该文本内容</h2></div>
<button type="button" onclick="loadXMLDoc()">修改内容</button>

	      
	<script>
		    function loadXMLDoc() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
				xmlhttp = new XMLHttpRequest();
			} else {
				// IE6, IE5 浏览器执行代码
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

					$("#myDiv").append(xmlhttp.responseText);
				}
			}
			xmlhttp.open("GET", "./ShowExaminit", true);
			xmlhttp.send();
		}
	</script>
</body>


</html>