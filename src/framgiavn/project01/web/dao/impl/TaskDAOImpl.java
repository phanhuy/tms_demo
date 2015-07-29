package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.CourseDAO;
import framgiavn.project01.web.dao.TaskDAO;
import framgiavn.project01.web.model.Task;
import framgiavn.project01.web.ulti.Logit2;

public class TaskDAOImpl extends HibernateDaoSupport implements TaskDAO {

	private static final Logit2 log = Logit2.getInstance(CourseDAO.class);
	
	protected void initDao() {
		// do nothing
	}
	
	@Override
	public List<Task> listTaskBySubjectId(Integer id, boolean lock) {
		try {
			Query query = getSession().getNamedQuery("");
			if (lock)
				query.setLockMode("task", LockMode.UPGRADE);
			query.setParameter("id", id);
			return query.list();
		} catch (RuntimeException re) {
			log.error("get course by id failed", re);
			throw re;
		}
	}

}
