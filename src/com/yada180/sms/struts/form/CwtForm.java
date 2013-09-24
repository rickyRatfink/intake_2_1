package com.yada180.sms.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.yada180.sms.domain.CwtDepartment;
import com.yada180.sms.domain.CwtJob;
import com.yada180.sms.domain.CwtMetrics;
import com.yada180.sms.domain.CwtModules;
import com.yada180.sms.domain.CwtProgram;
import com.yada180.sms.domain.CwtSupervisor;
import com.yada180.sms.domain.ErrorMessage;

public class CwtForm extends ActionForm {
	
	private List<CwtJob> jobList = new ArrayList<CwtJob>();
	private List<CwtSupervisor> supervisorList = new ArrayList<CwtSupervisor>();
	private List<CwtDepartment> departmentList = new ArrayList<CwtDepartment>();
	private List<CwtMetrics> metricList = new ArrayList<CwtMetrics>();
	private List<CwtProgram> programList = new ArrayList<CwtProgram>();
	private List<CwtModules> moduleList = new ArrayList<CwtModules>();
	private List<ErrorMessage> messages = new ArrayList<ErrorMessage>();
	private String messageType;
	private CwtDepartment cwtDepartment = new CwtDepartment();
	private CwtJob cwtJob = new CwtJob();
	private CwtSupervisor cwtSupervisor = new CwtSupervisor();
	private CwtProgram cwtProgram = new CwtProgram();
	private CwtModules cwtModule = new CwtModules();
	private CwtMetrics cwtMetric = new CwtMetrics();
	private String pageSource;
	private String jobMetric[] = new String[200];
	private String metricUbit[] = new String[200];
	private String moduleMetric[] = new String[200];
	
	private String monday="";
	private String tuesday="";
	private String wednesday="";
	private String thursday="";
	private String friday="";
	private String saturday="";
	private String sunday="";
	
	
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
	public String getSaturday() {
		return saturday;
	}
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	public String[] getModuleMetric() {
		return moduleMetric;
	}
	public void setModuleMetric(String[] moduleMetric) {
		this.moduleMetric = moduleMetric;
	}
	public List<CwtModules> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<CwtModules> moduleList) {
		this.moduleList = moduleList;
	}
	public CwtModules getCwtModule() {
		return cwtModule;
	}
	public void setCwtModule(CwtModules cwtModule) {
		this.cwtModule = cwtModule;
	}
	public CwtMetrics getCwtMetric() {
		return cwtMetric;
	}
	public void setCwtMetric(CwtMetrics cwtMetric) {
		this.cwtMetric = cwtMetric;
	}
	public String[] getMetricUbit() {
		return metricUbit;
	}
	public void setMetricUbit(String[] metricUbit) {
		this.metricUbit = metricUbit;
	}
	public List<CwtProgram> getProgramList() {
		return programList;
	}
	public void setProgramList(List<CwtProgram> programList) {
		this.programList = programList;
	}
	public CwtProgram getCwtProgram() {
		return cwtProgram;
	}
	public void setCwtProgram(CwtProgram cwtProgram) {
		this.cwtProgram = cwtProgram;
	}
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
