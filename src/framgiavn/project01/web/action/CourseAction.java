package framgiavn.project01.web.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.CourseBusiness;
import framgiavn.project01.web.model.Course;
import framgiavn.project01.web.ulti.Logit2;

public class CourseAction extends ActionSupport {
	
	CourseBusiness courseBusiness;
	Course course;
	public List<Course> courseList = new ArrayList<Course>();
	
	public CourseBusiness getCourseBusiness() {
		return courseBusiness;
	}
	public void setCourseBusiness(CourseBusiness courseBusiness) {
		this.courseBusiness = courseBusiness;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	public String listAllCourse() {
		
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String showCourse() {
		try {
			course = courseBusiness.findById(course.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String newCourse() {
		
		course.setStartDate(new Date());
		courseBusiness.addOrupdateCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String updateCourse() {
		
		courseBusiness.addOrupdateCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String destroyCourse() {
		courseBusiness.deleteCourse(course.getId());
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String editCoursePage() {
		try {
			course = courseBusiness.findById(course.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
