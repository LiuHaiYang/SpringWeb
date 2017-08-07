package com.oracle.biz;

import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.dao.ItemTypeDAO;
import com.oracle.dao.StageDAO;
import com.oracle.domain.ItemTypes;
import com.oracle.domain.Stage;

public class StageBIZ {
	public List<Stage> findAll(){
		try {
			StageDAO stageDAO = new StageDAO();
			return stageDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
             return null;
		}finally{
			jdbc_util.closeConnection();
		}
	}

}
