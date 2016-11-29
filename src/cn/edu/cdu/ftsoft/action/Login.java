package cn.edu.cdu.ftsoft.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.cdu.ftsoft.model.User;
import cn.edu.cdu.ftsoft.utils.Constants;


public class Login {
	private static final long serialVersionUID = 1L;
	private User user;

	private boolean isInvalid(String value){
		return (value == null || value.length() == 0);
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		System.out.println("action之中运行"
				+ "");
		if(isInvalid(user.getUsername())) return "input";
		if(isInvalid(user.getPassword())) return "input";
		if(this.user.getUsername().equals("dennis") && this.user.getPassword().equals("123")){
			ActionContext.getContext().getSession().put(Constants.USER_SESSION, user.getUsername());
			ActionContext.getContext().getSession().put(Constants.PASS, user.getPassword());
			return "success";
		}else{
			return "error";
		}
	}
}
