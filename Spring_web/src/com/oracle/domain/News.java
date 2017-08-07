package com.oracle.domain;

import java.sql.Timestamp;

/**
 * 新闻的实体类，对应数据库的news表
 * @author samsung1
 *
 */
public class News {
	//NEWS_ID
   private int newsId;
     //NEWS_TITLE
   private String newsTitle;
     //NEWS_TIME
   private Timestamp newsTime;
     //NEWS_CONTEXT
   private String newsContext;
     //NEWS_IMG
   private String newsImg;
   public News(){
   }
public int getNewsId() {
	return newsId;
}
public void setNewsId(int newsId) {
	this.newsId = newsId;
}
public String getNewsTitle() {
	return newsTitle;
}
public void setNewsTitle(String newsTitle) {
	this.newsTitle = newsTitle;
}
public Timestamp getNewsTime() {
	return newsTime;
}
public void setNewsTime(Timestamp newsTime) {
	this.newsTime = newsTime;
}
public String getNewsContext() {
	return newsContext;
}
public void setNewsContext(String newsContext) {
	this.newsContext = newsContext;
}
public String getNewsImg() {
	return newsImg;
}
public void setNewsImg(String newsImg) {
	this.newsImg = newsImg;
}
public News(int newsId, String newsTitle, Timestamp newsTime,
		String newsContext, String newsImg) {
	super();
	this.newsId = newsId;
	this.newsTitle = newsTitle;
	this.newsTime = newsTime;
	this.newsContext = newsContext;
	this.newsImg = newsImg;
}
public News(int newsId, String newsTitle) {
	this.newsId = newsId;
	this.newsTitle = newsTitle;
}
   
}
