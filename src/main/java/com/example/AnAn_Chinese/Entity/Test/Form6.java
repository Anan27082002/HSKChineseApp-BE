package com.example.AnAn_Chinese.Entity.Test;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "form6")
public class Form6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer id_test;
    private Integer number;

    private String question_sentence_chinese;

    private String question_sentence_pinyin;

    private String answer;

    private String image;
}