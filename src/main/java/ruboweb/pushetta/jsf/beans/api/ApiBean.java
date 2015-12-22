package ruboweb.pushetta.jsf.beans.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

import ruboweb.pushetta.back.model.ApiDoc;

@ManagedBean
@Scope("request")
public class ApiBean implements Serializable {

	private static final long serialVersionUID = 2456945976945761141L;

	private List<ApiDoc> docs;

	public ApiBean() {

	}

	@PostConstruct
	public void init() {
		this.docs = new ArrayList<ApiDoc>();
		this.docs.add(new ApiDoc("POST", "/rest/notify/create", "Body: {\"text\":\"Dumy text\", \"scheduleDate\":\"2015-12-01\"}"));
		this.docs.add(new ApiDoc("POST", "/rest/notify/createSend", "Body: {\"text\":\"Dumy text\", \"scheduleDate\":\"2015-12-01\"}"));
		this.docs.add(new ApiDoc("GET", "/rest/notify/get/{id}", ""));
		this.docs.add(new ApiDoc("PUT", "/rest/notify/delete/{id}", ""));
		this.docs.add(new ApiDoc("GET", "/rest/notify/by/{status}", "Valid status >> PENDING | SENT | ERROR | ALL"));
		this.docs.add(new ApiDoc("GET", "/rest/notify/send/{kind}", "Valid kinds >> PENDING | ERROR"));
	}

	public List<ApiDoc> getDocs() {
		return docs;
	}

}
