package com.project.ecommerceproject.api.entity;

import jakarta.validation.constraints.*;

public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(min = 3,max = 80)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 6,max = 32)
    @Pattern( regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
