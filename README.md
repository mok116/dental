# Dental Clinic API Documentation

## Overview
The Dental Clinic API is a RESTful API designed to manage operations for a dental clinic, including appointments, clinics, dentists, patients, and blog posts. This API interacts with a MariaDB database (`dental`) and provides endpoints for creating, retrieving, and managing dental-related data. The API is tested and documented using a Postman collection (`dental.postman_collection.json`) to facilitate development and integration.

## Purpose
This README provides instructions for using the API, setting up the environment, and leveraging the Postman collection to test endpoints. It complements the database schema and API specifications, offering a practical guide for developers.

## API Base URL
- **Local Development**: `http://localhost:6616`

## Authentication
- **Bearer Token (JWT)**: Required for protected endpoints (e.g., appointment creation, patient-specific data). The token is included in the `Authorization` header as `Bearer <token>`.
  - Example: `Authorization: Bearer eyJhbGciOiJIUzM4NCJ9...`
- **Public Endpoints**: Endpoints like `/blog/list`, `/clinic/list`, and `/item/list` do not require authentication.
- **Patient Authentication**: Use `/patient/login` to obtain a JWT token by providing `emailAddress` and `password`.

## Key Endpoints
The API provides endpoints for managing various entities in the dental clinic system. Below is a summary of key endpoints based on the Postman collection:

### Items
- **GET /item/list**: Retrieves a list of all dental services (e.g., Teeth Cleaning, Tooth Extraction).

### Dentists
- **GET /dentist/list**: Lists all dentists.
- **GET /dentist/{id}**: Retrieves details of a specific dentist by ID (e.g., `/dentist/1`).

### Dentist Items
- **GET /dentistItem/list**: Lists all dentist-service associations with fees.
- **GET /dentistItem/{id}**: Retrieves a specific dentist-service association by ID.
- **GET /dentistItem/dentist/{id}**: Lists services offered by a specific dentist (e.g., `/dentistItem/dentist/1`).
- **GET /dentistItem/item/{id}**: Lists dentists offering a specific service (e.g., `/dentistItem/item/1`).

### Clinics
- **GET /clinic/list**: Lists all clinics.
- **GET /clinic/{id}**: Retrieves details of a specific clinic by ID (e.g., `/clinic/1`).

### Clinic Dentists
- **GET /clinicDentist/list**: Lists all dentist schedules across clinics.
- **GET /clinicDentist/{id}**: Retrieves a specific dentist schedule by ID.
- **GET /clinicDentist/dentist/{id}**: Lists schedules for a specific dentist.
- **GET /clinicDentist/clinic/{id}**: Lists schedules for a specific clinic.
- **GET /clinicDentist/timeslot/{id}**: Lists schedules for a specific time slot.

### Patients
- **POST /patient/register**: Registers a new patient.
  - Example Body:
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "emailAddress": "john.doe@example.com",
      "password": "password123",
      "phone": "1234567890",
      "gender": "M",
      "dob": "1990-01-01T00:00:00"
    }
    ```
- **POST /patient/login**: Authenticates a patient and returns a JWT token.
  - Example Body:
    ```json
    {
      "emailAddress": "john.doe@example.com",
      "password": "password123"
    }
    ```
- **POST /patient/edit**: Updates patient details.
  - Example Body:
    ```json
    {
      "id": 1,
      "firstName": "JohnEdit",
      "lastName": "Doe",
      "emailAddress": "john.doe@example.com",
      "password": "password123",
      "phone": "1234567890",
      "gender": "M",
      "dob": "1990-01-01T00:00:00"
    }
    ```
- **GET /patient/{id}**: Retrieves patient details by ID (requires authentication).
- **POST /patient/forgot-password**: Initiates password reset by sending a code to the provided email.
  - Example Body:
    ```json
    {"email": "john.doe@example.com"}
    ```
- **POST /patient/reset-password**: Resets the password using the provided code.
  - Example Body:
    ```json
    {
      "email": "john.doe@example.com",
      "code": "<your_code>",
      "newPassword": "newpassword123"
    }
    ```

### Appointments
- **POST /appointment/create**: Creates a new appointment (requires authentication).
  - Example Body:
    ```json
    {
      "patientId": 1,
      "clinicDentistId": 2,
      "appointmentDate": "2025-05-24T10:00:00",
      "totalAmount": 150,
      "status": "PENDING",
      "appointmentItems": [
        {"id": 0, "dentistItemId": 1},
        {"id": 0, "dentistItemId": 2}
      ]
    }
    ```
- **GET /appointment/list**: Lists all appointments (requires authentication).
- **GET /appointment/{id}**: Retrieves details of a specific appointment (requires authentication).
- **GET /appointment/patient/{id}**: Lists appointments for a specific patient (requires authentication).
- **GET /appointment/clinicId/{clinicId}/dentistId/{dentistId}/appointmentDate/{date}**: Checks appointment availability for a specific clinic, dentist, and date (requires authentication).

### Blogs
- **GET /blog/list**: Lists all blog posts.
- **GET /blog/{id}**: Retrieves details of a specific blog post by ID (e.g., `/blog/1`).

## Setup Instructions

### Prerequisites
- **MariaDB**: Version 10.4.28 or compatible, hosting the `dental` database.
- **API Server**: Running on `http://localhost:6616` (e.g., implemented in Node.js, PHP, or Python).
- **Postman**: For testing the API using the provided collection.

### Database Setup
1. Execute the SQL script (`init_include_table_data.sql`) to create and populate the `dental` database:
   ```bash
   mysql -u [username] -p < init_include_table_data.sql
   ```
2. Verify the database:
   ```bash
   mysql -u [username] -p -e "USE dental; SHOW TABLES;"
   ```

### API Server Setup
1. Ensure the API server is running on `http://localhost:6616`.
2. Configure the server to connect to the `dental` database using appropriate credentials.
3. Implement JWT authentication for protected endpoints (e.g., using a secret key for token generation).

### Using the Postman Collection
1. **Import the Collection**:
   - Open Postman.
   - Click **Import** and upload `dental.postman_collection.json`.
   - The collection will appear under the **Collections** tab.

2. **Test Endpoints**:
   - Select an endpoint (e.g., `GET /item/list`).
   - Ensure the server is running at `http://localhost:6616`.
   - Send the request and verify the response.
   - For protected endpoints (e.g., `/appointment/create`), update the `Bearer Token` in the **Authorization** tab with a valid JWT obtained from `/patient/login`.

3. **Environment Variables** (Optional):
   - Create a Postman environment to manage the base URL and token:
     - Add a variable `base_url` with value `http://localhost:6616`.
     - Add a variable `token` and update it after a successful `/patient/login` request.
   - Update endpoint URLs to use `{{base_url}}` (e.g., `{{base_url}}/item/list`).

## Notes
- **Authentication**: Most endpoints in the Postman collection are marked as `noauth`, but appointment-related endpoints require a valid JWT. Ensure you authenticate via `/patient/login` before testing these.
- **Error Handling**: The API returns standard HTTP status codes (e.g., 200, 400, 401, 404) with JSON error messages.
- **Database Constraints**: The `dental` database uses foreign key constraints (e.g., `ON DELETE CASCADE`), so ensure valid IDs are used in requests.
- **Testing**: Use the Postman collection to test all endpoints systematically, starting with public endpoints (`/item/list`, `/blog/list`) and progressing to authenticated ones.

## Contributing
To contribute to the API or documentation:
1. Fork the repository (if applicable).
2. Create a new branch for your changes.
3. Update the Postman collection or API implementation as needed.
4. Submit a pull request with a detailed description of your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.