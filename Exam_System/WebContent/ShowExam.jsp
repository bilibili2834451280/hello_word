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
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    	<form class="layui-form"  action="" lay-filter="example">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>选择题</legend>
				</fieldset>
				

				<div class="layui-collapse" lay-accordion="" id="Choice_question">

						<div class='layui-colla-item'>
							<h2 class='layui-colla-title'>题名</h2>
							<div class='layui-colla-content layui-show'>
								<blockquote class='layui-elem-quote'>
									中国共产党第十九次全国代表大会，是在全面建成小康社会决胜阶段、中国特色社会主义进入_____的关键时期召开的一次十分重要的大会。
								</blockquote>
								<div class='layui-form-item'>
									<div class='layui-input-block'>
										<input type='radio' name='sex' value='新时期' title='新时期' checked=''> 
										<input type='radio' name='sex' value='新阶段' title='新阶段'> 
										<input type='radio' name='sex' value='新征程' title='新征程'> 
										<input type='radio' name='sex' value='新时代' title='新时代'>
									</div>
								</div>
							</div>
						</div>


						<div class="layui-colla-item">
						<h2 class="layui-colla-title">test</h2>
						<div class="layui-colla-content">
							<p>
								testtesttesttesttest
							</p>
						</div>
					</div>
					<div class="layui-colla-item">
						<h2 class="layui-colla-title">题名</h2>
						<div class="layui-colla-content">
							<p>
								testtesttesttesttesttesttest
							</p>
						</div>
					</div>
					
					<div class="layui-colla-item">
						<h2 class="layui-colla-title">题名</h2>
						<div class="layui-colla-content">
							<p>testtesttesttesttesttest</p>
						</div>
					</div>
				</div>
				
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>简答题</legend>
				</fieldset>
				<div class="layui-collapse" lay-accordion="" id="Short_Answer_Questions">
				<div class="layui-colla-item">
					<h2 class="layui-colla-title">题名</h2>
					<div class="layui-colla-content">
						<blockquote class="layui-elem-quote">
							 根据以下材料，选取角度，自拟题目，写一篇不少于800字的文章；除诗歌外，文体自选。</br>物各有性，水至淡，盐得味。水加水还是水，盐加盐还是盐。酸甜苦辣咸，五味调和，共存相生，百味纷呈。物如此，事犹是，人亦然。
						</blockquote>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">作答区域</label>
									<div class="layui-input-block">
										<textarea placeholder="请输入内容" class="layui-textarea" lay-verify="required|content" name="desc"></textarea>
									</div>
								</div>
					</div>
				</div>
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
	  //创建一个编辑器
	  var editIndex = layedit.build('LAY_demo_editor');
	 
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
	    	if(value.length < 800){
		        return '至少要写800个字符啊';
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
	});
</script>
<script>
function refresh1(x) {
	$("#Choice_question").empty();
	var xmlhttptmp3;
	if (window.XMLHttpRequest) {
	//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttptmp3 = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttptmp3 = new ActiveXObject("Microsoft.XMLHTTP");
	}
		xmlhttptmp3.onreadystatechange = function() {
			if (xmlhttptmp3.readyState == 4 && xmlhttptmp3.status == 200) {
			$("#Choice_question").append(xmlhttptmp3.responseText);
			}
		}
	xmlhttptmp3.open("GET", "./ShowExamgetChoice?tst_no="+x, true);
	xmlhttptmp3.send();
    return;
} 

</script>
</body>
</html>