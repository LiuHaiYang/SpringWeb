package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.biz.UsersBIZ;
import com.oracle.domain.Users;

@WebServlet("/login.do")

public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //1.接收用户请求
		String userName = request.getParameter("username");
		String userPass = request.getParameter("password");
		//2.调用业务
		UsersBIZ usersBIZ = new UsersBIZ();
		Users  users = usersBIZ.isLogin(userName, userPass);
		
		//3.页面导航
		if(users==null){
			response.sendRedirect("login.jsp");
		}else{
			//将用户对象保存到会话
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			response.sendRedirect("index.do");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");    
		this.doGet(request, response);
           
	}

}
