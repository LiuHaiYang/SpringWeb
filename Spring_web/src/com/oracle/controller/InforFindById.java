package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.biz.InforBIZ;
import com.oracle.domain.Infor;
@WebServlet("/inforbyid.do")
public class InforFindById extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         //1.接受用户数据
		int id = Integer.parseInt(request.getParameter("id"));
		 //2.调用业务
		InforBIZ inforBIZ = new InforBIZ();
		Infor  infor = inforBIZ.findById(id);
		 //3.页面导航
		request.setAttribute("infor", infor);
		request.getRequestDispatcher("information.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    this.doGet(request, response);
	}

}
