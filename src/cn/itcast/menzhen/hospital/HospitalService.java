package cn.itcast.menzhen.hospital;

import java.util.List;


public class HospitalService {
	
	private HospitalDao hospitalDao;

	public void setHospitalDao(HospitalDao hospitalDao) {
		this.hospitalDao = hospitalDao;
	}

	public String findhByName(String name) {
		// TODO Auto-generated method stub
		return hospitalDao.finhByName(name);
	}
	public String findhByHname(String name) {
		// TODO Auto-generated method stub
		return hospitalDao.finhByHname(name);
	}
	public List<Hospital> getAllHospital(){
		return hospitalDao.getAllHospital();
	}
	public void save(Hospital hospital){
		hospitalDao.save(hospital);
	}

}
