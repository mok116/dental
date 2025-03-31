export interface PatientRegisterRequest {
  firstName: string;
  lastName: string;
  emailAddress: string;
  gender: 'M' | 'F';
  dob: string; // Format: YYYY-MM-DDTHH:mm:ss
  phone: string;
  password: string;
}

export interface PatientLoginRequest {
  emailAddress: string;
  password: string;
}

// Example request bodies:
/*
// Register
{
  "firstName": "John",
  "lastName": "Doe",
  "emailAddress": "john.doe@example.com",
  "gender": "M",
  "dob": "1990-01-01T00:00:00",
  "phone": "+1234567890",
  "password": "hashedPassword123"
}

// Login
{
  "emailAddress": "john.doe@example.com",
  "password": "hashedPassword123"
}
*/
