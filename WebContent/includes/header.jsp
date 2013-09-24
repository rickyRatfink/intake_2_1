<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.yada180.sms.domain.SystemUser" %>

<% 
    SystemUser user = null;
	
	try {
	  user = (SystemUser)session.getAttribute("system_user"); 
	  if (user==null) user = new SystemUser();
	} catch (Exception e) {
		user=new SystemUser();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><title>
	Faith Farm Student Information System
</title>

	<link href="<%=request.getContextPath()%>/styles/site.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/styles/tcal.css" rel="stylesheet" type="text/css" />
   
    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/tcal.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/chart.js"></script>

    <script  type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.4.1.min.js">
    </script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.format.1.02.js">
    </script>    
    <script  type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.dateentry.min.js">
    </script>    
    <style type="text/css">
        @import "/Styles/jquery.datepick.css";
    </style>
    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.datepick.min.js"></script>    
   
 <div class="page">
        <div class="header">
            <div class="title">
                <a href="/Default.aspx"> 
                <h1>
                   Faith Farm Student Management 2.0
                </h1>
                </a>
            </div>
            <div class="loginDisplay">
                	<% if (user.getUsername()!=null) { %>
                        Welcome <b><%=user.getUsername() %>@<%=user.getFarmBase() %> </b>&nbsp;&nbsp;[ <a href="<%=request.getContextPath()%>/Login.do?action=logout" >Log Out</a> ]
                    <% } else { %>
                        [ <a href="<%=request.getContextPath()%>/Login.do" >Log In</a> ]
                    <% } %>
            </div>
             <div class="clear hideSkiplink">
                          
               
<div class="menu" >
	<ul>
		<li><a href="<%=request.getContextPath()%>/pages/index.jsp">Home</a></li>
        <li><a href="<%=request.getContextPath()%>/pages/about.jsp">About</a></li>
        <% if ("ADMIN".equals(user.getUserRole())) { %>
             <li><a href="<%=request.getContextPath()%>/Intake.do?action=SearchApps">Applications</a></li>
             <li><a href="<%=request.getContextPath()%>/Intake.do?action=Search">Search</a></li>
             <li><a href="<%=request.getContextPath()%>/Intake.do?action=Create">New Student</a></li>
             <li><a href="<%=request.getContextPath()%>/pages/student/results.jsp">Search Result</a></li>
             <li><a href="<%=request.getContextPath()%>/Cwt.do">CWT</a></li>
             <li><a href="<%=request.getContextPath()%>/Report.do">Reports for Printing</a></li>
             <li><a href="<%=request.getContextPath()%>/pages/">Fast Find</a></li>
        <% } %>
     </ul>
</div>
                    
          
            
            </div>
        </div>
        <div class="main">