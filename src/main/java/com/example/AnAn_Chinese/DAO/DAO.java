package com.example.AnAn_Chinese.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class DAO {
    @PersistenceContext
    public EntityManager entityManager;

}
