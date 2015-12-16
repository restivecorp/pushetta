package ruboweb.pushetta.back.service.notification;

import java.util.List;

import ruboweb.pushetta.back.model.Notification;

public interface NotificationService {

	Notification createNotification(Notification n);
	
	void createNotificationAndSend(Notification n);

	void deleteNotification(Long id);

	Notification findOneNotification(Long id);

	public List<Notification> getListNotifications();

	void sendNotifications();
}
