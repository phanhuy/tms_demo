<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="#session.logined == 'true'">			
	<h2>User info</h2>
	<b>ID:</b><s:property value="user.id" /><br>
	<b>Username:</b><s:property value="user.name"/><br>
	<b>Email:</b><s:property value="user.email" /><br>
	<b>Create at:</b><s:property value="user.create_at" /><br>
	<b>Update at:</b><s:property value="user.update_at" /><br>					
	<a href="<s:url value="/users/edit%{user.id}"/>">Edit</a>	
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a><br>	
</s:else>