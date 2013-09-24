package com.yada180.sms.struts.action;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yada180.sms.application.Constants;
import com.yada180.sms.domain.CwtDepartment;
import com.yada180.sms.domain.CwtJob;
import com.yada180.sms.domain.CwtJobMetric;
import com.yada180.sms.domain.CwtMetrics;
import com.yada180.sms.domain.CwtSupervisor;
import com.yada180.sms.domain.IntakeQuestionAnswer;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.dao.CwtDepartmentDao;
import com.yada180.sms.hibernate.dao.CwtJobDao;
import com.yada180.sms.hibernate.dao.CwtJobMetricDao;
import com.yada180.sms.hibernate.dao.CwtMetricsDao;
import com.yada180.sms.hibernate.dao.CwtModuleOfferingDao;
import com.yada180.sms.hibernate.dao.CwtModuleStudentDao;
import com.yada180.sms.hibernate.dao.CwtModulesDao;
import com.yada180.sms.hibernate.dao.CwtProgramDao;
import com.yada180.sms.hibernate.dao.CwtProgramMetricDao;
import com.yada180.sms.hibernate.dao.CwtProgramMetricModulesDao;
import com.yada180.sms.hibernate.dao.CwtSupervisorDao;
import com.yada180.sms.struts.form.CwtForm;
import com.yada180.sms.util.HtmlDropDownBuilder;
import com.yada180.sms.util.Validator;
import com.yada180.sms.validator.IntakeValidator;

