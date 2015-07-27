package framgiavn.project01.web.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.Course;
import framgiavn.project01.web.model.Subject;

public class CourseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CourseBusiness courseBusiness;
	SubjectBusiness subjectBusiness;
	Course course;
	Subject subject;
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public SubjectBusiness getSubjectBusiness() {
		return subjectBusiness;
	}
	public void setSubjectBusiness(SubjectBusiness subjectBusiness) {
		this.subjectBusiness = subjectBusiness;
	}

	public List<Course> courseList = new ArrayList<Course>();
	public List<Subject> subjectCourseList = new ArrayList<Subject>();
	
	public List<Subject> getSubjectCourseList() {
		return subjectCourseList;
	}
	public void setSubjectCourseList(List<Subject> subjectCourseList) {
		this.subjectCourseList = subjectCourseList;
	}
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
			subjectCourseList = subjectBusiness.listSubjectByCoureId(course.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String newCourse() {
		course.setStartDate(new Date());
		courseBusiness.addCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String updateCourse() throws Exception {		
		courseBusiness.updateCourse(course);
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
