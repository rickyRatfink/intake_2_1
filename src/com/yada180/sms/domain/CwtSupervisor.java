package com.yada180.sms.domain;

// Generated Sep 16, 2013 10:14:00 AM by Hibernate Tools 3.4.0.CR1

/**
 * CwtSupervisor generated by hbm2java
 */
public class CwtSupervisor implements java.io.Serializable {

	private Long supervisorId;
	private String firstname;
	private String lastname;
	private Long jobId;
	private String creationDate;
	private String createdBy;
	private Long departmentId;

	public CwtSupervisor() {
	}

	public CwtSupervisor(String firstname, String lastname, Long jobId,
			String creationDate, String createdBy, Long departmentId) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.jobId = jobId;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.departmentId = departmentId;
	}

	public Long getSupervisorId() {
		return this.supervisorId;
	}

	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
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

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
