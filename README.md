# Employee-Payroll-App- UC1- Use Case 1

A simple Java console application that demonstrates basic object‑oriented principles and user input validation while performing an employee registration use case. The program collects employee details, validates the data (email and phone number), hashes passwords, and stores the records in an in‑memory repository.

## Features

- Employee entity with encapsulated fields
- Input validation for email and 10‑digit phone numbers
- SHA‑256 password hashing using the `Validator` utility
- Simple repository for storing and retrieving employees by ID or name
- Custom `ValidationException` for error handling
