package com.icss.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

@WebServlet(urlPatterns = "/jiaoyanSvl")
public class JiaoyanSvl extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		System.out.println("uname="+uname);
		UserBiz biz=new UserBiz();
		int iRet;
		try {
			User user=biz.select(uname);
			if (user!=null) {
				iRet=0;
			}
			else {
				iRet=1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			iRet=-1;
		}
		PrintWriter out=response.getWriter();
		out.print(iRet);
		out.flush();
		out.close();
	}

}
