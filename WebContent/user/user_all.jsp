<%@ taglib prefix="s" uri="/struts-tags"%>

<h4>Framgia Training Course</h4>
<br>
<a href="<s:url value="/users/new"/>"><button type="button"
		class="btn btn-primary">Add User</button></a>
<br>
<br>

<s:iterator value="userList">
	<div class="panel panel-info">
		<div class="panel-heading">
			<a href="<s:url value="/users/detail"/><s:property value="id"/>"><s:property
					value="name" /></a>
		</div>		
	</div>
</s:iterator>
