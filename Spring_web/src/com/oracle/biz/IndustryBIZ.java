package com.oracle.biz;

import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.dao.IndustryDAO;
import com.oracle.domain.Industry;

public class IndustryBIZ {
	public List<Industry> findAll(){
		try {
			IndustryDAO industryDAO = new IndustryDAO();
			return industryDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
             return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}
	}
