package com.example.demo.squaregames.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserAuthDTO(
        @NotBlank(message = "Name cannot be blank")
        String username,
        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 18, message = "Password must be between 6 and 18 characters")
        String password,
        int id) {
}
