package com.yada180.sms.domain;

// Generated Sep 16, 2013 10:14:00 AM by Hibernate Tools 3.4.0.CR1

/**
 * IntakeJobSkill generated by hbm2java
 */
public class IntakeJobSkill implements java.io.Serializable {

	private Long intakeJobSkillId;
	private long jobSkillId;
	private String intakeId;

	public IntakeJobSkill() {
	}

	public IntakeJobSkill(long jobSkillId) {
		this.jobSkillId = jobSkillId;
	}

	public IntakeJobSkill(long jobSkillId, String intakeId) {
		this.jobSkillId = jobSkillId;
		this.intakeId = intakeId;
	}

	public Long getIntakeJobSkillId() {
		return this.intakeJobSkillId;
	}

	public void setIntakeJobSkillId(Long intakeJobSkillId) {
		this.intakeJobSkillId = intakeJobSkillId;
	}

	public long getJobSkillId() {
		return this.jobSkillId;
	}

	public void setJobSkillId(long jobSkillId) {
		this.jobSkillId = jobSkillId;
	}

	public String getIntakeId() {
		return this.intakeId;
	}

	public void setIntakeId(String intakeId) {
		this.intakeId = intakeId;
	}

}