package framgiavn.project01.web.business.impl;

import java.util.Date;
import java.util.List;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;


public class UserBusinessImpl  implements UserBusiness  {

	private UserDAO userDAO;
		
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public User findById(Integer id, Boolean lock) throws Exception {
		try {
			return getUserDAO().findById(id,lock);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public User findByName(String name) throws Exception {
		try {
			return getUserDAO().findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public User findByEmail(String email) throws Exception {
		try {
			return getUserDAO().findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public User login(String email, String pass) throws Exception {
		if (pass.equals("") || email.equals("")) {			
			return null;
		}		
		User user = getUserDAO().findByEmail(email);
		System.out.println(Helpers.encryptMd5(pass));		
		if (user != null && user.getPassword().equals(Helpers.encryptMd5(pass))) {
			System.out.println();
			return user;
		}
		return null;
	}

	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);	
	}

	@Override
	public void updateUser(User user) throws Exception {
		try {
			
			User userDB = userDAO.findById(user.getId(), true);			
			userDB.setId(user.getId());
			userDB.setName(user.getName());
			userDB.setEmail(user.getEmail());			
			userDB.setSuppervisor(user.getSuppervisor());
			userDB.setUpdate_at(new Date());
			user.setCreate_at(user.getCreate_at());			
			//userDAO.updateUser(userDB);
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void deleteUser(Integer id) throws Exception {
		userDAO.deleteUser(id);		
	}

	@Override
	public List<User> listUser() {
		return userDAO.listUser();		
	}
}