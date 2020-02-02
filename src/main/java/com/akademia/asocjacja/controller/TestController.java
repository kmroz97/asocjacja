package com.akademia.asocjacja.controller;

import com.akademia.asocjacja.dto.TestDto;
import com.akademia.asocjacja.dto.mapper.TestMapper;
import com.akademia.asocjacja.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestRepository testRepository;


    @GetMapping("/{id}")
    public TestDto sayHello(@PathVariable Long id){
        return testMapper.mapToTestDto(testRepository.findById(id).get());
    }
}
