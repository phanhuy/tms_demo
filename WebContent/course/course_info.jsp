<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Course <s:property value="course.name"/><br></h3>
ID: <s:property value="course.id"/><br>
Name: <s:property value="course.name"/><br>
Detail: <s:property value="course.detail" /><br>
<form></form>
<a href="<s:url value="/courses/delete%{course.id}"/>">Delete</a>
<a href="<s:url value="/courses/edit%{course.id}"/>">Edit</a>
<br><br>
<h4>Subject in course:<br></h4>	
<s:if test="subjectCourseList.size()>0">
	<br>
	<s:iterator value="subjectCourseList">
		<a href="<s:url value="/subjects/detail"/><s:property value="id"/>">
			<button type="button" class="btn btn-info"><s:property value="name"/></button></a>	
	</s:iterator>
</s:if>
<s:else>
	<br>
	<div class="alert alert-info" role="alert">
	  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  <span class="sr-only">Error:</span>
  		This Course hasn't subject! :D
	</div>
</s:else>