package com.yada180.sms.domain;

// Generated Sep 16, 2013 10:14:00 AM by Hibernate Tools 3.4.0.CR1

/**
 * MedicalCondition generated by hbm2java
 */
public class MedicalCondition implements java.io.Serializable {

	private Long medicalConditionId;
	private String description;

	public MedicalCondition() {
	}

	public MedicalCondition(String description) {
		this.description = description;
	}

	public Long getMedicalConditionId() {
		return this.medicalConditionId;
	}

	public void setMedicalConditionId(Long medicalConditionId) {
		this.medicalConditionId = medicalConditionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}