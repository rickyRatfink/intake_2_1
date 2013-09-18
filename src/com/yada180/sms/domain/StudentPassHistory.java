package com.yada180.sms.domain;

// Generated Sep 18, 2013 1:34:38 PM by Hibernate Tools 3.4.0.CR1

/**
 * StudentPassHistory generated by hbm2java
 */
public class StudentPassHistory implements java.io.Serializable {

	private Long studentPassHistoryId;
	private Long intakeId;
	private String hours;
	private String passDate;
	private String passType;
	private String creationDate;
	private String createdBy;

	public StudentPassHistory() {
	}

	public StudentPassHistory(Long intakeId, String hours, String passDate,
			String passType, String creationDate, String createdBy) {
		this.intakeId = intakeId;
		this.hours = hours;
		this.passDate = passDate;
		this.passType = passType;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
	}

	public Long getStudentPassHistoryId() {
		return this.studentPassHistoryId;
	}

	public void setStudentPassHistoryId(Long studentPassHistoryId) {
		this.studentPassHistoryId = studentPassHistoryId;
	}

	public Long getIntakeId() {
		return this.intakeId;
	}

	public void setIntakeId(Long intakeId) {
		this.intakeId = intakeId;
	}

	public String getHours() {
		return this.hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getPassDate() {
		return this.passDate;
	}

	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}

	public String getPassType() {
		return this.passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
