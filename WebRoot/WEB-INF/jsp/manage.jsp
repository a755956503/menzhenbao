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
  	main {
  		margin:10px;
  		margin-top: 30px;
  	}
  </style>
</head>

<body class="homepage" data-spy="scroll" data-target=".navbar">
  <!--[if lte IE 7]>
      <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
  <![endif]-->

  <header role="banner">
      <%@ include file="header.jsp" %>
  </header>

  <main role="main" class="row col-md-6 col-md-offset-3">
  	<div class="input-group">
				<div class="input-group-addon">筛选条件</div>
				<input class="form-control" type="search" id="input-filter1" size="15" placeholder="输入关键字"></input>
	</div>
  	<table class="table table-hover table-bordered table-responsive" style="margin-top:20px">
  		<thead>
  			<tr>
						<th>真实姓名</th>
						<th>症状</th>
						<th>性别</th>
						<th>年龄</th>
						<th>时间</th>
						<th>状态</th>
	   		</tr>
		</thead>
	   	<tbody>
	   		<s:iterator var="Regist" value="#request.hList">
	   			<s:if test="Regist.status!=0">
						<tr>
							<td>
								<s:property value="#Regist.r_name"/>
							</td>
							<td>
								<s:property value="#Regist.r_sympton"/>
							</td>
							<td>
								<s:property value="#Regist.r_sex"/>
							</td>
							<td>
								<s:property value="#Regist.r_age"/>
							</td>
							<td>
								<s:property value="#Regist.r_date"/>
							</td>
							<td>
								已处理
							</td>

						</tr>
				</s:if>
				<s:else>
						<tr>
							<td>
								<s:property value="#Regist.r_name"/>
							</td>
							<td>
								<s:property value="#Regist.r_sympton"/>
							</td>
							<td>
								<s:property value="#Regist.r_sex"/>
							</td>
							<td>
								<s:property value="#Regist.r_age"/>
							</td>
							<td>
								<s:property value="#Regist.r_date"/>
							</td>
							<td>
								<button class="btn btn-default btn-sm-1" onclick="toSet(event)" data="<s:property value="#Regist.r_id"/>">处理</button>
							</td>

						</tr>
				</s:else>

			</s:iterator>
		</tbody>
	   	
  	</table>
  </main>


  <!-- JavaScript -->
  <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.10.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.filtertable.min.js"></script>
  <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
  <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>

  <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
  <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
      $('table').filterTable({
      		inputSelector: '#input-filter1' 
      });
      function toSet(event){
      	var data=event.target.getAttribute("data");
      	//alert(data);
      	$.ajax({
      		url:"${ pageContext.request.contextPath }/regist_toSet.action?rid="+data,
      		type:"get",
      		success : function (res) {
        		 	alert(res);
           },
           	error:function(err){
           			alert(err)
           		}
      	})
      }
  </script>
</body>
</html>