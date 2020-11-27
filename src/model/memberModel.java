package model;

import java.util.Date;

public class memberModel {
	private Integer memberNum;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private Date memberBirth;
	private String memberMail;
	private String memberPhone;

	public memberModel() {
		super();
	}

	public memberModel(Integer memberNum, String memberId, String memberPassword, String memberName, Date memberBirth,
			String memberMail, String memberPhone) {
		super();
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberMail = memberMail;
		this.memberPhone = memberPhone;
	}

	public memberModel(String memberId, String memberPassword, String memberName, Date memberBirth, String memberMail,
			String memberPhone) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberMail = memberMail;
		this.memberPhone = memberPhone;
	}

	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
}
