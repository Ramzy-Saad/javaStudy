package com.example.demo.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private  StudentService studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void save_student_successfully(){
        StudentDto dto = new StudentDto("Ramzy",
                "Saad",
                "ramzysaad137@gmail.com",
                1);
        Student student = new Student(20,
                "ramzysaad137@gmail.com",
                "Ramzy",
                "Saad"
                );
        Student savedStudent = new Student(20,
                "ramzysaad137@gmail.com",
                "Ramzy",
                "Saad"
                );
        savedStudent.setId(1);

        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto(
                "Ramzy",
                "Saad",
                "ramzysaad137@gmail.com",20
        ));


        StudentResponseDto studentResponseDto = studentService.saveStudent(dto);

        assertEquals(dto.firstname(),studentResponseDto.firstname());
        assertEquals(dto.lastname(),studentResponseDto.lastname());
        assertEquals(dto.email(),studentResponseDto.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);


    }
}