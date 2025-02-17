package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.TestHSK;
import com.example.AnAn_Chinese.Entity.Test.TestProgress;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TestProgressDAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<TestProgress> getAllTestProgresses() {
        return entityManager.createQuery("SELECT tp FROM TestProgress tp", TestProgress.class).getResultList();
    }

    public TestProgress getTestProgressById(Integer id) {
        return entityManager.find(TestProgress.class, id);
    }

    public TestProgress getTestProgressByIdTestAndIdAccount(Integer idTest, Integer idAccount) {
        TestProgress testProgress = null;
        try {
            testProgress = entityManager.createQuery("SELECT tp FROM TestProgress tp WHERE tp.id_test = :idTest AND tp.id_account = :idAccount", TestProgress.class)
                    .setParameter("idTest", idTest)
                    .setParameter("idAccount", idAccount)
                    .getSingleResult();
        } catch (NoResultException e) {
            testProgress = new TestProgress();
            testProgress.setId_test(idTest);
            testProgress.setId_account(idAccount);
            testProgress.setPoint(0);
            entityManager.persist(testProgress);
        }

        return testProgress;
    }
    @Transactional
    public TestProgress createTestProgress(TestProgress testProgress) {
        entityManager.persist(testProgress);
        return testProgress;
    }

    @Transactional
    public TestProgress updateTestProgress(Integer id, TestProgress updatedTestProgress) {
        updatedTestProgress.setId(id);
        return entityManager.merge(updatedTestProgress);
    }

    @Transactional
    public void deleteTestProgress(Integer id) {
        TestProgress testProgress = entityManager.find(TestProgress.class, id);
        if (testProgress != null) {
            entityManager.remove(testProgress);
        }
    }

    @Transactional
    public void setOpenNextTest(Integer idTestProgress) {
        // Tìm TestProgress hiện tại
        TestProgress currentTestProgress = getTestProgressById(idTestProgress);
        if (currentTestProgress == null) {
            throw new IllegalArgumentException("TestProgress with id " + idTestProgress + " not found");
        }

        // Tìm Test hiện tại
        TestHSK currentTest = entityManager.find(TestHSK.class, currentTestProgress.getId_test());
        if (currentTest == null) {
            throw new IllegalArgumentException("TestHSK with id " + currentTestProgress.getId_test() + " not found");
        }

        // Tìm bài test kế tiếp có number lớn hơn và thuộc cùng of_level
        String jpql = "SELECT t FROM TestHSK t WHERE t.of_level = :ofLevel AND t.number > :currentNumber ORDER BY t.number ASC";
        List<TestHSK> nextTests = entityManager.createQuery(jpql, TestHSK.class)
                .setParameter("ofLevel", currentTest.getOf_level())
                .setParameter("currentNumber", currentTest.getNumber())
                .setMaxResults(1)
                .getResultList();

        if (!nextTests.isEmpty()) {
            TestHSK nextTest = nextTests.get(0);

            // Tìm TestProgress tương ứng với bài test kế tiếp và mở khóa nó
            String progressJpql = "SELECT tp FROM TestProgress tp WHERE tp.id_test = :testId AND tp.id_account = :accountId";
            List<TestProgress> nextTestProgressList = entityManager.createQuery(progressJpql, TestProgress.class)
                    .setParameter("testId", nextTest.getId())
                    .setParameter("accountId", currentTestProgress.getId_account())
                    .getResultList();

            if (!nextTestProgressList.isEmpty()) {
                TestProgress nextTestProgress = nextTestProgressList.get(0);
                nextTestProgress.set_open(true);
                entityManager.merge(nextTestProgress);
            } else {
                throw new IllegalArgumentException("TestProgress for the next test not found");
            }
        } else {
            throw new IllegalArgumentException("No next test found in the same level");
        }
    }
}
