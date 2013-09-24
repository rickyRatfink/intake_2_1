<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

 
<jsp:include page="../../../includes/header.jsp" flush="true"/>


<html:form method="POST" action="/Cwt.do">
    <h2>
        Course Work Therapy - Create Metric
    </h2>
    
      
       <br />
 		  <jsp:include page="../messages.jsp" flush="true"/>
	   <br />

      
            <div align="left">
            
            Metric Name<br /><html:text property="cwtMetric.metricName" size="30" maxlength="50" /><br />
 			<br />
            Description<br /><textarea name="cwtMetric.description" cols="40" rows="5"></textarea><br />
        	<br/>
        	
        	<b>UBIT</b><br/>
              		
					<logic:iterate id="loop" name="cwtForm" property="programList" indexId="i">
			        <tr>
			    	<td width="150">
			        	<bean:write name="loop" property="programName"/>
			        </td>
			        <td colspan="7">
			   			<html:checkbox property="metricUbit[${i}]" value="YES" />
			   			<br />
					</td>
			        </tr>
			        </logic:iterate>
			        
            <br /><br/>
            Status<br/>
            <html:select property="cwtProgram.status" styleClass="status" > 
						<html:option value="">Select</html:option>
						<html:optionsCollection name="ddl_cwtStatus" value="value" label="label" />
					</html:select>
               <br /><br />
           
            <input type="submit" name="action" value="Save"/>&nbsp;
            	
             </div>
    </div>
    <div class="footer">
        Faith Farm Ministries &copy;2013
    </div>
   
<html:hidden name="cwtForm" property="pageSource" value="metric"/>
</html:form>
</body>
</html>
