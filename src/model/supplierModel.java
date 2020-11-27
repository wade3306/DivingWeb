package model;

public class supplierModel {
	private Integer supplierNum;
	private String supplierId;
	private String supplierPassword;
	private String supplierName;
	private String supplierMail;
	private String supplierPhone;

	public supplierModel() {
		super();
	}

	public supplierModel(String supplierId, String supplierPassword, String supplierName,
			String supplierMail, String supplierPhone) {
		super();
		this.supplierId = supplierId;
		this.supplierPassword = supplierPassword;
		this.supplierName = supplierName;
		this.supplierMail = supplierMail;
		this.supplierPhone = supplierPhone;
	}

	public supplierModel(Integer supplierNum, String supplierId, String supplierPassword, String supplierName,
			String supplierMail, String supplierPhone) {
		super();
		this.supplierNum = supplierNum;
		this.supplierId = supplierId;
		this.supplierPassword = supplierPassword;
		this.supplierName = supplierName;
		this.supplierMail = supplierMail;
		this.supplierPhone = supplierPhone;
	}

	public Integer getSupplierNum() {
		return supplierNum;
	}

	public void setSupplierNum(Integer supplierNum) {
		this.supplierNum = supplierNum;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierPassword() {
		return supplierPassword;
	}

	public void setSupplierPassword(String supplierPassword) {
		this.supplierPassword = supplierPassword;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierMail() {
		return supplierMail;
	}

	public void setSupplierMail(String supplierMail) {
		this.supplierMail = supplierMail;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	
}