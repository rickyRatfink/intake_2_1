package com.yada180.sms.domain;

// Generated Sep 16, 2013 10:14:00 AM by Hibernate Tools 3.4.0.CR1

/**
 * IntakeEmployer generated by hbm2java
 */
public class IntakeEmployer implements java.io.Serializable {

	private Long intakeEmployerId;
	private String companyName;
	private String contactName;
	private String contactPhone;
	private String beginDate;
	private String endDate;
	private long intakeId;

	public IntakeEmployer() {
	}

	public IntakeEmployer(String companyName, String contactName,
			String contactPhone, String beginDate, long intakeId) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.beginDate = beginDate;
		this.intakeId = intakeId;
	}

	public IntakeEmployer(String companyName, String contactName,
			String contactPhone, String beginDate, String endDate, long intakeId) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.intakeId = intakeId;
	}

	public Long getIntakeEmployerId() {
		return this.intakeEmployerId;
	}

	public void setIntakeEmployerId(Long intakeEmployerId) {
		this.intakeEmployerId = intakeEmployerId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getIntakeId() {
		return this.intakeId;
	}

	public void setIntakeId(long intakeId) {
		this.intakeId = intakeId;
	}

}
