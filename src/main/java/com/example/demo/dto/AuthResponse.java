package com.example.demo.dto;

public class AuthResponse {
    private String message;
    private boolean success;
    private String name;
    private String email;
    private String role;

    public AuthResponse() {}

    public AuthResponse(String message, boolean success, String name, String email, String role) {
        this.message = message;
        this.success = success;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
