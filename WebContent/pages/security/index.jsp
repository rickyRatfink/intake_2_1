<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>  

<%@ page import="java.util.ArrayList" %>


<jsp:include page="../../includes/header.jsp" flush="true"/>
            
    <h2> 
        Log In
    </h2>
    <p>
        Please enter your username and password.
        <br />
        If you don't have an account ask to Supervisor for have one.
    </p>
    
            <span class="failureNotification">
                <ul>
				<div id="errors"><html:errors/>
                </ul>
            </span>
           
	<html:form action="/Login" focus="username">
	
            <div class="accountInfo">
                <fieldset class="login">
                    <legend>Account Information</legend>
                   
                    <p>
                        Username:<br />
                        <html:text property="systemUser.username" size="20" maxlength="20" styleClass="textbox"></html:text>
                     </p>
                    <p>
                        Password:<br />
                        <html:password property="systemUser.password" size="20" maxlength="20" styleClass="textbox"></html:password>
                    </p>
                 </fieldset>
                <p>
                    <input type="submit" name="action" value="Login" class="submitButton" />
                </p>
            </div>
        </html:form>

        </div>
        <div class="clear">
        </div>
    </div>
    <div class="footer">
        
    </div>
    

</form>
</body>
</html>
