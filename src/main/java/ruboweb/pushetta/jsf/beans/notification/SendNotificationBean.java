package ruboweb.pushetta.jsf.beans.notification;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ruboweb.pushetta.back.service.notification.NotificationService;

@Component
@ManagedBean
@Scope("request")
public class SendNotificationBean implements Serializable {

	private static final long serialVersionUID = -5973596528592865176L;

	@Autowired
	private NotificationService notificationService;

	public SendNotificationBean() {

	}

	public void send(ActionEvent actionEvent) {
		this.notificationService.sendNotifications();
		this.addMessage("Notifications Sent!!!");
	}

	public void forward(ActionEvent actionEvent) {
		this.notificationService.sendNotificationsWithError();
		this.addMessage("Notifications Forward!!!");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
