package com.example.AnAn_Chinese.Entity.Test;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "form1")
public class Form1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer id_test;
    private Integer number;
    private String image;
    private String answer;
}

