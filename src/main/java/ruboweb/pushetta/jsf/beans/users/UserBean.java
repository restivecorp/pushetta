package ruboweb.pushetta.jsf.beans.users;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ruboweb.pushetta.back.model.User;
import ruboweb.pushetta.back.service.user.UserService;

@Component
@ManagedBean
@Scope("request")
public class UserBean implements Serializable {
	private static final long serialVersionUID = -6256321042881640010L;

	private List<User> users;

	@Autowired
	private UserService userService;

	public UserBean() {

	}

	@PostConstruct
	public void init() {
		this.users = this.userService.getUsers();

	}

	public List<User> getUsers() {
		return users;
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("User Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		User u = (User) event.getObject();
		this.userService.createOrUpdateUser(u);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
