package cn.itcast.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	 
	static{
		
		try {
			//0读取配置文件
			Properties prop  = new Properties();
			
			InputStream is = JDBCUtils.class.getResourceAsStream("/db.properties");
			
			//InputStream is = new FileInputStream("src/db.properties");
			prop.load(is);
			
			is.close();
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			//1 注册驱动
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//1 获得连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//2 获得连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("创建连接失败!");
		}
		
		return conn;
	}
	
	//2 释放资源
		//1> 参数可能为空
		//2> 调用close方法要抛出异常,确保即使出现异常也能继续关闭
		//3>关闭顺序,需要从小到大
	public  static void  close(Connection conn , Statement st , ResultSet rs){
		
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(st!=null){
				st.close();	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();	
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
