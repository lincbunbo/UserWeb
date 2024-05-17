package com.icss.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.icss.biz.UserBiz;
import com.icss.entity.User;

@WebServlet(urlPatterns = "/registerSvl")
public class RegisterSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/main/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("role");
		String tel=request.getParameter("tel");
		System.out.println("uname="+uname+",pwd="+pwd+",role="+role+",tel="+tel);
		if (uname==null||pwd==null||uname.equals("")||pwd.equals("")||role==null||role.equals("")) {
			throw new RuntimeException("用户名或者密码或者角色不能为空");
		}
		UserBiz biz=new UserBiz();
		try {
			User user=biz.select(uname);
			if (user!=null) {
				request.setAttribute("sremsg", "用户名已经存在");
				request.getRequestDispatcher("/main/register.jsp").forward(request, response);
			}
			else {
				int flag=biz.register(uname, pwd, role, tel);
				if (flag==1) {
					System.out.println(uname+"注册成功");
					request.getRequestDispatcher("/main/login.jsp").forward(request, response);
				}else {
					System.out.println("注册失败");
					request.getRequestDispatcher("/main/register.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			request.getRequestDispatcher("/error/msg.jsp").forward(request, response);
		}
	}

}
