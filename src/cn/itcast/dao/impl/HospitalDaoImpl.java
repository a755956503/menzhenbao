package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.HospitalDao;
import cn.itcast.domain.Hospital;
import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;

public class HospitalDaoImpl implements HospitalDao {

	public void save(Hospital h) {
		// TODO Auto-generated method stub
		//1 获得连接
				Connection  conn  = JDBCUtils.getConnection();
				String sql = " INSERT INTO                                "+
						 " `t_hospital` (`h_name`, `h_address`, `name`)  "+
						 " VALUES                                  "+
					 "  (?, ?, ?)                                 ";
				PreparedStatement ps = null;
				try {
					 ps = conn.prepareStatement(sql);
				//4 设置参数
					ps.setString(1, h.getH_name());
					ps.setString(2, h.getH_address());
					ps.setString(3, h.getName());
				//5 执行sql
					int result = ps.executeUpdate();
					
					
					if(result != 1 ){
						throw new RuntimeException("开通诊所失败!");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("开通诊所失败!");
				}finally{
					//6 关闭资源
					JDBCUtils.close(conn, ps, null);
				}
	}

	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		List<Hospital> list = new ArrayList<Hospital>();
		//1 获得连接
		Connection  conn  = JDBCUtils.getConnection();
		//2 书写sql
		String sql = "select * from t_hospital ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3 获得PrepareStatement
			 ps = conn.prepareStatement(sql);
			//4 执行查询
			 rs = ps.executeQuery();
			//6 将结果集中的信息封装到User对象中
			while(rs.next()){
				//有数据
				Hospital u = new Hospital();
				u.setH_name(rs.getString("h_name"));
				u.setH_address(rs.getString("h_address"));
				u.setName(rs.getString("name"));
				
				list.add(u);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询诊所列表失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps, rs);
		}
	}

	public String getHospitalByName(String u) {
		// TODO Auto-generated method stub
		String hName= null;
		Connection  conn  = JDBCUtils.getConnection();
		String sql = "select * from t_hospital where name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3 获得PrepareStatement
			 ps = conn.prepareStatement(sql);
			//4 设置参数
			ps.setString(1, u);
			//5 执行查询
			 rs = ps.executeQuery();
			//6 将结果集中的信息封装到User对象中
			if(rs.next()){
				//有数据
				
				hName=rs.getString("h_name");
			}
			
			return hName;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps, rs);
		}
		
	}

}
