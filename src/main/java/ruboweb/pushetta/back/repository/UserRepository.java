package ruboweb.pushetta.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ruboweb.pushetta.back.model.User;

/**
 * CRUD Repository for the entity
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
