package ruboweb.pushetta.back.service.notification;

import java.util.List;

import ruboweb.pushetta.back.model.Notification;

public interface NotificationService {

	Notification createNotification(Notification n);
	
	Notification  createNotificationAndSend(Notification n);

	void deleteNotification(Long id);

	Notification findOneNotification(Long id);

	List<Notification> getListNotifications();
	List<Notification> getListNotificationsPending();
	List<Notification> getListNotificationsError();
	List<Notification> getListNotificationsSent();

	void sendNotifications();
	void sendNotificationsWithError();
}
