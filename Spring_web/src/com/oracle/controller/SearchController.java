package com.oracle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.biz.IndustryBIZ;
import com.oracle.biz.InforBIZ;
import com.oracle.biz.ItemBIZ;
import com.oracle.biz.ItemTypeBIZ;
import com.oracle.biz.StageBIZ;
import com.oracle.dao.IndustryDAO;
import com.oracle.domain.Industry;
import com.oracle.domain.Infor;
import com.oracle.domain.Item;
import com.oracle.domain.ItemTypes;
import com.oracle.domain.SearchVO;
import com.oracle.domain.Stage;
@WebServlet("/search.do")
public class SearchController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 获得请求参数
		SearchVO searchVO = new SearchVO(1, null, null, null);
		if (request.getParameter("industryId") != null
				&& !"-1".equals(request.getParameter("industryId"))) {
			int industryId = Integer.parseInt(request
					.getParameter("industryId"));
			searchVO.setIndustryId(industryId);
		}
		if (request.getParameter("stageId") != null
				&& !"-1".equals(request.getParameter("stageId"))) {
			int stageId = Integer.parseInt(request.getParameter("stageId"));
			searchVO.setStageId(stageId);
		}
		if (request.getParameter("typeId") != null
				&& !"-1".equals(request.getParameter("typeId"))) {
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			searchVO.setTypeId(typeId);
		}
		//分页
		ItemBIZ itemBIZ = new ItemBIZ();
        
		int recordCount = itemBIZ.findCountBySearch(searchVO);
		int pageCount = (recordCount-1)/5 + 1;
		
		if(request.getParameter("page") !=null
        		  && !"-1".equals(request.getParameter("page"))){
          //当前页面有指定的页码
        	  int page =Integer.parseInt(request.getParameter("page"));
             if(page<1){
            	 page=1;
             }
             if(page> pageCount){
            	 page=pageCount;
             }
        	  searchVO.setPage(page);
          }
		//保存了分页的数据
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("page", searchVO.getPage());
		//2.
		List<Item> itemList = itemBIZ.findBySearch(searchVO);
		request.setAttribute("itemList", itemList);
		
		//3.
		
		        //1.接受用户数据
				 //2.调用业务
		//
				IndustryBIZ industryBIZ= new IndustryBIZ();
				List<Industry>  industryList = industryBIZ.findAll();
				request.setAttribute("industryList", industryList);
	  //
		//
				StageBIZ stageBIZ = new StageBIZ();
				List<Stage> stageList = stageBIZ.findAll();
				request.setAttribute("stageList", stageList);
				
				ItemTypeBIZ itemtypeBIZ = new ItemTypeBIZ();
				List<ItemTypes> itemTypeList =itemtypeBIZ.findAll();
				request.setAttribute("itemTypeList", itemTypeList);

				//3.页面导航
				request.getRequestDispatcher("search.jsp").forward(request, response);
				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      this.doGet(request, response);
      
	}

}
