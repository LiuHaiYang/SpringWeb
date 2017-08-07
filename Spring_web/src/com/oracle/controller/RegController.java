package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jdbc.util.FileNameUtil;
import com.jdbc.util.UUIDUtil;
import com.jdbc.util.UsersUtil;
import com.oracle.biz.UsersBIZ;
import com.oracle.domain.Users;
import com.oracle.md5.MD5_Encoding;

@WebServlet("/reg.do")
@MultipartConfig//文件上传时必须加的注解
public class RegController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //1.接受用户请求
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 MD5_Encoding md5 = new MD5_Encoding();
		 String  pass = md5.getMD5ofStr(password);
		 Part part =request.getPart("userImg");
		 //获得一个随机文件名
		 String uuidfilename = UUIDUtil.getUUID();
		 //获得文件名
		 String realfilename = FileNameUtil.
				 getRealFileName(part.getHeader("Content-Disposition"));                                                                       
		 //通过组成（随机文件名+后缀） 上传文件名称
		 String savefilename = uuidfilename + FileNameUtil.getFileType(realfilename);
 		 //System.out.println(savefilename);  
		 //获取文件保存的位置
		 String path = this.getServletContext().getRealPath("/upimg");
		 //文件上传动作
		 part.write(path+"/"+savefilename);
		 
		 //2.调用业务逻辑
         Users users = new Users();
		 users.setUserName(username);
		 users.setUserPass(pass);
		 users.setUserImg(savefilename);
		 UsersBIZ  usersBIZ = new UsersBIZ();
		 int  i = usersBIZ.save(users);
		 //3.页面导航 
		switch(i){
		case UsersUtil.USER_SUCCESS:
		response.sendRedirect("login.jsp");
		return;
		case UsersUtil.USER_ERROR:
			String errorInfo = "注册失败！请重新注册！";
			request.setAttribute("errorInfo", errorInfo);
            request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		case UsersUtil.USER_USERNAME_NOT_EMPTY:
			String errorName = "用户名已存在！请重新注册！";
			request.setAttribute("errorInfo", errorName);

            request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     this.doGet(request, response);
	}

}
