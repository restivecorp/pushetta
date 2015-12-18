package ruboweb.pushetta.back.service.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruboweb.pushetta.back.model.User;
import ruboweb.pushetta.back.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User createOrUpdateUser(User u) {
		if (u == null) {
			throw new IllegalArgumentException(
					"UserServiceImpl#createUser u must not be null");
		}

		return this.userRepository.save(u);
	}

	@Override
	public User findOneUser(Long id) {
		if (id == null) {
			throw new IllegalArgumentException(
					"UserServiceImpl#findOneUser id must not be null");
		}
		return this.userRepository.findOne(id);
	}

	@Override
	public User findUserByToken(String token) {
		if (token == null) {
			throw new IllegalArgumentException(
					"UserServiceImpl#findUserByToken token must not be null");
		}
		
		if (token.isEmpty()) {
			throw new IllegalArgumentException(
					"UserServiceImpl#findUserByToken token must not be empty");
		}
		return this.userRepository.findUserByToken(token);
	}
	
	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}



}
