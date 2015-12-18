package ruboweb.pushetta.back.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "user")
public class User extends AbstractPersistable<Long> {
	private static final Logger logger = LoggerFactory.getLogger(User.class);

	private static final long serialVersionUID = 6088280461151862299L;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String token;

	public User() {

	}

	public User(String name) {
		this.name = name;
		this.token = this.generateToken();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	private String generateToken() {
		try {
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			String randomNum = new Integer(prng.nextInt()).toString();
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] bytes = sha.digest(randomNum.getBytes());
			StringBuilder result = new StringBuilder();
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			byte b;
			for (int idx = 0; idx < bytes.length; ++idx) {
				b = bytes[idx];
				result.append(digits[(b & 240) >> 4]);
				result.append(digits[b & 15]);
			}

			return result.toString();
		} catch (NoSuchAlgorithmException ex) {
			logger.error("generateToken() -- " + ex.getMessage());
		}
		return null;
	}
}
