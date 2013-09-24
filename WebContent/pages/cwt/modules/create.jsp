<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

 
<jsp:include page="../../../includes/header.jsp" flush="true"/>


<html:form method="POST" action="/Cwt.do">

    <h2>
        Course Work Therapy - Create Module 
    </h2>
    
       <br />
 		  <jsp:include page="../messages.jsp" flush="true"/>
	   <br />
 
            <div align="left">
            
            <b>Module Name</b><br /><html:text property="cwtModule.moduleName" size="30" maxlength="50" /><br /><br />
            <b>Description</b><br /><html:textarea property="cwtModule.description" cols="93" styleClass="textarea" /><br /><br />
            
            <b>Meeting Days</b><br />
            	<html:checkbox property="monday" value="M" />
            	<html:checkbox property="tuesday" value="T" />
            	<html:checkbox property="wednesday" value="W" />
            	<html:checkbox property="thursday" value="TH" />
            	<html:checkbox property="friday" value="F" />
            	<html:checkbox property="saturday" value="SA" />
            	<html:checkbox property="sunday" value="SU" />            
                <br /><br />
            <b>Meeting Times</b><br />
            	<html:text property="cwtModule.meetingTimes" size="30" maxlength="30" />
            <br /><br />
            <b>Meeting Location</b><br />
            	<html:text property="cwtModule.meetingLocation" size="30" maxlength="30" />
            <br/><br/>
            <b>Instructor</b><br/>
            
                      <html:select property="cwtModule.instructorId" styleClass="status"> 
                      	<html:option value="">Select</html:option>
						<html:optionsCollection name="ddl_supervisor" value="value" label="label" />
					  </html:select>
            
            <br/><br/>
        	<b>Metrics</b><br/>
  					<logic:iterate id="loop" name="cwtForm" property="metricList" indexId="i">
			        <tr>
			    	<td width="150">
			        	<bean:write name="loop" property="metricName"/>
			        </td>
			        <td colspan="7">
			   			<html:checkbox property="moduleMetric[${i}]" value="YES" />
			   			<br />
					</td>
			        </tr>
			        </logic:iterate>
            <br /><br/>
            <b>Status</b><br/>
               <html:select property="cwtModule.status" styleClass="status" > 
						<html:option value="">Select</html:option>
						<html:optionsCollection name="ddl_cwtStatus" value="value" label="label" />
					</html:select>
               <br /><br />
           
            <input type="submit" name="action" value="Save" />&nbsp;
            	
             </div>
    </div>
    <div class="footer">
        Faith Farm Ministries &copy;2013
    </div>
   
<html:hidden name="cwtForm" property="pageSource" value="module"/>

</html:form>
</body>
</html>
