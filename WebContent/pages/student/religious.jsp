<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<jsp:include page="../../includes/header_info.jsp" flush="true"/>
 

<html:form  action="/Intake">

    <table width="750">
	<tr>
		<td colspan="8"><b>Spiritual Information: </b><br /><br /></td>
	</tr>

    <jsp:include page="../../includes/messages.jsp" flush="true"/>

	<tr>
    	<td colspan="8">
                <table width="100%" border="0">
	<tr>
		<td colspan="8">Describe your religious/spiritual experiences:</td>
	</tr>
    <tr>
		<td colspan="8">
			<html:textarea property="intake.religiousExperience" cols="93" styleClass="textarea" />
		</td>
	</tr>
    <tr>
		<td colspan="8">&nbsp;</td>
	</tr>
    <tr>
		<td colspan="8">Religious Background
        		<html:select property="intake.religion" styleClass="select" >
					<html:option value="">Select</html:option>
					<html:optionsCollection name="ddl_religion" value="value" label="label" />
				</html:select> 
        </td>
	</tr>
    <tr>
		<td colspan="8" valign="bottom" align="center" height="45">    
    	    <input type="submit" name="action" value="Save" class="imageButtonSave" title="Save Information" />&nbsp;
  		</td>
	</tr>
    </table>
 <html:hidden property="pageSource" value="religious"/>  
</html:form>

    <div class="footer">
        
    </div>
   
</body>
</html>