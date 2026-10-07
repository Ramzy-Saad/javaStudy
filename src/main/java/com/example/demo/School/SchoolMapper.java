package com.example.demo.School;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {


    public School toSChool(SchoolDto dto){return new School(dto.name());}

    public SchoolDto toSchoolDto(School school){return new SchoolDto(school.getName());}
}
