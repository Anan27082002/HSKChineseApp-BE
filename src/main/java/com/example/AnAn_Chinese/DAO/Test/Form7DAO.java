package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form7;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form7DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form7> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form7 f", Form7.class).getResultList();
    }

    public Form7 getFormById(Integer id) {
        return entityManager.find(Form7.class, id);
    }

    public List<Form7> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form7 f WHERE f.id_test = :idTest", Form7.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form7 createForm(Form7 form7) {
        entityManager.persist(form7);
        return form7;
    }

    @Transactional
    public Form7 updateForm(Integer id, Form7 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form7 form7 = entityManager.find(Form7.class, id);
        if (form7 != null) {
            entityManager.remove(form7);
        }
    }
}
