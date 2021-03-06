<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

 
<jsp:include page="../../../includes/header.jsp" flush="true"/>

<html:form method="POST" action="/Cwt">
    <h2>
        Course Work Therapy - Metrics Search Results
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
                    <td class="colHeading2" width="500">Metric Name</td>
                    <td class="colHeading2" width="100">Status</td>
                </tr>
               <logic:iterate id="loop" name="cwtForm" property="metricList">
                <tr>
                    <td class="searchRowOdd2">
                    	 <a href="<%=request.getContextPath()%>/Cwt.do?action=Edit&id=<bean:write name="loop" property="metricId"/>">
                    	 	<img src="<%=request.getContextPath()%>/images/local/Edit.gif" width="16" height="14"/>
                    	 </a>
                   	<td class="searchRowOdd2" ><bean:write name="loop" property="metricName"/></td>
                    <td class="searchRowOdd2" ><bean:write name="loop" property="status"/></td>
                </tr> 
                </logic:iterate>
               

                </table>
                </td>
            </tr>
            </table>
            </br>
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
   <html:hidden name="cwtForm" property="pageSource" value="metrics"/>
</html:form>
</body>
</html>
