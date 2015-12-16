package ruboweb.pushetta.exception;

public class NotificatorException extends Exception {

	private static final long serialVersionUID = -2933206097927799095L;

	/**
	 * Error thar throws the exception
	 */
	private String error;

	/**
	 * Constructor
	 */
	public NotificatorException(String error) {
		super(error);
		this.error = error;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

}
