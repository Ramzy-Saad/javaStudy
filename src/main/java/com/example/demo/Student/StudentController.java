package com.example.demo.Student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("students")
    public List<StudentResponseDto> findStudents(){
        return studentService.findStudents();
    }

    @GetMapping("students/{student-id}")
    public StudentResponseDto findStudentById( @PathVariable("student-id") Integer id){
        return studentService.findStudentById(id);
    }

    @PutMapping("students/{student-id}")
    public StudentResponseDto updateStudentById( @PathVariable("student-id") Integer id,@RequestBody Student updatedStudent){
        return studentService.updateStudentById(id, updatedStudent);
    }

    @DeleteMapping("students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById( @PathVariable("student-id") Integer id){
        studentService.deleteStudentById(id);
    }

    @GetMapping("students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName (@PathVariable("student-name") String name){
        return studentService.findStudentByName(name);
    }

}
