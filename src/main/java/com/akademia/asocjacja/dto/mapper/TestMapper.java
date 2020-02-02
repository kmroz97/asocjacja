package com.akademia.asocjacja.dto.mapper;

import com.akademia.asocjacja.dto.TestDto;
import com.akademia.asocjacja.model.Test;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {

    private QuestionMapper questionMapper = new QuestionMapper();

    public TestDto mapToTestDto(Test test){
        TestDto testDto = new TestDto();
        testDto.setName(test.getName());
        testDto.setQuestions(questionMapper.mapToListQuestionDto(test.getQuestions()));

        return testDto;
    }
}
