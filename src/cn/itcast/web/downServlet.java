package cn.itcast.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class downServlet
 */
public class downServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1 鑾峰緱 鎵�湁鍙傛暟鐨勯敭
					Enumeration<String> en = request.getParameterNames();
					//OutputStream os = response.getOutputStream();
					response.setContentType("UTF-8");
					response.setCharacterEncoding("UTF-8");
					// 2 閬嶅巻鎵�湁閿�
					//String type=request.getParameter("type");
					String string=new String("[{\"id\":1,\"name\":\"chongfeng\",\"description\":null,\"imgUrl\":\"http://a755.ecs04.tomcats.pw/regist/dianke11.jpg\",\"type\":1},{\"id\":2,\"name\":\"鎵嬫満鍥藉簡绀糪");
					response.getWriter().write(string);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
