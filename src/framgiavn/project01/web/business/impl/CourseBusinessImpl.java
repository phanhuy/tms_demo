package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.model.*;
import framgiavn.project01.web.dao.*;

import java.util.List;
import java.util.Iterator;

import framgiavn.project01.web.business.CourseBusiness;

public class CourseBusinessImpl implements CourseBusiness {

	private CourseDAO courseDAO;
	private SubjectDAO subjectDAO;
	private SubjectCourseDAO subjectCourseDAO;
	
	private Course courseDB;
	private SubjectCourse subjectCourseDB;

	public SubjectCourseDAO getSubjectCourseDAO() {
		return subjectCourseDAO;
	}

	public void setSubjectCourseDAO(SubjectCourseDAO subjectCourseDAO) {
		this.subjectCourseDAO = subjectCourseDAO;
	}

	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	public Course getCourseDB() {
		return courseDB;
	}

	public void setCourseDB(Course courseDB) {
		this.courseDB = courseDB;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Course> listCourse() {
		return courseDAO.listCourse();
	}

	@Override
	public Course findById(Integer id) throws Exception {
		try{
			return getCourseDAO().findById(id, false);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteCourse(Integer id) {
		courseDAO.deleteCourse(id);
	}

	@Override
	public void addCourse(Course course) {
		courseDAO.addCourse(course);
		
	}

	@Override
	public void updateCourse(Course course) throws Exception {
		try {
			Course courseDB = courseDAO.findById(course.getId(), true);
			courseDB.setId(course.getId());
			courseDB.setName(course.getName());
			courseDB.setDetail(course.getDetail());
			courseDB.setStartDate(course.getStartDate());
			courseDB.setEndDate(course.getEndDate());
			
			courseDAO.updateCourse(courseDB);
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void addSubjectCourse(SubjectCourse subjectCourse) {
		subjectCourseDAO.addSubjectCourse(subjectCourse);
	}

	@Override
	public void removeSubjectCourse(Integer subject_id, Integer course_id) {
		subjectCourseDAO.removeSubjectCourse(subject_id, course_id);
	}

}
