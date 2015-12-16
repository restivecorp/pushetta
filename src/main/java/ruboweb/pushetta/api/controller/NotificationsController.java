package ruboweb.pushetta.api.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ruboweb.pushetta.back.model.Notification;
import ruboweb.pushetta.back.service.notification.NotificationService;

@Controller
@RequestMapping("/n")
public class NotificationsController {

	private final String HEADER_JSON = "Accept=application/json";

	private final String CREATE_NOTIFICATION = "/create";
	private final String CREATE_NOTIFICATION_AND_SEND = "/createSend";

	private final String GET_NOTIFICATION = "/get/{id}";
	private final String GET_NOTIFICATIONS = "/all";

	private final String GET_NOTIFICATION_PENDING = "/pending";
	private final String GET_NOTIFICATION_SENT = "/sent";
	private final String GET_NOTIFICATIONS_ERROR = "/error";

	private final String DELETE_NOTIFICATION = "/del/{id}";

	private final String SEND_NOTIFICATIONS_NOW = "/send";
	private final String SEND_NOTIFICATIONS_ERROR = "s/endError";

	@Autowired
	private NotificationService notificationService;

	public NotificationsController() {

	}

	@RequestMapping(value = "/dummy", method = RequestMethod.GET, headers = HEADER_JSON)
	public @ResponseBody
	Notification getDummy() {
		return new Notification("Dumy text", "2015-12-17");
	}

	@RequestMapping(value = CREATE_NOTIFICATION, method = RequestMethod.POST, headers = HEADER_JSON)
	public @ResponseBody
	Notification create(@RequestBody Notification param) {
		this.validate(param);
		param = this.notificationService.createNotification(param);
		return param;
	}

	@RequestMapping(value = CREATE_NOTIFICATION_AND_SEND, method = RequestMethod.POST, headers = HEADER_JSON)
	public void createAndSend(@RequestBody Notification param) {
		this.validate(param);
		this.notificationService.createNotificationAndSend(param);
	}

	@RequestMapping(value = GET_NOTIFICATION, method = RequestMethod.GET, headers = HEADER_JSON)
	public @ResponseBody
	Notification getNotification(@PathVariable("id") Long id) {
		if (id == null) {
			return null;
		}

		return this.notificationService.findOneNotification(id);
	}

	private void validate(Notification param) {
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
	}

	//
	// @RequestMapping(value = RestURIConstants.CREATE_LISTA_DESEOS, method =
	// RequestMethod.POST, headers = RestURIConstants.HEADER_JSON)
	// public @ResponseBody
	// ListaDeseos crearListaDeseos(@RequestBody ListaDeseos ld) {
	// ld = this.listaDeseosService.insertar(ld);
	// return ld;
	// }
	//
	// @RequestMapping(value = RestURIConstants.DELETE_LISTA_DESEOS, method =
	// RequestMethod.PUT, headers = RestURIConstants.HEADER_JSON)
	// public @ResponseBody
	// boolean borrarListaDeseos(@PathVariable("id") long id) {
	// ListaDeseos ld = this.listaDeseosService.obtenerListaDeseos(id);
	//
	// if (ld == null) {
	// return false;
	// }
	// this.listaDeseosService.borrar(ld);
	// return true;
	// }
	//
	// @RequestMapping(value = RestURIConstants.GET_LISTA_DESEOS, method =
	// RequestMethod.GET, headers = RestURIConstants.HEADER_JSON)
	// public @ResponseBody
	// ListaDeseos obtenerLista(@PathVariable("id") Long id) {
	// if (id == null) {
	// return null;
	// }
	//
	// return this.listaDeseosService.obtenerListaDeseos(id);
	// }
	//
	// @RequestMapping(value = RestURIConstants.GETALL_LISTA_DESEOS, method =
	// RequestMethod.GET, headers = RestURIConstants.HEADER_JSON)
	// public @ResponseBody
	// List<ListaDeseos> getAllListasDeseos() {
	// Collection<ListaDeseos> lldd = this.listaDeseosService.obtenerListas();
	//
	// if (lldd != null && lldd.size() > 0) {
	// return new ArrayList<ListaDeseos>(lldd);
	// }
	// return null;
	//
	// }

}
