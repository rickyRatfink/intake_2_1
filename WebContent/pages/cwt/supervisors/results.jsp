<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

 
<jsp:include page="../../../includes/header.jsp" flush="true"/>


<html:form method="POST" action="/Cwt">
   <h2>
        Course Work Therapy - Supervisor List
    </h2>
    
            <br />
            <jsp:include page="../messages.jsp" flush="true"/>
            <br/>
           
            <div align="left">
            <table width="80%" cellpadding="0" cellspacing="0">
            <tr>
            	<td>
                <table width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td class="colHeading2" width="100">Actions</td>
                    <td class="colHeading2" width="300">Name</td>
                    <td class="colHeading2" width="300">Job Title</td>
                    <td class="colHeading2" width="300">Department Title</td>
                    <td class="colHeading2" width="300">Farm Location</td>
                    <td class="colHeading2" width="150">Created By</td>
                 </tr>
                <logic:iterate id="loop1" name="cwtForm" property="supervisorList">
                <tr>
                    <td class="searchRowOdd2">
                    	 <img src="<%=request.getContextPath()%>/images/local/Edit.gif" width="16" height="14"/>&nbsp;
                   	<td class="searchRowOdd2" ><bean:write name="loop1" property="firstname"/>&nbsp;<bean:write name="loop1" property="lastname"/></td>
                    <td class="searchRowOdd2" >job title</td>
                    <td class="searchRowOdd2" >dept</td>
                    <td class="searchRowOdd2" >farm</td>
                    <td class="searchRowOdd2" ><bean:write name="loop1" property="createdBy"/></td>
                </tr> 
                </logic:iterate>
                <logic:empty name="cwtForm" property="supervisorList">
					<td colspan="8">No supervisors defined</td>
				</logic:empty>

                </table>
                </td>
            </tr>
            </table>
            
            <table width="100%" cellpadding="0" cellspacing="0">
            <tr>
            	<td height="23" valign="center" align="left">
            		<input type="submit" name="action" value="Create" />
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
 <html:hidden name="cwtForm" property="pageSource" value="supervisor"/>
</html:form>
</body>
</html>
