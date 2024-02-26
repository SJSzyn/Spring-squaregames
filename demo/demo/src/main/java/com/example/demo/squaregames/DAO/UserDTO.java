package com.example.demo.squaregames.DAO;

import java.util.UUID;

public record UserDTO(UUID id, String firstName, String lastName, int age) {

}
