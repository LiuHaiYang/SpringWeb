package com.oracle.domain;

public class SearchVO {
	private Integer page;
	private Integer industryId;
	private Integer stageId;
	private Integer typeId;
	public SearchVO(){
		
	}
	public SearchVO(Integer page, Integer industryId, Integer stageId,
			Integer typeId) {
		this.page = page;
		this.industryId = industryId;
		this.stageId = stageId;
		this.typeId = typeId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public Integer getStageId() {
		return stageId;
	}
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	

}
