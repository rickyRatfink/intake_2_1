<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
 
    

<script language="javascript" type="text/javascript">
function ucase(obj) {
  obj.value=obj.value.toUpperCase();
}

function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
	  
	  
function moveOnMax(field,nextFieldID){
	  if(field.value.length >= field.maxLength){
	    document.getElementById(nextFieldID).focus();
	  }
	}

</script>

<style>
body   
{
    background: #fffffff;
    font-size: .70em;
    font-family: "Helvetica Neue", "Lucida Grande", "Segoe UI", Arial, Helvetica, Verdana, sans-serif;
    margin: 0px;
    padding: 0px;
    color: #696969;
  
}

td {
   font-size: .80em;
}
</style>

</head>



<body>

<html:form action="/OnlineApp">


<table width="675" cellpadding="0" cellspacing="0" border="0">
<tr>
<td>

 <table width="100%">
	<tr>
		<td><b>Work Experience (Check all that apply):</b><br /></td>
	</tr>
</table>

<table width="100%">
	<tr>
	<td>
		<jsp:include page="messages.jsp" flush="true"/>
	</td>
	</tr>
</table>

  
 <table width="100%">
    		
		    	<logic:iterate id="loop" name="onlineAppForm" property="jobSkills" indexId="i">
		        <tr>
		    	<td width="150">
		        	<bean:write name="loop" property="description"/>
		        </td>
		        <td colspan="7">
		   			<html:checkbox property="workExperience[${i}]" value="YES" />
		   			<br />
				</td>
		        </tr>
		        </logic:iterate>
			
             <tr>
             	<td width="150">Other Description</td>
             	<td colspan="7"><html:text property="intake.otherJobSkill" size="20" maxlength="30"/></td>
             </tr>
            
   </table>
    
    <br/><br/>
    
    <table width="100%">
                <tr>
                	<td>Employer</td>
                	<td>Job Title/Description</td>
                    <td>Contact</td>
                    <td>Phone</td>
                    <td>Dates of Employment</td>
                </tr>
                <tr>
                	<td><html:text property="intake.employer1Name" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer1Job" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer1Contact" size="25" maxlength="60"/></td>
                    <td><html:text property="intake.employer1Phone" size="15" maxlength="20"/></td>
                    <td><html:text property="intake.employer1Dates" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                	<td><html:text property="intake.employer2Name" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer2Job" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer2Contact" size="25" maxlength="60"/></td>
                    <td><html:text property="intake.employer2Phone" size="15" maxlength="20"/></td>
                    <td><html:text property="intake.employer2Dates" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                	<td><html:text property="intake.employer3Name" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer3Job" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer3Contact" size="25" maxlength="60"/></td>
                    <td><html:text property="intake.employer3Phone" size="15" maxlength="20"/></td>
                    <td><html:text property="intake.employer3Dates" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                	<td><html:text property="intake.employer3Name" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer3Job" size="30" maxlength="60"/></td>
                	<td><html:text property="intake.employer3Contact" size="25" maxlength="60"/></td>
                    <td><html:text property="intake.employer3Phone" size="15" maxlength="20"/></td>
                    <td><html:text property="intake.employer3Dates" size="20" maxlength="20"/></td>
                </tr>
               
             </tr>
            
   </table>
     
	<br/><br/>
	
	<table width="100%">
    <tr>
    	<td align="left"><input type="submit" name="action" value="Back"  title="Return to previous step" /></td>
		<td align="right"><input type="submit" name="action" value="Next"  title="Continue to next step" /></td>
	</tr>

</td>
</tr>
</table>
	
<html:hidden property="pageSource" value="employment"/>  
    <html:hidden property="nextStep" value="process"/>  
    <html:hidden property="previousStep" value="legal"/> 
</html:form>


</body>
</html>