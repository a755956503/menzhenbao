package cn.itcast.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Regist;
import cn.itcast.domain.User;
import cn.itcast.service.RegistService;
import cn.itcast.service.UserService;

public class ListServlet extends HttpServlet {
	private UserService us = new UserService();
	private RegistService rService=new RegistService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//1 校验用户是否登录
			User u = (User) request.getSession().getAttribute("user");
			String hName=(String)request.getSession().getAttribute("hName");
			//未登录=> 重定向到登录页面
			if(hName==null){
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
		//2 调用Service查询用户列表. 
			List<User> list1 = us.getAllUser();
			List<Regist> list=rService.getRecordByHname(hName);
		//3将用户列表放入request域,转发到列表页面
			request.setAttribute("list", list);
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
