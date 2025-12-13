This project is a **Spring Boot-based Employee Management System** that uses **JWT (JSON Web Token)** for stateless authentication and authorization. Below is a summary of its key components:

### 1. **Authentication and Authorization**
- **JWT Authentication**:
    - Tokens are generated using `JWTGenerator` and validated in `JWTAuthenticationFilter`.
    - Tokens include user details and are signed with a secret key.
- **Security Configuration**:
    - Configured in `SecurityConfig` with stateless session management.
    - Endpoints under `/api/auth/**` are publicly accessible, while others require authentication.
    - `JwtAuthEntryPoint` handles unauthorized access attempts.

### 2. **Controllers**
- **`AuthController`**:
    - Handles user login (`/api/auth/login`) and registration (`/api/auth/register`).
    - On login, authenticates the user and returns a JWT token.
    - On registration, saves new users with encoded passwords and default roles.

### 3. **Repositories**
- **`UserRepository`**:
    - Provides methods to find users by username and check if a username exists.
- **`RoleRepository`**:
    - Used to fetch roles (e.g., "USER") for assigning to new users.

### 4. **User Details Service**
- **`CustomUserDetailsService`**:
    - Implements `UserDetailsService` to load user details from the database.
    - Maps user roles to Spring Security authorities.

### 5. **Entities**
- **`UserEntity`**:
    - Represents users with fields like `username`, `password`, and `roles`.
- **`Role`**:
    - Represents user roles (e.g., "USER", "ADMIN").

### 6. **Security Constants**
- `SecurityConstants` defines the JWT expiration time and secret key.

### 7. **Build and Configuration**
- Built with **Maven**.
- `.gitignore` excludes build artifacts, IDE-specific files, and other unnecessary files.

This project ensures secure, stateless authentication for managing employee-related operations.