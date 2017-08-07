package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.domain.Infor;

public class InforDAO {
	public Infor findById(int id) throws Exception{
		String sql ="select * from informations  where  INFO_ID = ?";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Infor infor = new Infor();
		    infor.setInfoId(rs.getInt("INFO_ID"));
		    infor.setInfoTitle(rs.getString("INFO_TITLE"));
		    infor.setInfoTime(rs.getTimestamp("INFO_TIME"));
		    infor.setInfoContext(rs.getString("INFO_CONTEXT"));
		    infor.setInfoImg(rs.getString("INFO_IMG"));
		    return infor;
		}else{
			return null;
		}

	}

	public List<Infor> FindAllInfor() throws Exception{
		List<Infor> inforList = new ArrayList<Infor>();
		Connection conn = jdbc_util.getconection();
		String sql ="select * from informations order by info_time desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Infor infor = new Infor();
		    infor.setInfoId(rs.getInt("INFO_ID"));
		    infor.setInfoTitle(rs.getString("INFO_TITLE"));
		    infor.setInfoTime(rs.getTimestamp("INFO_TIME"));
		    infor.setInfoContext(rs.getString("INFO_CONTEXT"));
		    infor.setInfoImg(rs.getString("INFO_IMG"));
		    inforList.add(infor);
			
		}
		return  inforList;
	}
}
