package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.SubjectCourse;

public interface SubjectCourseDAO {
	
	public void addSubjectCourse(SubjectCourse subjectCourse);
	
	public void removeSubjectCourse(Integer subject_id, Integer course_id);

}
