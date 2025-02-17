package com.example.AnAn_Chinese.DAO.Test;

import com.example.AnAn_Chinese.Entity.Test.Form2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Form2DAO extends com.example.AnAn_Chinese.DAO.DAO {

    public List<Form2> getAllForms() {
        return entityManager.createQuery("SELECT f FROM Form2 f", Form2.class).getResultList();
    }

    public Form2 getFormById(Integer id) {
        return entityManager.find(Form2.class, id);
    }

    public List<Form2> getFormsByIdTest(Integer idTest) {
        return entityManager.createQuery("SELECT f FROM Form2 f WHERE f.id_test = :idTest", Form2.class)
                .setParameter("idTest", idTest)
                .getResultList();
    }

    @Transactional
    public Form2 createForm(Form2 form2) {
        entityManager.persist(form2);
        return form2;
    }

    @Transactional
    public Form2 updateForm(Integer id, Form2 updatedForm) {
        updatedForm.setId(id);
        return entityManager.merge(updatedForm);
    }

    @Transactional
    public void deleteForm(Integer id) {
        Form2 form2 = entityManager.find(Form2.class, id);
        if (form2 != null) {
            entityManager.remove(form2);
        }
    }
}
