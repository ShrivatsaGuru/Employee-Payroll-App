/*
This class defines a custom exception called ValidationException, 
which extends the built-in Exception class.
It is used to signal validation errors in the application, 
such as invalid email formats or phone numbers

Version: 1.0
Author: Shrivatsa Guru
 */
package validation;
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
