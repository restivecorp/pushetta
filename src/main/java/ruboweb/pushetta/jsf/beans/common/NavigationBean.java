package ruboweb.pushetta.jsf.beans.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.context.annotation.Scope;

@ManagedBean
@Scope("request")
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 713875872520755956L;

	private final String REDIRECT = "?faces-redirect=true";

	@ManagedProperty(value = "#{menuBean}")
	private MenuBean menuBean;

	public NavigationBean() {

	}

	public String goToDataControlPage() {
		this.menuBean.activeDataControl();
		return "/pages/dataControl" + REDIRECT;
	}

	public String goToUsersPage() {
		this.menuBean.activeUsers();
		return "/pages/users" + REDIRECT;
	}

	public String goToCreateNewUser() {
		this.menuBean.activeUsers();
		return "/pages/user/new" + REDIRECT;
	}

	public String goToCreateOnePage() {
		this.menuBean.activeCreationOne();
		return "/pages/createOne" + REDIRECT;
	}

	public String goToListReportsPage() {
		this.menuBean.activeListReports();
		return "/pages/listReports" + REDIRECT;
	}

	public String goToSendNotificationsPage() {
		this.menuBean.activeSendNotifications();
		return "/pages/sendNotifications" + REDIRECT;
	}

	public String goToApiRestPage() {
		this.menuBean.activeApi();
		return "/pages/apiRest" + REDIRECT;
	}

	public MenuBean getMenuBean() {
		return menuBean;
	}

	public void setMenuBean(MenuBean menuBean) {
		this.menuBean = menuBean;
	}
}
