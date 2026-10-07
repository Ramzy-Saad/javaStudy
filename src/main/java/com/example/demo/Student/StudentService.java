package com.example.demo.Student;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<StudentResponseDto> findStudents(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer id){
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public StudentResponseDto updateStudentById( Integer id,Student updatedStudent){
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstname(updatedStudent.getFirstname());
        student.setLastname(updatedStudent.getLastname());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());
        Student savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public void deleteStudentById(Integer id){
        repository.deleteById(id);
    }

    public List<StudentResponseDto> findStudentByName (String name){
        return repository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }


}
