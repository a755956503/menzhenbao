package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {
		//保存用户对象
		void  save(User u);
		//根据用户名查询用户
		User getUserByName(String name);
		//查询所有用户
		List<User> getAllUser();
}


