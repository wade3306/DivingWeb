package model;

public class tourspotModel {
	private Integer tourspotNum;
	private Integer spotNum;
	
	public tourspotModel() {
		super();
	}
	public tourspotModel(Integer spotNum) {
		super();
		this.spotNum = spotNum;
	}
	public tourspotModel(Integer tourspotNum, Integer spotNum) {
		super();
		this.tourspotNum = tourspotNum;
		this.spotNum = spotNum;
	}
	public Integer getTourspotNum() {
		return tourspotNum;
	}
	public void setTourspotNum(Integer tourspotNum) {
		this.tourspotNum = tourspotNum;
	}
	public Integer getSpotNum() {
		return spotNum;
	}
	public void setSpotNum(Integer spotNum) {
		this.spotNum = spotNum;
	}
}
