package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Task;

public interface TaskDAO {
	
	public List<Task> listTaskBySubjectId(Integer id, boolean lock); 
}
