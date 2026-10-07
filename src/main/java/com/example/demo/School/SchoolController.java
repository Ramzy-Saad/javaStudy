package com.example.demo.School;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
        return schoolService.create(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> getALlSchools(){
        return schoolService.getALlSchools();
    }

    @GetMapping("/schools/{school-id}")
    public SchoolDto getSchoolById(@PathVariable("school-id") Integer id){
        return schoolService.getSchoolById(id);
    }


}
