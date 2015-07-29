<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Subject <s:property value="subject.name"/><br></h3>
ID: <s:property value="subject.id"/><br>
Name: <s:property value="subject.name"/><br>
Detail: <s:property value="subject.detail" /><br>
<form></form>
<a href="<s:url value="/subjects/delete%{subject.id}"/>">Delete</a>
<a href="<s:url value="/subjects/edit%{subject.id}"/>">Edit</a>
<br><br>
<h4>Task in subject:</h4>
<br>
<div class="task-all col-md-12">
	<s:if test="taskList.size()>0">
		<s:iterator value="taskList">
		<div class="task-info col-md-2">
			<b><s:property value="name"/>:</b><br>
			<s:property value="detail"/>
		</div>
		</s:iterator>
	</s:if>
	<s:else>
		<div class="alert alert-danger" role="alert">
		  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		  <span class="sr-only">Error:</span>
	  		Nothing tasks in <s:property value="subject.name"/> :(
		</div>
	</s:else>
</div>