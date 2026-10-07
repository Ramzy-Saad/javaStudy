package com.example.demo.Student;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email,
        int age
) {
}
