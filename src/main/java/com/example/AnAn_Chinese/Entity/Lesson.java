package com.example.AnAn_Chinese.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "Lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int number;
    private int of_level;
    private String name;
    private String vocabulary_audio_url;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
