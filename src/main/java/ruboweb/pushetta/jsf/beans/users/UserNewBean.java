package ruboweb.pushetta.jsf.beans.users;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ruboweb.pushetta.back.model.User;
import ruboweb.pushetta.back.service.user.UserService;

@Component
@ManagedBean
@Scope("request")
public class UserNewBean implements Serializable {
	private static final long serialVersionUID = -6256321042881640010L;

	@Autowired
	private UserService userService;

	@NotNull
	private String name;

	public UserNewBean() {

	}

	public void createNewUser(ActionEvent actionEvent) {
		User u = new User(this.name);
		this.userService.createOrUpdateUser(u);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