public class CwtAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	private final static IntakeValidator inakeValidator = new IntakeValidator();
	private final static Validator validator = new Validator();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 SystemUser user = (SystemUser) session.getAttribute("system_user");
		 
		 String action=request.getParameter("action");
		 
		 CwtForm cwtForm = (CwtForm)form;
		 CwtJobDao cwtJobDao = new CwtJobDao();
		 CwtSupervisorDao cwtSupervisorDao = new CwtSupervisorDao();
		 CwtDepartmentDao cwtDepartmentDao = new CwtDepartmentDao();
		 CwtProgramDao cwtProgramDao = new CwtProgramDao();
		 CwtMetricsDao cwtMetricsDao = new CwtMetricsDao();
		 CwtModulesDao cwtModulesDao = new CwtModulesDao();
		 CwtProgramMetricDao cwtProgramMetricDao = new CwtProgramMetricDao();
		 CwtProgramMetricModulesDao cwtProgramMetricModuleDao = new CwtProgramMetricModulesDao();
		 CwtModuleOfferingDao cwtModuleOfferingDao = new CwtModuleOfferingDao();
		 CwtModuleStudentDao cwtModuleStudentDao = new CwtModuleStudentDao();
		 CwtJobMetricDao cwtJobMetricDao = new CwtJobMetricDao();
		 
		 if ("programs".equals(action)) {
			 cwtForm.setProgramList(cwtProgramDao.listCwtPrograms());
			 return mapping.findForward(Constants.PROGRAMS);
		 }
		 else if ("metrics".equals(action)) {
			 cwtForm.setMetricList(cwtMetricsDao.listCwtMetricss());
			 cwtForm.setProgramList(cwtProgramDao.listCwtPrograms());
			 return mapping.findForward(Constants.METRICS);
		 }
		 else if ("modules".equals(action)) {
			 cwtForm.setModuleList(cwtModulesDao.listCwtModuless());
			 cwtForm.setMetricList(cwtMetricsDao.listCwtMetricss());
			 return mapping.findForward(Constants.MODULES);
		 }
		 else if ("departments".equals(action)) {
			 cwtForm.setDepartmentList(cwtDepartmentDao.listCwtDepartments());
			 return mapping.findForward(Constants.DEPARTMENTS);
		 }
		 else if ("jobs".equals(action)) {
			 cwtForm.setJobList(cwtJobDao.listCwtJobs());
			 cwtForm.setMetricList(cwtMetricsDao.listCwtMetricss());
			 return mapping.findForward(Constants.JOBS);
		 }
		 else if ("supervisors".equals(action)) {
			 cwtForm.setSupervisorList(cwtSupervisorDao.listCwtSupervisors());
			 return mapping.findForward(Constants.SUPERVISORS);
		 }
		 else if ("rotate".equals(action))
			 return mapping.findForward(Constants.ROTATE);
		 else if ("Edit".equals(action)) {
			 return mapping.findForward("create_"+cwtForm.getPageSource());
		 }
		 else if ("Create".equals(action)) {
			 cwtForm.setCwtDepartment(new CwtDepartment());
			 cwtForm.setCwtJob(new CwtJob());
			 cwtForm.setCwtSupervisor(new CwtSupervisor());
			 return mapping.findForward("create_"+cwtForm.getPageSource());
		 }
		 else if ("Save".equals(action)) {
			 if ("program".equals(cwtForm.getPageSource())) {
				 cwtForm.getCwtProgram().setCreatedBy(user.getUsername());
				 cwtForm.getCwtProgram().setCreationDate(validator.getEpoch()+"");
				 cwtProgramDao.addCwtProgram(cwtForm.getCwtProgram());
				 cwtForm.setProgramList(cwtProgramDao.listCwtPrograms());
				 return mapping.findForward(Constants.PROGRAMS);
			 }
			 if ("metric".equals(cwtForm.getPageSource())) {
				 cwtForm.getCwtMetric().setCreatedBy(user.getUsername());
				 cwtForm.getCwtMetric().setCreationDate(validator.getEpoch()+"");
				 cwtMetricsDao.addCwtMetrics(cwtForm.getCwtMetric());
				 cwtForm.setMetricList(cwtMetricsDao.listCwtMetricss());
				 return mapping.findForward(Constants.PROGRAMS);
			 }
			 if ("department".equals(cwtForm.getPageSource())) {
				 cwtForm.getCwtDepartment().setCreatedBy(user.getUsername());
				 cwtForm.getCwtDepartment().setCreationDate(validator.getEpoch()+"");
				 cwtDepartmentDao.addCwtDepartment(cwtForm.getCwtDepartment());
				 cwtForm.setDepartmentList(cwtDepartmentDao.listCwtDepartments());
				 return mapping.findForward(Constants.DEPARTMENTS);
			 }

			 if ("job".equals(cwtForm.getPageSource())) {
				 cwtForm.getCwtJob().setCreatedBy(user.getUsername());
				 cwtForm.getCwtJob().setCreationDate(validator.getEpoch()+"");
				 Long id = cwtJobDao.addCwtJob(cwtForm.getCwtJob());
				 cwtForm.getCwtJob().setJobId(id);
				 this.saveJobMetrics(cwtForm);
				 cwtForm.setJobList(cwtJobDao.listCwtJobs());
				 return mapping.findForward(Constants.JOBS);
			 }
			 
			 if ("supervisor".equals(cwtForm.getPageSource())) {
				 cwtForm.getCwtSupervisor().setCreatedBy(user.getUsername());
				 cwtForm.getCwtSupervisor().setCreationDate(validator.getEpoch()+"");
				 cwtSupervisorDao.addCwtSupervisor(cwtForm.getCwtSupervisor());
				 cwtForm.setSupervisorList(cwtSupervisorDao.listCwtSupervisors());
				 return mapping.findForward(Constants.SUPERVISORS);
			 }
} 
		 
		 return mapping.findForward(Constants.SUCCESS);
	}
	
	
	private void saveJobMetrics(CwtForm cwtForm) {
		
		CwtJobMetricDao dao = new CwtJobMetricDao();
		
		 /*
		  * First delete all medical conditions for given intake
		  */
		 List<CwtJobMetric> jobMetrics = dao.findByJobId(cwtForm.getCwtJob().getJobId());
		 
		 
		 for (Iterator iterator =
				 jobMetrics.iterator(); iterator.hasNext();){
			 CwtJobMetric obj = (CwtJobMetric) iterator.next();
			 dao.deleteCwtJobMetric(obj.getMetricJobId());
		 }
		 
		 String jobMetric[] = cwtForm.getJobMetric();
		 int index=0;
		 for (Iterator iterator =
				 cwtForm.getMetricList().iterator(); iterator.hasNext();){
			 CwtMetrics obj = (CwtMetrics) iterator.next();
			   
	    	   if ("YES".equals(jobMetric[index])) {
	    		   CwtJobMetric cjm = new CwtJobMetric();
	    		   cjm.setJobId(cwtForm.getCwtJob().getJobId());
	    		   cjm.setMetricId(obj.getMetricId());
	    		   dao.addCwtJobMetric(cjm);
	    		 }
	    index++;
		}
	}

	
	
}
