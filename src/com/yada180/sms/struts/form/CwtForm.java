package com.yada180.sms.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.yada180.sms.domain.CwtDepartment;
import com.yada180.sms.domain.CwtJob;
import com.yada180.sms.domain.CwtMetrics;
import com.yada180.sms.domain.CwtSupervisor;
import com.yada180.sms.domain.ErrorMessage;

public class CwtForm extends ActionForm {
	
	private List<CwtJob> jobList = new ArrayList<CwtJob>();
	private List<CwtSupervisor> supervisorList = new ArrayList<CwtSupervisor>();
	private List<CwtDepartment> departmentList = new ArrayList<CwtDepartment>();
	private List<CwtMetrics> metricList = new ArrayList<CwtMetrics>();
	private List<ErrorMessage> messages = new ArrayList<ErrorMessage>();
	private String messageType;
	private CwtDepartment cwtDepartment = new CwtDepartment();
	private CwtJob cwtJob = new CwtJob();
	private CwtSupervisor cwtSupervisor = new CwtSupervisor();
	
	private String pageSource;
	
	private String jobMetric[] = new String[] { "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "" };
	
	
	public String[] getJobMetric() {
		return jobMetric;
	}
	public void setJobMetric(String[] jobMetric) {
		this.jobMetric = jobMetric;
	}
	public List<CwtMetrics> getMetricList() {
		return metricList;
	}
	public void setMetricList(List<CwtMetrics> metricList) {
		this.metricList = metricList;
	}
	public String getPageSource() {
		return pageSource;
	}
	public void setPageSource(String pageSource) {
		this.pageSource = pageSource;
	}
	public CwtDepartment getCwtDepartment() {
		return cwtDepartment;
	}
	public void setCwtDepartment(CwtDepartment cwtDepartment) {
		this.cwtDepartment = cwtDepartment;
	}
	public CwtJob getCwtJob() {
		return cwtJob;
	}
	public void setCwtJob(CwtJob cwtJob) {
		this.cwtJob = cwtJob;
	}
	public CwtSupervisor getCwtSupervisor() {
		return cwtSupervisor;
	}
	public void setCwtSupervisor(CwtSupervisor cwtSupervisor) {
		this.cwtSupervisor = cwtSupervisor;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public List<CwtJob> getJobList() {
		return jobList;
	}
	public void setJobList(List<CwtJob> jobList) {
		this.jobList = jobList;
	}
	public List<CwtSupervisor> getSupervisorList() {
		return supervisorList;
	}
	public void setSupervisorList(List<CwtSupervisor> supervisorList) {
		this.supervisorList = supervisorList;
	}
	public List<CwtDepartment> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<CwtDepartment> departmentList) {
		this.departmentList = departmentList;
	}
	public List<ErrorMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<ErrorMessage> messages) {
		this.messages = messages;
	}
	
	

}
