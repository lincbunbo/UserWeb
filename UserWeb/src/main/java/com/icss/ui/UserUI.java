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
				System.out.println("用户登录失败，请重新输入");
			}else {
				System.out.println(user.getUname()+"用户登陆成功");
				System.out.println("用户身份是："+user.getRole());
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
