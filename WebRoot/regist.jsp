<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
 <head>
    
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
            <div class="login-title"><p>开通诊所</p>
                <i></i>
            </div>
            <form method="post" action="success.html">
            <div class="login-bar">
                <ul>
                     <li><img src="images/user_name.png"><input type="text" class="text" placeholder="请输入医院名称" /></li>
                     <li><img src="images/msg.png"><input type="text" class="text" placeholder="请输入医院地址" /></li>
                    <li><img src="images/user_name.png"><input type="text" class="text" placeholder="请输入用户名" /></li>
                    <li><img src="images/pwd.png"><input type="password" class="text" placeholder="请输入确认密码" /></li>
                </ul>
            </div>
            <div class="login-btn">
                <a href="register.html"><div class="login-reg"><p>立即开通</p></div></a>
            </div>
            </form>
        </div>
    </body>
</html>
