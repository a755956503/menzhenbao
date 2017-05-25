package cn.itcast.menzhen.regist;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.struts2.ServletActionContext;









import cn.itcast.menzhen.hospital.HospitalService;
import cn.itcast.menzhen.user.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegistAction extends ActionSupport implements ModelDriven<Regist>{
	
	
	private Regist regist=new Regist();
	private RegistService registService;
	private HospitalService hospitalService;
	
	public Regist getRegist() {
		return regist;
	}


	public void setRegist(Regist regist) {
		this.regist = regist;
	}
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	private String h_name=null;

	
	public void setRegistService(RegistService registService) {
		this.registService = registService;
	}


	public Regist getModel() {
		// TODO Auto-generated method stub
		return regist;
	}
	public String findAll() {
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		System.out.println(existUser.getUsername());
		List<Regist> regists;
		try{
			regists=registService.findAllByUsername(existUser.getUsername());
			System.out.println("regists"+regists);
			ServletActionContext.getRequest().setAttribute("registList", regists);
			return "findAllSuccess";
		}catch(Exception e){
			this.addActionMessage("访问失败");
			return "msg";
		}
		
		
	}
	public String hFindAll(){
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser==null){
			this.addActionMessage("对不起，您还没有登录！");
			return "msg";
		}
		h_name=hospitalService.findhByName(existUser.getUsername());
		if(h_name==null){
			this.addActionMessage("对不起，您还没有开通诊所！");
			return "msg";
		}
		ServletActionContext.getRequest().getSession().setAttribute("h_name", h_name);;
		try{
			List<Regist> hList = registService.findAllByh(h_name);
			// 压入值栈:
			ServletActionContext.getRequest().setAttribute("hList", hList);
			return "hFindAllSuccess";
		}catch(Exception e){
			this.addActionMessage("访问失败");
			return "msg";
		}
		
	}
	public String into() {
		HttpSession session =ServletActionContext.getRequest().getSession();
		if((session.getAttribute("existUser"))==null){
			this.addActionMessage("对不起，您还没有登录");
			return "intoFailed";
		}else{
			String h_name=ServletActionContext.getRequest().getParameter("h_name");
			ActionContext.getContext().getValueStack().set("h_name", h_name);
			System.out.println("h_name="+h_name);
			return "intoSuccess";
			
		}
		
		
	}
	public String submit() throws IOException {
		HttpServletResponse response=(HttpServletResponse) ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try{
			System.out.println("action"+regist);
			registService.submit(regist);
			
			response.getWriter().print("预约挂号成功！");
			response.getWriter().flush();
			response.getWriter().close();
			return NONE;
		}catch(Exception e){
			
			response.getWriter().print("预约挂号失败！");
			response.getWriter().flush();
			response.getWriter().close();

			return NONE;
		}
		
	}
	public String hFindTest(){
		String testname=hospitalService.findhByName("c");
		List<Regist> hList = registService.findAllByh(testname);
		// 压入值栈:
		ActionContext.getContext().getValueStack().set("hList", hList);
		return "hFindAllSuccess";
		
	}
	public String toSet() throws IOException {
		String rid=ServletActionContext.getRequest().getParameter("rid");
		System.out.println(rid);
		HttpServletResponse response=(HttpServletResponse) ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		try{
			registService.toSet(rid);
			
			response.getWriter().print("处理成功！");
			response.getWriter().flush();
			response.getWriter().close();
			return NONE;
		}catch(Exception e){
			//Json
			response.getWriter().print("处理失败！");
			response.getWriter().flush();
			response.getWriter().close();

			return NONE;
		}
		
	}
}
