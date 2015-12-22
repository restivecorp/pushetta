package ruboweb.pushetta.jsf.beans.notification;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ruboweb.pushetta.back.model.Notification;
import ruboweb.pushetta.back.service.notification.NotificationService;

@Component
@ManagedBean
@Scope("request")
public class NotificationBean implements Serializable {

	private static final long serialVersionUID = 4104066566471065698L;

	private List<Notification> notifications;

	@Autowired
	private NotificationService notificationService;

	public NotificationBean() {

	}

	@PostConstruct
	public void init() {
		this.notifications = this.notificationService.getListNotifications();

	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

}
