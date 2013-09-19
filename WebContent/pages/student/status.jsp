<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<jsp:include page="../../includes/header_info.jsp" flush="true"/>
 


<html:form method="POST" action="Intake">

    <table width="950">
	<tr>
		<td width="100%" colspan="2"><b>Student Status: </b><br /><br /></td>
	</tr>
    <tr>
    	<td valign="top">
        	<table width="150" cellpadding="0" cellspacing="0" border="0">
            <tr>
            	<td >Supervisor</td>
            </tr>
            <tr>
            	<td>
                      <html:select property="intake.supervisorId" > 
						<html:optionsCollection name="ddl_supervisor" value="supervisorId" label="firstname" />
					  </html:select>

            	</td>
            </tr>
            <tr>
            	<td>Job</td>
            </tr>
            <tr>
            	<td>
                    <html:select property="intake.jobId" > 
						<html:optionsCollection name="ddl_job" value="jobId" label="title" />
					</html:select>

            	</td>
            </tr>
            <tr>
            	<td>Class</td>
            </tr>
            <tr>
            	<td>
            		<html:text property="intake.currentClass" size="20" maxlength="20"/>
            	</td>
            </tr>
            <tr>
            	<td>Area</td>
            </tr>
            <tr>
            	<td>
            		<html:select property="intake.departmentId" > 
						<html:optionsCollection name="ddl_department" value="departmentId" label="title" />
					</html:select>
            	</td>
            </tr>
            <tr>
            	<td>Room</td>
            </tr>
            <tr>
            	<td>
            		<html:text property="intake.room" size="20" maxlength="20"/>
            	</td>
            </tr>
            <tr>
            	<td>Bed</td>
            </tr>
            <tr>
            	<td>
            		<html:text property="intake.bed" size="20" maxlength="20"/>
            	</td>
            </tr>
            <tr>
            	<td>Date Last Entered</td>
            </tr>
            <tr>
            	<td>
            		<html:text property="intake.entryDate" size="20" maxlength="12" styleClass="tcal"/>
            	</td>
            </tr>
            <tr>
            	<td>(This is the date they LAST ENTERED the program.  Please check the Student Status History for original entry date.)</td>
            </tr>
            <tr>
            	<td>Archived
            	   <html:text property="intake.archivedFlag" value="YES"/> 
            	</td>
            </tr>
            <tr>
            	<td>(Archived students will not show up in searches or reports.)</td>
            </tr>
            
            
            
            
            </table>
        
        </td>
       
        <td valign="top">
        	<table width="750" cellpadding="0" cellspacing="0" border="0">
            <tr style="background: silver; text-align: left;">
            	<td width="10"></td>
            	<td width="100"><b>Location</b></td>
                <td width="100"><b>Program</b></td>
                <td width="100"><b>Status</b></td>
                <td width="100"><b>Reason</b></td>
                <td width="100"><b>Date Began</b></td>
                <td width="100"><b>Date Ended</b></td>
                <td width="50"><b>Reset?</b></td>
            </tr>
            <logic:iterate id="loop" name="intakeForm" property="studentHistory" indexId="i">
            <tr>
            	<td></td>
            	<td><bean:write name="loop" property="studentHistory.farm"/></td>
            	<td><bean:write name="loop" property="studentHistory.phase"/></td>
            	<td><bean:write name="loop" property="studentHistory.programStatus"/></td>
            	<td><bean:write name="loop" property="studentHistory.reason"/></td>
            	<td><bean:write name="loop" property="studentHistory.beginDate"/></td>
            	<td><bean:write name="loop" property="studentHistory.endDate"/></td>
            	<td></td>
        	</tr>
        	</logic:iterate>
        	<tr>
        		<td colspan="8">No Status</td>
        	</tr>
        	<tr>
            	<td colspan="8">
               		 <hr style="border-bottom: 1px dotted #000000;"/>
                </td>
            </tr>
            <tr style="background: silver; text-align: left;">
            	<td colspan="8">Reason for Change of Status:<br /><br /></td>
            </tr>
            <tr style="background: silver; text-align: left;">
            	<td valign="top">Update:</td>
                <td valign="top">                     
                	<html:select property="history.farm" > 
						<html:optionsCollection name="ddl_farm" value="name" label="name" />
					</html:select>
					&nbsp;&nbsp;
                </td>
                <td valign="top">                     
                	<html:select property="history.phase" > 
						<html:optionsCollection name="ddl_phase" value="name" label="name" />
					</html:select>
                &nbsp;&nbsp;
                </td>
                <td valign="top" colspan="2"> 
                    <html:select property="history.programStatus" > 
						<html:optionsCollection name="ddl_programStatus" value="name" label="name" />
					</html:select>
                
                &nbsp;&nbsp;
                </td>
                <td valign="top"> <html:text property="history.beginDate" size="12" maxlength="12"/></td>
                <td valign="top"> <html:text property="history.endDate" size="12" maxlength="12"/></td>
                <td valign="top"></td>
                </tr>
                <tr style="background: silver; text-align: left;">
                	<td colspan="8">
                    	<html:textarea property="history.reason" cols="93" styleClass="textarea" />
                    </td>
                </tr>
            </tr>
            
            </table>
            <br /><br />
            <table width="700" cellpadding="0" cellspacing="0" border="0">
            <tr>
            	<td  style="background: silver; text-align: center;color:#000000;font-weight:bold;height=18px;">Student History</td>
            </tr>
            <tr>
            	<table width="700" cellpadding="0" cellspacing="0" >
            		<tr>
                    	<td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">From</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">To</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Location</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Program</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Ending Status</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Reason For Change of Status</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Del</td>
                     </tr>
                    <logic:iterate id="loop" name="intakeForm" property="studentHistory" indexId="i">
                     <tr> 
                     	<td><bean:write name="loop" property="studentHistory.beginDate"/></td>
                        <td><bean:write name="loop" property="studentHistory.endDate"/></td>
                        <td><bean:write name="loop" property="studentHistory.farm"/></td> 
                        <td><bean:write name="loop" property="studentHistory.phase"/></td>
                        <td><bean:write name="loop" property="studentHistory.programStatus"/></td>
                        <td><bean:write name="loop" property="studentHistory.reason"/></td>
                        <td><input type="submit" name="action" value="Delete History" onClick="javascript:document.getElementById('deleteId').value='<bean:write name="loop" property="studentHistory.studentHistoryId"/>'" class="imageButtonDelete"/></td>
                     </tr>
                     </logic:iterate>
                     <tr>
                     	<td colspan="7">No history</td> 
                     </tr>
                     <% } %>
                </table>
                
            <br /><br />
            <table width="700" cellpadding="0" cellspacing="0" border="0">
            <tr>
            	<td  style="background: silver; text-align: center;color:#000000;font-weight:bold;height=18px;">Pass History</td>
            </tr>
            <tr>
            	<table width="700" cellpadding="0" cellspacing="0" >
            		<tr>
                    	<td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Pass Date</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Hours</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Type</td>
                        <td style="height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">Del</td>
                     </tr>
                     <tr>
                    	<td style="background: silver;height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">
                    		<html:text property="passHistory.passDate" size="12" maxlength="12" styleClass="tcal"/>
                    	</td>
                        <td style="background: silver;height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">
                                <html:text property="passHistory.hours" size="3" maxlength="3"/>
                		</td>
                        <td colspan="2" style="background: silver;height:20px;border: 1px solid #666;color:#000000;font-weight:bold;padding-left:5px;">
                                 <html:select property="passHistory.passType" > 
									<html:optionsCollection name="ddl_passType" value="name" label="name" />
								</html:select>
						</td>
                        
                     </tr>
                     <logic:iterate id="loop" name="intakeForm" property="studentPassHistory" indexId="i">
                     <tr> 
                     	<td><bean:write name="loop" property="studentPassHistory.passDate"/></td>
                        <td><bean:write name="loop" property="studentPassHistory.hours"/></td>
                        <td><bean:write name="loop" property="studentPassHistory.passType"/></td> 
                        <td><input type="submit" name="action" value="Delete Pass History" onClick="javascript:document.getElementById('deleteId').value='<bean:write name="loop" property="studentPassHistory.passHistoryId"/>'" class="imageButtonDelete"/></td>
                     </tr>
                     </logic:iterate>
                     
                     <tr>
                     	<td colspan="7">No history</td> 
                     </tr>
                     
                    
                </table>
                
            </tr>
            </table>
        </td>
    </tr>
    </table>
	<br /><br />
    <div align="center">
   		<input type="submit" name="action" value="Save" class="imageButtonSave" title="Save Information" />&nbsp;
   </div>





    <div class="footer">
        
    </div>
    <input type="hidden" name="source" value="status"/>
    <input type="hidden" name="key" value="<bean:write name="intakeForm" property="intake.intakeId"/>"/>
    <input type="hidden" id="deleteId" name="deleteId" value=""/>
</html:form>
</body>
</html>