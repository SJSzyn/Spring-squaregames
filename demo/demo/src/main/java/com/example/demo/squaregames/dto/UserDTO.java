package com.example.demo.squaregames.dto;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record UserDTO(
        @NotBlank @Size(min = 2, max = 15) String firstName,
        @NotBlank @Size(min = 2, max = 15) String lastName,
        @NotNull @Min(0) @Max(122) int age,
        int id){

}
