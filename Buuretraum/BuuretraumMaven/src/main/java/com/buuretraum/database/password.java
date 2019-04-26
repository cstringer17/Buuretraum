package com.buuretraum.database;

import java.security.NoSuchAlgorithmException;

import org.mindrot.jbcrypt.BCrypt;

import com.lambdaworks.crypto.SCryptUtil;

public class password {

	public password() throws NoSuchAlgorithmException {

	}

	public String createHash(String originalPassword) {
		  
		return SCryptUtil.scrypt(originalPassword, 16, 16, 16);
	}

	public boolean checkPassword(String originalPassword, String generatedSecuredPasswordHash) {
		return BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);

	}

}
