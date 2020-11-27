package model;
import java.util.ArrayList;

public class tourModel {
	private Integer tourNum;
	private String tourName;
	private Integer tourPrice;
	private Integer tourSize;	
	private String tourFood;
	private String tourMotel;
	private String tourTraffic;
	private String tourShow;
	private Integer supplierNum;
	private ArrayList<tourspotModel> tourspot;
	
	public tourModel() {
		super();
	}
	public tourModel(String tourName, Integer tourPrice, Integer tourSize, String tourFood, String tourMotel,
			String tourTraffic, String tourShow, Integer supplierNum, ArrayList<tourspotModel> tourspot) {
		super();
		this.tourName = tourName;
		this.tourPrice = tourPrice;
		this.tourSize = tourSize;
		this.tourFood = tourFood;
		this.tourMotel = tourMotel;
		this.tourTraffic = tourTraffic;
		this.tourShow = tourShow;
		this.supplierNum = supplierNum;
		this.tourspot = tourspot;
		
	}
	public tourModel(Integer tourNum, String tourName, Integer tourPrice, Integer tourSize, String tourFood,
			String tourMotel, String tourTraffic, String tourShow, Integer supplierNum,
			ArrayList<tourspotModel> tourspot) {
		super();
		this.tourNum = tourNum;
		this.tourName = tourName;
		this.tourPrice = tourPrice;
		this.tourSize = tourSize;
		this.tourFood = tourFood;
		this.tourMotel = tourMotel;
		this.tourTraffic = tourTraffic;
		this.tourShow = tourShow;
		this.supplierNum = supplierNum;
		this.tourspot = tourspot;
	}
	public Integer getTourNum() {
		return tourNum;
	}
	public void setTourNum(Integer tourNum) {
		this.tourNum = tourNum;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public Integer getTourPrice() {
		return tourPrice;
	}
	public void setTourPrice(Integer tourPrice) {
		this.tourPrice = tourPrice;
	}
	public Integer getTourSize() {
		return tourSize;
	}
	public void setTourSize(Integer tourSize) {
		this.tourSize = tourSize;
	}
	public String getTourFood() {
		return tourFood;
	}
	public void setTourFood(String tourFood) {
		this.tourFood = tourFood;
	}
	public String getTourMotel() {
		return tourMotel;
	}
	public void setTourMotel(String tourMotel) {
		this.tourMotel = tourMotel;
	}
	public String getTourTraffic() {
		return tourTraffic;
	}
	public void setTourTraffic(String tourTraffic) {
		this.tourTraffic = tourTraffic;
	}
	public String getTourShow() {
		return tourShow;
	}
	public void setTourShow(String tourShow) {
		this.tourShow = tourShow;
	}
	public Integer getSupplierNum() {
		return supplierNum;
	}
	public void setSupplierNum(Integer supplierNum) {
		this.supplierNum = supplierNum;
	}
	public ArrayList<tourspotModel> getTourspot() {
		return tourspot;
	}
	public void setTourspot(ArrayList<tourspotModel> tourspot) {
		this.tourspot = tourspot;
	}
	
}
