package cn.itcast.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.HospitalService;

public class OpenServlet extends HttpServlet {
	private HospitalService hs = new HospitalService();
   private String hName=null;
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		System.out.print(name);
		if(name==null){
			response.getWriter().write("failed");
			return;
		}
		try {
			hName=hs.getHospitalByName(name);
			System.out.print("^^^^^^"+hName);
		} catch (Exception e) {
			e.printStackTrace();
			//request.setAttribute("error", e.getMessage());
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(hName==null){
			response.getWriter().write("empty");
		}else{
			response.getWriter().write(hName);
		}
		

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
