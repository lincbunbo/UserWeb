package com.icss.biz;

import com.icss.dao.UserDao;
import com.icss.entity.User;

public class UserBiz {
	
	/**
	 * �û���¼
	 * @param uname
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public User login(String uname,String pwd) throws Exception{
		//1.���У��
		if (uname==null  || uname.equals("")) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if (pwd==null  || pwd.equals("")) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		
		//2.����ҵ������ͼʵ���߼�����SSO,shiro,spring,security,���ƣ�
		
		UserDao dao=new UserDao();
		User user=dao.login(uname, pwd);
		
		return user;
	}
	/**
	 * �û�ע��
	 * @param uname
	 * @param pwd
	 * @param role
	 * @param tel
	 * @return
	 * @throws Exception
	 */
	public int register(String uname,String pwd,String role,String tel) throws Exception{
		//1.���У��

		if (uname==null  || uname.equals("")) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if (pwd==null  || pwd.equals("")) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		if (role==null  || role.equals("")) {
			throw new RuntimeException("��ɫ����Ϊ��");
		}
		//2.����ҵ������ͼʵ���߼�����SSO,shiro,spring,security,���ƣ�
		
		UserDao dao=new UserDao();
		int flag = dao.register(uname, pwd, role, tel);
		
		return flag;
	}
	/**
	 * �û���ѯ
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public User select(String uname) throws Exception{
		//1.���У��
		if (uname==null  || uname.equals("")) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		//2.����ҵ������ͼʵ���߼�����SSO,shiro,spring,security,���ƣ�
		
		UserDao dao=new UserDao();
		User user=dao.select(uname);
		
		return user;
	}
}
