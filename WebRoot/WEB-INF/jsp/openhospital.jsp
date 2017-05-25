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
 <style>
 	.login-container{
  position: absolute;
  top: 50%;
  -webkit-transform: translateY(-50%);
  -moz-transform:  translateY(-50%);
  -ms-transform:  translateY(-50%);
  -o-transform:  translateY(-50%);
  transform:  translateY(-50%);
  background-color: #ccc;
}
 	.login-title{padding-top:10%;
 					text-align: center;
 					padding-bottom:10%;}
 </style>
</head>
<body class="homepage" data-spy="scroll" data-target=".navbar">
  <!--[if lte IE 7]>
      <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
  <![endif]-->

  <header role="banner">
      <%@ include file="header.jsp" %>
  </header>
  <main role="main" >
    <div class=" col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2 login-container">
		
    <form class="form-horizontal" role="form" action="${ pageContext.request.contextPath }/hospital_save.action"  method="post" novalidate="novalidate">
    	<div class="row">
  			<div class="login-title"><h1><strong>开通诊所</strong></h1></div>
  		</div>
  		<div class="form-group">
    		<label for="username" class="col-sm-3 control-label">诊所名称:</label>
    		<div class="col-sm-9">
      			<input type="text" class="form-control" name="h_name" id="username" placeholder="请输入诊所名称">
      			<span class="help-block"><s:fielderror fieldName="username"/></span>
    		</div>
    		
  		</div>
  		<div class="form-group">
    		<label for="password" class="col-sm-3 control-label">诊所地址:</label>
    		<div class="col-sm-9">
      			<input type="password" id="password" name="h_address"  class="form-control" placeholder="请输入诊所地址">
      			<span class="help-block"><s:fielderror fieldName="password"/></span>
    		</div>   		
  		</div>
  		<div class="form-group">
  		    <div class="row">
    		<div class="col-sm-offset-4 col-xs-4">
      		<button type="submit" class="btn btn-primary btn-lg-3">立即开通</button>
    		</div>
    		</div>
  		</div>
	</form>
	</div>
		

    

  </main>


  <!-- JavaScript -->
  <script src="//js/jquery-1.8.3.js"></script>
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