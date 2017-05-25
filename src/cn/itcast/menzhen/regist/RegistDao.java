package cn.itcast.menzhen.regist;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.menzhen.hospital.Hospital;


public class RegistDao extends HibernateDaoSupport{

	public List<Regist> finAllByh(String h_name) {
		// TODO Auto-generated method stub
		//return (List<Regist>) this.getHibernateTemplate().get(Regist.class, h_name);
		List<Regist> list= this.getHibernateTemplate().find("from Regist where h_name = ?",h_name);
		if(list.size()!=0){
			System.out.println("registDao*********"+list.get(0).getH_name());
			return list;
		}
		return null;
	}
	public List<Regist> finAllByUsername(String username) {
		// TODO Auto-generated method stub
		//return (List<Regist>) this.getHibernateTemplate().get(Regist.class, h_name);
		List<Regist> list= this.getHibernateTemplate().find("from Regist where username = ?",username);
		if(list.size()!=0){
			System.out.println("registDao*********"+list.get(0).getH_name());
			return list;
		}
		return null;
	}
	public void submit(Regist regist){
		this.getHibernateTemplate().save(regist);
	}
	public void toSet(String rid){
		Regist regist = null;
		List<Regist> list=this.getHibernateTemplate().find("from Regist where r_id = ?",rid);
		if(list.size()!=0){
			System.out.println("toSet*********"+list.get(0).getH_name());
			regist=list.get(0);
		}else{
			System.out.println("toSet*********notfind");
		}
		regist.setR_status(1);
		this.getHibernateTemplate().update(regist);
		
		
	}

}
