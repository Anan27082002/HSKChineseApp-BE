package com.example.AnAn_Chinese.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "Vocabulary")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int lesson_id;
    private String text_chinese;
    private String text_pinyin;
    private String text_vietnamese;
    private int number;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
