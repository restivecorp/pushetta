package ruboweb.pushetta.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ruboweb.pushetta.back.model.Notification;

/**
 * CRUD Repository for the entity
 */
@Repository
public interface NotificationRepository extends
		JpaRepository<Notification, Long> {

	@Query("select n from Notification n where n.status is null and n.scheduleDate <= CURRENT_DATE")
	public List<Notification> findNotificationsToSend();
	
	@Query("select n from Notification n where n.status like 'ERROR:%'")
	public List<Notification> findNotificationsWithError();
	
	@Query("select n from Notification n where n.status = 'SENT'")
	public List<Notification> findNotificationsSent();
}
