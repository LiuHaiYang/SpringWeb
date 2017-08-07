package com.oracle.domain;

import java.sql.Timestamp;

public class Infor{
	//INFO_ID
	private int infoId;
	//INFO_TITLE
	private String infoTitle;
	//INFO_TIME
	private Timestamp infoTime;
	//INFO_CONTEXT
	private String infoContext;
	//INFO_IMG
	private String infoImg;
	public Infor(){
		
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public Timestamp getInfoTime() {
		return infoTime;
	}
	public void setInfoTime(Timestamp infoTime) {
		this.infoTime = infoTime;
	}
	public String getInfoContext() {
		return infoContext;
	}
	public void setInfoContext(String infoContext) {
		this.infoContext = infoContext;
	}
	public String getInfoImg() {
		return infoImg;
	}
	public void setInfoImg(String infoImg) {
		this.infoImg = infoImg;
	}
	
}
