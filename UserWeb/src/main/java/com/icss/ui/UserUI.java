package com.icss.ui;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

public class UserUI {
	
	public static void main(String[] args) {
		loginTest();
	}
	
	public static void loginTest() {
		UserBiz biz=new UserBiz();
		try {
			User user=biz.login("", "123");
			if (user==null) {
				System.out.println("�û���¼ʧ�ܣ�����������");
			}else {
				System.out.println(user.getUname()+"�û���½�ɹ�");
				System.out.println("�û�����ǣ�"+user.getRole());
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
}
