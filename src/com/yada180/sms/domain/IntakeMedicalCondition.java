package com.yada180.sms.domain;

// Generated Sep 16, 2013 10:14:00 AM by Hibernate Tools 3.4.0.CR1

/**
 * IntakeMedicalCondition generated by hbm2java
 */
public class IntakeMedicalCondition implements java.io.Serializable {

	private Long intakeMedicalConditionId;
	private long intakeId;
	private String answer;
	private Long medicalConditionId;

	public IntakeMedicalCondition() {
	}

	public IntakeMedicalCondition(long intakeId, String answer) {
		this.intakeId = intakeId;
		this.answer = answer;
	}

	public IntakeMedicalCondition(long intakeId, String answer,
			Long medicalConditionId) {
		this.intakeId = intakeId;
		this.answer = answer;
		this.medicalConditionId = medicalConditionId;
	}

	public Long getIntakeMedicalConditionId() {
		return this.intakeMedicalConditionId;
	}

	public void setIntakeMedicalConditionId(Long intakeMedicalConditionId) {
		this.intakeMedicalConditionId = intakeMedicalConditionId;
	}

	public long getIntakeId() {
		return this.intakeId;
	}

	public void setIntakeId(long intakeId) {
		this.intakeId = intakeId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getMedicalConditionId() {
		return this.medicalConditionId;
	}

	public void setMedicalConditionId(Long medicalConditionId) {
		this.medicalConditionId = medicalConditionId;
	}

}