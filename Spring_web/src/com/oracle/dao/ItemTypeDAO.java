package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.domain.ItemTypes;
/**
 * 按编号查询的多个项目类型的方法
 * @param ids多个项目编号
 * @return
 * @throws Exception
 */

public class ItemTypeDAO {
	public List<ItemTypes> findAll() throws Exception{
		List<ItemTypes> itemtypeList = new ArrayList<ItemTypes>();
		String sql = "select  * from itemtypes order by TYPE_ID asc";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ItemTypes itemTypes = new ItemTypes();
			itemTypes.setTypeId(rs.getInt("TYPE_ID"));
			itemTypes.setTypeName(rs.getString("TYPE_NAME"));
			itemtypeList.add(itemTypes);
		}
		return itemtypeList;
	}

	public List<ItemTypes> findById(String ids) throws Exception{
		List<ItemTypes> itemtypeList = new ArrayList<ItemTypes>();
		String sql = "select  * from itemtypes where" +
				" type_id in ( "+ids+")";
		Connection conn = jdbc_util.getconection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ItemTypes itemTypes = new ItemTypes();
			itemTypes.setTypeId(rs.getInt("TYPE_ID"));
			itemTypes.setTypeName(rs.getString("TYPE_NAME"));
			itemtypeList.add(itemTypes);
		}
		return itemtypeList;
	}
}
