package com.yada180.sms.domain;

// Generated Sep 18, 2013 1:34:38 PM by Hibernate Tools 3.4.0.CR1

/**
 * JobSkill generated by hbm2java
 */
public class JobSkill implements java.io.Serializable {

	private Long jobSkillId;
	private String description;

	public JobSkill() {
	}

	public JobSkill(String description) {
		this.description = description;
	}

	public Long getJobSkillId() {
		return this.jobSkillId;
	}

	public void setJobSkillId(Long jobSkillId) {
		this.jobSkillId = jobSkillId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
