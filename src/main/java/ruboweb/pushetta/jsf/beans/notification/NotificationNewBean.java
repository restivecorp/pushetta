package ruboweb.pushetta.jsf.beans.notification;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ruboweb.pushetta.back.model.Notification;
import ruboweb.pushetta.back.model.User;
import ruboweb.pushetta.back.service.notification.NotificationService;
import ruboweb.pushetta.back.service.user.UserService;

@Component
@ManagedBean
@Scope("request")
public class NotificationNewBean implements Serializable {

	private static final long serialVersionUID = 4467268651302185316L;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	@NotNull
	private String text;

	private Date date = new Date(System.currentTimeMillis());

	private boolean send;

	@NotNull
	private Long user;

	private List<SelectItem> users;

	public NotificationNewBean() {

	}

	public void createNewNotification(ActionEvent actionEvent) {
		if (this.user != null) {
			User u = this.userService.findOneUser(this.user);

			Notification n = new Notification(u, this.text,
					new SimpleDateFormat("yyyy-MM-dd").format(this.date));

			if (this.send) {
				this.notificationService.createNotificationAndSend(n);
			} else {
				this.notificationService.createNotification(n);
			}
		}
	}

	@PostConstruct
	public void init() {
		List<User> usr = this.userService.getUsers();

		if (usr != null) {
			this.users = new ArrayList<SelectItem>();
			for (User u : usr) {
				this.users.add(new SelectItem(u.getId(), u.getName()));
			}
		}
	}

	public List<SelectItem> getUsers() {
		return this.users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

}
