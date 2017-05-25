package cn.itcast.menzhen.index;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.menzhen.hospital.HospitalService;
import cn.itcast.menzhen.hospital.Hospital;
import cn.itcast.menzhen.regist.Regist;
import cn.itcast.menzhen.regist.RegistService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	private HospitalService hospitalService;
	private RegistService registService;
	private List<Regist>  registList;
	private List<Hospital> hospitalList;
	private List<String> test;
	
	public List<Regist> getRegistList() {
		return registList;
	}

	public void setRegistList(List<Regist> registList) {
		this.registList = registList;
	}

	public List<Hospital> getHospitalList() {
		return hospitalList;
	}

	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}

	public RegistService getRegistService() {
		return registService;
	}
	
	public void setRegistService(RegistService registService) {
		this.registService = registService;
	}

	public void setTest(List<String> test) {
		this.test = test;
	}



	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		test=new ArrayList<String>();
		test.add("a");
		test.add("b");
		//String testname=hospitalService.findhByName("c");
		//registList=registService.findAllByh(testname);
		//ActionContext.getContext().getValueStack().set("registList", registList);
		hospitalList=hospitalService.getAllHospital();
		ActionContext.getContext().getValueStack().set("hospitalList", hospitalList);
		return "indexSuccess";
	}
	

}
