package com.example.demo.School;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto create(SchoolDto dto){
        var school = schoolMapper.toSChool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> getALlSchools(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public SchoolDto getSchoolById(Integer id){
        return schoolRepository.findById(id).map(schoolMapper::toSchoolDto).orElse(null);
    }


}
