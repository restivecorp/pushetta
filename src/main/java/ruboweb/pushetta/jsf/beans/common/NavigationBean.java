package ruboweb.pushetta.jsf.beans.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 713875872520755956L;

	@ManagedProperty(value = "#{menuBean}")
	private MenuBean menuBean;

	public NavigationBean() {

	}

	public String goToDataControlPage() {
		this.menuBean.activeDataControl();
		return "/pages/dataControl";
	}
	
	public String goToUsersPage() {
		this.menuBean.activeUsers();
		return "/pages/users";
	}
	
	public String goToCreateOnePage() {
		this.menuBean.activeCreationOne();
		return "/pages/createOne";
	}
	
	public String goToListReportsPage() {
		this.menuBean.activeListReports();
		return "/pages/listReports";
	}
	
	public String goToSendNotificationsPage() {
		this.menuBean.activeSendNotifications();
		return "/pages/sendNotifications";
	}
	
	public String goToApiRestPage() {
		this.menuBean.activeApi();
		return "/pages/apiRest";
	}

	public MenuBean getMenuBean() {
		return menuBean;
	}

	public void setMenuBean(MenuBean menuBean) {
		this.menuBean = menuBean;
	}
}
