package com.yada180.sms.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.yada180.sms.domain.Intake;

public class IntakeForm extends ActionForm {

	private Intake intake = new Intake();
	private List<Intake> intakeList = new ArrayList<Intake>();

	private String usagePattern1 = "";
	private String usagePattern2 = "";
	private String usagePattern3 = "";
	private String usagePattern4 = "";
	private String usagePattern5 = "";
	private String usagePattern6 = "";
	private String usageLosses1 = "";
	private String usageLosses2 = "";
	private String usageLosses3 = "";
	private String usageLosses4 = "";
	private String usageLosses5 = "";
	private String usageLosses6 = "";
	private String usageLosses7 = "";
	private String usageLosses8 = "";
	private String usageLosses9 = "";
	
	
	private String veteranFlag = "";

	private String question[] = new String[] { "NO", "NO", "NO", "NO", "NO",
			"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
			"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
			"NO", "NO", "NO", "NO", "NO", "NO", "NO" };

	private String questionAnswerDetails[] = new String[] { "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "" };

	private String questionAnswerDates[] = new String[] { "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "" };

	private String medicalCondition[] = new String[] { "NO", "NO", "NO", "NO",
			"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
			"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO",
			"NO", "NO", "NO", "NO", "NO", "NO", "NO", "NO" };

	private String workExperience[] = new String[] { "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "" };

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		return errors;
	}
	
	private String getQuestionIndexed(int index) {
		return question[index];
	}
	
	private void setQuestionIndexed(int index, String value) {
		question[index]=value;
	}

	public String getVeteranFlag() {
		return veteranFlag;
	}

	public void setVeteranFlag(String veteranFlag) {
		this.veteranFlag = veteranFlag;
	}

	public Intake getIntake() {
		return intake;
	}

	public void setIntake(Intake intake) {
		this.intake = intake;
	}

	public List<Intake> getIntakeList() {
		return intakeList;
	}

	public void setIntakeList(List<Intake> intakeList) {
		this.intakeList = intakeList;
	}

	public String getUsagePattern1() {
		return usagePattern1;
	}

	public void setUsagePattern1(String usagePattern1) {
		this.usagePattern1 = usagePattern1;
	}

	public String getUsagePattern2() {
		return usagePattern2;
	}

	public void setUsagePattern2(String usagePattern2) {
		this.usagePattern2 = usagePattern2;
	}

	public String getUsagePattern3() {
		return usagePattern3;
	}

	public void setUsagePattern3(String usagePattern3) {
		this.usagePattern3 = usagePattern3;
	}

	public String getUsagePattern4() {
		return usagePattern4;
	}

	public void setUsagePattern4(String usagePattern4) {
		this.usagePattern4 = usagePattern4;
	}

	public String getUsagePattern5() {
		return usagePattern5;
	}

	public void setUsagePattern5(String usagePattern5) {
		this.usagePattern5 = usagePattern5;
	}

	public String getUsagePattern6() {
		return usagePattern6;
	}

	public void setUsagePattern6(String usagePattern6) {
		this.usagePattern6 = usagePattern6;
	}

	public String getUsageLosses1() {
		return usageLosses1;
	}

	public void setUsageLosses1(String usageLosses1) {
		this.usageLosses1 = usageLosses1;
	}

	public String getUsageLosses2() {
		return usageLosses2;
	}

	public void setUsageLosses2(String usageLosses2) {
		this.usageLosses2 = usageLosses2;
	}

	public String getUsageLosses3() {
		return usageLosses3;
	}

	public void setUsageLosses3(String usageLosses3) {
		this.usageLosses3 = usageLosses3;
	}

	public String getUsageLosses4() {
		return usageLosses4;
	}

	public void setUsageLosses4(String usageLosses4) {
		this.usageLosses4 = usageLosses4;
	}

	public String getUsageLosses5() {
		return usageLosses5;
	}

	public void setUsageLosses5(String usageLosses5) {
		this.usageLosses5 = usageLosses5;
	}

	public String getUsageLosses6() {
		return usageLosses6;
	}

	public void setUsageLosses6(String usageLosses6) {
		this.usageLosses6 = usageLosses6;
	}

	public String getUsageLosses7() {
		return usageLosses7;
	}

	public void setUsageLosses7(String usageLosses7) {
		this.usageLosses7 = usageLosses7;
	}

	public String getUsageLosses8() {
		return usageLosses8;
	}

	public void setUsageLosses8(String usageLosses8) {
		this.usageLosses8 = usageLosses8;
	}

	public String getUsageLosses9() {
		return usageLosses9;
	}

	public void setUsageLosses9(String usageLosses9) {
		this.usageLosses9 = usageLosses9;
	}

	public String[] getQuestion() {
		return question;
	}

	public void setQuestion(String[] question) {
		this.question = question;
	}

	public String[] getQuestionAnswerDetails() {
		return questionAnswerDetails;
	}

	public void setQuestionAnswerDetails(String[] questionAnswerDetails) {
		this.questionAnswerDetails = questionAnswerDetails;
	}

	public String[] getQuestionAnswerDates() {
		return questionAnswerDates;
	}

	public void setQuestionAnswerDates(String[] questionAnswerDates) {
		this.questionAnswerDates = questionAnswerDates;
	}

	public String[] getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(String[] medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public String[] getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String[] workExperience) {
		this.workExperience = workExperience;
	}

}
