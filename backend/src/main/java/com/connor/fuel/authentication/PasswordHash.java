package com.connor.fuel.authentication;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHash {

    /**
     * Hashes a plaintext password using the SHA256 algorithm.
     * @param plaintextPassword the plaintext password.
     * @return the hashed password.
     */
    public static String hashPasswordSHA256(String plaintextPassword) {
        return DigestUtils.sha256Hex(plaintextPassword);
    }

    /**
     * Checks that a given plaintext password matches the content of a SHA 265 hashed password.
     * @param plaintextPassword the plaintext password
     * @param hashedPassword the hashed password
     * @return a boolean stating whether the passwords match
     */
    public static boolean checkPasswordMatchesHash(String plaintextPassword, String hashedPassword) {
        String newHashedPassword = hashPasswordSHA256(plaintextPassword);
        return newHashedPassword.equals(hashedPassword);
    }

}
