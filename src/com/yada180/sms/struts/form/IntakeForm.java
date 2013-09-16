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

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		  	 
		  return errors;
		}

}
