package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form4;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form4DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form4> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form4 f", Form4.class).getResultList();
    }

    public Form4 getFormById(Integer id) {
        return entityManager.find(Form4.class, id);
    }

    public List<Form4> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form4 f WHERE f.id_test = :idTest", Form4.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form4 createForm(Form4 form4) {
        entityManager.persist(form4);
        return form4;
    }

    @Transactional
    public Form4 updateForm(Integer id, Form4 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form4 form4 = entityManager.find(Form4.class, id);
        if (form4 != null) {
            entityManager.remove(form4);
        }
    }
}
