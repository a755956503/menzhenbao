package cn.itcast.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.User;
import cn.itcast.service.HospitalService;
import cn.itcast.service.UserService;
import cn.itcast.utils.CheckUtils;

public class LoginServlet extends HttpServlet {
	private UserService us = new UserService();
	private HospitalService hs = new HospitalService();
	private String hName=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 1. 封装参数
		User u = new User();
		try {
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.非空校验
	Map<String,String> errors = CheckUtils.checkUser(u);
		if(errors.size()>0){
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// 3.调用Service
		User existU = null;
		try {
			existU= us.login(u);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			//request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		try {
			hName=hs.getHospitalByName(existU.getName());
			System.out.print("^^^^^^"+hName);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.setAttribute("User", existU);
		// 4.向session中加入登录标识
		request.getSession().setAttribute("user", existU);
		request.getSession().setAttribute("hName", hName);
		if(hName==null){
			response.getWriter().write("对不起，您还没有开通诊所！！");
		}else{
			response.sendRedirect(request.getContextPath()+"/ListServlet");
		}
		//request.setAttribute("User", existU);
		// 4.向session中加入登录标识
		//request.getSession().setAttribute("user", existU);
		// 5.重定向到列表显示servlet		
		//response.getWriter().write("[\"String\":\"success\"]");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
