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
 	.login-container{padding-top:12px}
 	.login-form{margin:10px}
 </style>
 <script>
	 /*$('#loginForm').on('submit', function (e){
       e.preventDefault();
 		var data=$(this).serialize()+"&username="+;
 		alert(data);
      $.ajax( {
         type:"POST",
         dataType: "json",
         url :${ pageContext.request.contextPath }/user_regist.action,
        data : ,
        success : function (res) {
         console . log(res)
              if (res . type == 'ok') {
                  alert(res . msg);
                 //成功后跳转路由设置
                  window . location . href = '';
              } else {
                  if (res . type == "no") {
                      alert(res . msg);
                       }
                   }
               }
            });
          });*/
		function onClick(){
			var data=$("#registForm").serialize()+"&username="+"<s:property value="#session.existUser.username"/>"
						+"&h_name="+"<s:property value="h_name"/>";
			$.ajax( {
         		type:"POST",
         		url :"${ pageContext.request.contextPath }/regist_submit.action",
        		data :data ,
        		success : function (res) {
        		 	alert(res);
           },
           		error:function(err){
           			alert(err)
           		}

          });
		}
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
    					id="registForm"
    					role="form"
						action=""
						>
  		<div class="form-group">
    		<label for="r_name" class="col-sm-3 control-label">真实姓名:</label>
    		<div class="col-sm-9">
      			<input type="text" class="form-control" name="r_name" id="r_name" placeholder="姓名">
    		</div>    		
  		</div>
  		<div class="form-group">
    		<label for="r_age" class="col-sm-3 control-label">年龄 :</label>
    		<div class="col-sm-9">
      			<input type="text" id="r_age" name="r_age"  class="form-control" placeholder="年龄">
    		</div>    		
  		</div>	
  		<div class="form-group">
    		<label for="r_sex" class="col-sm-3 control-label">性别 :</label>
    		<div class="col-sm-9">
      			<input type="text" id="r_sex" name="r_sex"  class="form-control" placeholder="性别">
    		</div>    		
  		</div>	
  		<div class="form-group">
    		<label for="r_sympton" class="col-sm-3 control-label">症状:</label>
    		<div class="col-sm-9">
      			<input type="text" id="r_sympton" name="r_sympton"  class="form-control" placeholder="症状">
    		</div>    		
  		</div>  		
	</form>
	<div class="form-group">
  		    <div class="row">
    		<div class="col-sm-offset-4 col-xs-4">
      		<button class="btn btn-primary btn-lg-3" onclick="onClick()">提交</button>
    		</div>
    		</div>
  		</div>
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