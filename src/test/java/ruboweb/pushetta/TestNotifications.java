package ruboweb.pushetta;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ruboweb.pushetta.back.model.Notification;
import ruboweb.pushetta.back.model.User;
import ruboweb.pushetta.back.repository.UserRepository;
import ruboweb.pushetta.back.service.notification.NotificationService;

public class TestNotifications extends TestBase {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserRepository userRepository;
	
	private User u;
	
	public TestNotifications() {

	}

	@Test
	@Rollback(true)
	public void createNotifications() {
		Notification n = new Notification(this.u, "Simple text", "2015-12-01");
		n = this.notificationService.createNotification(n);

		TestCase.assertNotNull(n.getId());
		TestCase.assertNotNull(n.getCreationDate());
	}

	@Test
	public void deleteNotifications() {
		Notification n = new Notification(this.u, "Simple text", "2015-12-01");
		n = this.notificationService.createNotification(n);

		TestCase.assertNotNull(n.getId());

		List<Notification> ns = this.notificationService.getListNotifications();

		Notification n1 = ns.iterator().next();
		this.notificationService.deleteNotification(n1.getId());
		n1 = this.notificationService.findOneNotification(n1.getId());
		TestCase.assertNull(n1);
	}
	
	@Test
	public void createNotificationsAndSend() {
		Notification n = new Notification(this.u, "Simple text", "2015-12-01");
		this.notificationService.createNotificationAndSend(n);
		
		n = this.notificationService.findOneNotification(n.getId());
		TestCase.assertNotNull(n);
		TestCase.assertNotNull(n.getStatus());
		TestCase.assertNotNull(n.getTrySend());
	}

	@Test
	public void sendNotifications() {
		Notification n = new Notification(this.u, "Simple text", "2015-12-01");
		n = this.notificationService.createNotification(n);
		TestCase.assertNotNull(n.getId());

		this.notificationService.sendNotifications();
		n = this.notificationService.findOneNotification(n.getId());
		TestCase.assertNotNull(n);
		TestCase.assertNotNull(n.getStatus());
		TestCase.assertNotNull(n.getTrySend());
	}

	@Before
	public void createUser() {
		this.u = new User("Dummy");
		this.u = this.userRepository.save(u);
	}
}
