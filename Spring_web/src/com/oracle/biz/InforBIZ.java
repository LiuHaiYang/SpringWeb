package com.oracle.biz;

import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.dao.InforDAO;
import com.oracle.domain.Infor;

public class InforBIZ {
	public Infor findById(int id){
		try {
			InforDAO inforDAO = new InforDAO();
			Infor infor = inforDAO.findById(id);
			return infor ;
		} catch (Exception e) {
			e.printStackTrace();
             return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}


	public List<Infor> findAllInfor(){
		try {
			InforDAO inforDAO = new InforDAO();
			List<Infor> infoList = inforDAO.FindAllInfor();
			return infoList ;
		} catch (Exception e) {
			e.printStackTrace();
             return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}
}
