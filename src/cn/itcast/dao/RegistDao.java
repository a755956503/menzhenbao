package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Regist;

public interface RegistDao {
	void save(Regist r);
	List<Regist> getRegist(String name);
	List<Regist> getRegistByHname(String name);
	int doRecord(int id);
}
