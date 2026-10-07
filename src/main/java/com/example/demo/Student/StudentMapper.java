package com.example.demo.Student;

import com.example.demo.School.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {



    public Student toStudent(StudentDto studentDto){
        Student student = new Student();
        student.setEmail(studentDto.email());
        student.setFirstname(studentDto.firstname());
        student.setLastname(studentDto.lastname());

        School school = new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getAge()
        );
    }
}
