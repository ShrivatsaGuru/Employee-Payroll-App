/*
This class is responsible for validating user input and hashing passwords.
It provides methods to validate email addresses and phone numbers
As well as a method to hash passwords using SHA-256.

Version: 1.0
Author: Shrivatsa Guru
 */
package validation;
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

}
