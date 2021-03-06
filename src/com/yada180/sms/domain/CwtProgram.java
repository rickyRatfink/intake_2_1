package com.yada180.sms.domain;

// Generated Sep 23, 2013 2:58:31 PM by Hibernate Tools 3.4.0.CR1

/**
 * CwtProgram generated by hbm2java
 */
public class CwtProgram implements java.io.Serializable {

	private Long programId;
	private String programName;
	private String description;
	private String status;
	private String creationDate;
	private String createdBy;

	public CwtProgram() {
	}

	public CwtProgram(String programName, String description, String status,
			String creationDate, String createdBy) {
		this.programName = programName;
		this.description = description;
		this.status = status;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
	}

	public Long getProgramId() {
		return this.programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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
