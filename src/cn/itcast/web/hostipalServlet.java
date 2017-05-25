package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

/**
 * Servlet implementation class hostipalServlet
 */
public class hostipalServlet extends HttpServlet {
//	private UserService us = new UserService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hostipalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//User u = (User) request.getSession().getAttribute("user");
		//未登录=> 重定向到登录页面
//	//2 调用Service查询用户列表. 
//		List<User> list = us.getAllUser();
//		StringBuffer sb = new StringBuffer();
//		sb.append("[");
//		for (User person :list) {//person.getName(),person.getAddress()获得姓名，地址，一些符号转换为char  
//            //锁定输出=> {"name":"姓名","address":"地址","age":年龄},  
//			sb.append("{").append("\"id\":").append("\""+person.getId()+"\"").append(",");  
//            sb.append("\"name\":").append("\""+person.getName()+"\"").append(",");  
//            sb.append("\"imgUrl\":").append("\""+"http://a755.ecs04.tomcats.pw/regist/hospital1.jpg"+"\"").append(",");  
//            sb.append("\"description\":").append("\""+person.getEmail()+"\"").append(",");
//            sb.append("\"price\":").append("\""+"5"+"\"");  
//            sb.append("}").append(",");  
//        }
//	//3将用户列表放入request域,转发到列表页面
//		PrintWriter out=response.getWriter();
//		sb.deleteCharAt(sb.length() - 1);  
//        sb.append("]");  
//        out.write(new String(sb));  
//        out.flush();  
//        out.close();//关闭 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
