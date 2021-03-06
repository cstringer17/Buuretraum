package buuretraum;

import java.security.NoSuchAlgorithmException;

import org.mindrot.jbcrypt.BCrypt;

import com.lambdaworks.crypto.SCryptUtil;

public class PasswordHasher {

	public PasswordHasher() throws NoSuchAlgorithmException {

	}

	public String createHash(String originalPassword) {
		  
		return SCryptUtil.scrypt(originalPassword, 16, 16, 16);
	}

	public boolean checkPassword(String originalPassword, String generatedSecuredPasswordHash) {
		return BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);

	}

}
