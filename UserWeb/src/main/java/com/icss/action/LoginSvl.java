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

@WebServlet(urlPatterns = "/loginSvl")
public class LoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/main/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		System.out.println("uname="+uname+",pwd="+pwd);
		if (uname==null||pwd==null||uname.equals("")||pwd.equals("")) {
			throw new RuntimeException("用户名或者密码不能为空");
		}
		UserBiz biz=new UserBiz();
		int iRet;
		try {
			User user=biz.login(uname, pwd);
			if (user!=null) {
				System.out.println(uname+"登陆成功");
				request.getSession().setAttribute("user", user);
				iRet=1;
			}else {
				System.out.println("登陆失败");
				request.setAttribute("msg", "用户名或者密码错误");
				iRet=0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			iRet=-1;
		}
		PrintWriter out=response.getWriter();
		out.print(iRet);
		out.flush();
		out.close();
	}

}
