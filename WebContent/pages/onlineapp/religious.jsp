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
		<td><b>Spiritual Information: </b><br /><br /></td>
	</tr>

 	<tr>
		<td>
    		<jsp:include page="messages.jsp" flush="true"/>
	   </td>
	</tr>
	</table>
	
	<table width="100%" border="0">
	<tr>
		<td >Describe your religious/spiritual experiences:</td>
	</tr>
    <tr>
		<td>
			<html:textarea property="intake.religiousExperience" cols="93" rows="15" styleClass="textarea" />
		</td>
	</tr>
    
    <tr>
		<t>Religious Background
        		<html:select property="intake.religion" styleClass="select" >
					<html:option value="">Select</html:option>
					<html:optionsCollection name="ddl_religion" value="value" label="label" />
				</html:select> 
        </td>
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
	
<html:hidden property="pageSource" value="religious"/>  
    <html:hidden property="nextStep" value="health"/>  
    <html:hidden property="previousStep" value="personal"/> 
</html:form>


</body>
</html>
    