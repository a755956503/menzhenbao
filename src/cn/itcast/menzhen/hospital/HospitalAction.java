package cn.itcast.menzhen.hospital;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.itcast.menzhen.regist.Regist;
import cn.itcast.menzhen.user.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HospitalAction extends ActionSupport implements ModelDriven<Hospital>{
	private HospitalService hospitalService;
	private Hospital hospital=new Hospital();
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	public String save() {
		//hospitalService.findhByHname(name)
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		hospital.setUsername(user.getUsername());
		System.out.println("hospital"+hospital.getH_name());
		System.out.println("address"+hospital.getH_address());
		try{
			hospitalService.save(hospital);
		}catch(Exception e){
			this.addActionMessage("开通失败");
			return "msg";
		}
		this.addActionMessage("开通成功");
		return "saveHospitalSuccess";
	}
	public String intoSave() {
		HttpSession session =ServletActionContext.getRequest().getSession();
		if((session.getAttribute("existUser"))==null){
			this.addActionMessage("对不起，您还没有登录");
			return "intoOpenFailed";
		}else{
//			String h_name=ServletActionContext.getRequest().getParameter("h_name");
//			ActionContext.getContext().getValueStack().set("h_name", h_name);
//			System.out.println("h_name="+h_name);
			return "intoOpenSuccess";
			
		}
	}

	public Hospital getModel() {
		// TODO Auto-generated method stub
		return hospital;
	}

}
