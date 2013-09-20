package com.yada180.sms.struts.action;

import java.util.ArrayList;
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
import com.yada180.sms.domain.Intake;
import com.yada180.sms.domain.IntakeJobSkill;
import com.yada180.sms.domain.IntakeMedicalCondition;
import com.yada180.sms.domain.IntakeQuestionAnswer;
import com.yada180.sms.domain.MedicalCondition;
import com.yada180.sms.domain.Question;
import com.yada180.sms.hibernate.dao.IntakeDao;
import com.yada180.sms.hibernate.dao.IntakeJobSkillDao;
import com.yada180.sms.hibernate.dao.IntakeMedicalConditionDao;
import com.yada180.sms.hibernate.dao.IntakeQuestionAnswerDao;
import com.yada180.sms.hibernate.dao.MedicalConditionDao;
import com.yada180.sms.hibernate.dao.QuestionDao;
import com.yada180.sms.hibernate.dao.StudentHistoryDao;
import com.yada180.sms.hibernate.dao.StudentPassHistoryDao;
import com.yada180.sms.struts.form.IntakeForm;
import com.yada180.sms.util.HtmlDropDownBuilder;
import com.yada180.sms.validator.IntakeValidator;

public class IntakeAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	private final static IntakeValidator inakeValidator = new IntakeValidator();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 String action=request.getParameter("action");
		 IntakeForm intakeForm = (IntakeForm)form;
		 IntakeDao intakeDao = new IntakeDao();
		 StudentHistoryDao studentHistoryDao = new StudentHistoryDao();
		 StudentPassHistoryDao studentPassHistoryDao = new StudentPassHistoryDao();
		 IntakeMedicalConditionDao intakeMedicalConditionDao = new IntakeMedicalConditionDao();
		 IntakeQuestionAnswerDao intakeQuestionAnswerDao = new IntakeQuestionAnswerDao();
		 IntakeJobSkillDao intakeJobSkillDao = new IntakeJobSkillDao();		
		
		 //clear out messages
		 intakeForm.setMessages(new ArrayList());
		 intakeForm.setMessageType("");
		 
		 if ("personal".equals(action))
			 return mapping.findForward(Constants.PERSONAL);
		 else if ("religious".equals(action))
			 return mapping.findForward(Constants.RELIGIOUS);
		 else if ("substance".equals(action))
			 return mapping.findForward(Constants.SUBSTANCE);
		 else if ("health".equals(action))
			 return mapping.findForward(Constants.HEALTH);
		 else if ("legal".equals(action))
			 return mapping.findForward(Constants.LEGAL);
		 else if ("employment".equals(action))
			 return mapping.findForward(Constants.EMPLOYMENT);
		 else if ("status".equals(action))
			 return mapping.findForward(Constants.STATUS);
		 else if ("Search".equals(action)) {
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
			 Intake intake = intakeDao.findById(new Long(key));
			 List studentHistory = studentHistoryDao.search(intake.getIntakeId());
			 List studentPassHistory = studentPassHistoryDao.search(intake.getIntakeId());
			 List<IntakeMedicalCondition> intakeMedicalCondition = intakeMedicalConditionDao.findById(intake.getIntakeId());
			 List<IntakeQuestionAnswer> intakeQuestionAnswer = intakeQuestionAnswerDao.findById(intake.getIntakeId());
			 List<IntakeJobSkill> intakeJobSkill = intakeJobSkillDao.findById(intake.getIntakeId());
			 
			 setIntakeMedicalConditions(intakeMedicalCondition,intakeForm);
			 setIntakeQuestionAnswer(intakeQuestionAnswer,intakeForm);
			 setIntakeJobSkills(intakeJobSkill,intakeForm);
			 
			 intakeForm.setIntake(intake);	
			 intakeForm.setStudentHistory(studentHistory);
			 intakeForm.setStudentPassHistory(studentPassHistory);
			 
			 return mapping.findForward(Constants.EDIT);
		 } 
		 else if ("Save".equals(action)) {
			 intakeForm.setMessageType("");
			 boolean valid = inakeValidator.validate(intakeForm);	
			 if (valid) {
				 if (intakeForm.getIntake().getIntakeId()!=null) {
					 intakeDao.updateIntake(intakeForm.getIntake());
					 if ("health".equals(intakeForm.getPageSource()))
						 saveMedicalConditions(intakeForm);
				 }
				 else {
					 intakeDao.addIntake(intakeForm.getIntake());
					 if ("health".equals(intakeForm.getPageSource()))
						 saveMedicalConditions(intakeForm);
				 }
				 
			 }
			 return mapping.findForward(intakeForm.getPageSource());
		 } 
		
		 

		 return mapping.findForward(Constants.SUCCESS);
	}
	private void setIntakeMedicalConditions(List<IntakeMedicalCondition> intakeMedicalCondition, IntakeForm intakeForm) {
		 
		String medicalCondition[] = new String[] { "NO", "NO", "NO", "NO",
					"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
					"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
					"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO" };
		  
		for (java.util.Iterator<IntakeMedicalCondition> iterator =
				  intakeMedicalCondition.iterator(); iterator.hasNext();) {
			  IntakeMedicalCondition obj = (IntakeMedicalCondition) iterator.next();
			  medicalCondition[obj.getMedicalConditionId().intValue()-1]="YES";
		  }
		
		intakeForm.setMedicalCondition(medicalCondition);
	}
	
	
	private void setIntakeQuestionAnswer(List<IntakeQuestionAnswer> intakeQuestionAnswer, IntakeForm intakeForm) {
		 
		 String healthAnswer[] = new String[] { "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO" };
		
		 String emotionalAnswer[] = new String[] { "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO" };

		 String physicalAnswer[] = new String[] { "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO" };
		
		 String mentalAnswer[] = new String[] { "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
				"NO", "NO", "NO", "NO", "NO", "NO", "NO" };
		
		 String emotionalAnswerDate[] = new String[] { "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		 String emotionalAnswerDetails[] = new String[] { "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		 String mentalAnswerDate[] = new String[] { "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		 String mentalAnswerDetails[] = new String[] { "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		 String physicalAnswerDetails[] = new String[] { "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		 String questionAnswerDates[] = new String[] { "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };

		for (java.util.Iterator<IntakeQuestionAnswer> iterator =
				intakeQuestionAnswer.iterator(); iterator.hasNext();) {
			IntakeQuestionAnswer obj = (IntakeQuestionAnswer) iterator.next();
			int id=(int)obj.getQuestionId()-1;
			
			if (id<15)
				healthAnswer[id]="YES";
			else if (id>14&&id<21) {
				emotionalAnswer[id-15]="YES";
				emotionalAnswerDate[id-15]=obj.getDates();
				emotionalAnswerDetails[id-15]=obj.getDetail();
			}
			else if (id>20&&id<26) {
				physicalAnswer[id-21]="YES";
				physicalAnswerDetails[id-21]=obj.getDetail();
			}
			else if (id>25&&id<32) {
				mentalAnswer[id-26]="YES";
				mentalAnswerDate[id-26]=obj.getDates();
				mentalAnswerDetails[id-26]=obj.getDetail();
			}
			
		  }
		
		intakeForm.setHealthAnswer(healthAnswer);
		intakeForm.setMentalAnswer(mentalAnswerDetails);
		intakeForm.setMentalAnswerDate(mentalAnswerDate);
		intakeForm.setMentalAnswerDetails(mentalAnswerDetails);
		intakeForm.setPhysicalAnswer(physicalAnswerDetails);
		intakeForm.setPhysicalAnswerDetails(physicalAnswerDetails);
		intakeForm.setEmotionalAnswer(emotionalAnswerDetails);
		intakeForm.setEmotionalAnswerDate(emotionalAnswerDate);
		intakeForm.setEmotionalAnswerDetails(emotionalAnswerDetails);
	}
	
	private void setIntakeJobSkills(List<IntakeJobSkill> intakeJobSkill, IntakeForm intakeForm) {
		 
		String workExperience[] = new String[] { "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "" };
		
		for (java.util.Iterator<IntakeJobSkill> iterator =
				  intakeJobSkill.iterator(); iterator.hasNext();) {
			IntakeJobSkill obj = (IntakeJobSkill) iterator.next();
			  workExperience[(int)obj.getJobSkillId()-1]="YES";
		  }
		
		intakeForm.setWorkExperience(workExperience);
	}
	
	private void saveMedicalConditions(IntakeForm intakeForm) {
		 
		 IntakeMedicalConditionDao dao = new IntakeMedicalConditionDao();
		 
		 /*
		  * First delete all medical conditions for given intake
		  */
		 List<IntakeMedicalCondition> intakeMedicalConditions = dao.findById(intakeForm.getIntake().getIntakeId());
		 for (Iterator iterator =
				 intakeMedicalConditions.iterator(); iterator.hasNext();){
			 IntakeMedicalCondition obj = (IntakeMedicalCondition) iterator.next();
			 dao.deleteIntakeMedicalCondition(obj.getIntakeMedicalConditionId());
		 }
		 
		 /*
		  * write to db medical conditions for given intake marked yes
		  */
		 List<MedicalCondition> medicalConditions = intakeForm.getMedicalConditions();
		 String medicalCondition[] = intakeForm.getMedicalCondition();
	     int index=0;  
		 for (Iterator iterator =
	    		   medicalConditions.iterator(); iterator.hasNext();){
	    	   MedicalCondition obj = (MedicalCondition) iterator.next();	    			
	    	   
	    	   if ("YES".equals(medicalCondition[index])) {
	    		   IntakeMedicalCondition imc = new IntakeMedicalCondition();
	    		   imc.setIntakeId(intakeForm.getIntake().getIntakeId());
	    		   imc.setMedicalConditionId(obj.getMedicalConditionId());
	    		   imc.setAnswer("YES");
	    		   dao.addIntakeMedicalCondition(imc);
	    		 }
	    	   
	    	   
	    	 index++;
	       }
	       
                
	}
	
}
