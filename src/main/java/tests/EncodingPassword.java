package tests;

import org.apache.commons.codec.binary.Base64;

public class EncodingPassword {
    public static void main(String[] args) {
        String password = "secret_sauce";
        byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
        System.out.println("encoded password is " + encodedBytes);
        byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
        System.out.println("decoded password is " + new String(decodedBytes));
    }
}
