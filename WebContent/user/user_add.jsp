<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Add new user</h3>
<br>
<s:form action="users/create" >
	<div class="form-group">
		<input type="text" name="user.name" value="" placeholder="Name" class="form-control">
	</div>
	<div class="form-group">
		<input type="text" name="user.email" value="" placeholder="Email" class="form-control">
	</div>
	<div class="form-group">
		Is suppervisor?  <input type="checkbox" name="user.suppervisor" style="margin-left:5px;">
	</div>
	<div class="form-group">
		<input type="text" name="user.password" value="" placeholder="Password" class="form-control">
	</div>
	<div class="form-group">
		<input type="password" name="confirm_password" value="" placeholder="Confirm password" class="form-control">
	</div>
	<div class="form-group">
		<input type="submit" value="Add" class="btn btn-default">
	</div>
</s:form>