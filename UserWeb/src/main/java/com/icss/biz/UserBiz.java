package com.icss.biz;

import com.icss.dao.UserDao;
import com.icss.entity.User;

public class UserBiz {
	
	/**
	 * 用户登录
	 * @param uname
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public User login(String uname,String pwd) throws Exception{
		//1.入参校验
		if (uname==null  || uname.equals("")) {
			throw new RuntimeException("用户名不能为空");
		}
		if (pwd==null  || pwd.equals("")) {
			throw new RuntimeException("密码不能为空");
		}
		
		//2.按照业务流程图实现逻辑处理（SSO,shiro,spring,security,令牌）
		
		UserDao dao=new UserDao();
		User user=dao.login(uname, pwd);
		
		return user;
	}
	/**
	 * 用户注册
	 * @param uname
	 * @param pwd
	 * @param role
	 * @param tel
	 * @return
	 * @throws Exception
	 */
	public int register(String uname,String pwd,String role,String tel) throws Exception{
		//1.入参校验

		if (uname==null  || uname.equals("")) {
			throw new RuntimeException("用户名不能为空");
		}
		if (pwd==null  || pwd.equals("")) {
			throw new RuntimeException("密码不能为空");
		}
		if (role==null  || role.equals("")) {
			throw new RuntimeException("角色不能为空");
		}
		//2.按照业务流程图实现逻辑处理（SSO,shiro,spring,security,令牌）
		
		UserDao dao=new UserDao();
		int flag = dao.register(uname, pwd, role, tel);
		
		return flag;
	}
	/**
	 * 用户查询
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public User select(String uname) throws Exception{
		//1.入参校验
		if (uname==null  || uname.equals("")) {
			throw new RuntimeException("用户名不能为空");
		}
		//2.按照业务流程图实现逻辑处理（SSO,shiro,spring,security,令牌）
		
		UserDao dao=new UserDao();
		User user=dao.select(uname);
		
		return user;
	}
}
