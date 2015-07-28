package framgiavn.project01.web.model;

import java.io.Serializable;

public class Task implements Serializable {
	
	private Integer id;
	private String name;
	private String detail;
	private Integer subject_id;
	private Subject subjects;
	
	public Subject getSubjects() {
		return subjects;
	}
	public void setSubjects(Subject subjects) {
		this.subjects = subjects;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

}
