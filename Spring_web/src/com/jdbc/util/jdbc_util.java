package com.jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class jdbc_util {
	
	private static DataSource ds;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	//static{}静态代码块，只在加载时执行一次，类加载是在实例化这个类的实例化之前执行。
	static{
		Properties pr = new Properties();
		InputStream is = jdbc_util.class.getResourceAsStream("/dbcp.properties");
		try {
			pr.load(is);
			ds = BasicDataSourceFactory.createDataSource(pr);
		} catch (Exception e) {
          System.out.println("加载文件失败！");
			e.printStackTrace();
		}
		
	}
	/**
	 * 获得数据库的连接方法
	 * @return
	 * @throws Exception
	 */
	public static Connection getconection() throws Exception {
	Connection conn = threadLocal.get();
	if(conn==null || conn.isClosed()){
		conn = ds.getConnection();
	    threadLocal.set(conn);
	}
	return conn;
	}
	/**
	 * 释放连接资源的方法
	 */
	public static void closeConnection(){
		Connection conn = threadLocal.get();
		
			try {
				if(conn !=null && !conn.isClosed()){
				conn.close();
			   }
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				threadLocal.set(null);
			}
	}
}
