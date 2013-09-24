<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

 
<jsp:include page="../../../includes/header.jsp" flush="true"/>



<html:form method="POST" action="/Cwt">

    <h2>
        Course Work Therapy - Modules Search Results
    </h2>
    
            <br />
            <jsp:include page="../messages.jsp" flush="true"/>
            <br/>
            
            <div align="left">
            <table width="90%" cellpadding="0" cellspacing="0" >
            <tr>
            	<td>
                <table width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td class="colHeading2" width="100">Actions</td>
                    <td class="colHeading2" width="150">Module Name</td>
                    <td class="colHeading2" width="100">Meeting Days</td>
                    <td class="colHeading2" width="100">Meeting Times</td>
                    <td class="colHeading2" width="100">Location</td>
                    <td class="colHeading2" width="100">Instructor</td>
                    <td class="colHeading2" width="100">Status</td>
                </tr>
               
                <logic:iterate id="loop" name="cwtForm" property="moduleList">
                <tr>
                    <td class="searchRowOdd2">
                    	 <a href="<%=request.getContextPath()%>/Cwt.do?action=Edit&id=<bean:write name="loop" property="moduleId" />">
                    		 <img src="<%=request.getContextPath()%>/images/local/Edit.gif" width="16" height="14"/>
						 </a>
                   		 <a href="<%=request.getContextPath()%>/Cwt.do?action=Roster"><img src="<%=request.getContextPath()%>/images/local/enroll.png" width="14" height="14" title="Enroll Students"/></a></td>
                    <td class="searchRowOdd2" ><bean:write name="loop" property="moduleName"/></td>
                    <td class="searchRowOdd2" ><bean:write name="loop" property="meetingDays"/></td>
                    <td class="searchRowOdd2" ><bean:write name="loop" property="meetingTimes"/></td>
                    <td class="searchRowOdd2" ><bean:write name="loop" property="meetingLocation"/></td>
                    <td class="searchRowOdd2" >instructor name</td>
                    <td class="searchRowOdd2"><bean:write name="loop" property="status"/></td>
                </tr> 
                </logic:iterate>
               

                </table>
                </td>
            </tr>
            </table>
            <br/>
            <table width="100%" cellpadding="0" cellspacing="0">
            <tr>
            	<td height="23" valign="center" align="left">
            		<input type="submit" name="action" value="Create"/>
            	</td>
            </tr>
           	</table>
        	</div>

        </div>
        <div class="clear">
        </div>
    </div>
    <div class="footer">
        
    </div>
 <html:hidden name="cwtForm" property="pageSource" value="modules" />
</html:form>
</body>
</html>
