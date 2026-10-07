package com.example.demo.Student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private  StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentToStudent(){
        StudentDto dto = new StudentDto("Ramzy",
                "Saad",
                "ramzysaad137@gmail.com",
                1);
        Student student = studentMapper.toStudent(dto);
        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(),student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentResponseDTO(){
        Student student = new Student(2,"ramzysaad137@gmail.com","Saad","Ramzy");
        StudentResponseDto studentResponseDto = studentMapper.toStudentResponseDto(student);
        assertEquals(student.getFirstname(),studentResponseDto.firstname());
        assertEquals(student.getLastname(),studentResponseDto.lastname());
        assertEquals(student.getEmail(),studentResponseDto.email());
        assertEquals(student.getAge(),studentResponseDto.age());
    }
}