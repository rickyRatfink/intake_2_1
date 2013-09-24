package com.yada180.sms.struts.action;

import java.util.ArrayList;
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
import com.yada180.sms.domain.Intake;
import com.yada180.sms.hibernate.dao.IntakeDao;
import com.yada180.sms.struts.form.ReportForm;
import com.yada180.sms.util.HtmlDropDownBuilder;
import com.yada180.sms.util.Validator;

public class ReportAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	private final static Validator v8r = new Validator();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 
		 IntakeDao intakeDao = new IntakeDao ();
		 List<Intake> intakeList = new ArrayList<Intake>();
		 
		 ReportForm reportForm = (ReportForm)form;
		 
		 String report=request.getParameter("rpt");
		 String farm=request.getParameter("farm");
		 
		 if ("ClassList".equals(report)) {
			 reportForm.setReportTitle("Class List");
			 reportForm.setFarmBase(farm);
			 java.util.Date sDate = new java.util.Date();
			 reportForm.setRunDate(v8r.convertDate(sDate.toString()));
			 reportForm.setClass0List(intakeDao.listClass("Orientation", farm));
			 reportForm.setClass1List(intakeDao.listClass("1", farm));
			 reportForm.setClass2List(intakeDao.listClass("2", farm));
			 reportForm.setClass3List(intakeDao.listClass("3", farm));
			 reportForm.setClass4List(intakeDao.listClass("4", farm));
			 reportForm.setClass5List(intakeDao.listClass("5", farm));
			 reportForm.setClass6List(intakeDao.listClass("6", farm));
			 reportForm.setClass7List(intakeDao.listClass("Fresh Start", farm));
			 reportForm.setClass8List(intakeDao.listClass("SLS", farm));
			 reportForm.setClass9List(intakeDao.listClass("Intern", farm));
			 reportForm.setClass10List(intakeDao.listClass("Student Teacher", farm));			 
			 return mapping.findForward(Constants.CLASS_REPORT); 
		 }
		 else
			 return mapping.findForward(Constants.SUCCESS);
	}
	
}
