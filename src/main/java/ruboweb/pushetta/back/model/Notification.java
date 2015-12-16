package ruboweb.pushetta.back.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "notification")
public class Notification extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 48611217163723666L;

	@Column(nullable = false)
	private Date creationDate;

	@Column(nullable = false, length = 300)
	private String text;

	@Column(nullable = false)
	@Type(type = "date")
	private Date scheduleDate;

	@Column
	private String status;

	@Column
	private Date trySend;

	public Notification() {
		this.status = null;
		this.trySend = null;
		this.creationDate = new Date(System.currentTimeMillis());
	}

	public Notification(String text, Date scheduleDate) {
		text = text.replaceAll("\r", "");
		text = text.replaceAll("\n", "");
		this.text = text;
		this.scheduleDate = scheduleDate;
		this.creationDate = new Date(System.currentTimeMillis());
		this.status = null;
		this.trySend = null;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getTrySend() {
		return trySend;
	}

	public void setTrySend(Date trySend) {
		this.trySend = trySend;
	}

}
