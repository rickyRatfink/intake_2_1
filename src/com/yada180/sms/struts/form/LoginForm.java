package com.yada180.sms.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.yada180.sms.domain.SystemUser;

public class LoginForm  extends ActionForm {

	private SystemUser systemUser = new SystemUser();
	
	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}



	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		  ActionErrors errors = new ActionErrors();
		  if ((this.systemUser.getUsername()==null) || (this.systemUser.getUsername().length() < 1)) 
		      errors.add("",new ActionMessage("errors.required","username"));
		  if ((this.systemUser.getPassword()==null) || (this.systemUser.getPassword().length() < 1)) 
		      errors.add("", new ActionMessage("errors.required","password"));
		  
		  	 
		  return errors;
		}
}
