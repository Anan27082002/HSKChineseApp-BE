package com.example.AnAn_Chinese.Entity.Test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "form3")
public class Form3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer id_test;

    private Integer number;
    private String image;
    private String answer;
}
