package cn.itcast.menzhen.hospital;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.menzhen.user.User;

public class HospitalDao extends HibernateDaoSupport{

	public String finhByName(String name) {
		// TODO Auto-generated method stub
		List<Hospital> list= this.getHibernateTemplate().find("from Hospital where username = ?",name);
		if(list.size()!=0){
			System.out.println("hospitalDao*********"+list.get(0).getH_name());
			return list.get(0).getH_name();
			
		}
		return null;
	}
	public String finhByHname(String name) {
		// TODO Auto-generated method stub
		List<Hospital> list= this.getHibernateTemplate().find("from Hospital where h_name = ?",name);
		if(list.size()!=0){
			System.out.println("hospitalDao*********"+list.get(0).getH_name());
			return list.get(0).getH_name();
			
		}
		return null;
	}

	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Hospital");
	}
	public void save(Hospital hospital){
		this.getHibernateTemplate().save(hospital);
	}

}
