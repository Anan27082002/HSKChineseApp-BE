package com.example.AnAn_Chinese.Entity.Test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "testhsk")
public class TestHSK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer of_level;
    private Integer number;
    private String audio;
}
