package com.example.AnAn_Chinese.DAO.Test;


import com.example.AnAn_Chinese.DAO.DAO;
import com.example.AnAn_Chinese.Entity.Test.TestHSK;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TestHSKDAO extends DAO {

    public List<TestHSK> getAllTests() {
        return entityManager.createQuery("SELECT t FROM TestHSK t", TestHSK.class).getResultList();
    }

    public TestHSK getTestById(Integer id) {
        return entityManager.find(TestHSK.class, id);
    }

    public List<TestHSK> getListTestByOfLevel(Integer ofLevel) {
        return entityManager.createQuery("SELECT t FROM TestHSK t WHERE t.of_level = :ofLevel", TestHSK.class)
                .setParameter("ofLevel", ofLevel)
                .getResultList();
    }

    @Transactional
    public TestHSK createTest(TestHSK testHSK) {
        entityManager.persist(testHSK);
        return testHSK;
    }

    @Transactional
    public TestHSK updateTest(Integer id, TestHSK updatedTest) {
        updatedTest.setId(id);
        return entityManager.merge(updatedTest);
    }

    @Transactional
    public void deleteTest(Integer id) {
        TestHSK testHSK = entityManager.find(TestHSK.class, id);
        if (testHSK != null) {
            entityManager.remove(testHSK);
        }
    }
}

