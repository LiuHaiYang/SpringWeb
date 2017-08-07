package com.oracle.biz;

import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.dao.ItemTypeDAO;
import com.oracle.domain.ItemTypes;


public class ItemTypeBIZ {
	public List<ItemTypes> findAll(){
		try {
			ItemTypeDAO itemTypeDAO = new ItemTypeDAO();
			return itemTypeDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
             return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}

}
