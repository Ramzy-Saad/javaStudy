package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepositroy schoolRepositroy;

    public SchoolController(SchoolRepositroy schoolRepositroy) {
        this.schoolRepositroy = schoolRepositroy;
    }
    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
        var school = toSChool(dto);
        schoolRepositroy.save(school);
        return dto;
    }

    @GetMapping("/schools")
    public List<SchoolDto> getALlSchools(){
        return schoolRepositroy.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/schools/{school-id}")
    public School getSchoolById(@PathVariable("school-id") Integer id){
        return schoolRepositroy.findById(id).orElse(new School());
    }



    private School toSChool(SchoolDto dto){
        return new School(dto.name());
    }

    private SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }




}
