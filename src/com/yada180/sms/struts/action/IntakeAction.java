package com.yada180.sms.struts.action;

import java.io.InputStream;
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
import org.apache.struts.upload.FormFile;

import com.yada180.sms.application.Constants;
import com.yada180.sms.domain.Intake;
import com.yada180.sms.domain.IntakeJobSkill;
import com.yada180.sms.domain.IntakeMedicalCondition;
import com.yada180.sms.domain.IntakeQuestionAnswer;
import com.yada180.sms.domain.JobSkill;
import com.yada180.sms.domain.MedicalCondition;
import com.yada180.sms.domain.SearchParameter;
import com.yada180.sms.domain.StudentHistory;
import com.yada180.sms.domain.StudentPassHistory;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.dao.IntakeDao;
import com.yada180.sms.hibernate.dao.IntakeJobSkillDao;
import com.yada180.sms.hibernate.dao.IntakeMedicalConditionDao;
import com.yada180.sms.hibernate.dao.IntakeQuestionAnswerDao;
import com.yada180.sms.hibernate.dao.StudentHistoryDao;
import com.yada180.sms.hibernate.dao.StudentPassHistoryDao;
import com.yada180.sms.struts.form.IntakeForm;
import com.yada180.sms.util.HtmlDropDownBuilder;
import com.yada180.sms.util.Validator;
import com.yada180.sms.validator.IntakeValidator;

