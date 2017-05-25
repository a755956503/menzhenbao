package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.HospitalDao;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.HospitalDaoImpl;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.Hospital;
import cn.itcast.domain.User;

public class HospitalService {
	private HospitalDao hd = new HospitalDaoImpl();
	public List<Hospital> getAllHospital(){
		return hd.getAllHospital();
	}
	public String getHospitalByName(String u){
		return hd.getHospitalByName(u);
	}
	public void save(Hospital h){
		hd.save(h);
	}


}
