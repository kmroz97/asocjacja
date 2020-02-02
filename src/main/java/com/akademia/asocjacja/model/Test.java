package com.akademia.asocjacja.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Test extends EntityBase {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    public Test() {

    }

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        question.setTest(this);
        questions.add(question);
    }
}
