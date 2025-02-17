package com.example.AnAn_Chinese.DAO;


import com.example.AnAn_Chinese.DAO.Test.TestHSKDAO;
import com.example.AnAn_Chinese.DAO.Test.TestProgressDAO;
import com.example.AnAn_Chinese.Entity.Account;
import com.example.AnAn_Chinese.Entity.Lesson;
import com.example.AnAn_Chinese.Entity.LessonProgress;
import com.example.AnAn_Chinese.Entity.Test.TestHSK;
import com.example.AnAn_Chinese.Entity.Test.TestProgress;
import com.example.AnAn_Chinese.Request.AccountRequest;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDAO extends DAO{

    @Autowired
    private LessonProgressDAO lessonProgressDAO;
    @Autowired
    private TestProgressDAO testProgressDAO;
    @Autowired
    private LessonDAO lessonDAO;
    @Autowired
    private TestHSKDAO testHSKDAO;

    public List<Account> getAllAccount() {
        return entityManager.createQuery("SELECT acc FROM Account acc", Account.class).getResultList();
    }

    public Account getAccountById(Integer id) {
        return entityManager.find(Account.class, id);
    }
    public Account getAccountByInfo(AccountRequest acc) {
        try {
            return entityManager.createQuery("SELECT acc FROM Account acc WHERE acc.user_name = :user_name AND acc.password = :password", Account.class)
                    .setParameter("user_name", acc.getUsername())
                    .setParameter("password", acc.getPassword())
                    .getSingleResult();
        } catch (NoResultException e) {
           return null;
        }
    }

    @Transactional
    public Account createAccountIfUnique(Account acc) {
        try {
            entityManager.createQuery("SELECT acc FROM Account acc WHERE acc.user_name = :user_name", Account.class)
                    .setParameter("user_name", acc.getUser_name())
                    .getSingleResult();
            return null;
        } catch (NoResultException e) {
            entityManager.merge(acc);
            Account newAcc = entityManager.createQuery("SELECT acc FROM Account acc WHERE acc.user_name = :user_name", Account.class)
                    .setParameter("user_name", acc.getUser_name())
                    .getSingleResult();
            List<Lesson> listLessons = lessonDAO.getAllLessons();
            for (Lesson lesson : listLessons){
                LessonProgress newLessonProgress = new LessonProgress();
                newLessonProgress.setId_account(newAcc.getId());
                newLessonProgress.setProgress(0);
                newLessonProgress.setVocab_point(0);
                newLessonProgress.set_open(false);
                if(lesson.getNumber() == 1)
                    newLessonProgress.set_open(true);
                newLessonProgress.setId_lesson(lesson.getId());
                lessonProgressDAO.createLessonProgress(newLessonProgress);
            }

            List<TestHSK> testHSKList = testHSKDAO.getAllTests();
            for (TestHSK testHSK : testHSKList){
                TestProgress testProgress = new TestProgress();
                testProgress.setId_test(testHSK.getId());
                testProgress.setId_account(newAcc.getId());
                testProgress.setPoint(0);
                testProgress.set_open(true);
                testProgressDAO.createTestProgress(testProgress);
            }
            return acc;
        }
    }

    @Transactional
    public Account createAccount(Account acc) {
        entityManager.merge(acc);
        return acc;
    }

    @Transactional
    public Account updateAccount(Integer id, Account updateAcc) {
        updateAcc.setId(id);
        return entityManager.merge(updateAcc);
    }

    @Transactional
    public void deleteAccount(Integer id) {
        Account acc = entityManager.find(Account.class, id);
        if (acc != null) {
            entityManager.remove(acc);
        }
    }
}
