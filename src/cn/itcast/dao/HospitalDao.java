package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Hospital;


public interface HospitalDao {
	//保存用户对象
			void  save(Hospital h);
			//根据用户名查询用户
//			Hospital getHospitalByName(String name);
			//查询所有用户
			List<Hospital> getAllHospital();
			String getHospitalByName(String u);
}
