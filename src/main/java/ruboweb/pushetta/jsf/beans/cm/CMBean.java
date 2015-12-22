package ruboweb.pushetta.jsf.beans.cm;

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
public class CMBean implements Serializable {

	private static final long serialVersionUID = -4865002355748577895L;

	@Autowired
	private NotificationService notificationService;

	public CMBean() {

	}

	@PostConstruct
	public void init() {

	}

	public int getTotalErrors() {
		List<Notification> n = this.notificationService
				.getListNotificationsError();
		if (n != null) {
			return n.size();
		}
		return 0;
	}

	public int getTotalSent() {
		List<Notification> n = this.notificationService
				.getListNotificationsSent();
		if (n != null) {
			return n.size();
		}
		return 0;
	}

}
