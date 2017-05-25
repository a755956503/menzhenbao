<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<title>门诊宝</title>
 	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<meta name="description" content="">
  	<meta name="viewport" content="width=device-width">
<!-- Main Style Sheet -->
  <link rel="stylesheet" href="css/main.css">
  <!-- Modernizr -->
  <script src="js/vendor/modernizr-2.6.2.min.js"></script>
  <!-- Respond.js for IE 8 or less only -->
  <!--[if (lt IE 9) & (!IEMobile)]>
      <script src="${pageContext.request.contextPath}/js/vendor/respond.min.js"></script>
  <![endif]-->
 <styles>
 	.login-container{padding-top:12px}
 	.login-form{margin:10px}
 </styles>
 <script type="text/javascript">
	function checkForm(){
		// 校验用户名:
		var username = document.getElementById("username").value;
		if(username == ''){
			alert("用户名不能为空!");
			return false;
		}
		
		// 校验密码:
		var password = document.getElementById("password").value;
		if(password == ''){
			alert("密码不能为空!");
			return false;
		}
		
		// 校验确认密码
		var repassword = document.getElementById("repassword").value;
		if(password != repassword){
			alert("两次密码不一致!");
			return false;
		}
	}
	
	function checkUserName(){
		var username = $("#username").val();
		$("#span1").load("${pageContext.request.contextPath}/user_checkUserName.action?"+new Date().getTime(),{'username':username});
	}
	
	function change(){
		var img = document.getElementById("checkImg");
		img.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime();
	}
	
	/*
	function checkUserName(){
		// 获得用户名的值:
		var username = document.getElementById("username").value;
		// 1.创建异步加载对象:
		var xhr = createXMLHttpRequest();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var data = xhr.responseText;
					document.getElementById("span1").innerHTML = data;
				}
			}
		}
		// 3.打开连接:
		xhr.open("GET","${pageContext.request.contextPath}/user_checkUserName.action?"+new Date().getTime()+"&username="+username,true);
		// 4.发送
		xhr.send(null);
	}
	
	function createXMLHttpRequest() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}

		return xmlHttp;
	}
	*/
</script>
</head>
<body class="homepage" data-spy="scroll" data-target=".navbar">
  <!--[if lte IE 7]>
      <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
  <![endif]-->

  <header role="banner">
      <%@ include file="header.jsp" %>
  </header>
  <main role="main" id="login-container" class="row">
    <div class=" col-sm-6 col-md-4 col-md-offset-4 col-sm-offset-3 jumbotron">
		
    <form class="form-horizontal" 
    					role="form" id="registerForm"
						action="${ pageContext.request.contextPath }/user_regist.action"
						method="post" novalidate="novalidate"
						onsubmit="return checkForm();">
  		<div class="form-group">
    		<label for="username" class="col-sm-3 control-label">用户名:</label>
    		<div class="col-sm-9">
      			<input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名" onblur="checkUserName()">
      			<span id="span1" class="help-block"><s:fielderror fieldName="username"/></span>
    		</div>
    		
  		</div>
  		<div class="form-group">
    		<label for="password" class="col-sm-3 control-label">密码   :</label>
    		<div class="col-sm-9">
      			<input type="password" id="password" name="password"  class="form-control" placeholder="请输入密码">
      			<span class="help-block"><s:fielderror fieldName="password"/></span>
    		</div>
    		
  		</div>
  		<div class="form-group">
    		<label for="repassword" class="col-sm-3 control-label">确认   :</label>
    		<div class="col-sm-9">
      			<input type="password" id="repassword" name="repassword"  class="form-control" placeholder="请再次输入密码">
    		</div>    		
  		</div>
  		<div class="form-group">
    		<label for="email" class="col-sm-3 control-label">邮箱  :</label>
    		<div class="col-sm-9">
      			<input type="text" id="email" name="email"  class="form-control" placeholder="请输入邮箱">
      			<span><s:fielderror fieldName="email" /></span>
    		</div>    		
  		</div>
  		<div class="form-group"	>
  			<label for="checkcode" class="col-sm-3 control-label">验证码 :</label>
    		<div class="col-sm-4">
      			<input type="text" id="checkcode" name="echeckcode"  class="form-control" placeholder="请输入邮箱">
      			
    		</div>
    		<img id="checkImg" class="col-sm-5"
				 src="${ pageContext.request.contextPath }/checkImg.action"
				 title="点击更换验证码" onclick="change()"/>
  		</div>	
  		<div class="form-group">
  		    <div class="row">
    		<div class="col-sm-offset-4 col-xs-4">
      		<button type="submit" class="btn btn-primary btn-lg-3">立即注册</button>
    		</div>
    		</div>
  		</div>
	</form>
	</div>
		

    

  </main>

  <footer role="contentinfo">
    <div class="container">


      <p class="photo-credits"><a href="" title="Photo Credits">github</a></p>

    </div>
  </footer>

  <!-- JavaScript -->
  <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.10.2.min.js"></script>
  <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
  <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>

  <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
  <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
  </script>
</body>
</html>