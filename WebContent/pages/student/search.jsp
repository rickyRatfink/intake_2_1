<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@ page import="java.util.ArrayList" %>

<jsp:include page="../../includes/header.jsp" flush="true"/>


    <h2>
        Student Search
    </h2>
    	<div align="center">
        <div class="studentSearch">
        
        <html:form action="/Intake">
          	<table width="380" cellpadding="0" cellspacing="0" border="0">
            <tr>
            	<td></td>
                <td>From:</td>
                <td>To:</td>
                <td></td>
            </tr>
            <tr>
            	<td>Entry Date:</td>
                <td><html:text property="intake.entryDate" size="20" maxlength="13" styleClass="tcal" />
                </td>
                
                <td><html:text property="intake.exitDate" size="20" maxlength="13" styleClass="tcal" /></td>
                <td></td>
            </tr>
             <tr><td colspan="4"><br /></td></tr>
            <tr>
            	<td>Last Name:</td>
                <td colspan="3"><html:text property="intake.lastname" size="30" maxlength="13"  /></td>
            </tr>
             <tr><td colspan="4"><br /></td></tr>
             <tr>
            	<td>First Name:</td>
                <td colspan="3"><html:text property="intake.firstname" size="30" maxlength="13"  /></td>
            </tr>
             <tr><td colspan="4"><br /></td></tr>
             <tr>
            	<td>SSN:</td>
                <td colspan="3">
                	<html:text property="intake.ssn" size="11" maxlength="11"  />
                </td>
            </tr>
             <tr><td colspan="4"><br /></td></tr>
               <tr>
            	<td>Birthdate:</td>
                <td colspan="3"><html:text property="intake.dob" size="20" maxlength="13" styleClass="tcal" /></td>
            </tr>
            
            <tr><td colspan="4"><br /></td></tr>
             <tr>
            	<td>Location:</td>
                <td>
                	<html:select property="intake.farmBase" multiple="true" style="height:90px;" > 
					<html:option value="ALL">ALL</html:option>
					<html:optionsCollection name="ddl_farm" value="name" label="name" />
					</html:select>
                </td>
                 <td colspan="2">
                 	<table cellpadding="0" cellspacing="0" border="0">
                    <tr>
                    	<td>Show Archived?</td>
                    </tr>
                    <tr>
                    	<td><input type="radio" name="archivedFlag" value="YES" />
                        	<input type="radio" name="archivedFlag" value="No" />
                        </td>
                    </tr>
                     <tr>
                    	<td>Show Picture?</td>
                    </tr>
                    <tr>
                    	<td><input type="radio" name="pictureFlag" value="YES" />
                        	<input type="radio" name="pictureFlag" value="No" />
                        </td>
                    </tr>
                    <tr>
                    	<td colspan="2">Need GED?<input type="checkbox" name="gedFlag" value="YES"/>
                        </td>
                     </tr>
                     
                      <tr><td colspan="4"><br /></td></tr>
                      
                     </table>
                        
                  
                    
                 
                 </td>
            </tr>
            </table>
            <table width="100%" >
            	<tr>
                	<td width="100%" align="center">
                      <input type="submit" name="action" value="Search Students"/>
                    </td>
                 </tr>
             </table>
                	
           </html:form>  
        </div>
        </div>
    <div class="footer">
        
    </div>
   
</form>
</body>
</html>
