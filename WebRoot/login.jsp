<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
 <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<title>登陆页面</title>
        <meta charset="utf-8">
        <meta name="format-detection" content="telephone=no">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-touch-fullscreen" content="yes">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <link href="css/login.css" type="text/css" rel="stylesheet">
        <link href="css/global.css" type="text/css" rel="stylesheet">
</head>
<body style="background:green;">
        <div>
            <div class="login-title"><p>门诊管理</p>
                <i></i>
            </div>
            <form method="post" action="/mymenzhen/LoginServlet">
            <div class="login-bar">
                <ul>
                    <li><img src="images/login_user.png"><input type="text" name="name" class="text" placeholder="请输入用户名" /></li>
                    <li><img src="images/login_pwd.png"><input type="password" name="password" class="text" placeholder="请输入确认密码" /></li>
                </ul>
            </div>
            <div class="login-btn">
                <button class="submit" type="submit">登陆</button>
                <a href="regist.jsp"><div class="login-reg"><p>您还没有开通诊所？点击开通</p></div></a>
            </div>
            </form>
        </div>
    </body>
</html>
