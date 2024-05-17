package com.icss.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbFactory {
	
	public static Connection openConnection() throws Exception {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据库连接
		String url="jdbc:mysql://localhost:3306/aa212?useUnicode=true&characterEncoding=utf8&useSSL=false";
		Connection conn=DriverManager.getConnection(url,"root","200401");
		if (conn!=null) {
			System.out.println("打开了一个数据库连接");
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
				System.out.println("关闭数据库连接。。。");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
