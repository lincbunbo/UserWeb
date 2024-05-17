package com.icss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.entity.User;
import com.icss.util.DbFactory;

public class UserDao {

	/**
	 * 用户登录
	 * @param uname
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public User login(String uname,String pwd) throws Exception{
		User user=null;
		
		String sql="select * from tuser where uname=? and pwd=?";
		Connection conn=DbFactory.openConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			user=new User();
			user.setUname(uname);
			user.setPwd(pwd);
			user.setRole(rs.getInt("role"));
			user.setTel(rs.getString("tel"));
			
		}
		rs.close();
		ps.close();
		DbFactory.closeConnection(conn);
		return user;
	}
	/**
	 * 注册用户
	 * @param uname
	 * @param pwd
	 * @param role
	 * @param tel
	 * @return
	 * @throws Exception
	 */
	public int register(String uname,String pwd,String role,String tel) throws Exception{
		
		String sql="insert into tuser values(?,?,?,?)";
		Connection conn=DbFactory.openConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, pwd);
		ps.setString(3, role);
		ps.setString(4, tel);
		
		int flag=ps.executeUpdate();
		ps.close();
		DbFactory.closeConnection(conn);
		return flag;
	}
	/**
	 * 用户查询
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public User select(String uname) throws Exception{
		User user=null;
		
		String sql="select * from tuser where uname=?";
		Connection conn=DbFactory.openConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			user=new User();
			user.setUname(uname);
			user.setPwd(rs.getString("pwd"));
			user.setRole(rs.getInt("role"));
			user.setTel(rs.getString("tel"));
			
		}
		rs.close();
		ps.close();
		DbFactory.closeConnection(conn);
		return user;
	}
}
