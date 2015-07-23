package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.hql.ast.util.SessionFactoryHelper;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.model.Course;
import framgiavn.project01.web.dao.CourseDAO;
import framgiavn.project01.web.ulti.Logit2;

public class CourseDAOImpl extends HibernateDaoSupport implements CourseDAO {
	
	private static final Logit2 log = Logit2.getInstance(CourseDAO.class);
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public List<Course> listCourse() {
		log.debug("List all course");
		try{
			Query query = getSession().getNamedQuery("Course.SelectCourseAll");
			return query.list();
		} catch (RuntimeException re) {
			log.error("List all course error!", re);
			throw re;
		}
	}

	@Override
	public Course findById(Integer id) throws Exception {
		log.debug("Find course by id");
		try {
			Query query = getSession().getNamedQuery("Course.SelectCourseById");
			query.setParameter("id", id);
			
			return (Course) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("Get failed", re);
			throw re;
		}
	}

	@Override
	public void addOrupdateCourse(Course course) {
		log.debug("Add or update course");
		try {
			getHibernateTemplate().saveOrUpdate(course);
		} catch (RuntimeException re) {
			log.error("Add or update failed", re);
			throw re;
		}
	}

	@Override
	public void deleteCourse(Integer id) {
		log.debug("Delete a course");
		try {
			Query query = getSession().getNamedQuery("Course.DeleteCourseById");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("Delete failed");
			throw re;
		}
	}
	

}
