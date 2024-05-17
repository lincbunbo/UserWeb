package com.icss.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbFactory {
	
	public static Connection openConnection() throws Exception {
		//1.��������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ���ݿ�����
		String url="jdbc:mysql://localhost:3306/aa212?useUnicode=true&characterEncoding=utf8&useSSL=false";
		Connection conn=DriverManager.getConnection(url,"root","200401");
		if (conn!=null) {
			System.out.println("����һ�����ݿ�����");
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
				System.out.println("�ر����ݿ����ӡ�����");
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}

}
