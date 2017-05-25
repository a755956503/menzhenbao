package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	public void save(User u) {
		//1 获得连接
		Connection  conn  = JDBCUtils.getConnection();
		//2 准备Sql
		String sql = " INSERT INTO                                "+
						 " `t_user` (`name`, `password`, `email`)  "+
						 " VALUES                                  "+
					 "  (?, ?, ?)                                 ";
		//3 获得PrepareStatement对象
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement(sql);
		//4 设置参数
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
		//5 执行sql
			int result = ps.executeUpdate();
			
			
			if(result != 1 ){
				throw new RuntimeException("保存用户失败!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("保存用户失败!");
		}finally{
			//6 关闭资源
			JDBCUtils.close(conn, ps, null);
		}
	}

	public User getUserByName(String name) {
		User u = null;
		//1 获得连接
		Connection  conn  = JDBCUtils.getConnection();
		//2 书写sql
		String sql = "select * from t_user where name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3 获得PrepareStatement
			 ps = conn.prepareStatement(sql);
			//4 设置参数
			ps.setString(1, name);
			//5 执行查询
			 rs = ps.executeQuery();
			//6 将结果集中的信息封装到User对象中
			if(rs.next()){
				//有数据
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
			}
			
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps, rs);
		}
		
	}

	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		//1 获得连接
		Connection  conn  = JDBCUtils.getConnection();
		//2 书写sql
		String sql = "select * from t_user ";
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
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				
				list.add(u);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户列表失败!");
		}finally{
			//7 关闭资源, 返回User
			JDBCUtils.close(conn, ps, rs);
		}
		
	}

}
