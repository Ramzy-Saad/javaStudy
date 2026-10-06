package com.example.demo;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email,
        int age
) {
}
