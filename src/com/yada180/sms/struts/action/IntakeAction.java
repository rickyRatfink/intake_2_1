package com.yada180.sms.struts.action;

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
import com.yada180.sms.struts.form.IntakeForm;
import com.yada180.sms.util.HtmlDropDownBuilder;

public class IntakeAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 String action=request.getParameter("action");
		 IntakeForm intakeForm = (IntakeForm)form;
		 IntakeDao intakeDao = new IntakeDao();
		 
		 if ("Search".equals(action)) {
			 intakeForm.setIntake(new Intake());
			 
			 return mapping.findForward(Constants.SEARCH);
		 } else if ("Search Students".equals(action)) {
			 String entryDate=intakeForm.getIntake().getEntryDate();
			 String exitDate=intakeForm.getIntake().getExitDate();
			 String lastname=intakeForm.getIntake().getLastname();
			 String firstname=intakeForm.getIntake().getFirstname();
			 String ssn=intakeForm.getIntake().getSsn();
			 String dob=intakeForm.getIntake().getDob();
			 String farm=intakeForm.getIntake().getFarmBase();
			 List intakeList = intakeDao.search(entryDate, exitDate, lastname,firstname,ssn,dob,farm);
			 intakeForm.setIntakeList(intakeList);
			 
			 return mapping.findForward(Constants.RESULTS);
		 }
		 else if ("Edit".equals(action)) {
			 String key = request.getParameter("key");
			 Intake intake = intakeDao.findById(new Integer(key));
			 intakeForm.setIntake(intake);	
			 
			 return mapping.findForward(Constants.EDIT);
		 } 
		 else if ("Save".equals(action)) {
			 String key = request.getParameter("key");
			 String source = request.getParameter("source");
			 
			 return mapping.findForward(source);
		 }


		 return mapping.findForward(Constants.SUCCESS);
	}
	
}
