package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.SubjectBusiness;
import framgiavn.project01.web.dao.SubjectDAO;
import framgiavn.project01.web.model.Subject;

class SubjectBusinessImpl implements SubjectBusiness {
	
	private SubjectDAO subjectDAO;
	
	private Subject subjectDB;

	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}


	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}


	@Override
	public List<Subject> listSubjectByCoureId(Integer id) {
		return getSubjectDAO().listSubjectByCoureId(id, false);		
	}


	@Override
	public List<Subject> listSubject() {
		return subjectDAO.listSubject();
	}


	@Override
	public void addSubject(Subject subject) {
		subjectDAO.addSubject(subject);
	}


	@Override
	public void updateSubject(Subject subject) throws Exception {
		try {
			Subject subjectDB = subjectDAO.findById(subject.getId(), true);
			subjectDB.setId(subject.getId());
			subjectDB.setName(subject.getName());
			subjectDB.setDetail(subject.getDetail());
			
			subjectDAO.updateSubject(subjectDB);
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public void deleteSubject(Integer id) {
		subjectDAO.deleteSubject(id);
	}


	@Override
	public Subject findById(Integer id) throws Exception {
		try{
			return getSubjectDAO().findById(id, false);
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public List<Subject> listTaskById(Integer id) {
		return getSubjectDAO().listTaskById(id, false);
	}
	
}
