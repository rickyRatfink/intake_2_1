
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
Thank you for completing your application to Faith Farm Ministries <b><bean:write name="onlineAppForm" property="intake.farmBase"/>.</b>
<br/><br/>
To submit your application click 'Submit'</br>
To review your application click 'Review'<br/><br/>
Once your application has been processed a representative will contact you.
</td>
</tr>
 <tr>
    	<td align="left">
    		<input type="submit" name="action" value="Review"  title="Review your application" />&nbsp;
			<input type="submit" name="action" value="Submit"  title="Submit your application" />
		</td>
	</tr>

</table>
	
<html:hidden property="pageSource" value="process"/>  
</html:form>


</body>
</html>