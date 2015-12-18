package ruboweb.pushetta.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ruboweb.pushetta.back.model.Notification;
import ruboweb.pushetta.back.model.User;
import ruboweb.pushetta.back.service.notification.NotificationService;
import ruboweb.pushetta.back.service.user.UserService;

@Controller
@RequestMapping("/notify")
public class NotificationsController {

	private final String HEADER_JSON = "Accept=application/json";

	// create
	private final String CREATE_NOTIFICATION = "/create";
	private final String CREATE_NOTIFICATION_AND_SEND = "/createSend";

	// finds
	private final String GET_NOTIFICATION = "/get/{id}";
	private final String GET_NOTIFICATIONS = "/by/{status}";

	// delte
	private final String DELETE_NOTIFICATION = "/delete/{id}";

	// send
	private final String SEND_NOTIFICATIONS = "/send/{kind}";

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;
	
	public NotificationsController() {

	}

	@RequestMapping(value = CREATE_NOTIFICATION, method = RequestMethod.POST, headers = HEADER_JSON)
	public @ResponseBody
	Notification create(@RequestHeader("Auth") String token, @RequestBody Notification param) {
		param = this.validate(param, token);
		param = this.notificationService.createNotification(param);
		return param;
	}

	@RequestMapping(value = CREATE_NOTIFICATION_AND_SEND, method = RequestMethod.POST, headers = HEADER_JSON)
	public @ResponseBody
	Notification createAndSend(@RequestHeader("Auth") String token, @RequestBody Notification param) {
		param = this.validate(param, token);
		param = this.notificationService.createNotificationAndSend(param);
		return param;
	}

	@RequestMapping(value = GET_NOTIFICATION, method = RequestMethod.GET, headers = HEADER_JSON)
	public @ResponseBody
	Notification getNotification(@PathVariable("id") Long id) {
		if (id == null) {
			throw new IllegalArgumentException(
					"NotificationsController#getNotification. id must not be null.");
		}

		return this.notificationService.findOneNotification(id);
	}

	@RequestMapping(value = GET_NOTIFICATIONS, method = RequestMethod.GET, headers = HEADER_JSON)
	public @ResponseBody
	List<Notification> getNotifications(@PathVariable("status") String status) {
		if (status == null) {
			throw new IllegalArgumentException(
					"NotificationsController#getNotificationsByStatus. status must not be null.");
		}

		List<Notification> notifications = null;

		if (status.toUpperCase().equals("PENDING")) {
			notifications = this.notificationService
					.getListNotificationsPending();
		}

		if (status.toUpperCase().equals("SENT")) {
			notifications = this.notificationService.getListNotificationsSent();
		}

		if (status.toUpperCase().equals("ERROR")) {
			notifications = this.notificationService
					.getListNotificationsError();
		}

		if (status.toUpperCase().equals("ALL")) {
			notifications = this.notificationService.getListNotifications();
		}

		if (notifications != null && notifications.size() > 0) {
			return new ArrayList<Notification>(notifications);
		}
		return null;
	}

	@RequestMapping(value = DELETE_NOTIFICATION, method = RequestMethod.GET, headers = HEADER_JSON)
	public void deleteNotification(@PathVariable("id") Long id) {
		if (id == null) {
			throw new IllegalArgumentException(
					"NotificationsController#deleteNotification. id must not be null.");
		}

		Notification n = this.notificationService.findOneNotification(id);

		if (n != null) {
			this.notificationService.deleteNotification(id);
		}
	}

	@RequestMapping(value = SEND_NOTIFICATIONS, method = RequestMethod.GET, headers = HEADER_JSON)
	public void sendNotifications(@PathVariable("kind") String kind) {
		if (kind == null) {
			throw new IllegalArgumentException(
					"NotificationsController#sendNotifications. kind must not be null.");
		}

		if (kind.isEmpty()) {
			throw new IllegalArgumentException(
					"NotificationsController#sendNotifications. kind must not be empty.");
		}

		if (kind.toUpperCase().equals("ERROR")) {
			this.notificationService.sendNotificationsWithError();
		}

		if (kind.toUpperCase().equals("PENDING")) {
			this.notificationService.sendNotifications();
		}
	}

	private Notification validate(Notification param, String token) {
		if (param == null) {
			throw new IllegalArgumentException(
					"NotificationsController#validate. notification must not be null.");
		}
		if (param.getText() == null) {
			throw new IllegalArgumentException(
					"NotificationsController#validate. text must not be null.");
		}

		if (param.getText().isEmpty()) {
			throw new IllegalArgumentException(
					"NotificationsController#validate. text must not be empty.");
		}

		if (param.getScheduleDate() == null) {
			throw new IllegalArgumentException(
					"NotificationsController#validate. date must not be null.");
		}
		
		User u = this.userService.findOneUser(1L);
		
		if (u == null ){
			throw new IllegalArgumentException(
					"NotificationsController#validate. token not valid.");
		}
		
		param.setUser(u);
		return param;
	}

}
