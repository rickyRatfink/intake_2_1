<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
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
               <h1>
                   Faith Farm Student Management 2.0
                </h1> 
            </div>
            <div class="loginDisplay">
                	<% if (user.getUsername()!=null) { %>
                        Welcome <b><%=user.getUsername() %>@<%=user.getFarmBase() %> </b>&nbsp;&nbsp;[ <a href="<%=request.getContextPath()%>/Login.do?action=logout" >Log Out</a> ]
                    <% } else { %>
                        [ <a href="<%=request.getContextPath()%>/login" >Log In</a> ]
                    <% } %>
            </div>
   <div class="clear hideSkiplink"> 
                          
               
    
		<div class="menu" >	
		<ul>
    		<li><a href="<%=request.getContextPath()%>/Intake.do?action=personal" >Personal</a></li>
      		<li><a href="<%=request.getContextPath()%>/Intake.do?action=religious" >Religious</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=substance" >Substance</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=health" >Health</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=legal" >Legal</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=employment" >Employment</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=status" >Status</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=Search" >Search</a></li>
            <li><a href="<%=request.getContextPath()%>/Intake.do?action=Home" >Home</a></li>
        </ul>
		<table>
    	<tr>
    		 <td width="33"></td>
		     <td><font style="color:#FFFFFF"><b>Student Name:</b>&nbsp;<font style="color:#aeadad"><bean:write name="intakeForm" property="intake.firstname" />&nbsp;<bean:write name="intakeForm" property="intake.lastname" /></font>
		     &nbsp;&nbsp;&nbsp;
		     <font style="color:#FFFFFF"><b>SSN:</b>&nbsp;<font style="color:#aeadad"><bean:write name="intakeForm" property="intake.ssn" /></font>
		     &nbsp;&nbsp;&nbsp;
		     <%
		     /*
		     String sDate = IntakeForm.getIntake().getCreationDate();
		    
		     try {
		    	Long lDate=new Long("0");
		    	 
		    	if (sDate.length()>0) {
		    		lDate=new Long(sDate);
		    		sDate = v8r.convertEpoch(lDate);
		    	}
		     } catch (Exception e) { 
		    	 System.out.println(e.getMessage());
		     }*/
		     %>
		     <font style="color:#FFFFFF"><b>Date Entered:</b>&nbsp;<font style="color:#aeadad"><bean:write name="intakeForm" property="intake.entryDate" /></font>
		     </td>
		     </tr>
		     <tr>
		      <td width="33"></td>
		     <td>
		     <a href="<%=request.getContextPath()%>/pages/student/card.jsp" style="color:#19fd01"><b>Print Card</b></a>
		     &nbsp;&nbsp;&nbsp;
		     <a href="<%=request.getContextPath()%>/pages/student/card.jsp" style="color:#19fd01""><b>Print Student Information</b></a>
		     
		     <logic:equal name="intakeForm" property="intake.applicationStatus" value="Accepted">
		     	&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/Intake.do?action=Admit" style="color:#19fd01"><b>Admit To Program</b></a>
		     </logic:equal>
		     <logic:equal name="intakeForm" property="intake.applicationStatus" value="Pending">
		        &nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/Intake.do?action=Accept" style="color:#19fd01"><b>Accept Application</b></a>
		     </logic:equal>
		     <logic:equal name="intakeForm" property="intake.applicationStatus" value="Pending">
		    	&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/Intake.do?action=Deny" style="color:#19fd01"><b>Deny Application</b></a>
		     </logic:equal>
		     <logic:equal name="intakeForm" property="intake.applicationStatus" value="Denied">
		    	&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/Intake.do?action=Reinstate" style="color:#19fd01"><b>Reinstate Application</b></a>
		     </logic:equal>
		     </td>
		     
    	</tr>
    </table> 
    </div>

                  
          
            
            </div>
        </div>
        <div class="main">
       