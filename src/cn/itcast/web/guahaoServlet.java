package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.Regist;
import cn.itcast.domain.User;
import cn.itcast.service.RegistService;
import cn.itcast.utils.CheckUtils;

public class guahaoServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private RegistService rs=new RegistService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//1 封装参数到User对象
		Regist r=new Regist();
		try {
			BeanUtils.populate (r, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
//	//2 校验
//	Map<String, String> errors = CheckUtils.checkUser(u);
//	if(errors.size()>0){
//		//有错误信息=> 将错误信息放到request域=>转发到注册页面显示
//		request.setAttribute("errors", errors);
//		request.getRequestDispatcher("/regist.jsp").forward(request, response);
//		return;
//	}
//	//3 调用Service保存
	try {
		rs.regist(r);
	} catch (Exception e) {
		e.printStackTrace();
		response.getWriter().write("failed");
		return;
	}
	response.getWriter().write("success");

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */

}
