package ruboweb.pushetta.back.service.user;

import java.util.List;

import ruboweb.pushetta.back.model.User;

public interface UserService {

	User createOrUpdateUser(User u);

	User findOneUser(Long id);
	
	User findUserByToken(String token);

	List<User> getUsers();

}
