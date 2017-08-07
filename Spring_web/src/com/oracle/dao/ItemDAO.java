package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.SQLutil;
import com.jdbc.util.jdbc_util;
import com.oracle.domain.Item;
import com.oracle.domain.SearchVO;

public class ItemDAO {
	public int findCountBySearch(SearchVO searchVO) throws Exception{
		String sql = " select count(*) from items where 1=1 ";
		//
		if(searchVO.getIndustryId() != null && -1 !=searchVO.getIndustryId()){
			sql +=" and ITME_INDUSTRY = "+searchVO.getIndustryId();
		}
		//
		if(searchVO.getStageId() != null && -1 !=searchVO.getStageId()){
			sql  +=" and ITEM_STAGE = "+searchVO.getStageId();
		}
		//
		if(searchVO.getTypeId() != null && -1 !=searchVO.getTypeId()){
			sql +=" and ITEM_TYPE  like '%"+searchVO.getTypeId()+"%'" ;
		}
		sql = sql+" order by item_date desc ";
		sql = sql+" order by item_date desc ";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
	}
	public List<Item> findBySearch(SearchVO searchVO) throws Exception{
		String sql = " select * from items where 1=1 ";
		//
		if(searchVO.getIndustryId() != null && -1 !=searchVO.getIndustryId()){
			sql +=" and ITME_INDUSTRY = "+searchVO.getIndustryId();
		}
		//
		if(searchVO.getStageId() != null && -1 !=searchVO.getStageId()){
			sql  +=" and ITEM_STAGE = "+searchVO.getStageId();
		}
		//
		if(searchVO.getTypeId() != null && -1 !=searchVO.getTypeId()){
			sql +=" and ITEM_TYPE  like '%"+searchVO.getTypeId()+"%'" ;
		}
		sql = sql+" order by item_date desc  ";
		String pageSql = sql+SQLutil.getPageSql(searchVO.getPage(), 5);
        System.out.println(pageSql);		
		List<Item> itemList = new ArrayList<Item>();
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(pageSql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
		    Item item = new Item();
		    item.setItemId(rs.getInt("ITEM_ID"));
		    item.setItemTitle(rs.getString("ITEM_TITLE"));
		    item.setItemImg(rs.getString("ITME_IMG"));
		    item.setItemInvest(rs.getInt("ITEM_INVEST"));
		    item.setItemMessage(rs.getString("ITEM_MESSAGE"));
		    item.setItemUnit(rs.getString("ITEM_UNIT"));
		    item.setItemDate(rs.getTimestamp("ITEM_DATE"));
		    //通过领域编号查询领域对象，设置项目的领域信息
		    IndustryDAO industryDAO = new IndustryDAO();
		    item.setIndustry(industryDAO.findById(rs.getInt("ITME_INDUSTRY")));
		    //通过阶段编号查询阶段对象，设置项目的阶段信息
		    StageDAO stageDAO = new StageDAO();
		    item.setStage(stageDAO.findById(rs.getInt("ITEM_STAGE")));
		    //通过类型编号查询类型对象，设置项目的类型信息
		    ItemTypeDAO itemTypeDAO = new ItemTypeDAO();
		    item.setTypeList(itemTypeDAO.findById(rs.getString("ITEM_TYPE")));
		    
			itemList.add(item);
		}
		return itemList;
	}

	public List<Item> findAll () throws Exception{
		List<Item> itemList = new ArrayList<Item>();
		String sql = " select * from items order by item_date desc ";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
		    Item item = new Item();
		    item.setItemId(rs.getInt("ITEM_ID"));
		    item.setItemTitle(rs.getString("ITEM_TITLE"));
		    item.setItemImg(rs.getString("ITME_IMG"));
		    item.setItemInvest(rs.getInt("ITEM_INVEST"));
		    item.setItemMessage(rs.getString("ITEM_MESSAGE"));
		    item.setItemUnit(rs.getString("ITEM_UNIT"));
		    item.setItemDate(rs.getTimestamp("ITEM_DATE"));
		    //通过领域编号查询领域对象，设置项目的领域信息
		    IndustryDAO industryDAO = new IndustryDAO();
		    item.setIndustry(industryDAO.findById(rs.getInt("ITME_INDUSTRY")));
		    //通过阶段编号查询阶段对象，设置项目的阶段信息
		    StageDAO stageDAO = new StageDAO();
		    item.setStage(stageDAO.findById(rs.getInt("ITEM_STAGE")));
		    //通过类型编号查询类型对象，设置项目的类型信息
		    ItemTypeDAO itemTypeDAO = new ItemTypeDAO();
		    item.setTypeList(itemTypeDAO.findById(rs.getString("ITEM_TYPE")));
		    
			itemList.add(item);
		}
		return itemList;
	}
}
