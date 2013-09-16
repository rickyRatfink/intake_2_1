package com.yada180.sms.struts.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.yada180.sms.application.Constants;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.dao.SystemUserDao;
import com.yada180.sms.struts.form.LoginForm;
import com.yada180.sms.util.HtmlDropDownBuilder;


public class LoginAction extends Action {
	
	private final static Logger LOGGER = Logger.getLogger(LoginAction.class.getName());
	private final static HtmlDropDownBuilder html = new HtmlDropDownBuilder();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {		
		LOGGER.setLevel(Level.INFO);

		 HttpSession session = request.getSession(false);
		 
		 if ("logout".equals(request.getParameter("action"))) {
			 session.invalidate();
			 return mapping.findForward(Constants.FAILURE);
		 }
		 //SystemUserHome userDao = new SystemUserHome();
		 SystemUserDao userDao = new SystemUserDao();
		 ActionRedirect redirect = null;
		 LoginForm loginForm = (LoginForm)form;
		 LOGGER.log(Level.INFO, "In login action..."+loginForm.getSystemUser().getUsername());
		 SystemUser user = userDao.authenticate(loginForm.getSystemUser().getUsername(), loginForm.getSystemUser().getPassword());
		 
		 if (user!=null) {
			 html.refresh(session);
			 session.setAttribute("system_user", user);
			 return mapping.findForward(Constants.SUCCESS);
		 } else {
			 return mapping.findForward(Constants.FAILURE);
		 }
   
	}
	
}
