<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page import="java.util.ArrayList" %>

<jsp:include page="../../includes/header.jsp" flush="true"/>

<html:form  action="/Intake">
    <h2>
        Student Search Results
    </h2>
    
  
     <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr>
         <td class="colHeading2" width="100">Actions</td>
         <td class="colHeading2" width="100">Student Id</td>
         <td class="colHeading2" width="100">First Name</td>
         <td class="colHeading2" width="30">MI</td>
         <td class="colHeading2" width="300">Last Name</td>
         <td class="colHeading2" width="300">SSN</td>
         <td class="colHeading2" width="300">DOB</td>
    </tr>
    <logic:notEmpty name="intakeForm">
    
	    <logic:iterate id="loop" name="intakeForm" property="intakeList">
	    <tr>
	       <td class="searchRowOdd2">
	                    	 <a href="<%=request.getContextPath()%>/Intake.do?action=Edit&key=<bean:write name="loop" property="intakeId"/>" style="text-decoration:none">
	                    	 <img src="<%=request.getContextPath()%>/images/local/Edit.gif" width="16" height="14"/>&nbsp;</a>
	                   		 <img src="<%=request.getContextPath()%>/images/local/Report.gif" width="14" height="14"/>
	      </td>
	       <td class="searchRowOdd2"><bean:write name="loop" property="intakeId"/></td>
	       <td class="searchRowOdd2"><bean:write name="loop" property="firstname"/></td>
	       <td class="searchRowOdd2"><bean:write name="loop" property="mi"/></td>
	       <td class="searchRowOdd2"><bean:write name="loop" property="lastname"/></td>
	       <td class="searchRowOdd2"><bean:write name="loop" property="ssn"/></td>
	       <td class="searchRowOdd2"><bean:write name="loop" property="dob"/></td>
	   </tr>
	   </logic:iterate>
	   <logic:empty name="intakeForm" property="intakeList">
    	<tr><td class="searchRowOdd2" colspan="7">No results</td></tr>
       </logic:empty>
		
	</logic:notEmpty>
	<logic:empty name="intakeForm">
    	<tr><td class="searchRowOdd2" colspan="7">No results</td></tr>
    </logic:empty>
	
    </table>
    <div class="footer">
    </div>
   
</html:form>
</body>
</html>