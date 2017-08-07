package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.domain.News;

public class NewsDAO {
   
	public List<News> FindAll() throws  Exception{
		List<News> newsList = new ArrayList<News>();
		Connection conn = jdbc_util.getconection();
		String sql = "select * from news order by news_title desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
           News news = new News();
			news.setNewsId(rs.getInt("NEWS_ID"));
			news.setNewsTitle(rs.getString("NEWS_TITLE"));
			news.setNewsTime(rs.getTimestamp("NEWS_TIME"));
			news.setNewsContext(rs.getString("NEWS_CONTEXT"));
			news.setNewsImg(rs.getString("NEWS_IMG"));
			newsList.add(news);
		}
		return newsList;
	}
}
