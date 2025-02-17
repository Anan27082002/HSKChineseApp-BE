package com.example.AnAn_Chinese.Entity.Test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "test_progress")
public class TestProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer id_account;
    private Integer id_test;
    private Integer point;
    private boolean is_open;
}
