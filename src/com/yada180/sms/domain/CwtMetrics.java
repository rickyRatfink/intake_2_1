package com.yada180.sms.domain;

// Generated Sep 18, 2013 1:34:38 PM by Hibernate Tools 3.4.0.CR1

/**
 * CwtMetrics generated by hbm2java
 */
public class CwtMetrics implements java.io.Serializable {

	private Long metricId;
	private String metricName;
	private String description;
	private String creationDate;
	private String createdBy;
	private String status;

	public CwtMetrics() {
	}

	public CwtMetrics(String metricName, String description,
			String creationDate, String createdBy, String status) {
		this.metricName = metricName;
		this.description = description;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.status = status;
	}

	public Long getMetricId() {
		return this.metricId;
	}

	public void setMetricId(Long metricId) {
		this.metricId = metricId;
	}

	public String getMetricName() {
		return this.metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
