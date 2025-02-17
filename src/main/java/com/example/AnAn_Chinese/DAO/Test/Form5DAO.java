package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form5;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form5DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form5> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form5 f", Form5.class).getResultList();
    }

    public Form5 getFormById(Integer id) {
        return entityManager.find(Form5.class, id);
    }

    public List<Form5> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form5 f WHERE f.id_test = :idTest", Form5.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form5 createForm(Form5 form5) {
        entityManager.persist(form5);
        return form5;
    }

    @Transactional
    public Form5 updateForm(Integer id, Form5 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form5 form5 = entityManager.find(Form5.class, id);
        if (form5 != null) {
            entityManager.remove(form5);
        }
    }
}
