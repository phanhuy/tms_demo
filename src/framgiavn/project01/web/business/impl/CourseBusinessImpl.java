package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.model.Course;
import framgiavn.project01.web.dao.CourseDAO;

import java.util.List;

import framgiavn.project01.web.business.CourseBusiness;

public class CourseBusinessImpl implements CourseBusiness {

	private CourseDAO courseDAO;
	
	
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
			return getCourseDAO().findById(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void addOrupdateCourse(Course course) {
		courseDAO.addOrupdateCourse(course);
	}

	@Override
	public void deleteCourse(Integer id) {
		courseDAO.deleteCourse(id);
	}

}
