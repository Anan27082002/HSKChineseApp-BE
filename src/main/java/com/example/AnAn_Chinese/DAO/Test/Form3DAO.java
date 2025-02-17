package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form3;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form3DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form3> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form3 f", Form3.class).getResultList();
    }

    public Form3 getFormById(Integer id) {
        return entityManager.find(Form3.class, id);
    }

    public List<Form3> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form3 f WHERE f.id_test = :idTest", Form3.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form3 createForm(Form3 form3) {
        entityManager.persist(form3);
        return form3;
    }

    @Transactional
    public Form3 updateForm(Integer id, Form3 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form3 form3 = entityManager.find(Form3.class, id);
        if (form3 != null) {
            entityManager.remove(form3);
        }
    }
}
