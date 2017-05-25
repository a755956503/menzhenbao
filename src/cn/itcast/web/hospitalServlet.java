package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Hospital;
import cn.itcast.domain.User;
import cn.itcast.service.HospitalService;
import cn.itcast.service.UserService;

public class hospitalServlet extends HttpServlet {
	private HospitalService hs = new HospitalService();

	/**
	 * Constructor of the object.
	 */
	public hospitalServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Hospital> list = hs.getAllHospital();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Hospital hospital :list) {//person.getName(),person.getAddress()获得姓名，地址，一些符号转换为char  
            //锁定输出=> {"name":"姓名","address":"地址","age":年龄},  
			sb.append("{").append("\"h_name\":").append("\""+hospital.getH_name()+"\"").append(",");  
            sb.append("\"h_address\":").append("\""+hospital.getH_address()+"\"").append(",");  
            sb.append("\"name\":").append("\""+hospital.getName()+"\"");  
            sb.append("}").append(",");  
        }
	//3将用户列表放入request域,转发到列表页面
		PrintWriter out=response.getWriter();
		sb.deleteCharAt(sb.length() - 1);  
        sb.append("]");  
        out.write(new String(sb));  
        out.flush();  
        out.close();//关闭 
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
