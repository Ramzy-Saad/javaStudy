package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;


    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto){
        var student = studentMapper.toStudent(studentDto);
        Student studentRepo = repository.save(student);
        return studentMapper.toStudentResponseDto(studentRepo);
    }

    public List<Student> findStudents(){
        return repository.findAll();
    }

    public Student findStudentById(Integer id){
        return repository.findById(id).orElse(new Student());
    }

    public Student updateStudentById( Integer id,Student updatedStudent){
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstname(updatedStudent.getFirstname());
        student.setLastname(updatedStudent.getLastname());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());
        return repository.save(student);
    }

    public void deleteStudentById(Integer id){
        repository.deleteById(id);
    }

    public List<Student> findStudentByName (String name){
        return repository.findAllByFirstnameContaining(name);
    }


}
