package cn.itcast.menzhen.regist;

import java.util.List;


public class RegistService {
	
	private RegistDao registDao;

	public void setRegistDao(RegistDao registDao) {
		this.registDao = registDao;
	}

	public List<Regist> findAllByh(String h_name) {
		// TODO Auto-generated method stub
		return registDao.finAllByh(h_name);
	}
	public List<Regist> findAllByUsername(String username) {
		// TODO Auto-generated method stub
		return registDao.finAllByUsername(username);
	}
	public void submit(Regist regist) {
		System.out.println("service"+regist);
		registDao.submit(regist);
		
	}
	public void toSet(String rid){
		registDao.toSet(rid);
		
	}
}