public class IntakeAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	private final static IntakeValidator inakeValidator = new IntakeValidator();
	private final static Validator validator = new Validator();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 SystemUser user = (SystemUser) session.getAttribute("system_user");
		 
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
		 else if ("Photo".equals(action)) 
			 return mapping.findForward(Constants.PHOTO);
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
			 List intakeList = intakeDao.search(entryDate, exitDate, lastname,firstname,ssn,dob,null,farm);
			 intakeForm.setIntakeList(intakeList);
			 
			 return mapping.findForward(Constants.RESULTS);
		 }
		 else if ("SearchApps".equals(action)) {
			 intakeForm.setSearchParameter(new SearchParameter());
			 return mapping.findForward(Constants.SEARCH_APPLICATIONS);
		 }
		 else if ("Search Applications".equals(action)) {
			 List intakeList = intakeDao.search(intakeForm.getSearchParameter().getBeginDate(), 
					 intakeForm.getSearchParameter().getEndDate(), 
					 intakeForm.getSearchParameter().getLastname(),
					 intakeForm.getSearchParameter().getFirstname(),
					 intakeForm.getSearchParameter().getSsn(),
					 intakeForm.getSearchParameter().getDob(),
					 intakeForm.getSearchParameter().getApplicationStatus(),
					 intakeForm.getSearchParameter().getFarmBase());
			 intakeForm.setApplicantList(intakeList);
			 return mapping.findForward(Constants.APPLICATIONS);
		 }
		 else if ("Admit".equals(action)) {
			 String entryDate = validator.convertEpoch(validator.getEpoch());
			 
			 intakeForm.getIntake().setApplicationStatus("In Program");
			 intakeForm.getIntake().setClass_("Orientation");
			 intakeForm.getIntake().setLastUpdatedDate(validator.getEpoch()+"");
			 intakeForm.getIntake().setLastUpdatedBy(user.getUsername());
			 intakeForm.getIntake().setFarmBase(user.getFarmBase());
			 intakeForm.getIntake().setEntryDate(entryDate);
			 intakeDao.updateIntake(intakeForm.getIntake());
			 
			 //create history record
			 StudentHistory history = new StudentHistory();
			 history.setBeginDate(entryDate);
			 history.setFarm(user.getFarmBase());
			 history.setPhase("Phase I");
			 history.setProgramStatus("In Program");
			 history.setCreatedBy(user.getUsername());
			 history.setCreationDate(validator.getEpoch()+"");
			 history.setIntakeId(intakeForm.getIntake().getIntakeId());
			 
			 studentHistoryDao.addStudentHistory(history);
			 return mapping.findForward(Constants.PERSONAL);
		 }
		 else if ("Accept".equals(action)) {
			 intakeForm.getIntake().setApplicationStatus("Accepted");
			 intakeForm.getIntake().setLastUpdatedDate(validator.getEpoch()+"");
			 intakeForm.getIntake().setLastUpdatedBy(user.getUsername());
			 intakeDao.updateIntake(intakeForm.getIntake());
			 return mapping.findForward(Constants.PERSONAL);
		 }
		 else if ("Deny".equals(action)) {
			 intakeForm.getIntake().setApplicationStatus("Denied");
			 intakeForm.getIntake().setLastUpdatedDate(validator.getEpoch()+"");
			 intakeForm.getIntake().setLastUpdatedBy(user.getUsername());
			 intakeDao.updateIntake(intakeForm.getIntake());
			 return mapping.findForward(Constants.PERSONAL);
		 }
		 else if ("Reinstate".equals(action)) {
			 intakeForm.getIntake().setApplicationStatus("Pending");
			 intakeForm.getIntake().setLastUpdatedDate(validator.getEpoch()+"");
			 intakeForm.getIntake().setLastUpdatedBy(user.getUsername());
			 intakeDao.updateIntake(intakeForm.getIntake());
			 return mapping.findForward(Constants.PERSONAL);
		 }
 		 else if ("Create".equals(action)) {
			 this.clearForm(intakeForm);
			 return mapping.findForward(Constants.PERSONAL);
		 }
		 else if ("Home".equals(action))
			 return mapping.findForward(Constants.HOME);
		 else if ("Upload".equals(action)) {
			 FormFile file = intakeForm.getImageFile();
			 try {
				 InputStream stream = file.getInputStream();
				 final byte[] bytes = new byte[224024];
				 int read = stream.read(bytes);				 
				 intakeForm.getIntake().setImageHeadshot(bytes);
			 } catch (Exception e) { LOGGER.log(Level.SEVERE, e.getMessage()); }
			
			 return mapping.findForward(Constants.PERSONAL);
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
			 
			 /*
			  * Find the most recent status and set it for the current
			  */
			 StudentHistory currentStatus = new StudentHistory();
				for (java.util.Iterator<StudentHistory> iterator =
						studentHistory.iterator(); iterator.hasNext();) {
					    currentStatus = (StudentHistory) iterator.next();
				}
				intakeForm.setCurrentStatus(currentStatus);
			 
			 return mapping.findForward(Constants.EDIT);
		 } 
		 else if ("Save".equals(action)) {
			 intakeForm.setMessageType("");
			 boolean valid = inakeValidator.validate(intakeForm);	
			 if (valid) {
				 if (intakeForm.getIntake().getIntakeId()!=null) {
					 intakeForm.getIntake().setLastUpdatedDate(validator.getEpoch()+"");
					 intakeForm.getIntake().setLastUpdatedBy(user.getUsername());
					 intakeDao.updateIntake(intakeForm.getIntake());
					 if ("health".equals(intakeForm.getPageSource()))
						 saveMedicalConditions(intakeForm);
					 if ("substance".equals(intakeForm.getPageSource()))
					 	 saveUsagePatternAndLosses(intakeForm);
					 if ("employment".equals(intakeForm.getPageSource()))
					 	 saveJobSkills(intakeForm);
					 if ("status".equals(intakeForm.getPageSource()))
					 	 saveStatus(intakeForm,user);
					     
				 }
				 else {
					 intakeForm.getIntake().setCreationDate(validator.getEpoch()+"");
					 intakeForm.getIntake().setCreatedBy(user.getUsername());
					 intakeDao.addIntake(intakeForm.getIntake());
					 if ("health".equals(intakeForm.getPageSource()))
						 saveMedicalConditions(intakeForm);
					 if ("substance".equals(intakeForm.getPageSource()))
					 	 saveUsagePatternAndLosses(intakeForm);
					 if ("employment".equals(intakeForm.getPageSource()))
					 	 saveJobSkills(intakeForm);
					 if ("status".equals(intakeForm.getPageSource()))
					 	 saveStatus(intakeForm,user);

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
		intakeForm.setMentalAnswer(mentalAnswer);
		intakeForm.setMentalAnswerDate(mentalAnswerDate);
		intakeForm.setMentalAnswerDetails(mentalAnswerDetails);
		intakeForm.setPhysicalAnswer(physicalAnswer);
		intakeForm.setPhysicalAnswerDetails(physicalAnswerDetails);
		intakeForm.setEmotionalAnswer(emotionalAnswer);
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
	
	private void saveIntakeQuestionAnswer(IntakeForm intakeForm) {
		
		IntakeQuestionAnswerDao dao = new IntakeQuestionAnswerDao();
		
		 /*
		  * First delete all medical conditions for given intake
		  */
		 List<IntakeQuestionAnswer> intakeQuestionAnswers = dao.findById(intakeForm.getIntake().getIntakeId());
		 for (Iterator iterator =
				 intakeQuestionAnswers.iterator(); iterator.hasNext();){
			 IntakeQuestionAnswer obj = (IntakeQuestionAnswer) iterator.next();
			 dao.deleteIntakeQuestionAnswer(obj.getIntakeQuestionAnswerId());
		 }
		 
		 String healthAnswer[] = intakeForm.getHealthAnswer();
		 String emotionalAnswer[] = intakeForm.getEmotionalAnswer();
		 String emotionalAnswerDate[] = intakeForm.getEmotionalAnswerDate();
		 String emotionalAnswerDetails[] = intakeForm.getEmotionalAnswerDetails();
		 String physicalAnswer[] = intakeForm.getPhysicalAnswer();
		 String physicalAnswerDetails[] = intakeForm.getPhysicalAnswerDetails();
		 String mentalAnswer[] = intakeForm.getMentalAnswer();
		 String mentalAnswerDate[] = intakeForm.getMentalAnswerDate();
		 String mentalAnswerDetails[] = intakeForm.getMentalAnswerDetails();
		 
		for (int index=0;index<15;index++) {
	    	   
	    	   if ("YES".equals(healthAnswer[index])) {
	    		   IntakeQuestionAnswer iqa = new IntakeQuestionAnswer();
	    		   iqa.setIntakeId(intakeForm.getIntake().getIntakeId());
	    		   iqa.setAnswer("YES");	 
	    		   iqa.setQuestionId(new Long(index+1));
	    		   dao.addIntakeQuestionAnswer(iqa);
	    		 }
	    	   
	    	   if ("YES".equals(emotionalAnswer[index])) {
	    		   IntakeQuestionAnswer iqa = new IntakeQuestionAnswer();
	    		   iqa.setIntakeId(intakeForm.getIntake().getIntakeId());
	    		   iqa.setAnswer("YES");	
	    		   iqa.setDates(emotionalAnswerDate[index]);
	    		   iqa.setDetail(emotionalAnswerDetails[index]);
	    		   iqa.setQuestionId(new Long(index+1));
	    		   dao.addIntakeQuestionAnswer(iqa);
	    		 }
	    	   
	    	   if ("YES".equals(physicalAnswer[index])) {
	    		   IntakeQuestionAnswer iqa = new IntakeQuestionAnswer();
	    		   iqa.setIntakeId(intakeForm.getIntake().getIntakeId());
	    		   iqa.setAnswer("YES");	
	    		   iqa.setDetail(physicalAnswerDetails[index]);
	    		   iqa.setQuestionId(new Long(index+1));
	    		   dao.addIntakeQuestionAnswer(iqa);
	    		 }
	    	   
	    	   if ("YES".equals(mentalAnswer[index])) {
	    		   IntakeQuestionAnswer iqa = new IntakeQuestionAnswer();
	    		   iqa.setIntakeId(intakeForm.getIntake().getIntakeId());
	    		   iqa.setAnswer("YES");	
	    		   iqa.setDates(mentalAnswerDate[index]);
	    		   iqa.setDetail(mentalAnswerDetails[index]);
	    		   iqa.setQuestionId(new Long(index+1));
	    		   dao.addIntakeQuestionAnswer(iqa);
	    		 }
	    }

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
	
	private void saveJobSkills(IntakeForm intakeForm) {
		 
		 IntakeJobSkillDao dao = new IntakeJobSkillDao();
		 
		 /*
		  * First delete all medical conditions for given intake
		  */
		 List<IntakeJobSkill> intakeJobSkills = dao.findById(intakeForm.getIntake().getIntakeId());
		 for (Iterator iterator =
				 intakeJobSkills.iterator(); iterator.hasNext();){
			 IntakeJobSkill obj = (IntakeJobSkill) iterator.next();
			 dao.deleteIntakeJobSkill(obj.getIntakeJobSkillId());
		 }
		 
		 /*
		  * write to db medical conditions for given intake marked yes
		  */
		 List<JobSkill> medicalConditions = intakeForm.getJobSkills();
		 String workExperience[] = intakeForm.getWorkExperience();
	     int index=0;  
		 for (Iterator iterator =
	    		   medicalConditions.iterator(); iterator.hasNext();){
	    	   JobSkill obj = (JobSkill) iterator.next();	    			
	    	   
	    	   if ("YES".equals(workExperience[index])) {
	    		   IntakeJobSkill ijs = new IntakeJobSkill();
	    		   ijs.setIntakeId(intakeForm.getIntake().getIntakeId());	    		   
	    		   ijs.setJobSkillId(obj.getJobSkillId());
	    		   dao.addIntakeJobSkill(ijs);
	    		 }	    	   
	    	   
	    	 index++;
	       }
	       
               
	}
	
	private void saveUsagePatternAndLosses(IntakeForm intakeForm) {
		intakeForm.getIntake().setUsageLosses(intakeForm.getUsageLosses1()+
				intakeForm.getUsageLosses2()+
				intakeForm.getUsageLosses3()+
				intakeForm.getUsageLosses4()+
				intakeForm.getUsageLosses5()+
				intakeForm.getUsageLosses6()+
				intakeForm.getUsageLosses7()+
				intakeForm.getUsageLosses8()+
				intakeForm.getUsageLosses9()				
				);
		
		intakeForm.getIntake().setUsagePattern(intakeForm.getUsagePattern1()+ 
				intakeForm.getUsagePattern2()+ 
				intakeForm.getUsagePattern3()+ 
				intakeForm.getUsagePattern4()+ 
				intakeForm.getUsagePattern5()+ 
				intakeForm.getUsagePattern6() 
				);
		
	}
	
	private void saveStatus(IntakeForm intakeForm, SystemUser user) {
		
		StudentHistoryDao dao = new StudentHistoryDao();
		StudentPassHistoryDao dao1 = new StudentPassHistoryDao();
		StudentPassHistory passHistory = intakeForm.getPassHistory();
		StudentHistory studentHistory = intakeForm.getHistory();
		
		if (studentHistory.getFarm().length()>0 && 
				studentHistory.getPhase().length()>0 &&
				studentHistory.getProgramStatus().length()>0 &&
				studentHistory.getBeginDate().length()>0||studentHistory.getEndDate().length()>0) {
			studentHistory.setIntakeId(intakeForm.getIntake().getIntakeId());
			passHistory.setCreationDate(validator.getEpoch()+"");
			passHistory.setCreatedBy(user.getUsername());
			dao.addStudentHistory(studentHistory);
		}
		
		if (passHistory.getPassDate().length()>0 && 
				passHistory.getHours().length()>0 &&
				passHistory.getPassType().length()>0) {
			passHistory.setIntakeId(intakeForm.getIntake().getIntakeId());
			passHistory.setCreationDate(validator.getEpoch()+"");
			passHistory.setCreatedBy(user.getUsername());
			dao1.addStudentPassHistory(passHistory);
		}
		
		intakeForm.setPassHistory(new StudentPassHistory());
		intakeForm.setHistory(new StudentHistory());
		intakeForm.setStudentHistory(dao.findByIntakeId(intakeForm.getIntake().getIntakeId()));
		intakeForm.setStudentPassHistory(dao1.findByIntakeId(intakeForm.getIntake().getIntakeId()));		
		
		
	}
	
	private void clearForm(IntakeForm intakeForm) {
		 intakeForm.setCurrentStatus(new StudentHistory());
		 intakeForm.setEmotionalAnswer(new String[15]);
		 intakeForm.setEmotionalAnswerDate(new String[15]);
		 intakeForm.setEmotionalAnswerDetails(new String[15]);
		 intakeForm.setMentalAnswer(new String[15]);
		 intakeForm.setMentalAnswerDate(new String[15]);
		 intakeForm.setMentalAnswerDetails(new String[15]);
		 intakeForm.setPhysicalAnswer(new String[15]);
		 intakeForm.setPhysicalAnswerDetails(new String[15]);
		 intakeForm.setHealthAnswer(new String[15]);
		 intakeForm.setHistory(new StudentHistory());
		 intakeForm.setStudentHistory(new ArrayList<StudentHistory>());
		 intakeForm.setStudentPassHistory(null);//new ArrayList<StudentPassHistory>());
		 intakeForm.setPassHistory(new StudentPassHistory());
		 intakeForm.setWorkExperience(new String[30]);
		 intakeForm.setIntake(new Intake());
		 intakeForm.setUsageLosses1("");
		 intakeForm.setUsageLosses2("");
		 intakeForm.setUsageLosses3("");
		 intakeForm.setUsageLosses4("");
		 intakeForm.setUsageLosses5("");
		 intakeForm.setUsageLosses6("");
		 intakeForm.setUsageLosses7("");
		 intakeForm.setUsageLosses8("");
		 intakeForm.setUsageLosses9("");
		 intakeForm.setUsagePattern1("");
		 intakeForm.setUsagePattern2("");
		 intakeForm.setUsagePattern3("");
		 intakeForm.setUsagePattern4("");
		 intakeForm.setUsagePattern5("");
		 intakeForm.setUsagePattern6("");
	}
	

	
	
}
