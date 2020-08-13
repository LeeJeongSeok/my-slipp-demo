package com.lee.practice.myslippdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Entity
public class Question extends AbstractEntity{

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    @JsonProperty
    private User writer;

    @JsonProperty
    private String title;

    @Lob
    @JsonProperty
    private String contents;

    @JsonProperty
    private Integer countOfAnswer = 0 ;

    @OneToMany(mappedBy = "question")
    @OrderBy("id DESC")
    private List<Answer> answers;

    public Question() {

    }

    public Question(User writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }


    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public boolean isSameWriter(User loginUser) {
        System.out.println("writer status : " + this.writer.equals(loginUser));
        return this.writer.equals(loginUser);
    }


    public void addAnswer() {
        this.countOfAnswer += 1;
    }

    public void deleteAnswer() {
        this.countOfAnswer -= 1;
    }
}
