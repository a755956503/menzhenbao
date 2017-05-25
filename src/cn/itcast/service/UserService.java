package cn.itcast.service;

import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;

public class UserService {
	
	private UserDao ud = new UserDaoImpl();
	
	public void regist(User u ){
		//1 校验用户名不重复
		User existU = ud.getUserByName(u.getName());
		if(existU != null){
			//用户名已经存在
			throw new RuntimeException("用户名已存在!");
		}
		//2 调用dao,执行保存
		ud.save(u);
	}
	
	public User login(User u){
		//1 根据用户名,调用dao获得User对象
		User existU = ud.getUserByName(u.getName());
		if(existU==null){
			//没获得到=>用户名不存在=> 抛出异常
			throw new RuntimeException("用户名不存在!");
		}
		//2 比对密码是否一致
		if(!existU.getPassword().equals(u.getPassword())){
			//不一致=>密码不正确=>抛出异常
			throw new RuntimeException("密码不正确!");
		}
		//3 登录成功返回User对象
		return existU;
	}
	
	public List<User> getAllUser(){
		return ud.getAllUser();
	}
}
