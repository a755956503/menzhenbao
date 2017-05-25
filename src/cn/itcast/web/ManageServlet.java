package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Regist;
import cn.itcast.service.RegistService;

public class ManageServlet extends HttpServlet {
	private RegistService rService=new RegistService();

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
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("hname");
//		String name="a";
		if(name==null){
			response.getWriter().write("empty");
			return;
		}
		List<Regist> list=rService.getRecordByHname(name);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Regist regist:list) {//person.getName(),person.getAddress()获得姓名，地址，一些符号转换为char  
            //锁定输出=> {"name":"姓名","address":"地址","age":年龄},  
			sb.append("{").append("\"r_name\":").append("\""+regist.getR_name()+"\"").append(",");  
            sb.append("\"r_date\":").append("\""+regist.getR_date()+"\"").append(","); 
            sb.append("\"r_age\":").append("\""+regist.getR_age()+"\"").append(",");  
            sb.append("\"r_sex\":").append("\""+regist.getR_sex()+"\"").append(",");  
            sb.append("\"r_status\":").append("\""+regist.getR_status()+"\"").append(",");  
            sb.append("\"r_sympton\":").append("\""+regist.getR_sympton()+"\"");  
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
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */

}
