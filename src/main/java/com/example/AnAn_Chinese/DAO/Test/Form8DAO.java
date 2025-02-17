package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form8;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form8DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form8> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form8 f", Form8.class).getResultList();
    }

    public Form8 getFormById(Integer id) {
        return entityManager.find(Form8.class, id);
    }

    public List<Form8> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form8 f WHERE f.id_test = :idTest", Form8.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form8 createForm(Form8 form8) {
        entityManager.persist(form8);
        return form8;
    }

    @Transactional
    public Form8 updateForm(Integer id, Form8 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form8 form8 = entityManager.find(Form8.class, id);
        if (form8 != null) {
            entityManager.remove(form8);
        }
    }
}
