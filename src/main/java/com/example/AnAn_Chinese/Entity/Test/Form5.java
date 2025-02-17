package com.example.AnAn_Chinese.Entity.Test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "form5")
public class Form5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer id_test;

    private Integer number;
    private String sentence_chinese;
    private String sentence_pinyin;
    private String answer;
    private String image_url;
}
