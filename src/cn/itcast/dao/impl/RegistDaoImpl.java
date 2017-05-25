package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import cn.itcast.dao.RegistDao;
import cn.itcast.domain.Regist;
import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;

public class RegistDaoImpl implements RegistDao{

	public void save(Regist r) {
		// TODO Auto-generated method stub
		//Connection conn=JDBCUtils.getConnection();
		Connection  conn  = JDBCUtils.getConnection();
		String sql="insert into t_register(h_name,name,r_name,r_age,r_sex,r_sympton,r_date)"
				+"values(?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, r.getH_name());
			ps.setString(2, r.getName());
			ps.setString(3, r.getR_name());
			ps.setString(4, r.getR_age());
			ps.setString(5, r.getR_sex());
			ps.setString(6, r.getR_sympton());
			ps.setDate(7, r.getR_date());
			
			int result=ps.executeUpdate();
			if(result != 1 ){
				throw new RuntimeException("保存数据失败!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("预约挂号失败!");
		}finally{
			//6 关闭资源
			JDBCUtils.close(conn, ps, null);
		}
		
	}

	public List<Regist> getRegist(String name) {
		// TODO Auto-generated method stub
		List<Regist> list=new ArrayList<Regist>() ;
		Connection  conn  = JDBCUtils.getConnection();
		String sql = "select * from t_register where name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3 获得PrepareStatement
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			//4 执行查询
			 rs = ps.executeQuery();
			//6 将结果集中的信息封装到User对象中
			while(rs.next()){
				//有数据
				Regist r=new Regist();
				r.setH_name(rs.getString("h_name"));
				r.setR_date(rs.getDate("r_date"));
				r.setR_sympton(rs.getString("r_sympton"));
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询挂号记录失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps, rs);
		}
			

	}

	public List<Regist> getRegistByHname(String name) {
		// TODO Auto-generated method stub
		List<Regist> list=new ArrayList<Regist>() ;
		Connection  conn  = JDBCUtils.getConnection();
		String sql = "select * from t_register where h_name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3 获得PrepareStatement
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			//4 执行查询
			 rs = ps.executeQuery();
			//6 将结果集中的信息封装到User对象中
			while(rs.next()){
				//有数据
				Regist r=new Regist();
				r.setR_name(rs.getString("r_name"));
				r.setR_age(rs.getString("r_age"));
				r.setR_sex(rs.getString("r_sex"));
				r.setR_status(rs.getInt("r_status"));
				r.setR_date(rs.getDate("r_date"));
				r.setR_sympton(rs.getString("r_sympton"));
				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询挂号记录失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps, rs);
		}
			
	}

	public int doRecord(int id) {
		int result=0;
		// TODO Auto-generated method stub
		Connection  conn  = JDBCUtils.getConnection();
		String sql = "update t_register set r_status=1 where r_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3 获得PrepareStatement
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			//4 执行查询
			 result=ps.executeUpdate();
			//6 将结果集中的信息封装到User对象中
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询挂号记录失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps,rs);
		}
		return result;
	}

}
