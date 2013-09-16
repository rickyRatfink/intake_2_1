<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page import="java.util.ArrayList" %>

<jsp:include page="../../includes/header.jsp" flush="true"/>


    <h2>
        Student Search Results
    </h2>
    
    <% int row=0; String rowClass="Odd"; %>
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
    <logic:iterate id="loop" name="intakeForm" property="intakeList">
    <tr>
       <td class="searchRow<%=rowClass%>2">
                    	 <a href="<%=request.getContextPath()%>/Intake.do?action=Edit&key=<bean:write name="loop" property="intakeId"/>" style="text-decoration:none">
                    	 <img src="<%=request.getContextPath()%>/images/local/Edit.gif" width="16" height="14"/>&nbsp;</a>
                   		 <img src="<%=request.getContextPath()%>/images/local/Report.gif" width="14" height="14"/>
      </td>
       <td class="searchRow<%=rowClass%>2"><bean:write name="loop" property="intakeId"/></td>
       <td class="searchRow<%=rowClass%>2"><bean:write name="loop" property="firstname"/></td>
       <td class="searchRow<%=rowClass%>2"><bean:write name="loop" property="mi"/></td>
       <td class="searchRow<%=rowClass%>2"><bean:write name="loop" property="lastname"/></td>
       <td class="searchRow<%=rowClass%>2"><bean:write name="loop" property="ssn"/></td>
       <td class="searchRow<%=rowClass%>2"><bean:write name="loop" property="dob"/></td>
   </tr>
   
   <%
   row++;
   if (row==2) 
	  	rowClass="Even"; 
	  else {
	    row=0;
		rowClass="Odd";
	  }
   %>
   </logic:iterate>
    </table>
    <div class="footer">
    </div>
   
</form>
</body>
</html>