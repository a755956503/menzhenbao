<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav role="navigation" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#home-navbar">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <s:if test="#session.existUser!=null">
						<h2 style="padding-left:10px;padding-left:10px;"><strong>欢迎您，<s:property value="#session.existUser.username"/></strong></h2>
            </s:if>
			  <s:else>
			  	<a class="navbar-brand" href="${ pageContext.request.contextPath }/index.action"><h2><strong>门诊宝</strong></h2></a>
			  </s:else>
            
          </div>
            
          <div class="navbar-collapse collapse" id="home-navbar">
            <ul class="nav navbar-nav">
             
              <li><a href="${ pageContext.request.contextPath }/index.action">立即挂号</a></li>
              <li><a href="${ pageContext.request.contextPath }/regist_hFindAll.action">诊所管理</a></li>
              <li><a href="${ pageContext.request.contextPath }/hospital_intoSave.action">开通诊所</a></li>
              <s:if test="#session.existUser!=null">
              		
              		<li>
						<a href="${ pageContext.request.contextPath }/regist_findAll.action">挂号记录</a>
					</li>
					<li>
					 	<a href="${ pageContext.request.contextPath }/user_quit.action">退出</a>
					</li>
			  </s:if>
			  <s:else>
			     <li>
					<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>
				</li>
				<li>
					<a href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>
				</li>
			  </s:else>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container -->
      </nav>