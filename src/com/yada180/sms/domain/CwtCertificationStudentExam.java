package com.yada180.sms.domain;

// Generated Sep 18, 2013 1:34:38 PM by Hibernate Tools 3.4.0.CR1

/**
 * CwtCertificationStudentExam generated by hbm2java
 */
public class CwtCertificationStudentExam implements java.io.Serializable {

	private Long certificationExamId;
	private long programId;
	private String examDate;
	private String grade;
	private long intakeId;
	private String creationDate;
	private String createdBy;

	public CwtCertificationStudentExam() {
	}

	public CwtCertificationStudentExam(long programId, long intakeId) {
		this.programId = programId;
		this.intakeId = intakeId;
	}

	public CwtCertificationStudentExam(long programId, String examDate,
			String grade, long intakeId, String creationDate, String createdBy) {
		this.programId = programId;
		this.examDate = examDate;
		this.grade = grade;
		this.intakeId = intakeId;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
	}

	public Long getCertificationExamId() {
		return this.certificationExamId;
	}

	public void setCertificationExamId(Long certificationExamId) {
		this.certificationExamId = certificationExamId;
	}

	public long getProgramId() {
		return this.programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public String getExamDate() {
		return this.examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getIntakeId() {
		return this.intakeId;
	}

	public void setIntakeId(long intakeId) {
		this.intakeId = intakeId;
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
