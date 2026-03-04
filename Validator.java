/*
This class is responsible for validating user input and hashing passwords.
It provides methods to validate email addresses and phone numbers
As well as a method to hash passwords using SHA-256.

Version: 1.0
Author: Shrivatsa Guru
 */
public class Validator {

    public boolean validateEmail(String email) throws ValidationException {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new ValidationException("Invalid email format");
        }
        return true;
    }

    public boolean validatePhoneNumber(int phoneNumber) throws ValidationException {
        String phoneRegex = "^[0-9]{10}$";
        if (!String.valueOf(phoneNumber).matches(phoneRegex)) {
            throw new ValidationException("Invalid phone number format");
        }
        return true;
    }

    public String hashPassword(String password) throws ValidationException {
        try {
            byte[] hashed = java.security.MessageDigest
                    .getInstance("SHA-256")
                    .digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            return java.util.HexFormat.of().formatHex(hashed);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new ValidationException("Error occurred while hashing password");
        }
    }
}
