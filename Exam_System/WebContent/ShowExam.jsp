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
  <link rel="stylesheet" href="./layui-v2.5.4/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	
  <div class="layui-header">
    <div class="layui-logo"><h2>试题库</h2></div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;" >所有试卷</a>
          <dl class="layui-nav-child" id="alltst">
			<script>
				var xmlhttptmp1;
				if (window.XMLHttpRequest) {
				//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
				xmlhttptmp1 = new XMLHttpRequest();
				} else {
					// IE6, IE5 浏览器执行代码
				xmlhttptmp1 = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttptmp1.onreadystatechange = function() {
						if (xmlhttptmp1.readyState == 4 && xmlhttptmp1.status == 200) {
						$("#alltst").append(xmlhttptmp1.responseText);
						}
					}
				xmlhttptmp1.open("GET", "./ShowExaminitalltst", true);
				xmlhttptmp1.send();
			</script>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;" >所有答案</a>
          <dl class="layui-nav-child" id="allans">
          	<script>
				var xmlhttptmp2;
				if (window.XMLHttpRequest) {
				//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
					xmlhttptmp2 = new XMLHttpRequest();
				} else {
					// IE6, IE5 浏览器执行代码
					xmlhttptmp2 = new ActiveXObject("Microsoft.XMLHTTP");
				}
					xmlhttptmp2.onreadystatechange = function() {
						if (xmlhttptmp2.readyState == 4 && xmlhttptmp2.status == 200) {
						$("#allans").append(xmlhttptmp2.responseText);
						}
					}
				xmlhttptmp2.open("GET", "./ShowExaminitallans", true);
				xmlhttptmp2.send();
			</script>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:;">联系老师</a></li>
        <li class="layui-nav-item"><a href="javascript:;">发布题解</a></li>
      </ul>
    </div>
  </div>

  <div class="layui-body" id="tstbody">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	<form class="layui-form"  action="" lay-filter="tst_alldetail">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>选择题</legend>
				</fieldset>
				

				<div class="layui-collapse" lay-accordion="" id="Choice_question" lay-filter="collapsetttst">
					<!--  动态加载-->
				</div>
				
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>简答题</legend>
				</fieldset>
				<div class="layui-collapse" lay-accordion="" id="Short_Answer_Questions" lay-filter="collapsetttst">
				<!--  动态加载-->
				
				</div>

					
					
					<div class="layui-form-item" style="text-align:center;margin:20px 5px 15px 20px;">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>

		</form>
	</div>
  </div>
  <script>$("#tstbody").hide();</script>
  <div class="layui-body" id="ansbody">
    <!-- 内容主体区域 -->
    	<div style="padding: 15px;">
    		<table class="layui-hide" id="ans_table"></table>
  		</div>
  </div>
  <script>$("#ansbody").hide();</script>
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
	
</div>

<script src="./layui-v2.5.4/layui/layui.js"></script>
<script>
layui.use('element', function(){
  var element = layui.element;
});
layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  //日期
	  laydate.render({
	    elem: '#date'
	  });
	  laydate.render({
	    elem: '#date1'
	  });
	  //自定义验证规则
	  form.verify({
	    title: function(value){
	      if(value.length < 5){
	        return '标题至少得5个字符啊';
	      }
	    }
	    ,pass: [
	      /^[\S]{6,12}$/
	      ,'密码必须6到12位，且不能出现空格'
	    ]
	    ,content: function(value){
	    	if(value.length < 20){
		        return '至少要写20个字符啊';
		      }
	    }
	  });
	  //监听提交
	  form.on('submit(demo1)', function(data){
	    layer.alert(JSON.stringify(data.field), {
	      title: '最终的提交信息'
	    })
	    return false;
	  });
	  element.on('collapse(collapsetttst)', function(data){
		    layer.msg('展开状态：'+ data.show);
		  });
	});
</script>
<script>
function refresh1(x) {
	
	$("#ansbody").hide();
	$("#Choice_question").empty();
	$("#Short_Answer_Questions").empty();
	
	var xmlhttptmp3;//选择题连接
	var xmlhttptmp4;//简答题连接
	
	if (window.XMLHttpRequest) {
	//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttptmp3 = new XMLHttpRequest();
		xmlhttptmp4 = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttptmp3 = new ActiveXObject("Microsoft.XMLHTTP");
		xmlhttptmp4 = new ActiveXObject("Microsoft.XMLHTTP");
		
	}
	//开启监听,,等待加载
	xmlhttptmp3.onreadystatechange = function() {
			if (xmlhttptmp3.readyState == 4 && xmlhttptmp3.status == 200) {
				$("#Choice_question").append(xmlhttptmp3.responseText);
				//刷新radio等动态元素
				layui.use('form', function() {
				      var form = layui.form; 
				       form.render();
				   });
			}
		}
	xmlhttptmp4.onreadystatechange = function() {
			if (xmlhttptmp4.readyState == 4 && xmlhttptmp4.status == 200) {
				$("#Short_Answer_Questions").append(xmlhttptmp4.responseText);
				layui.use('element', function() {
                    var element = layui.element;
                    element.init();
                });
				$("#tstbody").show();//更新完成
			}
		}
	xmlhttptmp3.open("GET", "./ShowExamgetChoice?tst_no="+x, true);
	xmlhttptmp4.open("GET", "./ShowExamgetShort_Answer?tst_no="+x, true);
	xmlhttptmp3.send();
	xmlhttptmp4.send();
    return;
}

function refresh2(x) {
	$("#tstbody").hide();
	
	table.render({
	    elem: '#ans_table'
	    ,url:"/ExamShowans_table?tst_no="+x
	    ,cellMinWidth: 80 
	    ,cols: [[
	      {field:'pro_no', width:80, title: '题目编号', sort: true}
	      ,{field:'cha_no', width:80, title: '章节编号'}
	      ,{field:'cha_title', width:80, title: '章节标题', sort: true}
	      ,{field:'cha_mpiont', width:80, title: '章节要点'}
	      ,{field:'ans_detail', title: '答案', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
	      ,{field:'pro_dif', title: '难度', sort: true}
	      ,{field:'ans_no', title: '答案编号', sort: true}
	    ]]
	  });
	$("#ansbody").show();
    return;
}
</script>
</body>
</html>