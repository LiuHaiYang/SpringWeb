package com.oracle.biz;

import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.dao.ItemDAO;
import com.oracle.domain.Item;
import com.oracle.domain.SearchVO;

public class ItemBIZ {
	
	public int findCountBySearch( SearchVO searchVO){
		try {
			return new ItemDAO().findCountBySearch(searchVO);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			jdbc_util.closeConnection();
		}
	}
	
	public List<Item> findBySearch( SearchVO searchVO){
		try {
			return new ItemDAO().findBySearch(searchVO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}

	public List<Item> findALl(){
		try {
			return new ItemDAO().findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}
}
