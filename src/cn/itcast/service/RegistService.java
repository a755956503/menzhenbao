package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.RegistDao;
import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.RegistDaoImpl;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.Regist;
import cn.itcast.domain.User;

public class RegistService {
private RegistDao rd = new RegistDaoImpl();
	
	public void regist(Regist r ){
		//1 校验用户名不重复
		rd.save(r);
	}
	public List<Regist> getRecord(String name){
		return rd.getRegist(name);
	}
	public List<Regist> getRecordByHname(String name){
		return rd.getRegistByHname(name);
	}
	public int doRecord(int id){
		return rd.doRecord(id);
	}

}
