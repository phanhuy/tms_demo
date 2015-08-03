<%@ taglib prefix="s" uri="/struts-tags"%>

<h4>Add new course</h4>
<br>
<s:form action="create" >
	<div class="form-group">
		<input type="text" name="course.name" value="" id="addCourse_course_name" placeholder="Course name" class="form-control">
	</div>
	<div class="form-group">
		<textarea name="course.detail" cols="50" rows="5" id="addCourse_course_detail" placeholder="Course detail" class="form-control"></textarea>
	</div>
	<div class="form-group col-md-8">
		<input type="submit" id="addCourse_0" value="Add" class="btn btn-default">
	</div>
</s:form>