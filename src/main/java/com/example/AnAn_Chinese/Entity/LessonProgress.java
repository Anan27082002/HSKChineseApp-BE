package com.example.AnAn_Chinese.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "lesson_progress")
public class LessonProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer id_account;
    private Integer id_lesson;
    private Integer progress; // 0 la Conversation 1 la Grammar 2 la Vocab
    private Integer vocab_point;
    private boolean is_open;
}
