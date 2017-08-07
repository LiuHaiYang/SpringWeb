package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.domain.Industry;
import com.oracle.domain.Stage;

public class StageDAO {
	
	public List<Stage>  findAll() throws Exception{
		List<Stage>  satgeList = new ArrayList<Stage>();
		String sql = "select * from STAGE order by stage_id asc";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Stage stage = new Stage();
			stage.setStageId(rs.getInt("STAGE_ID"));
			stage.setStageTitle(rs.getString("STAGE_TITLE"));
			satgeList.add(stage);
			}
			return satgeList;
		
	}
	
	public Stage findById(int id) throws Exception{
		String sql = "select * from STAGE where STAGE_ID = ?";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Stage stage = new Stage();
			stage.setStageId(rs.getInt("STAGE_ID"));
			stage.setStageTitle(rs.getString("STAGE_TITLE"));
			return stage;
		}else{
			return null;
		}
	}

}
