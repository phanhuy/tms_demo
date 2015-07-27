package framgiavn.project01.web.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;;;

public class UserAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<User> userList = new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	private UserBusiness userBusiness = null;
	private User user = null;
	private Map<String, Object> session;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findUserById() {
		try {
			user = userBusiness.findById(user.getId(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String findUserByName() {
		try {
			user = userBusiness.findByName(user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String homePage() {
		return SUCCESS;
	}

	public String login() {
		return SUCCESS;
	}

	public String dologin() throws Exception {
		String input_email = user.getEmail();
		String input_pass = user.getPassword();
		// System.out.println(input_email+" "+input_pass);
		user = userBusiness.login(input_email, input_pass);

		if (user == null) {
			session = ActionContext.getContext().getSession();
			session.put("logined", "false");
			return ERROR;
		} else {
			session = ActionContext.getContext().getSession();
			session.put("username", user.getName());
			session.put("userid", user.getId());
			session.put("logined", "true");
			session.put("context", (new Date()).toString());
			return SUCCESS;
		}
	}

	public String logout() {
		user = null;
		session = ActionContext.getContext().getSession();
		session.remove("update_success");
		session.remove("username");
		session.remove("userid");
		session.remove("logined");
		session.remove("context");
		return SUCCESS;
	}

	public String showUser() {
		try {
			user = userBusiness.findById(user.getId(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String editUserPage() {
		try {
			user = userBusiness.findById(user.getId(), false);			
			session = ActionContext.getContext().getSession();
			session.remove("update_success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateUser() throws Exception {
		System.out.println(user.getPassword() + " abc " + user.getConfirm_pass());		
		User userDB = userBusiness.findById(user.getId(), false);
		if (!Helpers.encryptMd5(user.getPassword()).equals(userDB.getPassword())) {
			session = ActionContext.getContext().getSession();
			session.put("update_success", "false");
			return ERROR;
		}

		userBusiness.updateUser(user);
		user = userBusiness.findById(user.getId(), false);

		return SUCCESS;
	}

	public String create() {
		user.setCreate_at(new Date());
		try {
			userBusiness.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewAll() {
		userList = userBusiness.listUser();
		return SUCCESS;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String text1 = request.getParameter("confirm_pass");
		System.out.println("confirm_pass: "+text1);
	}
}