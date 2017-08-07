package com.jdbc.util;

public class SQLutil {
	/**
	 * 分页查询语句的方法
	 * @param sql  查询的语句
	 * @param page   页码
	 * @return
	 */
	public static String getPageSql(int page, int recrdOfPage){
		String pagesql = " LIMIT "+ (page-1)*recrdOfPage+","+page*recrdOfPage+" ";
	  return pagesql;
	}

}
