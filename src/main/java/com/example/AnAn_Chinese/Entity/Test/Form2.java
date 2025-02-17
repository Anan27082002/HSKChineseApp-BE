package com.example.AnAn_Chinese.Entity.Test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "form2")
public class Form2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer id_test;

    private Integer number;

    private String list_image;

    private String answer;
}
