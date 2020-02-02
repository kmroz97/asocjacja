package com.akademia.asocjacja.dto.mapper;

import com.akademia.asocjacja.dto.QuestionDto;
import com.akademia.asocjacja.model.Answer;
import com.akademia.asocjacja.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    public QuestionDto mapToQuestionDto(Question question) {
        QuestionDto questionDto = new QuestionDto(question.getContent());
        questionDto.setId(question.getId());

        List<Answer> answers = question.getAnswers();

        List<String> answersName = new ArrayList<>();

        for (int i = 0; i < answersName.size(); i++) {
            answersName.add(answers.get(i).getName());

        }

        List<String> answersName2 = answers.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        questionDto.setOptions(answersName2);

        String correctAnswer = "";
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                correctAnswer = answers.get(i).getName();
            }


        }

        questionDto.setAnswer(correctAnswer);
        return questionDto;

    }

    public List<QuestionDto> mapToListQuestionDto(List<Question> questions){
        return questions.stream()
                .map(q -> mapToQuestionDto(q))
                .collect(Collectors.toList());
    }
}
