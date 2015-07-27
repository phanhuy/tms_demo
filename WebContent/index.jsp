<%@ taglib prefix="s" uri="/struts-tags"%>

<li class="page-scroll"><a href="<s:url value="/courses/"/> ">Course</a>

					
				

<s:if test="#session.logined == 'true'">	
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a>
</s:else>