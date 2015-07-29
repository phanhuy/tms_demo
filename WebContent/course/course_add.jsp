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
	<br><h4>Add subject in course</h4>
	<s:if test="subjectList.size()>0">
		<s:iterator value="subjectList">
			<div class="col-lg-6">
		    <div class="input-group">
		      <span class="input-group-addon">
		        <input type="checkbox" value="${id }" aria-label="...">
		      </span>
		      <input type="text" class="form-control" path="" value="${name}" readonly="true">
		    </div><!-- /input-group -->
		  	</div><!-- /.col-lg-6 -->
		</s:iterator>  
	</s:if>
	<s:else>
		<div class="alert alert-danger" role="alert">
	  		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  		<span class="sr-only">Error:</span>
  				Subject not exist :(
		</div>
	</s:else>
	<br><br>
	<div class="form-group col-md-8">
		<input type="submit" id="addCourse_0" value="Add" class="btn btn-default">
	</div>
</s:form>