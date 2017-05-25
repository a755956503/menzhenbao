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
import cn.itcast.service.UserService;
import cn.itcast.utils.CheckUtils;

public class RegistServlet extends HttpServlet {
	
	private UserService us= new UserService(); 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1 封装参数到User对象
			User u = new User();
			try {
				BeanUtils.populate (u, request.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		//2 校验
		Map<String, String> errors = CheckUtils.checkUser(u);
		if(errors.size()>0){
			//有错误信息=> 将错误信息放到request域=>转发到注册页面显示
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		//3 调用Service保存
		try {
			us.regist(u);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		response.getWriter().write("success");
		//4 根据结果,跳转到对应页面
	  //response.sendRedirect(request.getContextPath()+"/login.jsp");
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
