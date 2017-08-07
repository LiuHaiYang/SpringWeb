package com.oracle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.biz.InforBIZ;
import com.oracle.biz.ItemBIZ;
import com.oracle.biz.NewsBIZ;
import com.oracle.domain.Infor;
import com.oracle.domain.Item;
import com.oracle.domain.News;

@WebServlet("/index.do")
public class indexController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创业政策
     NewsBIZ newsBIZ = new NewsBIZ();
     List<News> newsList = newsBIZ.findAll();
     request.setAttribute("newsList", newsList);
        //创业动态
     InforBIZ inforBIZ = new InforBIZ();
     List<Infor> inforList = inforBIZ.findAllInfor();
	request.setAttribute("inforList", inforList);
       //优秀项目
	  ItemBIZ itemBIZ = new ItemBIZ();
	  List<Item> itemList = itemBIZ.findALl();
	  request.setAttribute("itemList",itemList );
	  //页面跳转
	request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   doGet(request, response);
	}

}
