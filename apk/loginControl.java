package apk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class loginControl {
    private boolean authority;

    static boolean validasiIDdanPassword(String NIP, String pwd) {
        if (isAlphanumeric(NIP) && isAlphanumeric(pwd)) {
            String passwordToHash = pwd;
            String generatedPassword = null;
            try {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Add password bytes to digest
                md.update(passwordToHash.getBytes());
                //Get the hash's bytes
                byte[] bytes = md.digest();
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                //Get complete hashed password in hex format
                generatedPassword = sb.toString();
                boolean authentication = login_entity.matchingUserInDatabase(NIP, generatedPassword);
                return authentication;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

    }

    static boolean isAlphanumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
                return false;
        }

        return true;
    }

}
