package com.emp.empmanagement.security;

public class SecurityConstants {
    //Set JWT expiration time as 8hrs and secret key
    public static final long JWT_Expiration = 28800000;
    public static final String JWT_Secret = "my_jwt_secret_is_very_long_and_secure_so_it_is_hard_to_guess_even_for_a_hacker";
}
