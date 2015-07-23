package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Course;

public interface CourseDAO {

	public List<Course> listCourse();
	
	public Course findById( Integer id) throws Exception;
	
	public void addOrupdateCourse(Course course);
	
	public void deleteCourse(Integer id);
	
	
}
