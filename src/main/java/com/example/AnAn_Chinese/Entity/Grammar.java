package com.example.AnAn_Chinese.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "Grammar")
public class Grammar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1020)
    private String example_chinese;
    @Column(length = 1020)
    private String example_pinyin;
    @Column(length = 1020)
    private String example_vietnamese;
    private int number;
    private int lesson_id;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
