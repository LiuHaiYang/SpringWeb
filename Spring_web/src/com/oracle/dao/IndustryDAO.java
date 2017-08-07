package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.domain.Industry;
import com.oracle.domain.News;

public class IndustryDAO {
	public List<Industry> findAll() throws Exception{
		List<Industry> industryList = new ArrayList<Industry>();
		String sql = "select * from industry order by INDUSTRY_ID ASC ";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Industry industry = new Industry();
			industry.setIndustryId(rs.getInt("INDUSTRY_ID"));
			industry.setIndustryTitle(rs.getString("INDUSTRY_TITLE"));
			industryList.add(industry);
			}
			return industryList;
		
	}

	public Industry findById(int id) throws Exception{
		String sql = "select * from industry where industry_id = ?";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Industry industry = new Industry();
			industry.setIndustryId(rs.getInt("INDUSTRY_ID"));
			industry.setIndustryTitle(rs.getString("INDUSTRY_TITLE"));
			return industry;
		}else{
			return null;
		}
	}
}
