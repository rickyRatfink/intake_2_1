package com.yada180.sms.application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yada180.sms.util.Validator;
import com.yada180.sms.domain.Farm;

public class Controller extends HttpServlet {

	private String URL = "";
	private Validator v = new Validator();
	private final static Logger LOGGER = Logger.getLogger(Controller.class
			.getName());

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.setLevel(Level.SEVERE);
		HttpSession session = request.getSession(true);

		 if (!v.isAuthenticated(request))		
			 URL="pages/security/index.jsp";
		 
		try {
			String action = request.getParameter("action");
			String entity = request.getParameter("entity");
			
			URL = "pages/index.jsp";
			
		} catch (Exception e) {
			session.setAttribute("SYSTEM_ERR", e.getMessage());
			LOGGER.log(Level.SEVERE,e.getMessage());
			URL = "pages/error.jsp";
		}
		
		
		request.getRequestDispatcher("/" + URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
        
  

}