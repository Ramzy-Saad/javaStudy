package com.example.demo.Student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        @NotEmpty(message = "First name is required field.")
        String firstname,
        @NotEmpty(message = "Second name is required field.")
        String lastname,
        String email,
        Integer schoolId
) {

}
