package ruboweb.pushetta.back.model;

import java.io.Serializable;

public class ApiDoc implements Serializable {

	private static final long serialVersionUID = -4025134791073968350L;

	private String method;
	private String url;
	private String example;

	public ApiDoc() {

	}

	public ApiDoc(String method, String url, String example) {
		super();
		this.method = method;
		this.url = url;
		this.example = example;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
