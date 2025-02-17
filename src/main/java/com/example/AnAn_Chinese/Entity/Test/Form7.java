package com.example.AnAn_Chinese.Entity.Test;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "form7")
public class  Form7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer id_test;

    private Integer number;

    private String question_sentence_chinese;

    private String question_sentence_pinyin;

    private String answer_sentence_chinese;

    private String answer_sentence_pinyin;

    private String answer;
}
