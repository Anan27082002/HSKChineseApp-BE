package com.example.AnAn_Chinese.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "Sentence")
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer conversation_id;
    private String text_chinese;
    private String text_pinyin;
    private String text_vietnamese;
    private Integer number;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
