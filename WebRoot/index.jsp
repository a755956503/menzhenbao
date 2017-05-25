<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta charset="UTF-8">
    <title>Document</title>
     <script src="build/react.js"></script>
    <script src="build/react-dom.js"></script>
    <script src="./build/browser.min.js"></script>
	<script src="./build/jquery-1.8.3.min.js"></script>
	    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css">
    <style type="text/css">
        *{padding: 0;margin: 0}
        #navbar{position: fixed;width: 100%;height: 60px;background-color: #222;}
        #navbar li{line-height: 60px;margin-left: 10px;display: inline-block;}
        #navbar li a{color: #fff;text-decoration: none;}
        shu{color:#fff;margin-left: 10px}
        .demo {
		  position: relative;
		  opacity: 0;
		  transition: .2s ease;
		  margin-bottom: 60px;
		}

		.grid {
		  position: relative;
		  /* fluffy */
		  margin: 0 auto;
		  width: 98%;
		  /* end fluffy */
		}

		.grid-item {
		  position: absolute;
		  top: 0;
		  left: 0;
		   /* fluffy */
		   width: 230px;
		   height: 250px;
		   border-radius: 3px;
		   background-color: #B452CD;
		   /* end fluffy */
		   -webkit-transition: .3s ease-in-out;
		   -o-transition: .3s ease-in-out;
		   transition: .3s ease-in-out;
		}
		#font{
           margin: 0;
           padding: 0;
           line-height: 1.5em;
           font-family: "Times New Roman", Times, serif;
           font-size: 14px;
           color: #B452CD;
}

		/* mq */

		@media (max-width: 600px) {
		  .grid-item {
		    width: 120px;
		    height: 80px;
		  }
		}
    </style>
</head>
<body  style="background:green;">	
     <div id="navbar">
               <ul><li><a href="">全部挂号单</a></li><shu>|</shu> 
                   <li><a href="">已处理</a></li><shu>|</shu>   
                   <li><a href="" >未处理</a></li><shu>|</shu> 
                   <li><a href="" >数据分析</a></li><shu>|</shu> 
               </ul>
     </div>
      <div class="htmleaf-demo center">
			  <a href="index.jsp" class="current">返回顶部</a>
    </div>  
    	<div class="demo">
	        <div class="grid">
	        <c:forEach items="${requestScope.list}" var="regist" >
	          <div class="grid-item">
							<a href="http://www.uestc.edu.cn/">
				                <ul id="hospitalName" id="font">真实姓名：${pageScope.regist.r_name}</ul>
				                <ul id="hospitalAddress" color:"#ffffff">时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：${pageScope.regist.r_age}</ul>									 
								<ul id="hospitalAddress" color:"#ffffff">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：${pageScope.regist.r_date}</ul>
								<ul id="hospitalAddress" color:"#ffffff">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：${pageScope.regist.r_sex}</ul>
								<ul id="hospitalAddress" color:"#ffffff">症&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状：${pageScope.regist.r_sympton}</ul>
							</a>							
            </div>
            </c:forEach>
	        </div>
		</div>
    <script src="js/minigrid.js"></script>
    <script>
      (function(){
        minigrid('.grid', '.grid-item', 6, null, 
          function(){
            var d = document.querySelector('.demo');
            d.style.opacity = 1;
          }
        );
        window.addEventListener('resize', function(){
          minigrid('.grid', '.grid-item');
        });
      })();
    </script>
    <script type="text/javascript">
    $(document).ready(function(){
      $(document).re
    })
    </script>
</body>
</html>