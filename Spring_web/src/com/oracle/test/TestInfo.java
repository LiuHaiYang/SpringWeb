package com.oracle.test;

import java.util.List;

import org.junit.Test;

import com.oracle.biz.InforBIZ;
import com.oracle.dao.ItemDAO;
import com.oracle.domain.Infor;
import com.oracle.domain.SearchVO;

public class TestInfo {

	@Test
	public void inforTest() throws Exception{
//		InforBIZ inforBIZ = new InforBIZ();
//		List<Infor> inforList = inforBIZ.findAllInfor();
//		for(Infor infor:inforList){
//			System.out.println(infor.getInfoId()+":"+infor.getInfoTitle());
//		}
		ItemDAO itemDAO = new ItemDAO();
		SearchVO searchVO = new SearchVO(1,2,1,3);
		itemDAO.findBySearch(searchVO);
				
	}
}
