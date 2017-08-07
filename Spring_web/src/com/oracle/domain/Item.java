package com.oracle.domain;

import java.sql.Timestamp;
import java.util.List;

public class Item {
	private int itemId;
	private String itemTitle;
	private String itemUnit;
	private String  itemMessage;
	private String itemImg;
	private int itemInvest;
	private Timestamp itemDate;
	private Industry industry;
	private Stage stage;
	private List<ItemTypes> typeList;
	public Item(){
		
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	public String getItemMessage() {
		return itemMessage;
	}
	public void setItemMessage(String itemMessage) {
		this.itemMessage = itemMessage;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public int getItemInvest() {
		return itemInvest;
	}
	public void setItemInvest(int itemInvest) {
		this.itemInvest = itemInvest;
	}
	public Timestamp getItemDate() {
		return itemDate;
	}
	public void setItemDate(Timestamp itemDate) {
		this.itemDate = itemDate;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public List<ItemTypes> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<ItemTypes> typeList) {
		this.typeList = typeList;
	}
	

}
