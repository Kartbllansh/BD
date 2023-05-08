package DataBase;

import java.security.SecureRandom;

public class SaltGenerate {
    private static final int SALT_LENGTH = 16; // длина соли в байтах
    public static String saltGetter() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[SALT_LENGTH];
        random.nextBytes(saltBytes);
        return bytesToHex(saltBytes);
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }
}
