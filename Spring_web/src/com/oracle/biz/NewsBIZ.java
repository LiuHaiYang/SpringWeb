package com.oracle.biz;

import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.dao.NewsDAO;
import com.oracle.domain.News;

public class NewsBIZ {

	public List<News> findAll(){
		try {
			NewsDAO newsDAO = new NewsDAO();
			return newsDAO.FindAll();
		} catch (Exception e) {
			e.printStackTrace();
             return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}
}
