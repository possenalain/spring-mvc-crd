package com.nalain.services.security;

public interface EncryptionService {
    String encryptString(String input);
    Boolean checkPassword(String plainPassword,String encryptedPassword);
}
