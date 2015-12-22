package ruboweb.pushetta.jsf.beans.common;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;

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
public class TimeBean implements Serializable {

	private static final long serialVersionUID = 7870948882653500929L;

	private String year;
	private String month;
	private String day;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	public TimeBean() {
		GregorianCalendar cal = new GregorianCalendar();
		this.year = cal.get(Calendar.YEAR) + "";
		this.month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG,
				Locale.ENGLISH);
		this.month = this.month.substring(0, 3);
		this.day = cal.get(Calendar.DAY_OF_MONTH) + "";
	}

	public String getTotalNotifications() {
		List<Notification> n = this.notificationService.getListNotifications();
		if (n != null) {
			return n.size() + "";
		}
		return "0";
	}
	
	public String getTotalErrors() {
		List<Notification> n = this.notificationService.getListNotificationsError();
		if (n != null) {
			return n.size() + "";
		}
		return "0";
	}
	
	public String getTotalSent() {
		List<Notification> n = this.notificationService.getListNotificationsSent();
		if (n != null) {
			return n.size() + "";
		}
		return "0";
	}
	
	public String getTotalPending() {
		List<Notification> n = this.notificationService.getListNotificationsPending();
		if (n != null) {
			return n.size() + "";
		}
		return "0";
	}
	
	public String getTotalNotificationsPlanned() {
		List<Notification> n = this.notificationService.getListNotificationsSent();
		if (n != null) {
			return n.size() + "";
		}
		return "0";
	}
	

	public String getTotalUsers() {
		List<User> u = this.userService.getUsers();
		if (u != null) {
			return u.size() + "";
		}
		return "0";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
