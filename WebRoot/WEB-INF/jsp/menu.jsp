<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${ pageContext.request.contextPath }/index.action">网站首页</a>
						|
					</li>
					<li>
						<a href="${ pageContext.request.contextPath }/index.action">医患社区</a>
						|
					</li>
					<li>
						<a href="http://123.207.24.69:8080/mymenzhen/login.jsp">诊所管理</a>
						|
					</li>
					<li>
						<a href="${ pageContext.request.contextPath }/regist_hFindTest.action">诊所测试</a>
						|
					</li>
					<s:iterator var="c" value="#session.categoryList">
						<li>
							<a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							|
						</li>
					</s:iterator>
		</ul>
	</div>