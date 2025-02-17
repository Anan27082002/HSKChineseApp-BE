package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form1;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form1DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form1> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form1 f", Form1.class).getResultList();
    }

    public Form1 getFormById(Integer id) {
        return entityManager.find(Form1.class, id);
    }

    public List<Form1> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form1 f WHERE f.id_test = :idTest", Form1.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form1 createForm(Form1 form1) {
        entityManager.persist(form1);
        return form1;
    }

    @Transactional
    public Form1 updateForm(Integer id, Form1 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form1 form1 = entityManager.find(Form1.class, id);
        if (form1 != null) {
            entityManager.remove(form1);
        }
    }
}
